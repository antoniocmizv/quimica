package org.clases.Clases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.clases.Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcelRead {
    public static void main(String[] args) {
        insertarSalas();
        insertarUbicaciones();
        insertarProductos();
        insertarFormatos();
        insertarRiesgos();
        insertarQuimicos();
    }

    public static void insertarSalas() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("salas");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO salas " +
                    "(Id_Almacen,Nombre_Almacen)" +
                    " VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                String nombreSala = row.getCell(0).getStringCellValue();
                int idAlmacen = (int) row.getCell(1).getNumericCellValue();
                // Inserta los datos en la base de datos
                ps.setInt(1, idAlmacen);
                ps.setString(2, nombreSala);
                ps.executeUpdate();
                System.out.println("Se inserto: " + idAlmacen + " " + nombreSala);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarUbicaciones() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("ubicaciones");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO ubicaciones " +
                    "(Id_Ubicacion,Nombre_Ubicacion,Codigo_Almacen)" +
                    " VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idUbicacion = (int) row.getCell(1).getNumericCellValue();
                String nombreUbicacion = row.getCell(0).getStringCellValue();
                int codigoAlmacen = (int) row.getCell(2).getNumericCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idUbicacion);
                ps.setString(2, nombreUbicacion);
                ps.setInt(3, codigoAlmacen);
                ps.executeUpdate();
                System.out.println("Se inserto: " + nombreUbicacion +
                        " CodUbi:" + idUbicacion + " CodAlm:" + codigoAlmacen);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarProductos() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("productos");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO productos " +
                    "(Id_Producto,Nombre_Producto,Cantidad,Stock_Minimo,Id_Ubicacion)" +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idProducto = (int) row.getCell(0).getNumericCellValue();
                String nombreProducto = row.getCell(1).getStringCellValue();
                int cantidad = (int) row.getCell(2).getNumericCellValue();
                int stockMinimo = (int) row.getCell(3).getNumericCellValue();
                int idUbicacion = (int) row.getCell(5).getNumericCellValue();


                // Inserta los datos en la base de datos
                ps.setInt(1, idProducto);
                ps.setString(2, nombreProducto);
                ps.setInt(3, cantidad);
                ps.setInt(4, stockMinimo);
                ps.setInt(5, idUbicacion);

                ps.executeUpdate();
                System.out.println("Se inserto: " + idProducto + " " + nombreProducto + " " +
                        cantidad + " " + stockMinimo + " " + idUbicacion);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarQuimicos() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("quimicos");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO quimicos " +
                    "(Id_Quimico,Pureza,Fecha_Caducidad,Id_Producto,Id_Formato,Id_Riesgo)" +
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idQuimico = (int) row.getCell(0).getNumericCellValue();
                String pureza = row.getCell(1).getStringCellValue();
                String fechaCaducidad = row.getCell(2).getStringCellValue();
                int idProducto = (int) row.getCell(3).getNumericCellValue();
                int idFormato = (int) row.getCell(5).getNumericCellValue();
                int idRiesgo = (int) row.getCell(7).getNumericCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idQuimico);
                ps.setString(2, pureza);
                ps.setString(3, fechaCaducidad);
                ps.setInt(4, idProducto);
                ps.setInt(5, idFormato);
                ps.setInt(6, idRiesgo);

                ps.executeUpdate();
                System.out.println("Se inserto: " + idQuimico + " " + pureza + " " + fechaCaducidad + " " +
                        idProducto + " " + idFormato + " " + idRiesgo);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarFormatos() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("formato");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO formato " +
                    "(Id_Formato,Formato)" +
                    " VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idFormato = (int) row.getCell(1).getNumericCellValue();
                String formato = row.getCell(0).getStringCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idFormato);
                ps.setString(2, formato);

                ps.executeUpdate();
                System.out.println("Se inserto: " + idFormato + " " + formato);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarRiesgos() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("riesgos");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO riesgos " +
                    "(Id_Riesgos,Riesgo)" +
                    " VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idRiesgo = (int) row.getCell(1).getNumericCellValue();
                String Riesgo = row.getCell(0).getStringCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idRiesgo);
                ps.setString(2, Riesgo);
                //Ejecuta la sentencia
                ps.executeUpdate();
                System.out.println("Se inserto: " + idRiesgo + " " + Riesgo);
            }

            // Cierra la conexión a la base de datos
            Conexion.cerrar();

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
