/*
 * Esta clase representa la ventana principal del usuario.
 * Permite operaciones con asignaturas, Temas y Actividades.
 */
package com.proyectofinal.main;

import com.proyectofinal.datos.DAOActividades;
import com.proyectofinal.entidades.Actividad;
import com.proyectofinal.entidades.Asignatura;
import com.proyectofinal.entidades.Maestro;
import com.proyectofinal.entidades.Tema;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author al_12
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    Maestro m;

    // Modelos para listas y comboboxes
    private DefaultListModel<Asignatura> modeloListaAsignaturas = new DefaultListModel<>();
    private DefaultListModel<Tema> modeloListaTemas = new DefaultListModel<>();
    private DefaultListModel<Actividad> modeloListaActividades = new DefaultListModel<>();
    private DefaultComboBoxModel<String> modeloComboBoxActividades;

    // Mapa para almacenar las actividades
    private Map<String, Actividad> mapaActividades = new HashMap<>();

    // Enum Modo utilizado para realizar distintas operaciones
    public enum Modo {
        AÑADIR, EDITAR, ELIMINAR
    }

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal(Maestro m) {
        this.m = m;
        initComponents();
        asignarModelos();
        rellenarDesplegable();
        rellenarMeses();
        botonesInicial();
        //Boton de prueba para exportar en pdf. Actualmente escondido.
        botonExportarPDF.setVisible(false);

    }

    /**
     * Rellena el desplegable de actividades de la pestaña Calendario con
     * asignaturas, temas y actividades. También crea un mapa con actividades
     * para que se muestre con un formato concreto.
     * Cada vez que se añade, edita o elimina algo, se llama a este método
     */
    private void rellenarDesplegable() {
        // Limpia modeloComboBoxActividades y el map antes de agregar elementos
        modeloComboBoxActividades.removeAllElements();
        mapaActividades.clear();

        // Recorre las asignaturas y temas y añade las actividades a modeloComboBoxActividades
        Collections.sort(m.getAsignaturas());
        for (Asignatura a : m.getAsignaturas()) {
            Collections.sort(a.getTemas());
            modeloComboBoxActividades.addElement("-" + a.getNombre());
            for (Tema t : a.getTemas()) {
                Collections.sort(t.getActividades());
                modeloComboBoxActividades.addElement("    -" + t.getNombre());
                for (Actividad ac : t.getActividades()) {
                    // Clave para el mapa de actividades
                    String clave = "        -" + ac.getNombre();

                    // Añadir actividad a modeloComboBoxActividades
                    modeloComboBoxActividades.addElement(clave);

                    // Añadir clave y actividad al mapa
                    mapaActividades.put(clave, ac);
                }
            }
        }
    }

    /**
     * Rellena el desplegable de meses con los nombres completos de los meses
     * con el idioma local.
     */
    private void rellenarMeses() {
        for (Month mes : Month.values()) {
            desplegableMeses.addItem(mes.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()));
        }
    }

    /**
     * Asigna los modelos a las listas y comboboxes de la interfaz.
     */
    private void asignarModelos() {
        listaAsignaturas.setModel(modeloListaAsignaturas);
        listaTemas.setModel(modeloListaTemas);
        listaActividades.setModel(modeloListaActividades);
        modeloComboBoxActividades = new DefaultComboBoxModel<>();
        desplegableActividades.setModel(modeloComboBoxActividades);
        Collections.sort(m.getAsignaturas());
        modeloListaAsignaturas.addAll(m.getAsignaturas());
    }

    /**
     * Configura los botones y etiquetas al iniciar la ventana.
     */
    private void botonesInicial() {
        editarAsignatura.setEnabled(false);
        eliminarAsignatura.setEnabled(false);
        añadirTema.setEnabled(false);
        editarTema.setEnabled(false);
        eliminarTema.setEnabled(false);
        añadirActividad.setEnabled(false);
        editarActividad.setEnabled(false);
        eliminarActividad.setEnabled(false);
        etiquetaBienvenida.setText("        Usuario: " + m.getLogin());
        etiquetaBienvenida1.setText("        Usuario: " + m.getLogin());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pestañas = new javax.swing.JTabbedPane();
        pestañaPrincipal = new javax.swing.JPanel();
        añadirAsignatura = new javax.swing.JButton();
        editarAsignatura = new javax.swing.JButton();
        añadirTema = new javax.swing.JButton();
        editarTema = new javax.swing.JButton();
        añadirActividad = new javax.swing.JButton();
        editarActividad = new javax.swing.JButton();
        eliminarAsignatura = new javax.swing.JButton();
        eliminarTema = new javax.swing.JButton();
        eliminarActividad = new javax.swing.JButton();
        etiquetaBienvenida = new javax.swing.JLabel();
        etiquetaCopyright = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTemas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaActividades = new javax.swing.JList<>();
        pestañaCalendario = new javax.swing.JPanel();
        etiquetaBienvenida1 = new javax.swing.JLabel();
        calendario = new com.github.lgooddatepicker.components.CalendarPanel();
        desplegableActividades = new javax.swing.JComboBox<>();
        desplegableMeses = new javax.swing.JComboBox<>();
        asignarFecha = new javax.swing.JButton();
        etiquetaMes = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        botonAsignarFecha = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();
        etiquetaFiltrarPorMes = new javax.swing.JLabel();
        etiquetaAsignarFecha1 = new javax.swing.JLabel();
        botonExportarPDF = new javax.swing.JButton();
        etiquetaActividad = new javax.swing.JLabel();
        botonFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonExportarTxt = new javax.swing.JButton();
        pestañaAlumnos = new javax.swing.JPanel();
        etiquetaBienvenida2 = new javax.swing.JLabel();
        botonEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pestañaPrincipal.setBackground(new java.awt.Color(193, 239, 255));

        añadirAsignatura.setText("Añadir asignatura");
        añadirAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirAsignaturaActionPerformed(evt);
            }
        });

        editarAsignatura.setText("Editar asignatura");
        editarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAsignaturaActionPerformed(evt);
            }
        });

        añadirTema.setText("Añadir tema");
        añadirTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirTemaActionPerformed(evt);
            }
        });

        editarTema.setText("Editar tema");
        editarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTemaActionPerformed(evt);
            }
        });

        añadirActividad.setText("Añadir Actividad");
        añadirActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActividadActionPerformed(evt);
            }
        });

        editarActividad.setText("Editar actividad");
        editarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActividadActionPerformed(evt);
            }
        });

        eliminarAsignatura.setText("Eliminar asignatura");
        eliminarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAsignaturaActionPerformed(evt);
            }
        });

        eliminarTema.setText("Eliminar tema");
        eliminarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTemaActionPerformed(evt);
            }
        });

        eliminarActividad.setText("Eliminar actividad");
        eliminarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActividadActionPerformed(evt);
            }
        });

        etiquetaBienvenida.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        etiquetaCopyright.setText("© 2025 Educa+. Versión 0.1 (Beta). Todos los derechos reservados.");

        listaAsignaturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAsignaturasMouseClicked(evt);
            }
        });
        listaAsignaturas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAsignaturasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listaAsignaturas);

        listaTemas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTemasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaTemas);

        listaActividades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaActividadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaActividades);

        javax.swing.GroupLayout pestañaPrincipalLayout = new javax.swing.GroupLayout(pestañaPrincipal);
        pestañaPrincipal.setLayout(pestañaPrincipalLayout);
        pestañaPrincipalLayout.setHorizontalGroup(
            pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                        .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(25, 25, 25)
                        .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(añadirTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(añadirActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarActividad, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editarAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(añadirAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pestañaPrincipalLayout.setVerticalGroup(
            pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                .addComponent(etiquetaBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestañaPrincipalLayout.createSequentialGroup()
                        .addComponent(añadirAsignatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarAsignatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarAsignatura)))
                .addGap(30, 30, 30)
                .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(añadirTema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarTema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarTema)))
                .addGap(30, 30, 30)
                .addGroup(pestañaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pestañaPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(añadirActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarActividad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(etiquetaCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pestañas.addTab("Principal", pestañaPrincipal);

        pestañaCalendario.setBackground(new java.awt.Color(255, 225, 231));

        etiquetaBienvenida1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        desplegableActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegableActividadesActionPerformed(evt);
            }
        });

        desplegableMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegableMesesActionPerformed(evt);
            }
        });

        asignarFecha.setText("Asignar fecha");
        asignarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarFechaActionPerformed(evt);
            }
        });

        etiquetaMes.setText("Mes");
        etiquetaMes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        etiquetaFecha.setText("Fecha");
        etiquetaFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        botonAsignarFecha.setText("Asignar fecha");
        botonAsignarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarFechaActionPerformed(evt);
            }
        });

        tablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Actividad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaActividades);

        etiquetaFiltrarPorMes.setText("Filtrar actividades por mes");
        etiquetaFiltrarPorMes.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaFiltrarPorMes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        etiquetaAsignarFecha1.setText("Asignar fecha a una actividad");
        etiquetaAsignarFecha1.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaAsignarFecha1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        botonExportarPDF.setText("Exportar a PDF");
        botonExportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarPDFActionPerformed(evt);
            }
        });

        etiquetaActividad.setText("Actividad");
        etiquetaActividad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        botonFiltrar.setText("Filtrar");
        botonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltrarActionPerformed(evt);
            }
        });

        jLabel1.setText("© 2025 Educa+. Versión 0.1 (Beta). Todos los derechos reservados.");

        botonExportarTxt.setText("Exportar a .txt");
        botonExportarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestañaCalendarioLayout = new javax.swing.GroupLayout(pestañaCalendario);
        pestañaCalendario.setLayout(pestañaCalendarioLayout);
        pestañaCalendarioLayout.setHorizontalGroup(
            pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(etiquetaAsignarFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(etiquetaFiltrarPorMes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etiquetaBienvenida1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                        .addComponent(etiquetaActividad)
                                        .addGap(28, 28, 28)
                                        .addComponent(desplegableActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141)
                                        .addComponent(etiquetaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                        .addComponent(etiquetaFecha)
                                        .addGap(48, 48, 48)
                                        .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(botonAsignarFecha))
                                            .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(asignarFecha)))
                        .addGap(18, 18, 18)
                        .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                .addComponent(desplegableMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                    .addComponent(botonExportarTxt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pestañaCalendarioLayout.setVerticalGroup(
            pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                .addComponent(etiquetaBienvenida1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaAsignarFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaFiltrarPorMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaActividad)
                    .addComponent(desplegableActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(desplegableMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaMes)
                        .addComponent(botonFiltrar)))
                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(etiquetaFecha))
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(botonAsignarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(asignarFecha))
                    .addGroup(pestañaCalendarioLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pestañaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonExportarPDF)
                            .addComponent(botonExportarTxt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pestañas.addTab("Calendario", pestañaCalendario);

        pestañaAlumnos.setBackground(new java.awt.Color(255, 254, 205));

        etiquetaBienvenida2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        botonEliminarUsuario.setText("Eliminar Usuario");
        botonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestañaAlumnosLayout = new javax.swing.GroupLayout(pestañaAlumnos);
        pestañaAlumnos.setLayout(pestañaAlumnosLayout);
        pestañaAlumnosLayout.setHorizontalGroup(
            pestañaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaAlumnosLayout.createSequentialGroup()
                .addComponent(etiquetaBienvenida2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
            .addGroup(pestañaAlumnosLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(botonEliminarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pestañaAlumnosLayout.setVerticalGroup(
            pestañaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaBienvenida2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminarUsuario)
                .addContainerGap(543, Short.MAX_VALUE))
        );

        pestañas.addTab("Eliminar usuario", pestañaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaActividadesMouseClicked
        //Posible mejora: Quizás es mejor usar isEmpty
        if (modeloListaActividades.size() > 0) {
            editarActividad.setEnabled(true);
            eliminarActividad.setEnabled(true);

        }
    }//GEN-LAST:event_listaActividadesMouseClicked

    private void listaTemasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTemasMouseClicked
        //Posible mejora: Hacer métodos para activar y desactivar los distintos botones
        if (modeloListaTemas.size() > 0) {
            editarTema.setEnabled(true);
            eliminarTema.setEnabled(true);
            añadirActividad.setEnabled(true);
            editarActividad.setEnabled(false);
            eliminarActividad.setEnabled(false);
            modeloListaActividades.clear();
            modeloListaActividades.addAll(listaTemas.getSelectedValue().getActividades());
        }
    }//GEN-LAST:event_listaTemasMouseClicked

    private void listaAsignaturasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAsignaturasValueChanged

    }//GEN-LAST:event_listaAsignaturasValueChanged

    private void listaAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAsignaturasMouseClicked
        //Si la lista de asignaturas tiene al menos un elemento, se configuran los distintos botones
        if (modeloListaAsignaturas.size() > 0) {
            editarAsignatura.setEnabled(true);
            eliminarAsignatura.setEnabled(true);
            añadirTema.setEnabled(true);
            modeloListaTemas.clear();
            modeloListaTemas.addAll(listaAsignaturas.getSelectedValue().getTemas());
            modeloListaActividades.clear();
            editarTema.setEnabled(false);
            eliminarTema.setEnabled(false);
            añadirActividad.setEnabled(false);
            editarActividad.setEnabled(false);
            eliminarActividad.setEnabled(false);
        } else {
            añadirTema.setEnabled(false);
        }
    }//GEN-LAST:event_listaAsignaturasMouseClicked

    private void eliminarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActividadActionPerformed
        //Si no hay ninguna asignatura o tema seleccionados, lanza una ventana emergente
        if (listaTemas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (listaActividades.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna actividad.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //Si todo está correcto, se abre una nueva ventana para modificar actividad pasándole un enum como modo (eliminar)
            new ModificarActividad(this, true, listaTemas.getSelectedValue(), listaActividades.getSelectedValue(), VentanaPrincipal.Modo.ELIMINAR).setVisible(true);
            modeloListaActividades.clear();
            modeloListaActividades.addAll(listaTemas.getSelectedValue().getActividades());
            if (modeloListaActividades.isEmpty()) {
                editarActividad.setEnabled(false);
                eliminarActividad.setEnabled(false);
            }
        }
        rellenarDesplegable();
    }//GEN-LAST:event_eliminarActividadActionPerformed

    private void eliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTemaActionPerformed
        if (listaTemas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (listaAsignaturas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarTema(this, true, listaAsignaturas.getSelectedValue(), listaTemas.getSelectedValue(), VentanaPrincipal.Modo.ELIMINAR).setVisible(true);
            modeloListaTemas.clear();
            modeloListaTemas.addAll(listaAsignaturas.getSelectedValue().getTemas());
            modeloListaActividades.clear();
            if (modeloListaTemas.isEmpty()) {
                editarTema.setEnabled(false);
                eliminarTema.setEnabled(false);
                añadirActividad.setEnabled(false);
            }
        }
        rellenarDesplegable();
    }//GEN-LAST:event_eliminarTemaActionPerformed

    private void eliminarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAsignaturaActionPerformed
        if (listaAsignaturas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarAsignatura(this, true, m, listaAsignaturas.getSelectedValue(), VentanaPrincipal.Modo.ELIMINAR).setVisible(true);
            modeloListaAsignaturas.clear();
            modeloListaAsignaturas.addAll(m.getAsignaturas());
            modeloListaTemas.clear();
            modeloListaActividades.clear();
            if (modeloListaAsignaturas.isEmpty()) {
                editarAsignatura.setEnabled(false);
                eliminarAsignatura.setEnabled(false);
            }
        }
        rellenarDesplegable();
    }//GEN-LAST:event_eliminarAsignaturaActionPerformed

    private void editarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActividadActionPerformed
        if (listaTemas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (listaActividades.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna actividad.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarActividad(this, true, listaTemas.getSelectedValue(), listaActividades.getSelectedValue(), VentanaPrincipal.Modo.EDITAR).setVisible(true);
            modeloListaActividades.clear();
            modeloListaActividades.addAll(listaTemas.getSelectedValue().getActividades());
        }
        rellenarDesplegable();
    }//GEN-LAST:event_editarActividadActionPerformed

    private void añadirActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActividadActionPerformed
        if (listaTemas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarActividad(this, true, listaTemas.getSelectedValue(), VentanaPrincipal.Modo.AÑADIR).setVisible(true);
            modeloListaActividades.clear();
            modeloListaActividades.addAll(listaTemas.getSelectedValue().getActividades());
        }
        rellenarDesplegable();
    }//GEN-LAST:event_añadirActividadActionPerformed

    private void editarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTemaActionPerformed
        if (listaTemas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (listaAsignaturas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarTema(this, true, listaAsignaturas.getSelectedValue(), listaTemas.getSelectedValue(), VentanaPrincipal.Modo.EDITAR).setVisible(true);
            modeloListaTemas.clear();
            modeloListaTemas.addAll(listaAsignaturas.getSelectedValue().getTemas());
            modeloListaActividades.clear();
        }
        rellenarDesplegable();
    }//GEN-LAST:event_editarTemaActionPerformed

    private void añadirTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirTemaActionPerformed
        if (listaAsignaturas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarTema(this, true, listaAsignaturas.getSelectedValue(), VentanaPrincipal.Modo.AÑADIR).setVisible(true);
            modeloListaTemas.clear();
            for(Asignatura a : m.getAsignaturas()){
                Collections.sort(a.getTemas());
            }
            modeloListaTemas.addAll(listaAsignaturas.getSelectedValue().getTemas());
            modeloListaActividades.clear();
        }
        rellenarDesplegable();
    }//GEN-LAST:event_añadirTemaActionPerformed

    private void editarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAsignaturaActionPerformed
        if (listaAsignaturas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ModificarAsignatura(this, true, m, listaAsignaturas.getSelectedValue(), VentanaPrincipal.Modo.EDITAR).setVisible(true);
            modeloListaAsignaturas.clear();
            modeloListaAsignaturas.addAll(m.getAsignaturas());
            modeloListaTemas.clear();
            modeloListaActividades.clear();
        }
        rellenarDesplegable();
    }//GEN-LAST:event_editarAsignaturaActionPerformed

    private void añadirAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirAsignaturaActionPerformed
        new ModificarAsignatura(this, true, m, VentanaPrincipal.Modo.AÑADIR).setVisible(true);
        modeloListaAsignaturas.clear();
        Collections.sort(m.getAsignaturas());
        modeloListaAsignaturas.addAll(m.getAsignaturas());
        modeloListaTemas.clear();
        modeloListaActividades.clear();
        rellenarDesplegable();
    }//GEN-LAST:event_añadirAsignaturaActionPerformed

    private void desplegableActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegableActividadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegableActividadesActionPerformed

    private void desplegableMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegableMesesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegableMesesActionPerformed

    private void asignarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarFechaActionPerformed
        //Si en el desplegable de actividades no se elige una actividad, lanza una ventana emergente
        if (!(mapaActividades.get(desplegableActividades.getSelectedItem()) instanceof Actividad)) {
            JOptionPane.showMessageDialog(this, "Debe escoger una actividad",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //Si todo está correcto, se actualiza la fecha en el propio objeto Actividad y en la base de datos a través del DAO
            if (calendario.getSelectedDate() != null) {
                mapaActividades.get(desplegableActividades.getSelectedItem()).setFecha(calendario.getSelectedDate());
                DAOActividades da = new DAOActividades();
                da.editarActividad(calendario.getSelectedDate(), mapaActividades.get(desplegableActividades.getSelectedItem()).getId());
                JOptionPane.showMessageDialog(this, "Fecha asignada correctamente",
                        "Actualización", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Debe escoger una fecha",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        rellenarDesplegable();
    }//GEN-LAST:event_asignarFechaActionPerformed

    private void botonAsignarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAsignarFechaActionPerformed

    //Este botón está ocultado. Se prueba la exportación a PDF.
    private void botonExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarPDFActionPerformed
        try {
            List<Actividad> actividadesPDF = new ArrayList<>();
            int mesSeleccionado = -1;

            for (Month mes : Month.values()) {
                if (mes.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()).equals(desplegableMeses.getSelectedItem())) {
                    mesSeleccionado = mes.getValue();
                    break;
                }
            }

            final int mesSeleccionadoFinal = mesSeleccionado;

            actividadesPDF = mapaActividades.values().stream()
                    .filter(a -> a.getFecha() != null && a.getFecha().getMonthValue() == mesSeleccionadoFinal)
                    .toList();

            PDDocument documentoActividades = new PDDocument();

            for (Actividad a : actividadesPDF) {
                PDPage page = new PDPage();
                documentoActividades.addPage(page);

                PDPageContentStream contentStream = new PDPageContentStream(documentoActividades, page);
                contentStream.beginText();

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Actividad de " + desplegableMeses.getSelectedItem());

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(0, -40);
                contentStream.showText("-Actividad: ");
                contentStream.newLineAtOffset(0, -20);
                contentStream.setFont(PDType1Font.HELVETICA, 16);
                contentStream.showText(a.getNombre());

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(0, -40);
                contentStream.showText("-Descripción: ");
                contentStream.newLineAtOffset(0, -20);
                contentStream.setFont(PDType1Font.HELVETICA, 16);
                contentStream.showText(a.getDescripcion());

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(0, -40);
                contentStream.showText("-Objetivos: ");
                contentStream.newLineAtOffset(0, -20);
                contentStream.setFont(PDType1Font.HELVETICA, 16);
                contentStream.showText(a.getObjetivos());

                contentStream.endText();
                contentStream.close();
            }

            documentoActividades.save("ejemplo.pdf");
            documentoActividades.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_botonExportarPDFActionPerformed

    private void botonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarActionPerformed

        //Conseguir el número del mes seleccionado
        int mesSeleccionado = -1;
        for (Month mes : Month.values()) {
            if (mes.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()).equals(desplegableMeses.getSelectedItem())) {
                mesSeleccionado = mes.getValue();
            }
        }
        final int mesSeleccionadoFinal = mesSeleccionado;

        // Crear el modelo con las columnas "Nombre" y "Fecha"
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaActividades.getModel();
        modeloTabla.setColumnCount(0);  // Limpiar columnas anteriores
        modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Fecha"});  // Establecer las columnas

        // Limpiar las filas existentes
        modeloTabla.setRowCount(0);

        //A través de un stream se asigna a la tabla las actividades que cumplan el filtro
        mapaActividades.values().stream()
                .filter(a -> a.getFecha() != null && a.getFecha().getMonthValue() == mesSeleccionadoFinal) // Filtrar solo si la fecha no es nula
                .sorted((a1, a2) -> a1.getFecha().compareTo(a2.getFecha()))
                .forEach(a -> {
                    modeloTabla.addRow(new Object[]{
                        a.getNombre(),
                        a.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    });
                });
    }//GEN-LAST:event_botonFiltrarActionPerformed

    private void botonExportarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarTxtActionPerformed
        //Método para exportar a txt
        List<Actividad> actividadesTXT = new ArrayList();
        int mesSeleccionado = -1;

        for (Month mes : Month.values()) {
            if (mes.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()).equals(desplegableMeses.getSelectedItem())) {
                mesSeleccionado = mes.getValue();
                break;
            }
        }

        final int mesSeleccionadoFinal = mesSeleccionado;

        actividadesTXT = mapaActividades.values().stream()
                .filter(a -> a.getFecha() != null && a.getFecha().getMonthValue() == mesSeleccionadoFinal)
                .toList();
        if (!actividadesTXT.isEmpty()) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter("actividadesMes.txt"));
                escritor.write("Actividades del mes de " + desplegableMeses.getSelectedItem() + "\n\n");
                for (Actividad a : actividadesTXT) {
                    escritor.write("Nombre: " + a.getNombre() + "\n");
                    escritor.write("Descripción: " + a.getDescripcion() + "\n");
                    escritor.write("Fecha: " + a.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
                    escritor.write("Objetivos: \n" + a.getObjetivos() + "\n\n");
                }
                escritor.close();
                JOptionPane.showMessageDialog(this, "Exportación realizada correctamente",
                        "Actualización", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                System.out.println("No se ha podido abrir el fichero");
            } catch (IOException e) {
                System.out.println("Error al leer el fichero: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay actividades para exportar",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botonExportarTxtActionPerformed

    private void botonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarUsuarioActionPerformed
        //Si el usuario pulsa el botón eliminarUsuario, se crea una ventana y posteriormente se verificará si ha sido eliminado
        EliminarUsuario eliminarUsuario = new EliminarUsuario(this, true, m);
        eliminarUsuario.setVisible(true);
        if(eliminarUsuario.esEliminado()){
            this.dispose();
            
        }
    }//GEN-LAST:event_botonEliminarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarFecha;
    private javax.swing.JButton añadirActividad;
    private javax.swing.JButton añadirAsignatura;
    private javax.swing.JButton añadirTema;
    private javax.swing.JButton botonAsignarFecha;
    private javax.swing.JButton botonEliminarUsuario;
    private javax.swing.JButton botonExportarPDF;
    private javax.swing.JButton botonExportarTxt;
    private javax.swing.JButton botonFiltrar;
    private com.github.lgooddatepicker.components.CalendarPanel calendario;
    private javax.swing.JComboBox<String> desplegableActividades;
    private javax.swing.JComboBox<String> desplegableMeses;
    private javax.swing.JButton editarActividad;
    private javax.swing.JButton editarAsignatura;
    private javax.swing.JButton editarTema;
    private javax.swing.JButton eliminarActividad;
    private javax.swing.JButton eliminarAsignatura;
    private javax.swing.JButton eliminarTema;
    private javax.swing.JLabel etiquetaActividad;
    private javax.swing.JLabel etiquetaAsignarFecha1;
    private javax.swing.JLabel etiquetaBienvenida;
    private javax.swing.JLabel etiquetaBienvenida1;
    private javax.swing.JLabel etiquetaBienvenida2;
    private javax.swing.JLabel etiquetaCopyright;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaFiltrarPorMes;
    private javax.swing.JLabel etiquetaMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Actividad> listaActividades;
    private javax.swing.JList<Asignatura> listaAsignaturas;
    private javax.swing.JList<Tema> listaTemas;
    private javax.swing.JPanel pestañaAlumnos;
    private javax.swing.JPanel pestañaCalendario;
    private javax.swing.JPanel pestañaPrincipal;
    private javax.swing.JTabbedPane pestañas;
    private javax.swing.JTable tablaActividades;
    // End of variables declaration//GEN-END:variables
}
