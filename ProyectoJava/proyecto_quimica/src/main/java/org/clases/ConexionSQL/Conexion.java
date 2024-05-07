package org.clases.ConexionSQL;

import java.sql.*;
import java.util.ArrayList;

import org.clases.Clases.Producto;


public class Conexion {

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
    public static String getTypeUser(String username, String password){
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
            String sql = "SELECT * FROM productos p " +
                    "INNER JOIN ubicaciones u ON p.Id_Ubicacion = u.Id_Ubicacion " +
                    "INNER JOIN salas s ON u.Codigo_Almacen = s.Id_Almacen " +
                    "WHERE p.Nombre_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda);
            rs = ps.executeQuery();
            ArrayList<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String nombre_ubicacion = rs.getString("nombre_ubicacion");
                String nombre_almacen = rs.getString("Nombre_Almacen");
                Producto producto = new Producto(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen);

                productos.add(producto);
            }
            return productos;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
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

    public static Connection conecta() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

}
