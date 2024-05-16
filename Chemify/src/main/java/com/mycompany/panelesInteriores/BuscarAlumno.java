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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author mario
 */
public class BuscarAlumno extends JPanel {

    private ArrayList<Producto> productos;

    /**
     * Creates new form Buscar
     */
    public BuscarAlumno() {
        initComponents();
    //hago que la tabla no se pueda editar
        tablaProductos.setDefaultEditor(Object.class, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        tablaProductos = new JTable();
        TFBuscar = new JTextField();
        botonBuscar = new JButton();
        jLabel1 = new JLabel();
        CBCantidad = new JCheckBox();
        Nombreaz = new JCheckBox();
        Nombreza = new JCheckBox();
        TFBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TFBuscar.setText("");
            }
        });
        CBCantidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    // Ordenar por cantidad (asumiendo que la cantidad es la tercera columna)
                    ordenarTabla((DefaultTableModel) tablaProductos.getModel(), 2);
                }
            }
        });
        Nombreaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    // Ordenar por nombre (asumiendo que el nombre es la segunda columna)
                    ordenarTabla((DefaultTableModel) tablaProductos.getModel(), 1);
                }
            }
        });

        setBackground(new Color(222, 255, 238));
        setPreferredSize(new Dimension(1046, 668));

        tablaProductos.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},

                },
                new String[]{
                        " ", " ", " ", " ", " "
                }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        TFBuscar.setText("Nombre");
        TFBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFBuscarFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TFBuscarFocusLost(evt);
            }
        });
        TFBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TFBuscarActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new Color(0, 102, 102));
        botonBuscar.setForeground(new Color(255, 255, 255));
        botonBuscar.setText("Buscar");

        jLabel1.setBackground(new Color(0, 0, 0));
        jLabel1.setText("Ordenar por : ");

        CBCantidad.setText("Cantidad ");

        Nombreaz.setText("Nombre (a-z)");
        Nombreaz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NombreazActionPerformed(evt);
            }
        });

        Nombreza.setText("Nombre (z-a)");
        Nombreza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NombrezaActionPerformed(evt);
            }
        });
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(433, 433, 433)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Nombreaz)
                                                                        .addComponent(CBCantidad)
                                                                        .addComponent(Nombreza)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(TFBuscar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(61, 61, 61)
                                                                .addComponent(botonBuscar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 986, GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonBuscar)
                                        .addComponent(TFBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(CBCantidad))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nombreaz)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nombreza, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_TFBuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TFBuscarActionPerformed

    private void NombreazActionPerformed(ActionEvent evt) {//GEN-FIRST:event_NombreazActionPerformed
        // TODO add your handling code here:
        if (Nombreaz.isSelected()) {
            Nombreza.setSelected(false);
        }
    }//GEN-LAST:event_NombreazActionPerformed

    private void NombrezaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_NombrezaActionPerformed
        // TODO add your handling code here:
        if (Nombreza.isSelected()) {
            Nombreaz.setSelected(false);
        }
    }//GEN-LAST:event_NombrezaActionPerformed

    private void TFBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFBuscarFocusGained
        // TODO add your handling code here:
        if (TFBuscar.getText().equalsIgnoreCase("Nombre"))// Al clicar en el tfield borra su contenido si su contenido coincide con el valor default
            TFBuscar.setText("");
    }//GEN-LAST:event_TFBuscarFocusGained

    private void TFBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFBuscarFocusLost
        // TODO add your handling code here:
        if (TFBuscar.getText().isBlank() || TFBuscar.getText().isEmpty()) //Comprueba que el TextField este vacio o en blanco para poner el texto por defecto
            TFBuscar.setText("Nombre");
    }//GEN-LAST:event_TFBuscarFocusLost

    private DefaultTableModel generarModeloTablaProducto() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Cantidad", "Stock Mínimo", "Ubicación", "Almacén"}
        );
    }

    private DefaultTableModel generarModeloTablaMateriales() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Cantidad", "Stock Mínimo", "Ubicación", "Almacén", "Tipo", "Descripción", "Fecha Compra", "Número Serie"}
        );
    }

    private DefaultTableModel generarModeloTablaQuimico() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Cantidad", "Stock Mínimo", "Ubicación", "Almacén", "Pureza", "Fecha Caducidad", "Formato"}
        );
    }

    private DefaultTableModel generarModeloTablaProductoAuxiliar() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Cantidad", "Stock Mínimo", "Ubicación", "Almacén", "Formato"}
        );
    }

    private void botonBuscarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_BuscarBoton1ActionPerformed
        // TODO add your handling code here:
        try {
            tablaProductos.setVisible(true);

            productos = Conexion.buscarProductos(TFBuscar.getText());
            //Añadir los productos a la tabla de productos
            DefaultTableModel model;

            if (!productos.isEmpty()) {
                Producto primerProducto = productos.get(0);
                if (primerProducto instanceof Materiales) {
                    model = generarModeloTablaMateriales();
                } else if (primerProducto instanceof Quimico) {
                    model = generarModeloTablaQuimico();
                } else if (primerProducto instanceof ProductoAuxiliar) {
                    model = generarModeloTablaProductoAuxiliar();
                } else {
                    model = generarModeloTablaProducto();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron productos");
                model = generarModeloTablaProducto();
            }

            for (Producto producto : productos) {
                if (producto instanceof Materiales) {
                    Materiales material = (Materiales) producto;
                    model.addRow(new Object[]{
                            material.getId_producto(),
                            material.getNombre(),
                            material.getCantidad(),
                            material.getStock_minimo(),
                            material.getUbicacion(),
                            material.getAlmacen(),
                            material.getSubtipo(),
                            material.getDescripcion(),
                            material.getFecha_compra(),
                            material.getNumero_serie()
                    });
                } else if (producto instanceof Quimico) {
                    Quimico quimico = (Quimico) producto;
                    model.addRow(new Object[]{
                            quimico.getId_producto(),
                            quimico.getNombre(),
                            quimico.getCantidad(),
                            quimico.getStock_minimo(),
                            quimico.getUbicacion(),
                            quimico.getAlmacen(),
                            quimico.getPureza(),
                            quimico.getFecha_caducidad(),
                            quimico.getFormato()
                    });
                } else {
                    model.addRow(new Object[]{
                            producto.getId_producto(),
                            producto.getNombre(),
                            producto.getCantidad(),
                            producto.getStock_minimo(),
                            producto.getUbicacion(),
                            producto.getAlmacen()
                    });
                }
                tablaProductos.setModel(model);
            }

        } catch (NullPointerException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al buscar productos, no se encuentra");
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al buscar productos" + ex);
        }


    }//GEN-LAST:event_BuscarBoton1ActionPerformed

    private void ordenarTabla(DefaultTableModel modelo, int columna) {
        // Convertir los datos de la tabla a una lista
        List<Producto> datos = new ArrayList<>(productos);

        // Ordenar la lista por cantidad
        datos.sort(Comparator.comparing(Producto::getCantidad));

        // Limpiar la tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        // Agregar los datos ordenados a la tabla
        for (Producto producto : datos) {
            if (producto instanceof Materiales) {
                Materiales material = (Materiales) producto;
                modelo.addRow(new Object[]{
                        material.getId_producto(),
                        material.getNombre(),
                        material.getCantidad(),
                        material.getStock_minimo(),
                        material.getUbicacion(),
                        material.getAlmacen(),
                        material.getSubtipo(),
                        material.getDescripcion(),
                        material.getFecha_compra(),
                        material.getNumero_serie()
                });
            } else if (producto instanceof Quimico) {
                Quimico quimico = (Quimico) producto;
                modelo.addRow(new Object[]{
                        quimico.getId_producto(),
                        quimico.getNombre(),
                        quimico.getCantidad(),
                        quimico.getStock_minimo(),
                        quimico.getUbicacion(),
                        quimico.getAlmacen(),
                        quimico.getPureza(),
                        quimico.getFecha_caducidad(),
                        quimico.getFormato()
                });
            } else {
                modelo.addRow(new Object[]{
                        producto.getId_producto(),
                        producto.getNombre(),
                        producto.getCantidad(),
                        producto.getStock_minimo(),
                        producto.getUbicacion(),
                        producto.getAlmacen()
                });
            }
        }
        // Establecer el modelo de la tabla
        tablaProductos.setModel(modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton botonBuscar;
    private JCheckBox CBCantidad;
    private JCheckBox Nombreaz;
    private JCheckBox Nombreza;
    private JTextField TFBuscar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
