/*
 * Esta clase representa la ventana donde se realizan operaciones con Actividades
 */
package com.proyectofinal.main;

import com.proyectofinal.datos.DAOActividades;
import com.proyectofinal.entidades.Actividad;
import com.proyectofinal.entidades.Tema;
import com.proyectofinal.main.VentanaPrincipal.Modo;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author al_12
 */
public class ModificarActividad extends javax.swing.JDialog {

    private Tema tema;
    private Actividad actividad;
    private Modo modo;

    /**
     * Creates new form AñadirAsignatura
     */
    public ModificarActividad(java.awt.Frame parent, boolean modal, Tema tema, Modo modo) {
        super(parent, modal);
        this.tema = tema;
        this.modo = modo;
        initComponents();
        etiquetaActividad.setText(modo.toString().substring(0, 1).toUpperCase()
                + modo.toString().substring(1).toLowerCase()
                + " actividad");
        if (modo == Modo.AÑADIR) {
            botonAceptar.setText("Añadir");
        }
    }

    public ModificarActividad(java.awt.Frame parent, boolean modal, Tema tema, Actividad actividad, Modo modo) {
        super(parent, modal);
        this.tema = tema;
        this.actividad = actividad;
        this.modo = modo;
        initComponents();
        etiquetaActividad.setText(modo.toString().substring(0, 1).toUpperCase()
                + modo.toString().substring(1).toLowerCase()
                + " actividad");
        if (modo == Modo.EDITAR) {
            botonAceptar.setText("Editar");
            nombreActividad.setText("Editar nombre");
            campoDescripcion.setText(actividad.getDescripcion());
            etiquetaDescripcion.setText("Editar descripción");
            campoNombreActividad.setText(actividad.getNombre());
            CampoObjetivos.setText(actividad.getObjetivos());
            etiquetaObjetivos.setText("Editar objetivos");
        } else if (modo == Modo.ELIMINAR) {
            botonAceptar.setText("Eliminar");
            nombreActividad.setText("¿Quieres eliminar?");
            campoNombreActividad.setText(actividad.getNombre());
            CampoObjetivos.setText(actividad.getObjetivos());
            campoDescripcion.setText(actividad.getDescripcion());
            campoNombreActividad.setEnabled(false);
            campoDescripcion.setEnabled(false);
            CampoObjetivos.setEnabled(false);
            etiquetaDescripcion.setVisible(false);
            etiquetaObjetivos.setVisible(false);
        }
    }

    private void añadirActividad() {
        if (campoNombreActividad.getText().isBlank() || campoNombreActividad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un nombre",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (tema.getActividades().stream().anyMatch((a) -> a.getNombre().trim().equalsIgnoreCase(campoNombreActividad.getText().trim()))) {
            JOptionPane.showMessageDialog(this, "El nombre de la actividad ya existe",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (campoDescripcion.getText().isBlank() || campoDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir una descripción",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (CampoObjetivos.getText().isBlank() || CampoObjetivos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir los objetivos",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            DAOActividades da = new DAOActividades();
            da.añadirActividad(campoNombreActividad.getText(), campoDescripcion.getText(), CampoObjetivos.getText(), tema);
            this.dispose();
        }
    }

    private void editarActividad() {
        if (campoNombreActividad.getText().isBlank() || campoNombreActividad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un nombre",
                    "Error", JOptionPane.WARNING_MESSAGE);
        }else if (campoDescripcion.getText().isBlank() || campoDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir una descripción",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (CampoObjetivos.getText().isBlank() || CampoObjetivos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir los objetivos",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            DAOActividades da = new DAOActividades();
            da.editarActividad(campoNombreActividad.getText(), campoDescripcion.getText(), CampoObjetivos.getText(), actividad.getId());
            actividad.setNombre(campoNombreActividad.getText().trim());
            actividad.setDescripcion(campoDescripcion.getText());
            actividad.setObjetivos(CampoObjetivos.getText());
            this.dispose();
        }
    }

    private void eliminarActividad() {
        DAOActividades da = new DAOActividades();
        da.eliminarActividad(actividad);
        tema.getActividades().remove(actividad);
        this.dispose();
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
        etiquetaActividad = new javax.swing.JLabel();
        nombreActividad = new javax.swing.JLabel();
        campoNombreActividad = new javax.swing.JTextField();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaObjetivos = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        CampoObjetivos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(193, 239, 255));

        etiquetaActividad.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        etiquetaActividad.setText(" ");

        nombreActividad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombreActividad.setText("Nombre");

        campoNombreActividad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campoNombreActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActividadActionPerformed(evt);
            }
        });
        campoNombreActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNombreActividadKeyPressed(evt);
            }
        });

        etiquetaDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaDescripcion.setText("Descripción");

        etiquetaObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaObjetivos.setText("Objetivos");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        campoDescripcion.setColumns(20);
        campoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campoDescripcion.setRows(5);
        jScrollPane1.setViewportView(campoDescripcion);

        CampoObjetivos.setColumns(20);
        CampoObjetivos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CampoObjetivos.setRows(5);
        jScrollPane2.setViewportView(CampoObjetivos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addComponent(etiquetaObjetivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(botonAceptar)
                        .addGap(132, 132, 132)
                        .addComponent(botonCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 101, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(etiquetaActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreActividad))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(etiquetaDescripcion)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(etiquetaObjetivos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed

        if (modo == Modo.AÑADIR) {
            añadirActividad();
        } else if (modo == Modo.EDITAR) {
            editarActividad();
        } else if (modo == Modo.ELIMINAR) {
            eliminarActividad();
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void campoNombreActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActividadActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void campoNombreActividadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreActividadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonAceptarActionPerformed(null);
        }

    }//GEN-LAST:event_campoNombreActividadKeyPressed

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
            java.util.logging.Logger.getLogger(ModificarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ModificarActividad dialog = new ModificarActividad(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CampoObjetivos;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JTextField campoNombreActividad;
    private javax.swing.JLabel etiquetaActividad;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaObjetivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreActividad;
    // End of variables declaration//GEN-END:variables
}
