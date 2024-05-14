/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesActualizar;

import com.mycompany.Clases.Producto;
import com.mycompany.Clases.ProductoAuxiliar;
import com.mycompany.ConexionSQL.Conexion;

import javax.swing.*;

/**
 *
 * @author mario
 */
public class ActualizarPA extends JFrame {

    /**
     * Creates new form Insertar
     */
    public ActualizarPA(Producto p) {
        initComponents();
        this.setVisible(true);
        this.setSize(1046, 656);
        this.setLocationRelativeTo(null);
        // Rellenar los campos con los datos del producto
        //Hago un downcasting de producto a producto auxiliar
        ProductoAuxiliar pa = (ProductoAuxiliar) p;
        NombrePA.setText(p.getNombre());
        CantidadPA.setText(String.valueOf(p.getCantidad()));
        StockMinimoM.setText(String.valueOf(p.getStock_minimo()));
        FormatoPA.setText(pa.getFormato());
        // Para los JComboBox, necesitarás tener una lista de las posibles opciones y seleccionar la correcta
        // Aquí hay un ejemplo con CBUbiR, asumiendo que tienes una lista de ubicaciones
        String[] localicaciones = Conexion.obtenerLocalizaciones();
        CBLocR.setModel(new javax.swing.DefaultComboBoxModel<>(localicaciones));

        CBLocR.addActionListener(e -> {
            String[] ubicaciones = Conexion.obtenerUbicacionesDeAlmacen(CBLocR.getSelectedItem().toString());
            CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(ubicaciones));
        });


        String[] ubicaciones = Conexion.obtenerUbicacionesDeAlmacen(CBLocR.getSelectedItem().toString());
        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(ubicaciones));
        // Agrega un listener al botón de actualización
        BInsertarM.addActionListener(e -> {
            try {
                // Obtiene los valores de los campos de entrada
                String nombre = NombrePA.getText();
                int cantidad = Integer.parseInt(CantidadPA.getText());
                int stockMinimo = Integer.parseInt(StockMinimoM.getText());
                String formato = FormatoPA.getText();
                String localizacion = (String) CBLocR.getSelectedItem();
                String ubicacion = (String) CBUbiR.getSelectedItem();


                int idAlmacen = Conexion.obtenerIdAlmacen(localizacion);
                int idUbicacion = Conexion.obtenerIdUbicacion(ubicacion);

                //Creo un objeto ProductoAuxiliar con los datos del formulario
                ProductoAuxiliar pa2 = new ProductoAuxiliar( p.getId_producto(),  nombre,  cantidad,  stockMinimo,  ubicacion,
                        localizacion,  idAlmacen,  idUbicacion, formato);

                // Actualiza el producto en la base de datos
                Conexion.actualizarProductoAuxiliar(pa2  );

                // Muestra un mensaje indicando que el producto se actualizó correctamente
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");

                // Oculta la ventana actual
                this.setVisible(false);
            } catch (NumberFormatException ex) {
                // Muestra un mensaje si hay un error de formato en los campos de cantidad o stock mínimo
                JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido en los campos Cantidad y Stock Mínimo");
            }
        });
    }





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CantidadPA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        StockMinimoM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FormatoPA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NombrePA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CBLocR = new javax.swing.JComboBox<>();
        CBUbiR = new javax.swing.JComboBox<>();
        BInsertarM = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 255, 238));
        setPreferredSize(new java.awt.Dimension(1046, 656));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(222, 255, 238));
        jPanel1.setMinimumSize(new java.awt.Dimension(1046, 656));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Stock Mínimo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(600, 310, 190, 25);
        jPanel1.add(CantidadPA);
        CantidadPA.setBounds(280, 340, 190, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Localización");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(600, 130, 130, 30);
        jPanel1.add(StockMinimoM);
        StockMinimoM.setBounds(600, 340, 190, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(280, 130, 80, 25);
        jPanel1.add(FormatoPA);
        FormatoPA.setBounds(280, 260, 190, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 300, 80, 25);
        jPanel1.add(NombrePA);
        NombrePA.setBounds(280, 170, 190, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Formato");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(280, 230, 80, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        jLabel7.setEnabled(false);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(600, 220, 110, 25);

        CBLocR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CBLocR);
        CBLocR.setBounds(600, 170, 190, 30);

        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBUbiR.setEnabled(false);
        jPanel1.add(CBUbiR);
        CBUbiR.setBounds(600, 260, 190, 30);

        BInsertarM.setBackground(new java.awt.Color(0, 102, 102));
        BInsertarM.setForeground(new java.awt.Color(255, 255, 255));
        BInsertarM.setText("Actualizar");
        jPanel1.add(BInsertarM);
        BInsertarM.setBounds(430, 520, 160, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1050, 660);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BInsertarM;
    private javax.swing.JComboBox<String> CBLocR;
    private javax.swing.JComboBox<String> CBUbiR;
    private javax.swing.JTextField CantidadPA;
    private javax.swing.JTextField FormatoPA;
    private javax.swing.JTextField NombrePA;
    private javax.swing.JTextField StockMinimoM;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
