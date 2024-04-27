package org.clases;

import java.sql.*;


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
    public static void buscarProductos(String busqueda) {
        try {
            conexion = conecta();
            String sql = "SELECT * FROM productos where nombre = ?";
            ps.setString(1, busqueda);
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre"+" ,"+rs.getString("cantidad")+" ,"
                        +rs.getString("Stock_Minimo")));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
