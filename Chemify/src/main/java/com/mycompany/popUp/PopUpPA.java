/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.popUp;

import com.mycompany.Clases.ProductoAuxiliar;

import java.awt.*;

/**
 * @author Mario
 */
public class PopUpPA extends javax.swing.JFrame {

    /**
     * Creates new form popUp
     */
    public PopUpPA(ProductoAuxiliar pa) {
        initComponents();
        this.pack();
        try {
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/quimica.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setResizable(false);


        NomTF.setEditable(false);
        NomTF.setFocusable(false);

        ForTF.setEditable(false);
        ForTF.setFocusable(false);

        CanTF.setEditable(false);
        CanTF.setFocusable(false);


        LocTF.setEditable(false);
        LocTF.setFocusable(false);

        UbiTF.setEditable(false);
        UbiTF.setFocusable(false);

        StoTF.setEditable(false);
        StoTF.setFocusable(false);


        NomTF.setText(pa.getNombre());
        ForTF.setText(pa.getFormato());
        CanTF.setText(String.valueOf(pa.getCantidad()));
        LocTF.setText(pa.getAlmacen());
        UbiTF.setText(pa.getUbicacion());
        StoTF.setText(String.valueOf(pa.getStock_minimo()));

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CanTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UbiTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ForTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NomTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LocTF = new javax.swing.JTextField();
        StoTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 171, 182));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETALLES DEL PRODUCTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 100);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Stock Mínimo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 450, 190, 25);
        jPanel1.add(CanTF);
        CanTF.setBounds(150, 480, 190, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Localización");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 260, 130, 30);
        jPanel1.add(UbiTF);
        UbiTF.setBounds(470, 390, 190, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 260, 80, 30);
        jPanel1.add(ForTF);
        ForTF.setBounds(150, 390, 190, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 450, 80, 25);
        jPanel1.add(NomTF);
        NomTF.setBounds(150, 300, 190, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Formato");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 360, 80, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ubicación");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(470, 360, 140, 25);
        jPanel1.add(LocTF);
        LocTF.setBounds(470, 300, 190, 30);
        jPanel1.add(StoTF);
        StoTF.setBounds(470, 480, 190, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CanTF;
    private javax.swing.JTextField ForTF;
    private javax.swing.JTextField LocTF;
    private javax.swing.JTextField NomTF;
    private javax.swing.JTextField StoTF;
    private javax.swing.JTextField UbiTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
