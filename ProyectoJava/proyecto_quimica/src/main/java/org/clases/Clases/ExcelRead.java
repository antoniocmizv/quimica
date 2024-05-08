package org.clases.Clases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.clases.ConexionSQL.Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelRead {
    public static void main(String[] args) {
        vaciarBD();
        insertarSalas();
        insertarUbicaciones();
        insertarProductos();
        insertarFormatos();
        insertarRiesgos();
        insertarQuimicos();
        insertarProductosAuxiliares();
        insertarMateriales();
    }

    public static void vaciarBD() {
        try (Connection conexion = Conexion.conecta()) {
            // Desactiva las restricciones de clave foránea
            PreparedStatement ps = conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            ps.execute();

            // Lista de todas las tablas en tu base de datos
            String[] tablas = {"salas", "ubicaciones", "productos", "quimicos", "formato", "riesgos",
                    "productos_auxiliares", "materiales",};

            // Itera sobre cada tabla
            for (String tabla : tablas) {
                // Crea la sentencia SQL para vaciar la tabla
                String sql = "TRUNCATE TABLE " + tabla;

                // Ejecuta la sentencia SQL
                ps = conexion.prepareStatement(sql);
                ps.executeUpdate();
            }

            // Reactiva las restricciones de clave foránea
            ps = conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
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

            // Cierra el Workbook
            workbook.close();

            // Cierra el FileInputStream
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrar();
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
                    "(Id_Producto,Nombre_Producto,Cantidad,Stock_Minimo,Id_Ubicacion,tipo)" +
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idProducto = (int) row.getCell(0).getNumericCellValue();
                String nombreProducto = row.getCell(1).getStringCellValue();
                int cantidad = (int) row.getCell(2).getNumericCellValue();
                int stockMinimo = (int) row.getCell(3).getNumericCellValue();
                int idUbicacion = (int) row.getCell(5).getNumericCellValue();
                int tipo = (int) row.getCell(6).getNumericCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idProducto);
                ps.setString(2, nombreProducto);
                ps.setInt(3, cantidad);
                ps.setInt(4, stockMinimo);
                ps.setInt(5, idUbicacion);
                ps.setInt(6, tipo);

                ps.executeUpdate();
                System.out.println(STR."Se inserto: \{idProducto} \{nombreProducto} \{cantidad} \{stockMinimo} \{idUbicacion}");
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
                System.out.println(STR."Se inserto: \{idQuimico} \{pureza} \{fechaCaducidad} \{idProducto} \{idFormato} \{idRiesgo}");
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
                System.out.println(STR."Se inserto: \{idFormato} \{formato}");
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

    public static void insertarProductosAuxiliares() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("prod_aux");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO productos_auxiliares " +
                    "(Formato,Id_Producto)" +
                    " VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idProducto = (int) row.getCell(0).getNumericCellValue();
                String formato = row.getCell(6).getStringCellValue();
                // Inserta los datos en la base de datos
                ps.setString(1, formato);
                ps.setInt(2, idProducto);
                ps.executeUpdate();
                System.out.println("Se inserto: " + idProducto + " " + formato);
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

    public static void insertarMateriales() {
        try {
            // Abre el archivo Excel
            FileInputStream file = new FileInputStream(new File("src/main/java/org/clases/excels/datos.xlsx"));

            // Crea un Workbook desde el archivo Excel
            Workbook workbook = new XSSFWorkbook(file);
            // Obtiene el número de hojas del Workbook
            int numberRows = workbook.getNumberOfSheets();
            // Obtiene la primera hoja del Workbook
            Sheet sheet = workbook.getSheet("materiales");
            // Obtiene una conexión a la base de datos
            Connection connection = Conexion.conecta();
            // Prepara la sentencia SQL para insertar los datos
            String sql = "INSERT INTO materiales " +
                    "(id_material,tipo,descripcion,fecha_compra,id_producto,n_serie)" +
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtiene los datos de la fila
                int idMaterial = (int) row.getCell(0).getNumericCellValue();
                String tipo = row.getCell(1).getStringCellValue();
                String descripcion = row.getCell(2).getStringCellValue();
                String fechaCompra = row.getCell(3).getStringCellValue();
                int idProducto = (int) row.getCell(4).getNumericCellValue();
                String numeroSerie = row.getCell(5).getStringCellValue();

                // Inserta los datos en la base de datos
                ps.setInt(1, idMaterial);
                ps.setString(2, tipo);
                ps.setString(3, descripcion);
                ps.setString(4, fechaCompra);
                ps.setInt(5, idProducto);
                ps.setString(6, numeroSerie);

                //Ejecuta la sentencia
                ps.executeUpdate();
                System.out.println(STR."Se inserto: \{idMaterial} \{tipo} \{descripcion} \{fechaCompra} \{idProducto} \{numeroSerie}");
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
