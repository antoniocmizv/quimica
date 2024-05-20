package com.mycompany.Clases;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mycompany.ConexionSQL.Conexion;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GeneradorPDF {
    //creo el main
    public static void main(String[] args) {
        GeneradorPDF generadorPDF = new GeneradorPDF();
        ArrayList<Producto> productos = Conexion.buscarProductos("acido");
        generadorPDF.generarPDFStockAlmacen(String.valueOf(productos));
    }
    public static void generarPDFStockAlmacen(String productoBuscar) {

        Document document = new Document();

        try {
            ArrayList<Producto> productos = Conexion.buscarProductos(productoBuscar);
            PdfWriter.getInstance(document, new FileOutputStream("StockAlmacen.pdf"));

            document.open();

            // Agregar título
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Chunk titleChunk = new Chunk("Stock del Almacén", font);
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            // Agregar tabla
            PdfPTable table = new PdfPTable(4); // 3 columnas: ID, Nombre, Cantidad, Ubicacion
            table.setWidthPercentage(100); // Ancho 100%
            table.setSpacingBefore(10f); // Espacio antes de la tabla
            table.setSpacingAfter(10f); // Espacio después de la tabla

            // Agregar cabeceras de la tabla
            Stream.of("ID Producto", "Nombre Producto", "Cantidad","Ubicacion")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headerFont));
                        table.addCell(header);
                    });

            // Agregar filas a la tabla
            for (Producto producto : productos) {
                table.addCell(String.valueOf(producto.getId_producto()));
                table.addCell(producto.getNombre());
                table.addCell(String.valueOf(producto.getCantidad()));
                table.addCell(producto.getUbicacion());

            }

            document.add(table);

            document.close();

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static byte[] generarPdfByte(String productoBuscado){
        Document document = new Document();
        ByteArrayOutputStream pdfData = new ByteArrayOutputStream();
        ArrayList<Producto> productos = Conexion.buscarProductos(productoBuscado);
        try {
            if (productoBuscado == null || productoBuscado.isEmpty()) {
                productos = Conexion.obtenerTodosLosProductos();
            }

            PdfWriter.getInstance(document, pdfData);

            document.open();

            // Agregar título
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Chunk titleChunk = new Chunk("Stock del Almacén", font);
            Paragraph titleParagraph = new Paragraph(titleChunk);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            // Agregar tabla
            PdfPTable table = new PdfPTable(5); // 3 columnas: ID, Nombre, Cantidad, Ubicacion
            table.setWidthPercentage(100); // Ancho 100%
            table.setSpacingBefore(10f); // Espacio antes de la tabla
            table.setSpacingAfter(10f); // Espacio después de la tabla

            // Agregar cabeceras de la tabla
            Stream.of("ID Producto", "Nombre Producto", "Cantidad","Almacen","Ubicacion")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headerFont));
                        table.addCell(header);
                    });

            // Agregar filas a la tabla
            for (Producto producto : productos) {
                table.addCell(String.valueOf(producto.getId_producto()));
                table.addCell(producto.getNombre());
                table.addCell(String.valueOf(producto.getCantidad()));
                table.addCell(producto.getAlmacen());
                table.addCell(producto.getUbicacion());

            }

            document.add(table);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return pdfData.toByteArray();
    }
}