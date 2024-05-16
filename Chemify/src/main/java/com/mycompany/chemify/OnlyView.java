/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.chemify;

import java.awt.*;
import java.net.URL;

import com.mycompany.Clases.ConexionManager;
import com.mycompany.panelesInteriores.BuscarAlumno;

import javax.swing.*;

/**
 *
 * @author mario and antonio castillo
 */
public class OnlyView extends javax.swing.JFrame {

    /**
     * Creates new form OnlyView
     */
    public OnlyView() {
        this.setVisible(true);
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        try {
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/quimica.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        BuscarAlumno pba1 = new BuscarAlumno();
        pba1.setSize(1046,656);
        pba1.setLocation(0, 0);
        
        
        ContenedorAlumno.removeAll();
        ContenedorAlumno.add(pba1,BorderLayout.CENTER);
        ContenedorAlumno.revalidate();
        ContenedorAlumno.repaint();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAlumno = new javax.swing.JPanel();
        Izquierda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BBuscar = new javax.swing.JButton();
        BCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ContenedorAlumno = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHEMIFY");
        setPreferredSize(new java.awt.Dimension(1414, 837));

        PanelAlumno.setToolTipText("");
        PanelAlumno.setPreferredSize(new java.awt.Dimension(1400, 800));
        PanelAlumno.setLayout(null);

        Izquierda.setBackground(new java.awt.Color(0, 102, 102));
        Izquierda.setPreferredSize(new java.awt.Dimension(350, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(222, 255, 238));
        jLabel1.setText("CHEMIFY");

        BBuscar.setBackground(new java.awt.Color(255, 255, 238));
        BBuscar.setForeground(new java.awt.Color(0, 0, 0));
        BBuscar.setText("Buscar");
        BBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });

        BCerrarSesion.setBackground(new java.awt.Color(255, 255, 238));
        BCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        BCerrarSesion.setText("Cerrar Sesión");
        BCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSesionActionPerformed(evt);
            }
        });

        URL url = getClass().getResource("/cerrar-sesion.png");
        ImageIcon icon = new ImageIcon(url);
        jLabel2.setIcon(icon);// NOI18N

        javax.swing.GroupLayout IzquierdaLayout = new javax.swing.GroupLayout(Izquierda);
        Izquierda.setLayout(IzquierdaLayout);
        IzquierdaLayout.setHorizontalGroup(
            IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IzquierdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(96, 96, 96))
            .addGroup(IzquierdaLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IzquierdaLayout.createSequentialGroup()
                        .addComponent(BCerrarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        IzquierdaLayout.setVerticalGroup(
            IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IzquierdaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(164, 164, 164)
                .addComponent(BBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(BCerrarSesion))
                .addGap(61, 61, 61))
        );

        PanelAlumno.add(Izquierda);
        Izquierda.setBounds(-10, -10, 350, 810);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 800));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1050, 123));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        ContenedorAlumno.setBackground(new java.awt.Color(222, 255, 238));
        ContenedorAlumno.setPreferredSize(new java.awt.Dimension(1046, 656));

        javax.swing.GroupLayout ContenedorAlumnoLayout = new javax.swing.GroupLayout(ContenedorAlumno);
        ContenedorAlumno.setLayout(ContenedorAlumnoLayout);
        ContenedorAlumnoLayout.setHorizontalGroup(
            ContenedorAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContenedorAlumnoLayout.setVerticalGroup(
            ContenedorAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenedorAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
        );

        PanelAlumno.add(jPanel1);
        jPanel1.setBounds(340, 0, 1070, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BBuscarActionPerformed

    private void BCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarSesionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login lg1 = new Login();
        lg1.setVisible(true);
    }//GEN-LAST:event_BCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OnlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnlyView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton BCerrarSesion;
    private javax.swing.JPanel ContenedorAlumno;
    private javax.swing.JPanel Izquierda;
    private javax.swing.JPanel PanelAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
