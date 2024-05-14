/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesInteriores;

import com.mycompany.Clases.ProductoAuxiliar;
import com.mycompany.ConexionSQL.Conexion;

/**
 *
 * @author mario
 */
public class InsertarPAuxiliares extends javax.swing.JPanel {

    /**
     * Creates new form Insertar
     */
    public InsertarPAuxiliares() {
        initComponents();
        //relleno los combox con una consulta a la base de datos
        String[] ubicaciones = Conexion.obtenerUbicaciones();
        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(ubicaciones));

        String[] localicaciones = Conexion.obtenerLocalizaciones();
        CBLocR.setModel(new javax.swing.DefaultComboBoxModel<>(localicaciones));

        //añado un action listener al boton insertar
        BInsertarM.addActionListener(e -> {
            //Creo un objeto Material con los datos del formulario
            String nombre = NombrePA.getText();
            int cantidad = Integer.parseInt(CantidadPA.getText());
            int stockMinimo = Integer.parseInt(StockMinimoM.getText());
            String formato = FormatoPA.getText();
            String ubicacion = (String) CBUbiR.getSelectedItem();
            String localizacion = (String) CBLocR.getSelectedItem();

            int id_almacen = 1; // Aquí debes obtener el id_almacen
            int id_ubicacion = 1; // Aquí debes obtener el id_ubicacion
            ProductoAuxiliar pa = new ProductoAuxiliar("1",nombre,cantidad,stockMinimo,ubicacion,localizacion,
                    id_almacen,id_ubicacion,formato);
            Conexion.insertarProductoAuxiliar(pa);
            //limipo los campos
            NombrePA.setText("");
            CantidadPA.setText("");
            StockMinimoM.setText("");
            FormatoPA.setText("");
            CBUbiR.setSelectedIndex(0);
            CBLocR.setSelectedIndex(0);
            //mensaje de confirmacion
            javax.swing.JOptionPane.showMessageDialog(null, "Material insertado correctamente");
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
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Stock Mínimo");
        add(jLabel2);
        jLabel2.setBounds(600, 280, 190, 25);
        add(CantidadPA);
        CantidadPA.setBounds(280, 310, 190, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Localización");
        add(jLabel3);
        jLabel3.setBounds(600, 120, 130, 30);
        add(StockMinimoM);
        StockMinimoM.setBounds(600, 310, 190, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        add(jLabel4);
        jLabel4.setBounds(280, 130, 80, 25);
        add(FormatoPA);
        FormatoPA.setBounds(280, 230, 190, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        add(jLabel5);
        jLabel5.setBounds(280, 280, 80, 25);
        add(NombrePA);
        NombrePA.setBounds(280, 170, 190, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Formato");
        add(jLabel6);
        jLabel6.setBounds(280, 200, 80, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        add(jLabel7);
        jLabel7.setBounds(600, 200, 110, 25);

        CBLocR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(CBLocR);
        CBLocR.setBounds(600, 160, 190, 30);

        CBUbiR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(CBUbiR);
        CBUbiR.setBounds(600, 230, 190, 30);

        BInsertarM.setBackground(new java.awt.Color(0, 102, 102));
        BInsertarM.setForeground(new java.awt.Color(255, 255, 255));
        BInsertarM.setText("INSERTAR");
        BInsertarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInsertarMActionPerformed(evt);
            }
        });
        add(BInsertarM);
        BInsertarM.setBounds(430, 520, 160, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void BInsertarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInsertarMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BInsertarMActionPerformed


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
    // End of variables declaration//GEN-END:variables
}
