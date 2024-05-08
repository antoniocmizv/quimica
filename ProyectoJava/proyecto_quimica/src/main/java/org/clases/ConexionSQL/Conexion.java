package org.clases.ConexionSQL;

import java.sql.*;
import java.util.ArrayList;

import org.clases.Clases.Materiales;
import org.clases.Clases.Producto;
import org.clases.Clases.ProductoAuxiliar;
import org.clases.Clases.Quimico;


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
            return rs.getString("tipo");
        } catch (
                Exception ex) {
            System.out.println(ex);
            return null;
        }

    }


    public static ArrayList<Producto> buscarProductos(String busqueda) {
        try {
            conexion = conecta();
            String sql1 = "SELECT tipo FROM productos WHERE Nombre_Producto = ?";
            ps = conexion.prepareStatement(sql1);
            ps.setString(1, busqueda);
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
                    "WHERE p.Nombre_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda);
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
            ProductoAuxiliar auxiliar = new ProductoAuxiliar(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                    nombre_almacen, formato);
            auxiliares.add(auxiliar);}
            return auxiliares;
        }catch (Exception ex){
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
                    "WHERE p.Nombre_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda);
            rs = ps.executeQuery();
            ArrayList<Producto> materiales = new ArrayList<>();
            while (rs.next()) {
                String id_producto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                int stock_minimo = rs.getInt("stock_minimo");
                String nombre_ubicacion = rs.getString("nombre_ubicacion");
                String nombre_almacen = rs.getString("Nombre_Almacen");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String fecha_compra = rs.getString("fecha_compra");
                String numero_serie = rs.getString("n_serie");
                Materiales material = new Materiales(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen, tipo, descripcion, fecha_compra, numero_serie);
                materiales.add(material);
            }
            return materiales;
        }catch (Exception ex){
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
                    "INNER JOIN formato f on q.Id_Formato = f.Id_Formato "+
                    "WHERE p.Nombre_Producto = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, busqueda);
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
                Quimico quimico = new Quimico(id_producto, nombre, cantidad, stock_minimo, nombre_ubicacion,
                        nombre_almacen, pureza, fecha_caducidad, formato);
                quimicos.add(quimico);
            }
            return quimicos;
        }catch (Exception ex){
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
