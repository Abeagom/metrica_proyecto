/*
 * Esta clase representa la ventana de registro de un nuevo usuario.
 * Si los datos son correctos, se crea un nuevo usuario y se vuelve a la pantalla de login.
 */
package com.proyectofinal.main;

import com.proyectofinal.datos.DAOMaestros;
import com.proyectofinal.entidades.Maestro;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author al_12
 */
public class PantallaRegistro extends javax.swing.JDialog {

    /**
     * Creates new form Login
     */
    public PantallaRegistro(JFrame parent, boolean modal) {
        super(parent, modal);  // Llamada al constructor de JDialog
        initComponents();
        setLocationRelativeTo(parent);  // Opcional: centrado sobre el JFrame
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        etiquetaTitulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaNombreUsuario = new javax.swing.JLabel();
        campoNombreUsuario = new javax.swing.JTextField();
        etiquetaContraseña = new javax.swing.JLabel();
        campoContraseña = new javax.swing.JPasswordField();
        etiquetaRepiteContraseña = new javax.swing.JLabel();
        campoRepiteContraseña = new javax.swing.JPasswordField();
        botonCrearCuenta = new javax.swing.JButton();
        etiquetaCopyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 72)); // NOI18N
        etiquetaTitulo.setText("Educa+");
        jLayeredPane1.setLayer(etiquetaTitulo, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaTitulo);
        etiquetaTitulo.setBounds(90, 0, 390, 100);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoLogin.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        jLayeredPane1.add(fondo);
        fondo.setBounds(-80, 0, 830, 430);

        etiquetaNombre.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaNombre.setText("Nombre");
        jLayeredPane1.setLayer(etiquetaNombre, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaNombre);
        etiquetaNombre.setBounds(100, 100, 300, 40);

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        jLayeredPane1.setLayer(campoNombre, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(campoNombre);
        campoNombre.setBounds(100, 140, 440, 22);

        etiquetaNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaNombreUsuario.setText("Introduce un nombre de usuario");
        jLayeredPane1.setLayer(etiquetaNombreUsuario, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaNombreUsuario);
        etiquetaNombreUsuario.setBounds(100, 160, 300, 40);

        campoNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreUsuarioActionPerformed(evt);
            }
        });
        jLayeredPane1.setLayer(campoNombreUsuario, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(campoNombreUsuario);
        campoNombreUsuario.setBounds(100, 190, 440, 22);

        etiquetaContraseña.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaContraseña.setText("Introduce contraseña");
        jLayeredPane1.setLayer(etiquetaContraseña, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaContraseña);
        etiquetaContraseña.setBounds(100, 210, 300, 40);
        jLayeredPane1.setLayer(campoContraseña, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(campoContraseña);
        campoContraseña.setBounds(100, 250, 440, 22);

        etiquetaRepiteContraseña.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaRepiteContraseña.setText("Repite la contraseña");
        jLayeredPane1.setLayer(etiquetaRepiteContraseña, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaRepiteContraseña);
        etiquetaRepiteContraseña.setBounds(100, 270, 300, 40);
        jLayeredPane1.setLayer(campoRepiteContraseña, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(campoRepiteContraseña);
        campoRepiteContraseña.setBounds(100, 300, 440, 22);

        botonCrearCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonCrearCuenta.setText("Crear cuenta");
        botonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCuentaActionPerformed(evt);
            }
        });
        jLayeredPane1.setLayer(botonCrearCuenta, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(botonCrearCuenta);
        botonCrearCuenta.setBounds(100, 340, 160, 32);

        etiquetaCopyright.setText("© 2025 Educa+. Versión 0.1 (Beta). Todos los derechos reservados.");
        jLayeredPane1.setLayer(etiquetaCopyright, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(etiquetaCopyright);
        etiquetaCopyright.setBounds(20, 400, 410, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCuentaActionPerformed
        DAOMaestros dm = new DAOMaestros();
        // Verificación de que todos los campos están completos. Si no, muestra una ventana emergente.
        if (campoNombre.getText().trim().isEmpty() | campoNombreUsuario.getText().trim().isEmpty() | campoContraseña.getText().trim().isEmpty() | campoRepiteContraseña.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        // Verificación de que las contraseñas coinciden
        } else if (!campoContraseña.getText().equals(campoRepiteContraseña.getText())) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden",
                    "Error", JOptionPane.ERROR_MESSAGE);
        // Verificación de que el nombre de usuario no exista en la base de datos
        } else if (dm.comprobarUsuario(campoNombreUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(this, "El usuario ya existe",
                    "Error", JOptionPane.ERROR_MESSAGE);
        // Si todo está correcto, se crea un nuevo usuario
        } else {
            dm.crearUsuario(new Maestro(campoNombreUsuario.getText(), campoContraseña.getText(), campoNombre.getText()));
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente",
                    "Registro correcto", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_botonCrearCuentaActionPerformed

    private void campoNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreUsuarioActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PantallaRegistro dialog = new PantallaRegistro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonCrearCuenta;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNombreUsuario;
    private javax.swing.JPasswordField campoRepiteContraseña;
    private javax.swing.JLabel etiquetaContraseña;
    private javax.swing.JLabel etiquetaCopyright;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaNombreUsuario;
    private javax.swing.JLabel etiquetaRepiteContraseña;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
