package org.clases.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;

    public Gestion() {
        // Configuración de la ventana
        setTitle("Gestión de Productos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // Creación de los componentes
        searchField = new JTextField(20);
        searchButton = new JButton("Buscar");
        insertButton = new JButton("Insertar");
        deleteButton = new JButton("Eliminar");
        updateButton = new JButton("Actualizar");

        // Personalización de los componentes
        Font font = new Font("SansSerif", Font.PLAIN, 16);
        searchField.setFont(font);
        searchButton.setFont(font);
        insertButton.setFont(font);
        deleteButton.setFont(font);
        updateButton.setFont(font);


        // Añadir los componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        add(panel);

        // Añadir ActionListener a los botones
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Conexion para buscar productos

            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Conexion para insertar productos
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Conexion para eliminar productos
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Conexion para actualizar productos
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new Gestion();
    }
}