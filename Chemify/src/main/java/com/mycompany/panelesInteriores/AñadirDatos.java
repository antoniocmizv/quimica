/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesInteriores;

import com.mycompany.Clases.Materiales;
import com.mycompany.Clases.Producto;
import com.mycompany.Clases.ProductoAuxiliar;
import com.mycompany.Clases.Quimico;
import com.mycompany.ConexionSQL.Conexion;
import com.mycompany.panelesActualizar.ActualizarM;
import com.mycompany.panelesActualizar.ActualizarPA;
import com.mycompany.panelesActualizar.ActualizarR;
import com.mycompany.popUp.PopUpM;
import com.mycompany.popUp.PopUpPA;
import com.mycompany.popUp.PopUpR;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author mario
 */
public class AñadirDatos extends javax.swing.JPanel {

    /**
     * Creates new form AñadirDatos
     */
    public AñadirDatos() {

        initComponents();
        rellenarTablaFormato();
        jLabel3.setVisible(false);
        Almacenes.setVisible(false);
        jTable1.setModel(modeloFormato());
        rellenarTablaFormato();

        //ajusto el combobox para declaarar los posibles valores
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formato", "Ubicación", "Almacen"}));


        //añado un listener al combobox
        jComboBox1.addActionListener(e -> {
            //obtengo el valor seleccionado
            String seleccion = (String) jComboBox1.getSelectedItem();
            //dependiendo del valor seleccionado, muestro un mensaje
            switch (seleccion) {
                case "Formato":
                    jLabel3.setVisible(false);
                    Almacenes.setVisible(false);
                    jTable1.setModel(modeloFormato());
                    //relleno la tabla con una consulta
                    rellenarTablaFormato();
                    break;
                case "Ubicación":
                    jTable1.setModel(modeloUbicaciones());
                    //relleno la tabla con una consulta
                    rellenarTablaUbicaciones();
                    jLabel3.setVisible(true);
                    Almacenes.setVisible(true);
                    Almacenes.setModel(new javax.swing.DefaultComboBoxModel<>(Conexion.obtenerLocalizaciones()));
                    break;
                case "Almacen":
                    jLabel3.setVisible(false);
                    Almacenes.setVisible(false);
                    jTable1.setModel(modeloAlmacen());
                    //relleno la tabla con una consulta
                    rellenarTablaLocalizaciones();
                    break;
                default:
                    jTable1.setModel(new DefaultTableModel());
                    break;
            }
        });
        //añado un listener al boton para insertar
        BFor.addActionListener(e -> {
            //obtengo el valor del campo de texto
            String valor = AñadirFor.getText();
            //obtengo el valor seleccionado del combobox
            String seleccion = (String) jComboBox1.getSelectedItem();
            //dependiendo del valor seleccionado, inserto un valor
            switch (seleccion) {
                case "Formato":
                    Conexion.insertarFormato(valor);
                    rellenarTablaFormato();
                    break;
                case "Ubicación":
                    int idAlmacen = Conexion.obtenerIdAlmacen(Almacenes.getSelectedItem().toString());
                    Conexion.insertarUbicacion(valor, idAlmacen);
                    rellenarTablaUbicaciones();
                    break;
                case "Almacen":
                    Conexion.insertarLocalizacion(valor);
                    rellenarTablaLocalizaciones();
                    break;
                default:
                    break;
            }
        });

        //añado un listener a la tabla para que el click derecho borre
        jTable1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem menuItem2 = new JMenuItem("Eliminar");
                    popup.add(menuItem2);
                    popup.show(table, me.getX(), me.getY());
                    menuItem2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Aquí va el código para eliminar el producto
                            //obtengo el valor seleccionado en la tabla
                            String valor = (String) jTable1.getValueAt(row, 0);


                            //mensaje de verificacion
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el campo?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                // Eliminar el producto
                                if (jComboBox1.getSelectedItem().equals("Formato")) {
                                    Conexion.eliminarFormato(valor);
                                    rellenarTablaFormato();
                                } else if (jComboBox1.getSelectedItem().equals("Ubicación")) {
                                    Conexion.eliminarUbicacion(valor);
                                    rellenarTablaUbicaciones();
                                } else if (jComboBox1.getSelectedItem().equals("Almacen")) {
                                    Conexion.eliminarLocalizacion(valor);
                                    rellenarTablaLocalizaciones();
                                }
                                JOptionPane.showMessageDialog(null, "Registro eliminado");

                            }

                        }
                    });
                }
            }
        });

    }

    private void rellenarTablaUbicaciones() {
        //obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //limpio la tabla
        modelo.setRowCount(0);
        //relleno la tabla con una consulta
        String [] ubicaciones = Conexion.obtenerUbicaciones();
        for (String ubicacion : ubicaciones) {
            modelo.addRow(new Object[]{ubicacion});
        }

    }
    private void rellenarTablaFormato(){
        //obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //limpio la tabla
        modelo.setRowCount(0);
        //relleno la tabla con una consulta
        String [] formatos = Conexion.obtenerFormatosQ();
        for (String formato : formatos) {
            modelo.addRow(new Object[]{formato});
        }
    }
    private void rellenarTablaLocalizaciones(){
        //obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //limpio la tabla
        modelo.setRowCount(0);
        //relleno la tabla con una consulta
        String [] localizaciones = Conexion.obtenerLocalizaciones();
        for (String localizacion : localizaciones) {
            modelo.addRow(new Object[]{localizacion});
        }
    }

    private DefaultTableModel modeloFormato() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"Formato"}
        );
    }

    private DefaultTableModel modeloUbicaciones() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"Ubicación"}
        );
    }

    private DefaultTableModel modeloAlmacen() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"Almacen"}
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AñadirFor = new javax.swing.JTextField();
        BFor = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Almacenes = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(222, 255, 238));
        setPreferredSize(new java.awt.Dimension(1046, 656));
        setLayout(null);
        add(AñadirFor);
        AñadirFor.setBounds(130, 310, 190, 30);

        BFor.setBackground(new java.awt.Color(0, 102, 102));
        BFor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BFor.setForeground(new java.awt.Color(255, 255, 255));
        BFor.setText("Añadir");
        BFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BForActionPerformed(evt);
            }
        });
        add(BFor);
        BFor.setBounds(170, 430, 100, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1);
        jComboBox1.setBounds(130, 230, 150, 22);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(510, 230, 452, 210);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setText("AÑADIR ");
        add(jLabel6);
        jLabel6.setBounds(130, 170, 170, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setText("CONSULTAR Y BORRAR");
        add(jLabel7);
        jLabel7.setBounds(560, 150, 370, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("GESTIÓN DE DATOS");
        add(jLabel1);
        jLabel1.setBounds(310, 0, 350, 80);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("VALOR");
        add(jLabel2);
        jLabel2.setBounds(130, 270, 100, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setText("ELIJA ALMACÉN:");
        add(jLabel3);
        jLabel3.setBounds(130, 350, 250, 30);

        Almacenes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Almacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlmacenesActionPerformed(evt);
            }
        });
        add(Almacenes);
        Almacenes.setBounds(130, 390, 210, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void AlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmacenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlmacenesActionPerformed

    private void BForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BForActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Almacenes;
    private javax.swing.JTextField AñadirFor;
    private javax.swing.JButton BFor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
