/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Utilidades.*;
import javax.swing.JOptionPane;
import entidades.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Ventana_Principal extends javax.swing.JFrame {

    public Usuario usuarioActual;

    private boolean ordenar_de_forma_asendente_Facultad;
    private boolean ordenar_de_forma_asendente_Asignaturas;
    private boolean ordenar_de_forma_asendente_Carreras;
    private boolean ordenar_de_forma_asendente_Estudiantes;
    private boolean ordenar_de_forma_asendente_Convocatoria;

    public ArrayList<Facultad> facultades_existentes;
    public ArrayList<Facultad> facultades_en_tabla;

    public ArrayList<Asignatura> asignaturas_existentes_de_carrera;
    public ArrayList<Asignatura> asignaturas_en_tabla;

    public ArrayList<Carrera> carreras_existentes_de_facultad;
    public ArrayList<Carrera> carreras_en_tabla;

    public ArrayList<Estudiante> estudiantes_existentes_de_asignatura;
    public ArrayList<Estudiante> estudiantes_en_tabla;

    public ArrayList<Convocatoria> convocatorias_existentes_de_estudiante_y_asignatura;
    public ArrayList<Convocatoria> convocatorias_en_tabla;

    public Profesor profesorDeAsignatura;

    /**
     * Creates new form Ventana_Principal
     */
    public Ventana_Principal() {
        initComponents();

        setLocationRelativeTo(null);

        facultades_existentes = new ArrayList<>();
        facultades_en_tabla = new ArrayList<>();
        asignaturas_existentes_de_carrera = new ArrayList<>();
        asignaturas_en_tabla = new ArrayList<>();
        carreras_existentes_de_facultad = new ArrayList<>();
        carreras_en_tabla = new ArrayList<>();
        estudiantes_existentes_de_asignatura = new ArrayList<>();
        estudiantes_en_tabla = new ArrayList<>();
        convocatorias_existentes_de_estudiante_y_asignatura = new ArrayList<>();
        convocatorias_en_tabla = new ArrayList<>();

        ordenar_de_forma_asendente_Facultad = true;
        ordenar_de_forma_asendente_Asignaturas = true;
        ordenar_de_forma_asendente_Carreras = true;
        ordenar_de_forma_asendente_Estudiantes = true;
        ordenar_de_forma_asendente_Convocatoria = true;

        ButtonGroup bg_ordenar_Asignatura = new ButtonGroup();
        bg_ordenar_Asignatura.add(MI_RB_Ordenar_Asignatura_Por_Modalidad);
        bg_ordenar_Asignatura.add(MI_RB_Ordenar_Asignatura_Por_Nombre);
        bg_ordenar_Asignatura.add(MI_RB_Ordenar_Asignatura_Por_Semestre);
        MI_RB_Ordenar_Asignatura_Por_Nombre.setSelected(true);

        ButtonGroup bg_ordenar_Estudiantes = new ButtonGroup();
        bg_ordenar_Estudiantes.add(MI_RB_Ordenar_Estudiantes_Por_Apellidos);
        bg_ordenar_Estudiantes.add(MI_RB_Ordenar_Estudiantes_Por_Nombre);
        bg_ordenar_Estudiantes.add(MI_RB_Ordenar_Estudiantes_Por_Grupo);
        MI_RB_Ordenar_Estudiantes_Por_Nombre.setSelected(true);

        final Ventana_Principal estaVentana = this;
        UtilidadesParaVentana.ponerIconoDeVentana_Principal(this);

        T_Facultades.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("algo 1111111111111111111111");
                if (T_Facultades.getSelectedRow() != -1) {
                    try {
                        Facultad l = estaVentana.facultades_en_tabla.get(T_Facultades.getSelectedRow());
                        l=EnMemoria.BD.obtenerPorID_Facultad(l);
                        actualizar_T_A_PartirDe(l);
                    } catch (Exception ex) {
                        DLG_Respuesta.mostrarDlg_ErrorEnLaBD(estaVentana, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        T_Carrera.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("algo 1111111111111111111111");
                if (T_Carrera.getSelectedRow() != -1) {
                    try {
                        Carrera l = estaVentana.carreras_en_tabla.get(T_Carrera.getSelectedRow());
                        l=EnMemoria.BD.obtenerPorID_Carrera(l);
                        actualizar_T_A_PartirDe(l);
                    } catch (Exception ex) {
                        DLG_Respuesta.mostrarDlg_ErrorEnLaBD(estaVentana, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        T_Asignaturas.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("algo 1111111111111111111111");
                if (T_Asignaturas.getSelectedRow() != -1) {
                    try {
                        Asignatura l = estaVentana.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());
                        l=EnMemoria.BD.obtenerPorID_Asignatura(l);
                        actualizar_T_A_PartirDe(l);
                    } catch (Exception ex) {
                        DLG_Respuesta.mostrarDlg_ErrorEnLaBD(estaVentana, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        T_Estudiantes.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("algo 1111111111111111111111");
                if (T_Estudiantes.getSelectedRow() != -1) {
                    try {
                        Estudiante l = estaVentana.estudiantes_en_tabla.get(T_Estudiantes.getSelectedRow());
                        l=EnMemoria.BD.obtenerPorID_Estudiante(l);
                        actualizar_T_A_PartirDe(l);
                    } catch (Exception ex) {
                        DLG_Respuesta.mostrarDlg_ErrorEnLaBD(estaVentana, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    public void actualizar(Usuario u) throws Exception {
        this.usuarioActual = u;
        ordenar_de_forma_asendente_Facultad = true;
        ordenar_de_forma_asendente_Asignaturas = true;
        ordenar_de_forma_asendente_Carreras = true;
        ordenar_de_forma_asendente_Estudiantes = true;
        ordenar_de_forma_asendente_Convocatoria = true;

        UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Asiganturas, this.ordenar_de_forma_asendente_Asignaturas);
        UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Carreras, this.ordenar_de_forma_asendente_Carreras);
        UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Estudiantes, this.ordenar_de_forma_asendente_Estudiantes);
        UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Facultades, this.ordenar_de_forma_asendente_Facultad);

        TI_Filtro_Asiganturas.setText("");
        TI_Filtro_Carreras.setText("");
        TI_Filtro_Estudiantes.setText("");
        TI_Filtro_Facultades.setText("");

        this.facultades_existentes = new ArrayList<>(Arrays.asList(EnMemoria.BD.obtenerTodos_Facultad()));
        actualizarTabla_Facultad(this.facultades_existentes);

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
        L_Facultades = new javax.swing.JLabel();
        B_Agregar_Facultades = new javax.swing.JButton();
        B_Editar_Facultades = new javax.swing.JButton();
        B_Eliminar_Facultades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_Facultades = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_Carrera = new javax.swing.JTable();
        B_Agregar_Carrera = new javax.swing.JButton();
        B_Editar_Carrera = new javax.swing.JButton();
        B_Eliminar_Carrera = new javax.swing.JButton();
        L_Carrera = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_Estudiantes = new javax.swing.JTable();
        B_Eliminar_Asignaturas = new javax.swing.JButton();
        B_Editar_Asignaturas = new javax.swing.JButton();
        B_Agregar_Asignaturas = new javax.swing.JButton();
        L_Asignaturas = new javax.swing.JLabel();
        L_Profesor = new javax.swing.JLabel();
        B_Agregar_Profesor = new javax.swing.JButton();
        B_Editar_Profesor = new javax.swing.JButton();
        B_Eliminar_Profesor = new javax.swing.JButton();
        B_Agregar_Estudiantes = new javax.swing.JButton();
        B_Editar_Estudiantes = new javax.swing.JButton();
        B_Eliminar_Estudiantes = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        T_Asignaturas = new javax.swing.JTable();
        L_Estudiantes = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        L_Profesor_Nombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        T_Examenes = new javax.swing.JTable();
        B_Eliminar_Examenes = new javax.swing.JButton();
        B_Editar_Examenes = new javax.swing.JButton();
        B_Agregar_Examenes = new javax.swing.JButton();
        L_Examenes = new javax.swing.JLabel();
        L_Profesor_Apellidos = new javax.swing.JLabel();
        TI_Filtro_Facultades = new javax.swing.JTextField();
        B_Filtrar_Facultades = new javax.swing.JButton();
        B_Invertir_Orden_Facultades = new javax.swing.JButton();
        B_Invertir_Orden_Asiganturas = new javax.swing.JButton();
        B_Filtrar_Asiganturas = new javax.swing.JButton();
        TI_Filtro_Asiganturas = new javax.swing.JTextField();
        TI_Filtro_Estudiantes = new javax.swing.JTextField();
        B_Filtrar_Estudiantes = new javax.swing.JButton();
        B_Invertir_Orden_Estudiantes = new javax.swing.JButton();
        TI_Filtro_Carreras = new javax.swing.JTextField();
        B_Filtrar_Carreras = new javax.swing.JButton();
        B_Invertir_Orden_Carreras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        L_Promedio = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MI_Administrar_Usuario = new javax.swing.JMenuItem();
        MI_Cambiar_Contrasenna = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MI_Cerrar_Sesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MI_Agregar_Facultad = new javax.swing.JMenuItem();
        MI_Modificar_Facultad = new javax.swing.JMenuItem();
        MI_Eliminar_Facultad = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MI_Agregar_Carrera = new javax.swing.JMenuItem();
        MI_Modifcar_Carrera = new javax.swing.JMenuItem();
        MI_Eliminar_Carrera = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MI_Agregar_Asignatura = new javax.swing.JMenuItem();
        MI_Modificar_Asignatura = new javax.swing.JMenuItem();
        MI_Eliminar_Asignatura = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        MI_RB_Ordenar_Asignatura_Por_Nombre = new javax.swing.JRadioButtonMenuItem();
        MI_RB_Ordenar_Asignatura_Por_Modalidad = new javax.swing.JRadioButtonMenuItem();
        MI_RB_Ordenar_Asignatura_Por_Semestre = new javax.swing.JRadioButtonMenuItem();
        jMenu6 = new javax.swing.JMenu();
        MI_ChB_Filtrar_Asignatura_Por_Nombre = new javax.swing.JCheckBoxMenuItem();
        MI_ChB_Filtrar_Asignatura_Por_Modalidad = new javax.swing.JCheckBoxMenuItem();
        MI_ChB_Filtrar_Asignatura_Por_Semestre = new javax.swing.JCheckBoxMenuItem();
        jMenu7 = new javax.swing.JMenu();
        MI_Agregar_Estudiante = new javax.swing.JMenuItem();
        MI_Modificar_Estudiante = new javax.swing.JMenuItem();
        MI_Eliminar_Estudiante = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        MI_RB_Ordenar_Estudiantes_Por_Nombre = new javax.swing.JRadioButtonMenuItem();
        MI_RB_Ordenar_Estudiantes_Por_Apellidos = new javax.swing.JRadioButtonMenuItem();
        MI_RB_Ordenar_Estudiantes_Por_Grupo = new javax.swing.JRadioButtonMenuItem();
        jMenu9 = new javax.swing.JMenu();
        MI_ChB_Filtrar_Estudiantes_Por_Nombre = new javax.swing.JCheckBoxMenuItem();
        MI_ChB_Filtrar_Estudiantes_Por_Apellidos = new javax.swing.JCheckBoxMenuItem();
        MI_ChB_Filtrar_Estudiantes_Por_Grupo = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administración");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_Facultades.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Facultades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Facultades.setText("Facultades");
        jPanel1.add(L_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 340, 26));

        B_Agregar_Facultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 45, 40));

        B_Editar_Facultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 45, 40));

        B_Eliminar_Facultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 45, 40));

        T_Facultades.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        T_Facultades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Informatica"},
                {"Matematica"},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(T_Facultades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 292, 150));

        T_Carrera.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        T_Carrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ingenieria Informatica"},
                {"Licenciatura Informatica"},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane2.setViewportView(T_Carrera);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 292, 150));

        B_Agregar_Carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_CarreraActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 45, 40));

        B_Editar_Carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_CarreraActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 45, 40));

        B_Eliminar_Carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_CarreraActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 45, 40));

        L_Carrera.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Carrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Carrera.setText("Carreras");
        jPanel1.add(L_Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 340, -1));

        T_Estudiantes.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        T_Estudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Juan Jasinto", "Guanlberto Gomes", "1"},
                {"Miguel Lucas", "Santos Casa", null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Grupo"
            }
        ));
        jScrollPane3.setViewportView(T_Estudiantes);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 100, 415, 150));

        B_Eliminar_Asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_AsignaturasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Asignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 45, 40));

        B_Editar_Asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_AsignaturasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Asignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 45, 40));

        B_Agregar_Asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_AsignaturasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Asignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 45, 40));

        L_Asignaturas.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Asignaturas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Asignaturas.setText("Asignaturas");
        jPanel1.add(L_Asignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 340, 26));

        L_Profesor.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Profesor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Profesor.setText("Profesor");
        jPanel1.add(L_Profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 370, -1));

        B_Agregar_Profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_ProfesorActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 45, 40));

        B_Editar_Profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_ProfesorActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 45, 40));

        B_Eliminar_Profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_ProfesorActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 45, 40));

        B_Agregar_Estudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 100, 45, 40));

        B_Editar_Estudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 140, 45, 40));

        B_Eliminar_Estudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 180, 45, 40));

        T_Asignaturas.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        T_Asignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Matamica", "Presencial", "Primer"},
                {"Español", "Turno", "Segundo"},
                {"Programacion", "Presencial", "Primer"},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Modalidad", "Semestre"
            }
        ));
        jScrollPane5.setViewportView(T_Asignaturas);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 323, 150));

        L_Estudiantes.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Estudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Estudiantes.setText("Estudiantes");
        jPanel1.add(L_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 430, 26));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        L_Profesor_Nombre.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        L_Profesor_Nombre.setText("nombre...");
        jPanel1.add(L_Profesor_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel8.setText("Apellidos: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        T_Examenes.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        T_Examenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5", "1", "01-02-23"},
                {"4", "2", "05-04-23"},
                {"3", "3", null},
                {null, null, null}
            },
            new String [] {
                "Nota", "Numero", "Fecha"
            }
        ));
        jScrollPane6.setViewportView(T_Examenes);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 313, 415, 160));

        B_Eliminar_Examenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/papelera copia.png"))); // NOI18N
        B_Eliminar_Examenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Eliminar_ExamenesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Eliminar_Examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 390, 45, 40));

        B_Editar_Examenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/editar copia.png"))); // NOI18N
        B_Editar_Examenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Editar_ExamenesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Editar_Examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 350, 45, 40));

        B_Agregar_Examenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agregar copia.png"))); // NOI18N
        B_Agregar_Examenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Agregar_ExamenesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Agregar_Examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 310, 45, 40));

        L_Examenes.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Examenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Examenes.setText("Exámenes");
        jPanel1.add(L_Examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 460, -1));

        L_Profesor_Apellidos.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        L_Profesor_Apellidos.setText("apellidos...");
        jPanel1.add(L_Profesor_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        TI_Filtro_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TI_Filtro_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(TI_Filtro_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 240, 38));

        B_Filtrar_Facultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar copia reducido.png"))); // NOI18N
        B_Filtrar_Facultades.setToolTipText("Buscar según la entrada ");
        B_Filtrar_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Filtrar_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Filtrar_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 45, 40));

        B_Invertir_Orden_Facultades.setToolTipText("Cambiar dirección del orden de los datos mostrados en la tabla ");
        B_Invertir_Orden_Facultades.setMargin(new java.awt.Insets(2, 2, 2, 2));
        B_Invertir_Orden_Facultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Invertir_Orden_FacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Invertir_Orden_Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 45, 40));

        B_Invertir_Orden_Asiganturas.setToolTipText("Cambiar dirección del orden de los datos mostrados en la tabla ");
        B_Invertir_Orden_Asiganturas.setMargin(new java.awt.Insets(2, 2, 2, 2));
        B_Invertir_Orden_Asiganturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Invertir_Orden_AsiganturasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Invertir_Orden_Asiganturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 45, 40));

        B_Filtrar_Asiganturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar copia reducido.png"))); // NOI18N
        B_Filtrar_Asiganturas.setToolTipText("Buscar según la entrada ");
        B_Filtrar_Asiganturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Filtrar_AsiganturasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Filtrar_Asiganturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 45, 40));

        TI_Filtro_Asiganturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TI_Filtro_AsiganturasActionPerformed(evt);
            }
        });
        jPanel1.add(TI_Filtro_Asiganturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 270, 38));

        TI_Filtro_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TI_Filtro_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(TI_Filtro_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 370, 38));

        B_Filtrar_Estudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar copia reducido.png"))); // NOI18N
        B_Filtrar_Estudiantes.setToolTipText("Buscar según la entrada ");
        B_Filtrar_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Filtrar_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Filtrar_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 50, 45, 40));

        B_Invertir_Orden_Estudiantes.setToolTipText("Cambiar dirección del orden de los datos mostrados en la tabla ");
        B_Invertir_Orden_Estudiantes.setMargin(new java.awt.Insets(2, 2, 2, 2));
        B_Invertir_Orden_Estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Invertir_Orden_EstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(B_Invertir_Orden_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 45, 40));

        TI_Filtro_Carreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TI_Filtro_CarrerasActionPerformed(evt);
            }
        });
        jPanel1.add(TI_Filtro_Carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 240, 38));

        B_Filtrar_Carreras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar copia reducido.png"))); // NOI18N
        B_Filtrar_Carreras.setToolTipText("Buscar según la entrada ");
        B_Filtrar_Carreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Filtrar_CarrerasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Filtrar_Carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 45, 40));

        B_Invertir_Orden_Carreras.setToolTipText("Cambiar dirección del orden de los datos mostrados en la tabla ");
        B_Invertir_Orden_Carreras.setMargin(new java.awt.Insets(2, 2, 2, 2));
        B_Invertir_Orden_Carreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Invertir_Orden_CarrerasActionPerformed(evt);
            }
        });
        jPanel1.add(B_Invertir_Orden_Carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 45, 40));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setText("Promedio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, -1, -1));

        L_Promedio.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        L_Promedio.setText("5.95");
        jPanel1.add(L_Promedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 480, -1, -1));

        jMenu1.setText("Usuario");

        MI_Administrar_Usuario.setText("Administrar Usuarios");
        MI_Administrar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Administrar_UsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Administrar_Usuario);

        MI_Cambiar_Contrasenna.setText("Cambiar Contraseña");
        MI_Cambiar_Contrasenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Cambiar_ContrasennaActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Cambiar_Contrasenna);
        jMenu1.add(jSeparator1);

        MI_Cerrar_Sesion.setText("Cerrar Sesión");
        MI_Cerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Cerrar_SesionActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Cerrar_Sesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Facultades");

        MI_Agregar_Facultad.setText("Agregar Facultad");
        MI_Agregar_Facultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Agregar_FacultadActionPerformed(evt);
            }
        });
        jMenu2.add(MI_Agregar_Facultad);

        MI_Modificar_Facultad.setText("Modificar Facultad");
        MI_Modificar_Facultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Modificar_FacultadActionPerformed(evt);
            }
        });
        jMenu2.add(MI_Modificar_Facultad);

        MI_Eliminar_Facultad.setText("Eliminar Facultad");
        MI_Eliminar_Facultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Eliminar_FacultadActionPerformed(evt);
            }
        });
        jMenu2.add(MI_Eliminar_Facultad);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Carreras");

        MI_Agregar_Carrera.setText("Agregar Carrera");
        MI_Agregar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Agregar_CarreraActionPerformed(evt);
            }
        });
        jMenu3.add(MI_Agregar_Carrera);

        MI_Modifcar_Carrera.setText("Modifcar Carrera");
        MI_Modifcar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Modifcar_CarreraActionPerformed(evt);
            }
        });
        jMenu3.add(MI_Modifcar_Carrera);

        MI_Eliminar_Carrera.setText("Eliminar Carrera");
        MI_Eliminar_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Eliminar_CarreraActionPerformed(evt);
            }
        });
        jMenu3.add(MI_Eliminar_Carrera);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Asignatura");

        MI_Agregar_Asignatura.setText("Agregar Asignatura");
        MI_Agregar_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Agregar_AsignaturaActionPerformed(evt);
            }
        });
        jMenu4.add(MI_Agregar_Asignatura);

        MI_Modificar_Asignatura.setText("Modificar Asignatura");
        MI_Modificar_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Modificar_AsignaturaActionPerformed(evt);
            }
        });
        jMenu4.add(MI_Modificar_Asignatura);

        MI_Eliminar_Asignatura.setText("Eliminar Asignatura");
        MI_Eliminar_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_Eliminar_AsignaturaActionPerformed(evt);
            }
        });
        jMenu4.add(MI_Eliminar_Asignatura);
        jMenu4.add(jSeparator2);

        jMenu5.setText("Ordenar por");

        MI_RB_Ordenar_Asignatura_Por_Nombre.setSelected(true);
        MI_RB_Ordenar_Asignatura_Por_Nombre.setText("Nombre");
        MI_RB_Ordenar_Asignatura_Por_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Asignatura_Por_NombreActionPerformed(evt);
            }
        });
        jMenu5.add(MI_RB_Ordenar_Asignatura_Por_Nombre);

        MI_RB_Ordenar_Asignatura_Por_Modalidad.setSelected(true);
        MI_RB_Ordenar_Asignatura_Por_Modalidad.setText("Modalidad");
        MI_RB_Ordenar_Asignatura_Por_Modalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Asignatura_Por_ModalidadActionPerformed(evt);
            }
        });
        jMenu5.add(MI_RB_Ordenar_Asignatura_Por_Modalidad);

        MI_RB_Ordenar_Asignatura_Por_Semestre.setSelected(true);
        MI_RB_Ordenar_Asignatura_Por_Semestre.setText("Semestre");
        MI_RB_Ordenar_Asignatura_Por_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Asignatura_Por_SemestreActionPerformed(evt);
            }
        });
        jMenu5.add(MI_RB_Ordenar_Asignatura_Por_Semestre);

        jMenu4.add(jMenu5);

        jMenu6.setText("Filtrar por");

        MI_ChB_Filtrar_Asignatura_Por_Nombre.setSelected(true);
        MI_ChB_Filtrar_Asignatura_Por_Nombre.setText("Nombre");
        MI_ChB_Filtrar_Asignatura_Por_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Asignatura_Por_NombreActionPerformed(evt);
            }
        });
        jMenu6.add(MI_ChB_Filtrar_Asignatura_Por_Nombre);

        MI_ChB_Filtrar_Asignatura_Por_Modalidad.setSelected(true);
        MI_ChB_Filtrar_Asignatura_Por_Modalidad.setText("Modalidad");
        MI_ChB_Filtrar_Asignatura_Por_Modalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Asignatura_Por_ModalidadActionPerformed(evt);
            }
        });
        jMenu6.add(MI_ChB_Filtrar_Asignatura_Por_Modalidad);

        MI_ChB_Filtrar_Asignatura_Por_Semestre.setSelected(true);
        MI_ChB_Filtrar_Asignatura_Por_Semestre.setText("Semestre");
        MI_ChB_Filtrar_Asignatura_Por_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Asignatura_Por_SemestreActionPerformed(evt);
            }
        });
        jMenu6.add(MI_ChB_Filtrar_Asignatura_Por_Semestre);

        jMenu4.add(jMenu6);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Estudiantes");

        MI_Agregar_Estudiante.setText("Agregar Estudiante");
        jMenu7.add(MI_Agregar_Estudiante);

        MI_Modificar_Estudiante.setText("Modificar Estudiante");
        jMenu7.add(MI_Modificar_Estudiante);

        MI_Eliminar_Estudiante.setText("Eliminar Estudiante");
        jMenu7.add(MI_Eliminar_Estudiante);
        jMenu7.add(jSeparator3);

        jMenu8.setText("Ordenar Por");

        MI_RB_Ordenar_Estudiantes_Por_Nombre.setSelected(true);
        MI_RB_Ordenar_Estudiantes_Por_Nombre.setText("Nombre");
        MI_RB_Ordenar_Estudiantes_Por_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Estudiantes_Por_NombreActionPerformed(evt);
            }
        });
        jMenu8.add(MI_RB_Ordenar_Estudiantes_Por_Nombre);

        MI_RB_Ordenar_Estudiantes_Por_Apellidos.setSelected(true);
        MI_RB_Ordenar_Estudiantes_Por_Apellidos.setText("Apellidos");
        MI_RB_Ordenar_Estudiantes_Por_Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Estudiantes_Por_ApellidosActionPerformed(evt);
            }
        });
        jMenu8.add(MI_RB_Ordenar_Estudiantes_Por_Apellidos);

        MI_RB_Ordenar_Estudiantes_Por_Grupo.setSelected(true);
        MI_RB_Ordenar_Estudiantes_Por_Grupo.setText("Grupo");
        MI_RB_Ordenar_Estudiantes_Por_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RB_Ordenar_Estudiantes_Por_GrupoActionPerformed(evt);
            }
        });
        jMenu8.add(MI_RB_Ordenar_Estudiantes_Por_Grupo);

        jMenu7.add(jMenu8);

        jMenu9.setText("Filtrar Por");

        MI_ChB_Filtrar_Estudiantes_Por_Nombre.setSelected(true);
        MI_ChB_Filtrar_Estudiantes_Por_Nombre.setText("Nombre");
        MI_ChB_Filtrar_Estudiantes_Por_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Estudiantes_Por_NombreActionPerformed(evt);
            }
        });
        jMenu9.add(MI_ChB_Filtrar_Estudiantes_Por_Nombre);

        MI_ChB_Filtrar_Estudiantes_Por_Apellidos.setSelected(true);
        MI_ChB_Filtrar_Estudiantes_Por_Apellidos.setText("Apellidos");
        MI_ChB_Filtrar_Estudiantes_Por_Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Estudiantes_Por_ApellidosActionPerformed(evt);
            }
        });
        jMenu9.add(MI_ChB_Filtrar_Estudiantes_Por_Apellidos);

        MI_ChB_Filtrar_Estudiantes_Por_Grupo.setSelected(true);
        MI_ChB_Filtrar_Estudiantes_Por_Grupo.setText("Grupo");
        MI_ChB_Filtrar_Estudiantes_Por_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ChB_Filtrar_Estudiantes_Por_GrupoActionPerformed(evt);
            }
        });
        jMenu9.add(MI_ChB_Filtrar_Estudiantes_Por_Grupo);

        jMenu7.add(jMenu9);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_Agregar_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_FacultadesActionPerformed
        intentarAgregarFacultad();
    }//GEN-LAST:event_B_Agregar_FacultadesActionPerformed

    private void TI_Filtro_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TI_Filtro_FacultadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TI_Filtro_FacultadesActionPerformed

    private void B_Filtrar_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Filtrar_FacultadesActionPerformed
        try {
            final String texto = TI_Filtro_Facultades.getText().trim().toLowerCase();
            if (texto.isEmpty()) {

                this.facultades_existentes = new ArrayList<>(Arrays.asList(EnMemoria.BD.obtenerTodos_Facultad()));
                actualizarTabla_Facultad(this.facultades_existentes);

            } else {
                final ArrayList<Facultad> seleccionados = new ArrayList<>();
                this.facultades_existentes.forEach(v -> {
                    if (v.getFacultad().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                    }
                });
                actualizarTabla_Facultad(seleccionados);
            }
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Filtrar_FacultadesActionPerformed

    private void B_Invertir_Orden_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Invertir_Orden_FacultadesActionPerformed
        try {
            this.ordenar_de_forma_asendente_Facultad = !this.ordenar_de_forma_asendente_Facultad;
            UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Facultades, this.ordenar_de_forma_asendente_Facultad);
            actualizarTabla_Facultad(this.facultades_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Invertir_Orden_FacultadesActionPerformed

    private void B_Invertir_Orden_AsiganturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Invertir_Orden_AsiganturasActionPerformed
        try {
            this.ordenar_de_forma_asendente_Asignaturas = !this.ordenar_de_forma_asendente_Asignaturas;
            UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Asiganturas, this.ordenar_de_forma_asendente_Asignaturas);
            actualizarTabla_Asignatura(this.asignaturas_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Invertir_Orden_AsiganturasActionPerformed

    private void B_Filtrar_AsiganturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Filtrar_AsiganturasActionPerformed
        aplicarFiltro_Asignaturas();
    }//GEN-LAST:event_B_Filtrar_AsiganturasActionPerformed

    private void TI_Filtro_AsiganturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TI_Filtro_AsiganturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TI_Filtro_AsiganturasActionPerformed

    private void TI_Filtro_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TI_Filtro_EstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TI_Filtro_EstudiantesActionPerformed

    private void B_Filtrar_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Filtrar_EstudiantesActionPerformed
        aplicarFiltro_Estudiantes();
    }//GEN-LAST:event_B_Filtrar_EstudiantesActionPerformed

    private void B_Invertir_Orden_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Invertir_Orden_EstudiantesActionPerformed
        try {
            this.ordenar_de_forma_asendente_Estudiantes = !this.ordenar_de_forma_asendente_Estudiantes;
            UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Estudiantes, this.ordenar_de_forma_asendente_Estudiantes);
            actualizarTabla_Estudiante(this.estudiantes_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Invertir_Orden_EstudiantesActionPerformed

    private void TI_Filtro_CarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TI_Filtro_CarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TI_Filtro_CarrerasActionPerformed

    private void B_Filtrar_CarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Filtrar_CarrerasActionPerformed
        try {
            final String texto = TI_Filtro_Carreras.getText().trim().toLowerCase();
            if (texto.isEmpty()) {
                Facultad l = this.facultades_en_tabla.get(T_Facultades.getSelectedRow());
                actualizar_T_A_PartirDe(l);

            } else {
                final ArrayList<Carrera> seleccionados = new ArrayList<>();
                this.carreras_existentes_de_facultad.forEach(v -> {
                    if (v.getCarrera().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                    }
                });
                actualizarTabla_Carrera(seleccionados);
            }
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Filtrar_CarrerasActionPerformed

    private void B_Invertir_Orden_CarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Invertir_Orden_CarrerasActionPerformed
        try {
            this.ordenar_de_forma_asendente_Carreras = !this.ordenar_de_forma_asendente_Carreras;
            UtilidadesParaVentana.cambiarIconoDeDireccion(B_Invertir_Orden_Carreras, this.ordenar_de_forma_asendente_Carreras);
            actualizarTabla_Carrera(this.carreras_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_B_Invertir_Orden_CarrerasActionPerformed

    private void B_Editar_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_FacultadesActionPerformed
        intentarModificarFacultad();
    }//GEN-LAST:event_B_Editar_FacultadesActionPerformed

    private void B_Eliminar_FacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_FacultadesActionPerformed
        intentarElimnarFacultad();
    }//GEN-LAST:event_B_Eliminar_FacultadesActionPerformed

    private void B_Agregar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_CarreraActionPerformed
        intentarAgregarCarrera();
    }//GEN-LAST:event_B_Agregar_CarreraActionPerformed

    private void B_Eliminar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_CarreraActionPerformed
        intentarEliminarCarrera();
    }//GEN-LAST:event_B_Eliminar_CarreraActionPerformed

    private void B_Editar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_CarreraActionPerformed
        intentarModificarCarrera();
    }//GEN-LAST:event_B_Editar_CarreraActionPerformed

    private void B_Agregar_AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_AsignaturasActionPerformed
        intentarAgregarAsignatura();
    }//GEN-LAST:event_B_Agregar_AsignaturasActionPerformed

    private void B_Editar_AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_AsignaturasActionPerformed
        intentarModificarAsignatura();
    }//GEN-LAST:event_B_Editar_AsignaturasActionPerformed

    private void B_Eliminar_AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_AsignaturasActionPerformed
        intentarEliminarAsignatura();
    }//GEN-LAST:event_B_Eliminar_AsignaturasActionPerformed

    private void B_Agregar_ProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_ProfesorActionPerformed
        intentarAgregarProfesor();
    }//GEN-LAST:event_B_Agregar_ProfesorActionPerformed

    private void B_Editar_ProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_ProfesorActionPerformed
        intentarModificarProfesor();
    }//GEN-LAST:event_B_Editar_ProfesorActionPerformed

    private void B_Eliminar_ProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_ProfesorActionPerformed
        intentarEliminarProfesor();
    }//GEN-LAST:event_B_Eliminar_ProfesorActionPerformed

    private void B_Agregar_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_EstudiantesActionPerformed
        intentarAgregarEstudiante();
    }//GEN-LAST:event_B_Agregar_EstudiantesActionPerformed

    private void B_Editar_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_EstudiantesActionPerformed
        intentarModificarEstudiante();
    }//GEN-LAST:event_B_Editar_EstudiantesActionPerformed

    private void B_Eliminar_EstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_EstudiantesActionPerformed
        intentarEliminarEstudiante();
    }//GEN-LAST:event_B_Eliminar_EstudiantesActionPerformed

    private void B_Agregar_ExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Agregar_ExamenesActionPerformed
        intentarAgregarConvocatoria();
    }//GEN-LAST:event_B_Agregar_ExamenesActionPerformed

    private void B_Eliminar_ExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Eliminar_ExamenesActionPerformed
        intentarEliminarConvocatoria();
    }//GEN-LAST:event_B_Eliminar_ExamenesActionPerformed

    private void B_Editar_ExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Editar_ExamenesActionPerformed
        intentarModificarConvocatoria();
    }//GEN-LAST:event_B_Editar_ExamenesActionPerformed

    private void MI_Agregar_FacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Agregar_FacultadActionPerformed
        intentarAgregarFacultad();
    }//GEN-LAST:event_MI_Agregar_FacultadActionPerformed

    private void MI_Modificar_FacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Modificar_FacultadActionPerformed
       intentarModificarFacultad();
    }//GEN-LAST:event_MI_Modificar_FacultadActionPerformed

    private void MI_Eliminar_FacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Eliminar_FacultadActionPerformed
        intentarElimnarFacultad();
    }//GEN-LAST:event_MI_Eliminar_FacultadActionPerformed

    private void MI_Agregar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Agregar_CarreraActionPerformed
       intentarAgregarCarrera();
    }//GEN-LAST:event_MI_Agregar_CarreraActionPerformed

    private void MI_Modifcar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Modifcar_CarreraActionPerformed
       intentarModificarCarrera();
    }//GEN-LAST:event_MI_Modifcar_CarreraActionPerformed

    private void MI_Eliminar_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Eliminar_CarreraActionPerformed
       intentarEliminarCarrera();
    }//GEN-LAST:event_MI_Eliminar_CarreraActionPerformed

    private void MI_Agregar_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Agregar_AsignaturaActionPerformed
       intentarAgregarAsignatura();
    }//GEN-LAST:event_MI_Agregar_AsignaturaActionPerformed

    private void MI_Modificar_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Modificar_AsignaturaActionPerformed
       intentarModificarAsignatura();
    }//GEN-LAST:event_MI_Modificar_AsignaturaActionPerformed

    private void MI_Eliminar_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Eliminar_AsignaturaActionPerformed
       intentarModificarAsignatura();
    }//GEN-LAST:event_MI_Eliminar_AsignaturaActionPerformed

    private void MI_RB_Ordenar_Asignatura_Por_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Asignatura_Por_NombreActionPerformed
       try {

            actualizarTabla_Asignatura(this.asignaturas_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Asignatura_Por_NombreActionPerformed

    private void MI_RB_Ordenar_Asignatura_Por_ModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Asignatura_Por_ModalidadActionPerformed
        try {

            actualizarTabla_Asignatura(this.asignaturas_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Asignatura_Por_ModalidadActionPerformed

    private void MI_RB_Ordenar_Asignatura_Por_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Asignatura_Por_SemestreActionPerformed
      try {

            actualizarTabla_Asignatura(this.asignaturas_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Asignatura_Por_SemestreActionPerformed

    private void MI_ChB_Filtrar_Asignatura_Por_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Asignatura_Por_NombreActionPerformed
       aplicarFiltro_Asignaturas();
    }//GEN-LAST:event_MI_ChB_Filtrar_Asignatura_Por_NombreActionPerformed

    private void MI_ChB_Filtrar_Asignatura_Por_ModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Asignatura_Por_ModalidadActionPerformed
        aplicarFiltro_Asignaturas();
    }//GEN-LAST:event_MI_ChB_Filtrar_Asignatura_Por_ModalidadActionPerformed

    private void MI_ChB_Filtrar_Asignatura_Por_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Asignatura_Por_SemestreActionPerformed
     aplicarFiltro_Asignaturas();
    }//GEN-LAST:event_MI_ChB_Filtrar_Asignatura_Por_SemestreActionPerformed

    private void MI_RB_Ordenar_Estudiantes_Por_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Estudiantes_Por_NombreActionPerformed
       try {

            actualizarTabla_Estudiante(this.estudiantes_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Estudiantes_Por_NombreActionPerformed

    private void MI_RB_Ordenar_Estudiantes_Por_ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Estudiantes_Por_ApellidosActionPerformed
         try {

            actualizarTabla_Estudiante(this.estudiantes_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Estudiantes_Por_ApellidosActionPerformed

    private void MI_RB_Ordenar_Estudiantes_Por_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RB_Ordenar_Estudiantes_Por_GrupoActionPerformed
        try {

            actualizarTabla_Estudiante(this.estudiantes_en_tabla);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_RB_Ordenar_Estudiantes_Por_GrupoActionPerformed

    private void MI_ChB_Filtrar_Estudiantes_Por_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Estudiantes_Por_NombreActionPerformed
        aplicarFiltro_Estudiantes();
    }//GEN-LAST:event_MI_ChB_Filtrar_Estudiantes_Por_NombreActionPerformed

    private void MI_ChB_Filtrar_Estudiantes_Por_ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Estudiantes_Por_ApellidosActionPerformed
        aplicarFiltro_Estudiantes();
    }//GEN-LAST:event_MI_ChB_Filtrar_Estudiantes_Por_ApellidosActionPerformed

    private void MI_ChB_Filtrar_Estudiantes_Por_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ChB_Filtrar_Estudiantes_Por_GrupoActionPerformed
       aplicarFiltro_Estudiantes();
    }//GEN-LAST:event_MI_ChB_Filtrar_Estudiantes_Por_GrupoActionPerformed

    private void MI_Administrar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Administrar_UsuarioActionPerformed
         try {
            EnMemoria.ventana_Administrar_Usuarios.actualizar(usuarioActual);
            EnMemoria.ventana_Administrar_Usuarios.setVisible(true);
            setVisible(false);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_Administrar_UsuarioActionPerformed

    private void MI_Cambiar_ContrasennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Cambiar_ContrasennaActionPerformed
        try {
            EnMemoria.dialogo_Cambiar_Contrasenna.setLocationRelativeTo(this);
            EnMemoria.dialogo_Cambiar_Contrasenna.resetear(usuarioActual);
            EnMemoria.dialogo_Cambiar_Contrasenna.setVisible(true);
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }//GEN-LAST:event_MI_Cambiar_ContrasennaActionPerformed

    private void MI_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Cerrar_SesionActionPerformed
       EnMemoria.ventana_Loguin.resetear();
        setVisible(false);
        EnMemoria.ventana_Loguin.setVisible(true);
    }//GEN-LAST:event_MI_Cerrar_SesionActionPerformed

    private void intentarEliminarConvocatoria() {
        try {
            if (T_Examenes.getSelectedRow() != -1) {

                if (JOptionPane.showConfirmDialog(this, "Desea eliminar el Examen seleccionado?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    Convocatoria a = this.convocatorias_en_tabla.get(T_Examenes.getSelectedRow());

                    EnMemoria.BD.eliminarConvocatoria(a);

                    this.convocatorias_existentes_de_estudiante_y_asignatura.remove(a);

                    actualizarTabla_Convocatoria(this.convocatorias_existentes_de_estudiante_y_asignatura);

                    DLG_Respuesta.mostrarDlgExito(this, "Examen eliminado con éxito  ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar un examen en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarModificarConvocatoria() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura a = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (T_Estudiantes.getSelectedRow() != -1) {
                    Estudiante e = this.estudiantes_en_tabla.get(T_Estudiantes.getSelectedRow());

                    if (T_Examenes.getSelectedRow() != -1) {
                        Convocatoria c = this.convocatorias_en_tabla.get(T_Examenes.getSelectedRow());

                        EnMemoria.dialogo_Modificar_Examen.resetear(e, a,c);
                        EnMemoria.dialogo_Modificar_Examen.setVisible(true);

                    } else {
                        DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar un examen en la tabla ");
                    }
                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una estudiante en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarConvocatoria() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura a = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (T_Estudiantes.getSelectedRow() != -1) {
                    Estudiante e = this.estudiantes_en_tabla.get(T_Estudiantes.getSelectedRow());

                    EnMemoria.dialogo_Agregar_Examen.resetear(e, a);
                    EnMemoria.dialogo_Agregar_Examen.setVisible(true);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una estudiante en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarEliminarEstudiante() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura a = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (T_Estudiantes.getSelectedRow() != -1) {
                    if (JOptionPane.showConfirmDialog(this, "Desea eliminar el Estudiante seleccionado?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                        Estudiante e = this.estudiantes_en_tabla.get(T_Estudiantes.getSelectedRow());

                        EnMemoria.BD.eliminarEstudiante(e);
                        TI_Filtro_Estudiantes.setText("");

                        this.estudiantes_existentes_de_asignatura.remove(e);

                        actualizarTabla_Estudiante(this.estudiantes_existentes_de_asignatura);

                        DLG_Respuesta.mostrarDlgExito(this, "Estudiante eliminado con éxito  ");
                    }

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una estudiante en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarModificarEstudiante() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura a = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (T_Estudiantes.getSelectedRow() != -1) {
                    Estudiante e = this.estudiantes_en_tabla.get(T_Estudiantes.getSelectedRow());

                    EnMemoria.dialogo_Modificar_Estudiante.resetear(e, a);
                    EnMemoria.dialogo_Modificar_Estudiante.setVisible(true);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una estudiante en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarEstudiante() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                EnMemoria.dialogo_Agregar_Estudiante.resetear(e);
                EnMemoria.dialogo_Agregar_Estudiante.setVisible(true);

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarModificarProfesor() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (this.profesorDeAsignatura != null) {

                    EnMemoria.dialogo_Modificar_Profesor.resetear(this.profesorDeAsignatura, e);
                    EnMemoria.dialogo_Modificar_Profesor.setVisible(true);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que agregar un profesor");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarProfesor() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                EnMemoria.dialogo_Agregar_Profesor.resetear(e);
                EnMemoria.dialogo_Agregar_Profesor.setVisible(true);

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarEliminarProfesor() {
        try {
            if (T_Asignaturas.getSelectedRow() != -1) {
                Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                if (this.profesorDeAsignatura != null) {

                    if (JOptionPane.showConfirmDialog(this, "Desea eliminar el Profesor de esta Asignatura?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

                        EnMemoria.BD.quitarProfesorDeAsignaturaYEliminarlo(e, this.profesorDeAsignatura);

                        actualizarDatosProfesor(null);

                        DLG_Respuesta.mostrarDlgExito(this, "Profesor eliminado con éxito  ");
                    }

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que agregar un profesor");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarEliminarAsignatura() {
        try {
            if (T_Carrera.getSelectedRow() != -1) {
                Carrera l = carreras_en_tabla.get(T_Carrera.getSelectedRow());

                if (T_Asignaturas.getSelectedRow() != -1) {

                    if (JOptionPane.showConfirmDialog(this, "Desea eliminar la Asignatura seleccionada?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                        Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                        EnMemoria.BD.eliminarAsignatura(e);
                        TI_Filtro_Asiganturas.setText("");
                        TI_Filtro_Estudiantes.setText("");

                        this.asignaturas_existentes_de_carrera.remove(e);

                        actualizarTabla_Asignatura(this.asignaturas_existentes_de_carrera);

                        DLG_Respuesta.mostrarDlgExito(this, "Asignatura eliminada con éxito  ");
                    }

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una carrera en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarModificarAsignatura() {
        try {
            if (T_Carrera.getSelectedRow() != -1) {
                Carrera l = carreras_en_tabla.get(T_Carrera.getSelectedRow());

                if (T_Asignaturas.getSelectedRow() != -1) {
                    Asignatura e = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());

                    EnMemoria.dialogo_Modificar_Asignatura.resetear(e);
                    EnMemoria.dialogo_Modificar_Asignatura.setVisible(true);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una carrera en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarAsignatura() {
        try {
            if (T_Carrera.getSelectedRow() != -1) {
                Carrera l = carreras_en_tabla.get(T_Carrera.getSelectedRow());

                EnMemoria.dialogo_Agregar_Asignatura.resetear(l);
                EnMemoria.dialogo_Agregar_Asignatura.setVisible(true);

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una carrera en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    public void actualizar_Convocatoria(Convocatoria e) throws Exception {

        this.convocatorias_existentes_de_estudiante_y_asignatura.remove(e);
        this.convocatorias_existentes_de_estudiante_y_asignatura.add(e);
        actualizarTabla_Convocatoria(this.convocatorias_existentes_de_estudiante_y_asignatura);
    }

    public void actualizar_Estudiante(Estudiante e) throws Exception {

        TI_Filtro_Estudiantes.setText("");

        this.estudiantes_existentes_de_asignatura.remove(e);
        this.estudiantes_existentes_de_asignatura.add(e);
        actualizarTabla_Estudiante(this.estudiantes_existentes_de_asignatura);
    }

    public void actualizar_Asignatura(Asignatura e) throws Exception {
        TI_Filtro_Asiganturas.setText("");
        TI_Filtro_Estudiantes.setText("");

        this.asignaturas_existentes_de_carrera.remove(e);
        this.asignaturas_existentes_de_carrera.add(e);
        actualizarTabla_Asignatura(this.asignaturas_existentes_de_carrera);
    }

    public void actualizar_Profesor(Profesor e) throws Exception {

        actualizarDatosProfesor(e);

    }

    private void intentarModificarCarrera() {
        try {
            if (T_Facultades.getSelectedRow() != -1) {
                Facultad l = this.facultades_en_tabla.get(T_Facultades.getSelectedRow());

                if (T_Carrera.getSelectedRow() != -1) {
                    Carrera m = carreras_en_tabla.get(T_Carrera.getSelectedRow());

                    String medioBasiocModificado = JOptionPane.showInputDialog(this, "Escriba el nombre de la carrera modificada ", m.getCarrera());//"Modificar Local",JOptionPane.QUESTION_MESSAGE
                    if (medioBasiocModificado != null && MetodosValidacion.validar_es_modificar_Carrera_correcto(this, m, medioBasiocModificado)) {
                        m.setCarrera(medioBasiocModificado);
                        Carrera medioModificado = EnMemoria.BD.modificarCarrera(m);

                        TI_Filtro_Asiganturas.setText("");
                        TI_Filtro_Carreras.setText("");
                        TI_Filtro_Estudiantes.setText("");

                        this.carreras_existentes_de_facultad.remove(m);
                        this.carreras_existentes_de_facultad.add(medioModificado);
                        actualizarTabla_Carrera(this.carreras_existentes_de_facultad);

                        DLG_Respuesta.mostrarDlgExito(this, "Carrera modificada con éxito  ");

                    }

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Carrera en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Facultad en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarEliminarCarrera() {
        try {
            if (T_Facultades.getSelectedRow() != -1) {
                Facultad l = this.facultades_en_tabla.get(T_Facultades.getSelectedRow());

                if (T_Carrera.getSelectedRow() != -1) {

                    if (JOptionPane.showConfirmDialog(this, "Desea eliminar la Carrera seleccionada?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                        Carrera m = carreras_en_tabla.get(T_Carrera.getSelectedRow());

                        EnMemoria.BD.eliminarCarrera(m);
                        TI_Filtro_Asiganturas.setText("");
                        TI_Filtro_Carreras.setText("");
                        TI_Filtro_Estudiantes.setText("");

                        this.carreras_existentes_de_facultad.remove(m);

                        actualizarTabla_Carrera(this.carreras_existentes_de_facultad);

                        DLG_Respuesta.mostrarDlgExito(this, "Carrera eliminada con éxito  ");
                    }

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Carrera en la tabla ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Facultad en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarCarrera() {
        try {
            if (T_Facultades.getSelectedRow() != -1) {

                String nombre = JOptionPane.showInputDialog(this, "Escriba el nombre de la Carrera a agregar ", "Agregar Carrera", JOptionPane.QUESTION_MESSAGE);
                if (nombre != null && MetodosValidacion.validar_es_nuevo_Carrera_correcto(this, nombre)) {
                    Facultad l = this.facultades_en_tabla.get(T_Facultades.getSelectedRow());
                    Carrera nuevo = EnMemoria.BD.agregarCarrera(l, nombre);
                    DLG_Respuesta.mostrarDlgExito(this, "Carrera agregada con éxito");
                    TI_Filtro_Asiganturas.setText("");
                    TI_Filtro_Carreras.setText("");
                    TI_Filtro_Estudiantes.setText("");

                    this.carreras_existentes_de_facultad.add(nuevo);
                    actualizarTabla_Carrera(this.carreras_existentes_de_facultad);

                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Facultad en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void aplicarFiltro_Estudiantes() {
        try {
            final String texto = TI_Filtro_Estudiantes.getText().trim().toLowerCase();
            if (texto.isEmpty()) {
                if (T_Asignaturas.getSelectedRow() != -1) {
                    Asignatura l = this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow());
                    actualizar_T_A_PartirDe(l);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una asignatura en la tabla ");
                }

            } else {
                final ArrayList<Estudiante> seleccionados = new ArrayList<>();
                this.estudiantes_existentes_de_asignatura.forEach(v -> {
                    if (MI_ChB_Filtrar_Estudiantes_Por_Apellidos.isSelected()
                            && v.getApellidos().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }
                    if (MI_ChB_Filtrar_Estudiantes_Por_Grupo.isSelected()
                            && v.getGrupo().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }
                    if (MI_ChB_Filtrar_Estudiantes_Por_Nombre.isSelected()
                            && v.getNombre().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }

                });
                actualizarTabla_Estudiante(seleccionados);
            }
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void aplicarFiltro_Asignaturas() {
        try {
            final String texto = TI_Filtro_Asiganturas.getText().trim().toLowerCase();
            if (texto.isEmpty()) {
                if (T_Carrera.getSelectedRow() != -1) {
                    Carrera l = this.carreras_en_tabla.get(T_Carrera.getSelectedRow());
                    actualizar_T_A_PartirDe(l);

                } else {
                    DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una carrera en la tabla ");
                }

            } else {
                final ArrayList<Asignatura> seleccionados = new ArrayList<>();
                this.asignaturas_existentes_de_carrera.forEach(v -> {
                    if (MI_ChB_Filtrar_Asignatura_Por_Nombre.isSelected()
                            && v.getAsignatura().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }
                    if (MI_ChB_Filtrar_Asignatura_Por_Modalidad.isSelected()
                            && v.getModalidad().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }
                    if (MI_ChB_Filtrar_Asignatura_Por_Semestre.isSelected()
                            && v.getSemestre().toLowerCase().contains(texto)) {
                        seleccionados.add(v);
                        return;
                    }

                });
                actualizarTabla_Asignatura(seleccionados);
            }
        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarElimnarFacultad() {
        try {
            if (T_Facultades.getSelectedRow() != -1) {
                if (JOptionPane.showConfirmDialog(this, "Desea eliminar la Facultad seleccionada?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    Facultad localSeleccionado = facultades_en_tabla.get(T_Facultades.getSelectedRow());

                    EnMemoria.BD.eliminarFacultad(localSeleccionado);
                    TI_Filtro_Asiganturas.setText("");
                    TI_Filtro_Carreras.setText("");
                    TI_Filtro_Estudiantes.setText("");
                    TI_Filtro_Facultades.setText("");

                    this.facultades_existentes.remove(localSeleccionado);

                    actualizarTabla_Facultad(this.facultades_existentes);

                    DLG_Respuesta.mostrarDlgExito(this, "Facultad eliminada con éxito  ");
                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una Facultad en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarModificarFacultad() {
        try {
            if (T_Facultades.getSelectedRow() != -1) {
                Facultad l = facultades_en_tabla.get(T_Facultades.getSelectedRow());

                String nombre = JOptionPane.showInputDialog(this, "Escriba el nombre de la facultad modificada ", l.getFacultad());
                if (nombre != null && MetodosValidacion.validar_es_modificar_Facultad_correcto(this, l, nombre)) {
                    l.setFacultad(nombre);
                    Facultad nombreModificado = EnMemoria.BD.modificarFacultad(l);

                    TI_Filtro_Asiganturas.setText("");
                    TI_Filtro_Carreras.setText("");
                    TI_Filtro_Estudiantes.setText("");
                    TI_Filtro_Facultades.setText("");

                    this.facultades_existentes.remove(l);
                    this.facultades_existentes.add(nombreModificado);
                    actualizarTabla_Facultad(this.facultades_existentes);

                    DLG_Respuesta.mostrarDlgExito(this, "Facultad modificada con éxito  ");

                }

            } else {
                DLG_Respuesta.mostrarDlgInvalido(this, "Tiene que seleccionar una facultad en la tabla ");
            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void intentarAgregarFacultad() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Escriba el nombre de la Facultad a agregar ", "Agregar Facultad", JOptionPane.QUESTION_MESSAGE);
            if (nombre != null && MetodosValidacion.validar_es_nuevo_Facultad_correcto(this, nombre)) {
                Facultad nuevo = EnMemoria.BD.agregarFacultad(nombre);
                DLG_Respuesta.mostrarDlgExito(this, "Facultad agregada con éxito");
                TI_Filtro_Asiganturas.setText("");
                TI_Filtro_Carreras.setText("");
                TI_Filtro_Estudiantes.setText("");
                TI_Filtro_Facultades.setText("");
                this.facultades_existentes.add(nuevo);
                actualizarTabla_Facultad(this.facultades_existentes);

            }

        } catch (Exception ex) {
            DLG_Respuesta.mostrarDlg_ErrorEnLaBD(this, ex);
        }
    }

    private void actualizarTabla_Facultad(ArrayList<Facultad> L) throws Exception {
        L = ordenar_Facultad(L);
        this.facultades_en_tabla = L;
        int cantidad = L.size();
        String Tiulos[] = {"Nombre"};
        Object O[][] = new Object[cantidad][Tiulos.length];
        for (int i = 0; i < cantidad; i++) {
            O[i][0] = L.get(i).getFacultad();
        }
        T_Facultades.setModel(new DefaultTableModel(O, Tiulos) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        });
        Facultad l = null;
        if (cantidad > 0) {
            T_Facultades.addRowSelectionInterval(0, 0);
            l = L.get(0);
            l=EnMemoria.BD.obtenerPorID_Facultad(l);
        }

        actualizar_T_A_PartirDe(l);

    }

    private void actualizar_T_A_PartirDe(Facultad l) throws Exception {
        if (l != null) {
            this.carreras_existentes_de_facultad = new ArrayList<>(Arrays.asList(EnMemoria.BD.obtenerTodos_Carrera(l)));

        } else {
            this.carreras_existentes_de_facultad = new ArrayList<>();
        }
        actualizarTabla_Carrera(this.carreras_existentes_de_facultad);
    }

    private void actualizarTabla_Carrera(ArrayList<Carrera> L) throws Exception {
        L = ordenar_Carreras(L);
        this.carreras_en_tabla = L;
        int cantidad = L.size();
        String Tiulos[] = {"Nombre"};
        Object O[][] = new Object[cantidad][Tiulos.length];
        for (int i = 0; i < cantidad; i++) {
            Carrera e = L.get(i);
            O[i][0] = e.getCarrera();

        }
        T_Carrera.setModel(new DefaultTableModel(O, Tiulos) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        });
        Carrera l = null;
        if (cantidad > 0) {
            T_Carrera.addRowSelectionInterval(0, 0);
            l = L.get(0);
            l=EnMemoria.BD.obtenerPorID_Carrera(l);
        }
        actualizar_T_A_PartirDe(l);
    }

    private void actualizar_T_A_PartirDe(Carrera l) throws Exception {
        if (l != null) {
            Asignatura []A=EnMemoria.BD.obtenerTodos_Asignatura(l);
            this.asignaturas_existentes_de_carrera = new ArrayList<>(Arrays.asList(A));

        } else {
            this.asignaturas_existentes_de_carrera = new ArrayList<>();
        }
        actualizarTabla_Asignatura(this.asignaturas_existentes_de_carrera);
    }

    private void actualizarTabla_Asignatura(ArrayList<Asignatura> L) throws Exception {
        L = ordenar_Asignatura(L);
        this.asignaturas_en_tabla = L;
        int cantidad = L.size();
        String Tiulos[] = {"Nombre", "Modalidad", "Semestre"};
        Object O[][] = new Object[cantidad][Tiulos.length];
        for (int i = 0; i < cantidad; i++) {
            Asignatura a = L.get(i);
            O[i][0] = a.getAsignatura();
            O[i][1] = a.getModalidad();
            O[i][2] = a.getSemestre();

        }
        T_Asignaturas.setModel(new DefaultTableModel(O, Tiulos) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        });
        Asignatura l = null;
        if (cantidad > 0) {
            T_Asignaturas.addRowSelectionInterval(0, 0);
            l = L.get(0);
            l=EnMemoria.BD.obtenerPorID_Asignatura(l);

        }
        actualizar_T_A_PartirDe(l);

    }

    private void actualizar_T_A_PartirDe(Asignatura l) throws Exception {
        Profesor p = null;
        if (l != null) {
            this.estudiantes_existentes_de_asignatura = new ArrayList<>(Arrays.asList(EnMemoria.BD.obtenerTodos_Estudiante(l)));
            p = EnMemoria.BD.obtenerProfesor(l);
        } else {
            this.estudiantes_existentes_de_asignatura = new ArrayList<>();
        }
        actualizarDatosProfesor(p);
        actualizarTabla_Estudiante(this.estudiantes_existentes_de_asignatura);
    }

    private void actualizarTabla_Estudiante(ArrayList<Estudiante> L) throws Exception {
        L = ordenar_Estudiante(L);
        this.estudiantes_en_tabla = L;
        int cantidad = L.size();
        String Tiulos[] = {"Nombre", "Apellidos", "Grupo"};
        Object O[][] = new Object[cantidad][Tiulos.length];
        for (int i = 0; i < cantidad; i++) {
            Estudiante a = L.get(i);
            O[i][0] = a.getNombre();
            O[i][1] = a.getApellidos();
            O[i][2] = a.getGrupo();

        }
        T_Estudiantes.setModel(new DefaultTableModel(O, Tiulos) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        });
        Estudiante l = null;
        if (cantidad > 0) {
            T_Estudiantes.addRowSelectionInterval(0, 0);
            l = L.get(0);
            l=EnMemoria.BD.obtenerPorID_Estudiante(l);
        }
        actualizar_T_A_PartirDe(l);

    }

    private void actualizar_T_A_PartirDe(Estudiante l) throws Exception {

        if (l != null && T_Asignaturas.getSelectedRow() != -1) {
            this.convocatorias_existentes_de_estudiante_y_asignatura = new ArrayList<>(Arrays.asList(
                    EnMemoria.BD.obtenerTodos_Convocatoria(
                            this.asignaturas_en_tabla.get(T_Asignaturas.getSelectedRow()),
                            l
                    )
            ));

        } else {
            this.convocatorias_existentes_de_estudiante_y_asignatura = new ArrayList<>();
        }

        actualizarTabla_Convocatoria(this.convocatorias_existentes_de_estudiante_y_asignatura);
    }

    private void actualizarTabla_Convocatoria(ArrayList<Convocatoria> L) throws Exception {
        L = ordenar_Convocatoria(L);
        this.convocatorias_en_tabla = L;
        int cantidad = L.size();
        String Tiulos[] = {"Nota", "Numero", "Fecha"};
        Object O[][] = new Object[cantidad][Tiulos.length];
        
        double sumaNotas=0;
        
        for (int i = 0; i < cantidad; i++) {
            Convocatoria a = L.get(i);
            O[i][0] =  a.getNota();
            O[i][1] = a.getNumero();
            O[i][2] = a.getFecha();//UtilidadesParaVentana.obtenerFechaConFormato(a.getFecha());
            
            sumaNotas+=Double.parseDouble(a.getNota()) ;
        }
        T_Examenes.setModel(new DefaultTableModel(O, Tiulos) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        });
        
        L_Promedio.setText(cantidad>0?String.format("%02.2f", sumaNotas/(double)cantidad):"--.--" );

    }

    private ArrayList<Convocatoria> ordenar_Convocatoria(ArrayList<Convocatoria> L) {
        L.sort(new Comparator<Convocatoria>() {
            @Override
            public int compare(Convocatoria o1, Convocatoria o2) {

                return new Integer(o1.getNumero()).compareTo(new Integer(o2.getNumero()) );
            }
        });
        if (!ordenar_de_forma_asendente_Convocatoria) {
            Collections.reverse(L);
        }
        return L;
    }

    private ArrayList<Estudiante> ordenar_Estudiante(ArrayList<Estudiante> L) {
        L.sort(new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                if (MI_RB_Ordenar_Estudiantes_Por_Apellidos.isSelected()) {
                    return o1.getApellidos().compareToIgnoreCase(o2.getApellidos());
                }
                if (MI_RB_Ordenar_Estudiantes_Por_Grupo.isSelected()) {
                    return o1.getGrupo().compareToIgnoreCase(o2.getGrupo());
                }

                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        if (!ordenar_de_forma_asendente_Estudiantes) {
            Collections.reverse(L);
        }
        return L;
    }

    private void actualizarDatosProfesor(Profesor p) {
        this.profesorDeAsignatura = p;
        boolean existeProfesor = p != null;
        if (existeProfesor) {
            L_Profesor_Nombre.setText(p.getNombre());
            L_Profesor_Apellidos.setText(p.getApellidos());

        } else {
            L_Profesor_Nombre.setText("-----------");
            L_Profesor_Apellidos.setText("-----------");

        }
//         L_Profesor_Nombre.setVisible(existeProfesor);
//         L_Profesor_Apellidos.setVisible(existeProfesor);

    }

    private ArrayList<Asignatura> ordenar_Asignatura(ArrayList<Asignatura> L) {
        L.sort(new Comparator<Asignatura>() {
            @Override
            public int compare(Asignatura o1, Asignatura o2) {
                if (MI_RB_Ordenar_Asignatura_Por_Modalidad.isSelected()) {
                    return o1.getModalidad().compareToIgnoreCase(o2.getModalidad());
                }
                if (MI_RB_Ordenar_Asignatura_Por_Nombre.isSelected()) {
                    return o1.getAsignatura().compareToIgnoreCase(o2.getAsignatura());
                }

                return o1.getSemestre().compareToIgnoreCase(o2.getSemestre());
            }
        });
        if (!ordenar_de_forma_asendente_Asignaturas) {
            Collections.reverse(L);
        }
        return L;
    }

    private ArrayList<Carrera> ordenar_Carreras(ArrayList<Carrera> L) {
        L.sort(new Comparator<Carrera>() {
            @Override
            public int compare(Carrera o1, Carrera o2) {
                return o1.getCarrera().compareToIgnoreCase(o2.getCarrera());
            }
        });
        if (!ordenar_de_forma_asendente_Carreras) {
            Collections.reverse(L);
        }
        return L;
    }

    private ArrayList<Facultad> ordenar_Facultad(ArrayList<Facultad> L) {
        L.sort(new Comparator<Facultad>() {
            @Override
            public int compare(Facultad o1, Facultad o2) {
                return o1.getFacultad().compareToIgnoreCase(o2.getFacultad());
            }
        });
        if (!ordenar_de_forma_asendente_Facultad) {
            Collections.reverse(L);
        }
        return L;
    }

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
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Agregar_Asignaturas;
    private javax.swing.JButton B_Agregar_Carrera;
    private javax.swing.JButton B_Agregar_Estudiantes;
    private javax.swing.JButton B_Agregar_Examenes;
    private javax.swing.JButton B_Agregar_Facultades;
    private javax.swing.JButton B_Agregar_Profesor;
    private javax.swing.JButton B_Editar_Asignaturas;
    private javax.swing.JButton B_Editar_Carrera;
    private javax.swing.JButton B_Editar_Estudiantes;
    private javax.swing.JButton B_Editar_Examenes;
    private javax.swing.JButton B_Editar_Facultades;
    private javax.swing.JButton B_Editar_Profesor;
    private javax.swing.JButton B_Eliminar_Asignaturas;
    private javax.swing.JButton B_Eliminar_Carrera;
    private javax.swing.JButton B_Eliminar_Estudiantes;
    private javax.swing.JButton B_Eliminar_Examenes;
    private javax.swing.JButton B_Eliminar_Facultades;
    private javax.swing.JButton B_Eliminar_Profesor;
    private javax.swing.JButton B_Filtrar_Asiganturas;
    private javax.swing.JButton B_Filtrar_Carreras;
    private javax.swing.JButton B_Filtrar_Estudiantes;
    private javax.swing.JButton B_Filtrar_Facultades;
    private javax.swing.JButton B_Invertir_Orden_Asiganturas;
    private javax.swing.JButton B_Invertir_Orden_Carreras;
    private javax.swing.JButton B_Invertir_Orden_Estudiantes;
    private javax.swing.JButton B_Invertir_Orden_Facultades;
    private javax.swing.JLabel L_Asignaturas;
    private javax.swing.JLabel L_Carrera;
    private javax.swing.JLabel L_Estudiantes;
    private javax.swing.JLabel L_Examenes;
    private javax.swing.JLabel L_Facultades;
    private javax.swing.JLabel L_Profesor;
    private javax.swing.JLabel L_Profesor_Apellidos;
    private javax.swing.JLabel L_Profesor_Nombre;
    private javax.swing.JLabel L_Promedio;
    private javax.swing.JMenuItem MI_Administrar_Usuario;
    private javax.swing.JMenuItem MI_Agregar_Asignatura;
    private javax.swing.JMenuItem MI_Agregar_Carrera;
    private javax.swing.JMenuItem MI_Agregar_Estudiante;
    private javax.swing.JMenuItem MI_Agregar_Facultad;
    private javax.swing.JMenuItem MI_Cambiar_Contrasenna;
    private javax.swing.JMenuItem MI_Cerrar_Sesion;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Asignatura_Por_Modalidad;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Asignatura_Por_Nombre;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Asignatura_Por_Semestre;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Estudiantes_Por_Apellidos;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Estudiantes_Por_Grupo;
    private javax.swing.JCheckBoxMenuItem MI_ChB_Filtrar_Estudiantes_Por_Nombre;
    private javax.swing.JMenuItem MI_Eliminar_Asignatura;
    private javax.swing.JMenuItem MI_Eliminar_Carrera;
    private javax.swing.JMenuItem MI_Eliminar_Estudiante;
    private javax.swing.JMenuItem MI_Eliminar_Facultad;
    private javax.swing.JMenuItem MI_Modifcar_Carrera;
    private javax.swing.JMenuItem MI_Modificar_Asignatura;
    private javax.swing.JMenuItem MI_Modificar_Estudiante;
    private javax.swing.JMenuItem MI_Modificar_Facultad;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Asignatura_Por_Modalidad;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Asignatura_Por_Nombre;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Asignatura_Por_Semestre;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Estudiantes_Por_Apellidos;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Estudiantes_Por_Grupo;
    private javax.swing.JRadioButtonMenuItem MI_RB_Ordenar_Estudiantes_Por_Nombre;
    private javax.swing.JTextField TI_Filtro_Asiganturas;
    private javax.swing.JTextField TI_Filtro_Carreras;
    private javax.swing.JTextField TI_Filtro_Estudiantes;
    private javax.swing.JTextField TI_Filtro_Facultades;
    private javax.swing.JTable T_Asignaturas;
    private javax.swing.JTable T_Carrera;
    private javax.swing.JTable T_Estudiantes;
    private javax.swing.JTable T_Examenes;
    private javax.swing.JTable T_Facultades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
