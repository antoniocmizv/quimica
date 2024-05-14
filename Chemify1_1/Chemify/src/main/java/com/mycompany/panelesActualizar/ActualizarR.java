/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesActualizar;

import com.mycompany.Clases.Producto;
import com.mycompany.Clases.Quimico;
import com.mycompany.ConexionSQL.Conexion;
import com.mycompany.panelesInteriores.*;

import javax.swing.*;

/**
 * @author mario
 */
public class ActualizarR extends javax.swing.JFrame {

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
        String[] ubicaciones = Conexion.obtenerUbicaciones();
        CBUbiR.setModel(new DefaultComboBoxModel<>(ubicaciones));
        CBUbiR.setSelectedItem(p.getUbicacion());

        String[] formatos = Conexion.obtenerFormatosQ();
        CBForR.setModel(new DefaultComboBoxModel<>(formatos));
        CBForR.setSelectedItem(pq.getFormato());

        //String[] riesgos = Conexion.obtenerRiesgos();
       // CBRiesR.setModel(new DefaultComboBoxModel<>(riesgos));
        CBRiesR.setSelectedItem(pq.getRiesgo());

        // Puedes hacer lo mismo con los otros JComboBox
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(580, 80, 110, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 80, 80, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(270, 220, 80, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Stock Mínimo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 290, 190, 25);

        BInsertarM.setBackground(new java.awt.Color(0, 102, 102));
        BInsertarM.setForeground(new java.awt.Color(255, 255, 255));
        BInsertarM.setText("ACTUALIZAR");
        BInsertarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInsertarMActionPerformed(evt);
            }
        });
        getContentPane().add(BInsertarM);
        BInsertarM.setBounds(430, 510, 160, 40);
        getContentPane().add(CantidadR);
        CantidadR.setBounds(270, 250, 190, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Formato");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(270, 150, 80, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Localización");
        jLabel3.setEnabled(false);
        jLabel3.setFocusable(false);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 420, 130, 30);
        getContentPane().add(NombreR);
        NombreR.setBounds(270, 110, 190, 30);
        getContentPane().add(StockMinimoR);
        StockMinimoR.setBounds(580, 320, 190, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Riesgos");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 290, 190, 25);
        getContentPane().add(GradoPurezaR);
        GradoPurezaR.setBounds(580, 180, 190, 30);

        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CBUbiR);
        CBUbiR.setBounds(580, 110, 190, 30);

        CBForR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CBForR);
        CBForR.setBounds(270, 180, 190, 30);

        CBRiesR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CBRiesR);
        CBRiesR.setBounds(270, 320, 190, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Grado de Pureza");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(580, 150, 190, 25);

        CBLocR1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBLocR1.setEnabled(false);
        CBLocR1.setFocusable(false);
        getContentPane().add(CBLocR1);
        CBLocR1.setBounds(50, 460, 190, 30);
        getContentPane().add(FechaCaducidadR);
        FechaCaducidadR.setBounds(580, 250, 190, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Fecha de Caducidad");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(580, 220, 190, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void BInsertarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInsertarMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BInsertarMActionPerformed


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
    // End of variables declaration//GEN-END:variables
}
