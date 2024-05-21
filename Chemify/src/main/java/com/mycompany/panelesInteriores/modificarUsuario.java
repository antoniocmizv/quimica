/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.panelesInteriores;

import com.mycompany.Clases.*;
import com.mycompany.ConexionSQL.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Mario Ortega
 */
public class modificarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form insertarUsuario
     */
    public modificarUsuario() {
        initComponents();
        //defino el modelo de tabla para ver los usuarios actuales
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Tipo de Usuario");
        jTable1.setModel(modelo);
        //añado los usuarios actuales
        ArrayList<User> usuarios = Conexion.obtenerUsuarios();
        for (User usuario : usuarios) {
            modelo.addRow(new Object[]{usuario.getUsername(), usuario.getPassword(), usuario.getType()});
        }
        //defino el combobox de tipo de usuario
        TipoUsuario.removeAllItems();
        TipoUsuario.addItem("admin");
        TipoUsuario.addItem("viewer");

        //añado el action listener al boton de añadir usuario
        jButton1.addActionListener(e -> {
            try {
                String nombre = NUsuario.getText().trim();
                String contraseña = CUsuario.getText().trim();
                String tipo = (String) TipoUsuario.getSelectedItem();

                // Validación de entrada
                if (nombre.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre y la contraseña no pueden estar vacíos.");
                    return;
                }
                User usuario = new User(nombre, contraseña, tipo, "");
                Conexion.insertarUsuario(usuario);
                modelo.addRow(new Object[]{nombre, contraseña, tipo});
                NUsuario.setText("");
                CUsuario.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });
        //añado el listener de click derecho para eliminar un usuario
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                    //añado un popup menu para eliminar un usuario
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem item = new JMenuItem("Eliminar");
                    menu.add(item);
                    menu.show(jTable1, e.getX(), e.getY());
                    item.addActionListener(e1 -> {
                        int row = jTable1.rowAtPoint(e.getPoint());
                        String nombre = (String) modelo.getValueAt(row, 0);
                        Conexion.eliminarUsuario(nombre);
                        modelo.removeRow(row);
                    });
                }
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

        NUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TipoUsuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 255, 238));
        setPreferredSize(new java.awt.Dimension(1046, 656));
        setLayout(null);
        add(NUsuario);
        NUsuario.setBounds(90, 220, 160, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("NOMBRE");
        add(jLabel1);
        jLabel1.setBounds(120, 190, 100, 30);

        CUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CUsuarioActionPerformed(evt);
            }
        });
        add(CUsuario);
        CUsuario.setBounds(90, 310, 160, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("TIPO DE USUARIO");
        add(jLabel2);
        jLabel2.setBounds(70, 360, 200, 40);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Añadir Usuario");
        add(jButton1);
        jButton1.setBounds(100, 480, 130, 30);

        TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        add(TipoUsuario);
        TipoUsuario.setBounds(110, 400, 120, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("CONTRASEÑA");
        add(jLabel3);
        jLabel3.setBounds(90, 270, 160, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(460, 190, 570, 310);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("GESTIÓN DE USUARIOS");
        add(jLabel4);
        jLabel4.setBounds(250, 40, 400, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setText("USUARIOS ACTUALES");
        add(jLabel5);
        jLabel5.setBounds(590, 130, 310, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setText("AÑADIR USUARIO");
        add(jLabel6);
        jLabel6.setBounds(40, 130, 270, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void CUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CUsuario;
    private javax.swing.JTextField NUsuario;
    private javax.swing.JComboBox<String> TipoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
