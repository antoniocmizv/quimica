package org.clases;


import org.clases.interfaces.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        // Set the frame properties
        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the components
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        // Change the font and size
        Font font = new Font("SansSerif", Font.PLAIN, 16);
        usernameField.setFont(font);
        passwordField.setFont(font);
        loginButton.setFont(font);

        // Remove the border around the text fields
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Create a panel for the text fields
        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));
        textFieldsPanel.add(new JLabel("Usuario:"));
        textFieldsPanel.add(usernameField);
        textFieldsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        textFieldsPanel.add(new JLabel("Contraseña:"));
        textFieldsPanel.add(passwordField);

        // Set the layout for the main panel and add the components
        setLayout(new BorderLayout(10, 10)); // Add some padding
        add(textFieldsPanel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
        // Add an action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean isValidUser = Conexion.validarUsuario(username, password);

                if (isValidUser) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    Conexion.cerrar();
                    setVisible(false);
                    new Inicio();

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    Conexion.cerrar();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
