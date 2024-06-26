/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.chemify;

import com.mycompany.ConexionSQL.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

/**
 * @author mario
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {

        initComponents();
        this.pack(); // Se ajusta al tamaño preferido establecido
        this.setLocationRelativeTo(null); // Situamos la pestaña en el centro
        this.setResizable(false);
        this.setVisible(true);
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    // Checkbox has been selected
                    PFContraseña.setEchoChar((char) 0);
                } else {
                    // Checkbox has been deselected
                    PFContraseña.setEchoChar('*');
                }
            }
        });
        try {
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/quimica.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        Derecha = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        TituloEmpresa = new javax.swing.JLabel();
        Izquierda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFUsuario = new javax.swing.JTextField();
        PFContraseña = new javax.swing.JPasswordField();
        BEntrar = new javax.swing.JButton();
        BAlumno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN\n");
        setLocation(new java.awt.Point(0, 0));

        PanelLogin.setBackground(new java.awt.Color(153, 153, 153));
        PanelLogin.setPreferredSize(new java.awt.Dimension(800, 500));
        PanelLogin.setLayout(null);

        Derecha.setBackground(new java.awt.Color(0, 102, 102));
        Derecha.setPreferredSize(new java.awt.Dimension(400, 500));

        TituloEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloEmpresa.setForeground(new java.awt.Color(222, 255, 238));
        TituloEmpresa.setText("CHEMIFY");
        URL url = getClass().getResource("/quimica.png");
        ImageIcon icon = new ImageIcon(url);
        Logo.setIcon(icon);
        javax.swing.GroupLayout DerechaLayout = new javax.swing.GroupLayout(Derecha);
        Derecha.setLayout(DerechaLayout);
        DerechaLayout.setHorizontalGroup(
                DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DerechaLayout.createSequentialGroup()
                                .addContainerGap(332, Short.MAX_VALUE)
                                .addComponent(Logo)
                                .addGap(71, 71, 71))
                        .addGroup(DerechaLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(TituloEmpresa)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DerechaLayout.setVerticalGroup(
                DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DerechaLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(TituloEmpresa)
                                .addContainerGap(60, Short.MAX_VALUE))
        );

        PanelLogin.add(Derecha);
        Derecha.setBounds(0, 0, 400, 500);

        Izquierda.setBackground(new java.awt.Color(222, 255, 238));
        Izquierda.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("CONTRASEÑA");

        TFUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        PFContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFContraseñaActionPerformed(evt);
            }
        });

        BEntrar.setBackground(new java.awt.Color(0, 102, 102));
        BEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BEntrar.setText("Entrar");
        BEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEntrarActionPerformed(evt);
            }
        });

        BAlumno.setBackground(new java.awt.Color(0, 102, 102));
        BAlumno.setForeground(new java.awt.Color(255, 255, 255));
        BAlumno.setText("Entrar como Alumno");
        BAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAlumnoActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Revelar Contraseña");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IzquierdaLayout = new javax.swing.GroupLayout(Izquierda);
        Izquierda.setLayout(IzquierdaLayout);
        IzquierdaLayout.setHorizontalGroup(
                IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(jLabel1))
                                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(TFUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                        .addComponent(PFContraseña)))
                                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(BEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(BAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(jCheckBox1)))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        IzquierdaLayout.setVerticalGroup(
                IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IzquierdaLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1)
                                .addGap(12, 12, 12)
                                .addComponent(BEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );

        PanelLogin.add(Izquierda);
        Izquierda.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PFContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PFContraseñaActionPerformed

    private void BAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAlumnoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        OnlyView ov1 = new OnlyView();
        ov1.setVisible(true);
    }//GEN-LAST:event_BAlumnoActionPerformed

    private void BEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEntrarActionPerformed
        // TODO add your handling code here:

        String username = TFUsuario.getText();
        String password = new String(PFContraseña.getPassword());

        boolean isValidUser = Conexion.validarUsuario(username, password);
        String typeuser = Conexion.getTypeUser(username, password);
        //control de errores.
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña vacíos");
            return;
        }
        if (isValidUser) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
            Conexion.cerrar();
            setVisible(false);
            if (typeuser.equals("admin")) {
                new TeacherWindow();

            } else new OnlyView();

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            Conexion.cerrar();
        }


    }//GEN-LAST:event_BEntrarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAlumno;
    private javax.swing.JButton BEntrar;
    private javax.swing.JPanel Derecha;
    private javax.swing.JPanel Izquierda;
    private javax.swing.JLabel Logo;
    private javax.swing.JPasswordField PFContraseña;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JLabel TituloEmpresa;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
