/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesActualizar;

import com.mycompany.Clases.objetos.Producto;
import com.mycompany.Clases.objetos.Quimico;
import com.mycompany.ConexionSQL.Conexion;

import javax.swing.*;

/**
 * @author mario
 */
public class ActualizarR extends JFrame {

    /**
     * Creates new form Insertar
     */
    public ActualizarR(Producto p) {
        initComponents();
        this.setVisible(true);
        this.setSize(1046, 656);
        this.setLocationRelativeTo(null);

        // Rellenar los campos con los datos del producto
        //Hago un downcasting de producto a quimico
        Quimico pq = (Quimico) p;
        NombreR.setText(p.getNombre());
        CantidadR.setText(String.valueOf(p.getCantidad()));
        StockMinimoR.setText(String.valueOf(p.getStock_minimo()));
        GradoPurezaR.setText(String.valueOf(pq.getPureza()));
        FechaCaducidadR.setText(pq.getFecha_caducidad());

        // Para los JComboBox, necesitarás tener una lista de las posibles opciones y seleccionar la correcta
        // Aquí hay un ejemplo con CBUbiR, asumiendo que tienes una lista de ubicaciones
        String[] localicaciones = Conexion.obtenerLocalizaciones();
        CBLocR1.setModel(new javax.swing.DefaultComboBoxModel<>(localicaciones));

        CBLocR1.addActionListener(e -> {
            String[] ubicaciones = Conexion.obtenerUbicacionesDeAlmacen(CBLocR1.getSelectedItem().toString());
            CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(ubicaciones));
        });


        String[] ubicaciones = Conexion.obtenerUbicacionesDeAlmacen(CBLocR1.getSelectedItem().toString());
        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(ubicaciones));

        String[] formatos = Conexion.obtenerFormatosQ();
        CBForR.setModel(new DefaultComboBoxModel<>(formatos));
        CBForR.setSelectedItem(pq.getFormato());

        //String[] riesgos = Conexion.obtenerRiesgos();
        // CBRiesR.setModel(new DefaultComboBoxModel<>(riesgos));
        CBRiesR.setSelectedItem(pq.getRiesgo());

        String[] localizaciones = Conexion.obtenerLocalizaciones();
        CBLocR1.setModel(new DefaultComboBoxModel<>(localizaciones));
        //saco los datos para actualizar
        BInsertarM.addActionListener(e -> {
            try {
                // Obtiene los valores de los campos de entrada
                String nombre = NombreR.getText();
                int cantidad = Integer.parseInt(CantidadR.getText());
                int stockMinimo = Integer.parseInt(StockMinimoR.getText());
                String gradoPureza = GradoPurezaR.getText();
                String fechaCaducidad = FechaCaducidadR.getText();
                String ubicacion = (String) CBUbiR.getSelectedItem();
                String formato = (String) CBForR.getSelectedItem();
                String riesgo = (String) CBRiesR.getSelectedItem();
                String localizacion = (String) CBLocR1.getSelectedItem();

                // Obtén los valores de id_almacen e id_ubicacion según tu implementación
                int idAlmacen = Conexion.obtenerIdAlmacen(localizacion);
                int idUbicacion = Conexion.obtenerIdUbicacion(ubicacion);

                //Creo un objeto Quimico con los datos del formulario
                Quimico pq2 = new Quimico(p.getId_producto(), nombre, cantidad, stockMinimo, ubicacion, localizacion
                        , idAlmacen, idUbicacion, gradoPureza, fechaCaducidad, formato, riesgo);

                // Actualiza el producto en la base de datos
                Conexion.actualizarQuimico(pq2);
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
                //cierra la ventana
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + ex.getMessage());
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
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BInsertarM = new javax.swing.JButton();
        CantidadR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreR = new javax.swing.JTextField();
        StockMinimoR = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        GradoPurezaR = new javax.swing.JTextField();
        CBUbiR = new javax.swing.JComboBox<>();
        CBForR = new javax.swing.JComboBox<>();
        CBRiesR = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        CBLocR1 = new javax.swing.JComboBox<>();
        FechaCaducidadR = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 255, 238));
        setPreferredSize(new java.awt.Dimension(1046, 656));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(222, 255, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(1046, 656));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(580, 150, 90, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(270, 80, 80, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 220, 80, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Stock Mínimo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 370, 190, 25);

        BInsertarM.setBackground(new java.awt.Color(0, 102, 102));
        BInsertarM.setForeground(new java.awt.Color(255, 255, 255));
        BInsertarM.setText("ACTUALIZAR");
        jPanel1.add(BInsertarM);
        BInsertarM.setBounds(430, 510, 160, 40);
        jPanel1.add(CantidadR);
        CantidadR.setBounds(270, 250, 190, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Formato");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 150, 80, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Localización");
        jLabel3.setFocusable(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(580, 70, 130, 30);
        jPanel1.add(NombreR);
        NombreR.setBounds(270, 110, 260, 30);
        jPanel1.add(StockMinimoR);
        StockMinimoR.setBounds(270, 400, 190, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Riesgos");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(270, 290, 190, 25);
        jPanel1.add(GradoPurezaR);
        GradoPurezaR.setBounds(580, 250, 190, 30);

        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CBUbiR);
        CBUbiR.setBounds(580, 180, 190, 30);

        CBForR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CBForR);
        CBForR.setBounds(270, 180, 190, 30);

        CBRiesR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CBRiesR);
        CBRiesR.setBounds(270, 320, 190, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Grado de Pureza");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(580, 220, 190, 25);

        CBLocR1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBLocR1.setFocusable(false);
        jPanel1.add(CBLocR1);
        CBLocR1.setBounds(580, 110, 190, 30);
        jPanel1.add(FechaCaducidadR);
        FechaCaducidadR.setBounds(580, 320, 190, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Fecha de Caducidad");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(580, 290, 190, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1050, 660);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BInsertarM;
    private javax.swing.JComboBox<String> CBForR;
    private javax.swing.JComboBox<String> CBLocR1;
    private javax.swing.JComboBox<String> CBRiesR;
    private javax.swing.JComboBox<String> CBUbiR;
    private javax.swing.JTextField CantidadR;
    private javax.swing.JTextField FechaCaducidadR;
    private javax.swing.JTextField GradoPurezaR;
    private javax.swing.JTextField NombreR;
    private javax.swing.JTextField StockMinimoR;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
