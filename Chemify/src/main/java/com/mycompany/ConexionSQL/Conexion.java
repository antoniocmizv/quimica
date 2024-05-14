package com.mycompany.ConexionSQL;

import com.mycompany.Clases.ConexionManager;
import com.mycompany.Clases.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Conexion implements ConexionManager {

    private static final String DB_URL = "jdbc:mysql://localhost/proyecto_quimica";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conexion = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static boolean validarUsuario(String username, String password) {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (
                Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    public static String getTypeUser(String username, String password) {
        try {
            conexion = conecta();
            String sql = "SELECT type FROM usuarios WHERE username = ? AND password = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("type");
        } catch (
                Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    public static ArrayList<Producto> buscarProductos(String busqueda) {
        try {
            conexion = conecta();
            String sql1 = "SELECT tipo FROM productos WHERE Nombre_Producto like ?";
            ps = conexion.prepareStatement(sql1);
            ps.setString(1, busqueda + "%");
            rs = ps.executeQuery();
            rs.next();
            String type = rs.getString("tipo");
            if (type.equals("1")) {
                return buscarQuimico(busqueda);
            } else if (type.equals("3")) {
                return buscarMateriales(busqueda);
            } else if (type.equals("2")) {
                return buscarProductoAuxiliar(busqueda);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    private static ArrayList<Producto> buscarProductoAuxiliar(String busqueda) {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM productos p " +
                    "INNER JOIN ubicaciones u ON p.Id_Ubicacion = u.Id_Ubicacion " +
                    "INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen " +
                    "INNER JOIN productos_auxiliares a ON p.Id_Producto = a.Id_Producto " +
                    "WHERE p.Nombre_Producto like ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda + "%");
            rs = ps.executeQuery();
            ArrayList<Producto> auxiliares = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String nombre_ubicacion = rs.getString("nombre_ubicacion");
                String nombre_almacen = rs.getString("Nombre_Almacen");
                String formato = rs.getString("formato");
                int id_almacen = rs.getInt("id_almacen");
                int id_ubicacion = rs.getInt("id_ubicacion");

                ProductoAuxiliar auxiliar = new ProductoAuxiliar(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen, id_almacen, id_ubicacion, formato);
                auxiliares.add(auxiliar);
            }
            return auxiliares;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    private static ArrayList<Producto> buscarMateriales(String busqueda) {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM productos p " +
                    "INNER JOIN ubicaciones u ON p.Id_Ubicacion = u.Id_Ubicacion " +
                    "INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen " +
                    "INNER JOIN materiales m ON p.Id_Producto = m.Id_Producto " +
                    "WHERE p.Nombre_Producto like ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda + "%");
            rs = ps.executeQuery();
            ArrayList<Producto> materiales = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String nombre_ubicacion = rs.getString("nombre_ubicacion");
                String nombre_almacen = rs.getString("Nombre_Almacen");
                String subtipo = rs.getString("subtipo");
                String descripcion = rs.getString("descripcion");
                String fecha_compra = rs.getString("fecha_compra");
                String numero_serie = rs.getString("n_serie");
                int id_almacen = rs.getInt("id_almacen");
                int id_ubicacion = rs.getInt("id_ubicacion");
                Materiales material = new Materiales(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen, id_almacen, id_ubicacion, subtipo, descripcion, fecha_compra, numero_serie);
                materiales.add(material);
            }
            return materiales;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    private static ArrayList<Producto> buscarQuimico(String busqueda) {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM productos p " +
                    "INNER JOIN ubicaciones u ON p.Id_Ubicacion = u.Id_Ubicacion " +
                    "INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen " +
                    "INNER JOIN quimicos q ON p.Id_Producto = q.Id_Producto " +
                    "INNER JOIN formato f on q.Id_Formato = f.Id_Formato " +
                    "WHERE p.Nombre_Producto like ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda + "%");
            rs = ps.executeQuery();
            ArrayList<Producto> quimicos = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String nombre_ubicacion = rs.getString("nombre_ubicacion");
                String nombre_almacen = rs.getString("Nombre_Almacen");
                String pureza = rs.getString("pureza");
                String fecha_caducidad = rs.getString("fecha_caducidad");
                String formato = rs.getString("formato");
                //String riesgo = rs.getString("nombre_riesgo");
                int id_almacen = rs.getInt("id_almacen");
                int id_ubicacion = rs.getInt("id_ubicacion");

                Quimico quimico = new Quimico(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen, id_almacen, id_ubicacion, pureza, fecha_caducidad, formato, "Nocivo, comburente, corrosivo, peligroso para el medio ambiente, carcinogeno");
                quimicos.add(quimico);
            }
            return quimicos;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Connection conecta() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static String[] obtenerUbicaciones() {
        try {
            conexion = conecta();
            String sql = "SELECT nombre_ubicacion FROM ubicaciones";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> ubicaciones = new ArrayList<>();
            while (rs.next()) {
                ubicaciones.add(rs.getString("nombre_ubicacion"));
            }
            return ubicaciones.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    public static String[] obtenerUbicacionesDeAlmacen(String almacen) {
        try {
            conexion = conecta();
            String sql = "SELECT nombre_ubicacion FROM ubicaciones u" +
                    " INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen WHERE s.nombre_almacen = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, almacen);
            rs = ps.executeQuery();
            ArrayList<String> ubicaciones = new ArrayList<>();
            while (rs.next()) {
                ubicaciones.add(rs.getString("nombre_ubicacion"));
            }
            return ubicaciones.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String[] obtenerFormatosQ() {
        try {
            conexion = conecta();
            String sql = "SELECT formato FROM formato";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> formatos = new ArrayList<>();
            while (rs.next()) {
                formatos.add(rs.getString("formato"));
            }
            return formatos.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String[] obtenerLocalizaciones() {
        try {
            conexion = conecta();
            String sql = "SELECT nombre_almacen FROM salas";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> localizaciones = new ArrayList<>();
            while (rs.next()) {
                localizaciones.add(rs.getString("nombre_almacen"));
            }
            return localizaciones.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String[] obtenerRiesgos() {
        try {
            conexion = conecta();
            String sql = "SELECT riesgo FROM quimicos";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> riesgos = new ArrayList<>();
            while (rs.next()) {
                riesgos.add(rs.getString("riesgo"));
            }
            return riesgos.toArray(new String[0]);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static void insertarFormato(String formato) {
        try {
            conexion = conecta();
            String sql = "INSERT INTO formato (formato) VALUES (?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, formato);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public static void actualizarMaterial(Materiales m) {
        try {
            conexion = conecta();
            String sql = "UPDATE productos SET Nombre_Producto = ?, Cantidad = ?, Stock_Minimo = ?, Id_Ubicacion = ? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getCantidad());
            ps.setInt(3, m.getStock_minimo());
            ps.setInt(4, m.getId_ubicacion());
            ps.setString(5, m.getId_producto());
            ps.executeUpdate();

            sql = "UPDATE materiales SET subtipo = ?, Descripcion = ?, Fecha_Compra = ?, N_Serie = ? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, m.getSubtipo());
            ps.setString(2, m.getDescripcion());
            ps.setString(3, m.getFecha_compra());
            ps.setString(4, m.getNumero_serie());
            ps.setString(5, m.getId_producto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void actualizarProductoAuxiliar(ProductoAuxiliar pa) {
        try {
            conexion = conecta();
            String sql = "UPDATE productos SET Nombre_Producto = ?, Cantidad = ?, Stock_Minimo = ?, Id_Ubicacion = ? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pa.getNombre());
            ps.setInt(2, pa.getCantidad());
            ps.setInt(3, pa.getStock_minimo());
            ps.setInt(4, pa.getId_ubicacion());
            ps.setString(5, pa.getId_producto());
            ps.executeUpdate();

            sql = "UPDATE productos_auxiliares SET formato = ? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pa.getFormato());
            ps.setString(2, pa.getId_producto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static ArrayList<User> obtenerUsuarios() {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM usuarios";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<User> usuarios = new ArrayList<>();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String type = rs.getString("type");
                User user = new User(username, password, type);
                usuarios.add(user);

            }
            return usuarios;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static void insertarUsuario(User usuario) {
        try {
            conexion = conecta();
            String sql = "INSERT INTO usuarios (username, password, type) VALUES (?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getType());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void eliminarUsuario(String nombre) {
        try {
            conexion = conecta();
            String sql = "DELETE FROM usuarios WHERE username = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void insertarMaterial(Materiales material) {
        try {
            conexion = conecta();

            String sql = "INSERT INTO productos (Nombre_Producto, Cantidad, Stock_Minimo, Id_Ubicacion, tipo) " +
                    "VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, material.getNombre());
            ps.setInt(2, material.getCantidad());
            ps.setInt(3, material.getStock_minimo());
            ps.setInt(4, material.getId_ubicacion());
            ps.setInt(5, 3);
            ps.executeUpdate();

            // Obtener el ID del producto recién insertado
            int id_producto = 0;
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id_producto = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del producto insertado.");
                }
            }

            // Insertar en la tabla materiales con el ID obtenido
            String sql2 = "INSERT INTO materiales (Id_Producto, SUBTIPO, Descripcion, Fecha_Compra, N_Serie) " +
                    "VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql2);
            ps.setInt(1, id_producto);
            ps.setString(2, material.getSubtipo());
            ps.setString(3, material.getDescripcion());
            ps.setString(4, material.getFecha_compra());
            ps.setString(5, material.getNumero_serie());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrar();
        }

    }

    public static void eliminarProducto(Producto producto) {
        try {
            conexion = conecta();
            String sql = "DELETE FROM productos WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getId_producto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void insertarQuimico(Quimico quimico) {
        try {
            conexion = conecta();
            // Insertar primero en la tabla productos
            String sql3 = "INSERT INTO productos (Nombre_Producto, Cantidad, Stock_Minimo, Id_Ubicacion, tipo) " +
                    "VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, quimico.getNombre());
            ps.setInt(2, quimico.getCantidad());
            ps.setInt(3, quimico.getStock_minimo());
            ps.setInt(4, quimico.getId_ubicacion());
            ps.setInt(5, 1); // Tipo 1 para químicos
            ps.executeUpdate();

            // Obtener el ID generado para el producto insertado
            int id_producto = 0;
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id_producto = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del producto insertado.");
                }
            }

            // Obtener el ID del formato
            String sql2 = "SELECT Id_Formato FROM formato WHERE formato = ?";
            ps = conexion.prepareStatement(sql2);
            ps.setString(1, quimico.getFormato());
            rs = ps.executeQuery();
            if (rs.next()) {
                int id_formato = rs.getInt("Id_Formato");

                // Insertar en la tabla quimicos con los IDs obtenidos
                String sql4 = "INSERT INTO quimicos (pureza, fecha_caducidad, id_producto, id_formato)" +
                        " VALUES (?, ?, ?, ?)";
                ps = conexion.prepareStatement(sql4);
                ps.setString(1, quimico.getPureza());
                ps.setString(2, quimico.getFecha_caducidad());
                ps.setInt(3, id_producto);
                ps.setInt(4, id_formato);
                ps.executeUpdate();
            } else {
                throw new SQLException("El formato especificado no existe.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            // Manejar excepciones de cierre adecuadamente
        }

    }

    public static void insertarProductoAuxiliar(ProductoAuxiliar pa) {
        try {
            conexion = conecta();
            // Insertar primero en la tabla productos
            String sql3 = "INSERT INTO productos (Nombre_Producto, Cantidad, Stock_Minimo, Id_Ubicacion, tipo) " +
                    "VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pa.getNombre());
            ps.setInt(2, pa.getCantidad());
            ps.setInt(3, pa.getStock_minimo());
            ps.setInt(4, pa.getId_ubicacion());
            ps.setInt(5, 2); // Tipo 2 para productos auxiliares
            ps.executeUpdate();

            // Obtener el ID generado para el producto insertado
            int id_producto = 0;
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id_producto = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del producto insertado.");
                }
            }

            // Insertar en la tabla productos_auxiliares con el ID obtenido
            String sql4 = "INSERT INTO productos_auxiliares (id_producto, formato) VALUES (?, ?)";
            ps = conexion.prepareStatement(sql4);
            ps.setInt(1, id_producto);
            ps.setString(2, pa.getFormato());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            cerrar();
        }
    }

    public static void actualizarQuimico(Quimico pq) {
        try {
            conexion = conecta();
            String sql = "UPDATE productos SET Nombre_Producto = ?, Cantidad = ?, Stock_Minimo = ?, Id_Ubicacion = ? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pq.getNombre());
            ps.setInt(2, pq.getCantidad());
            ps.setInt(3, pq.getStock_minimo());
            ps.setInt(4, pq.getId_ubicacion());
            ps.setString(5, pq.getId_producto());
            ps.executeUpdate();
            //Busco el id del formato
            sql = "SELECT Id_Formato FROM formato WHERE formato = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pq.getFormato());
            rs = ps.executeQuery();
            rs.next();
            int id_formato = rs.getInt("Id_Formato");

            sql = "UPDATE quimicos SET pureza = ?, fecha_caducidad = ?, id_Formato =? " +
                    "WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pq.getPureza());
            ps.setString(2, pq.getFecha_caducidad());
            ps.setInt(3, id_formato);
            ps.setString(4, pq.getId_producto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static List<Producto> obtenerProductos() {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM productos p" +
                    " INNER JOIN ubicaciones u ON p.Id_Ubicacion = u.Id_Ubicacion"+
                    " INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String ubicacion = rs.getString("nombre_ubicacion");
                String almacen = rs.getString("nombre_almacen");
                int id_almacen = rs.getInt("id_almacen");
                int id_ubicacion = rs.getInt("id_ubicacion");

                Producto producto = new Producto(id_producto, nombre, cantidad, stock_minimo, ubicacion,
                        almacen, id_almacen, id_ubicacion);
                productos.add(producto);
            }
            return productos;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static void insertarUbicacion(String valor, int idAlmacen) {
        try {

            conexion = conecta();
            String sql = "INSERT INTO ubicaciones (nombre_ubicacion, Codigo_Almacen) VALUES (?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, idAlmacen);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void insertarLocalizacion(String valor) {
        try {
            conexion = conecta();
            String sql = "INSERT INTO salas (nombre_almacen) VALUES (?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, valor);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static int obtenerIdAlmacen(String localizacion) {
        try {
            conexion = conecta();
            String sql = "SELECT Id_Almacen FROM salas WHERE nombre_almacen = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, localizacion);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("Id_Almacen");
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }

    public static int obtenerIdUbicacion(String ubicacion) {
        try {
            conexion = conecta();
            String sql = "SELECT Id_Ubicacion FROM ubicaciones WHERE nombre_ubicacion = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, ubicacion);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("Id_Ubicacion");
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }

    @Override
    public void insertar(Producto p) {

    }

    @Override
    public void eliminar(Producto p) {
        try {
            conexion = conecta();
            String sql = "DELETE FROM productos WHERE Id_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getId_producto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
