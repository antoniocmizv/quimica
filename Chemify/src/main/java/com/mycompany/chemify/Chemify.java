/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chemify;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.interfazSpring.MiAplicacion;

import javax.swing.*;

/**
 *
 * @author mario
 */
public class Chemify {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Cambia la skin de la aplicación por FlatLaf
                // Se hace aqui ya que tiene que ser antes de que se inicie la Ventana Principal
                try {
                    FlatLightLaf.setup();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                new Login();
            }
        });

    }
}
