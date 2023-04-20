/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Visual.*;

/**
 *
 * @author Rene2
 */
public  class EnMemoria {
    public static ComunicacionBD BD=new ComunicacionBD();
    public static Ventana_Principal ventana_Principal=new Ventana_Principal();
    public static Ventana_Loguin ventana_Loguin=new Ventana_Loguin();
    public static Dialogo_Agregar_Asignatura dialogo_Agregar_Asignatura=new Dialogo_Agregar_Asignatura(ventana_Principal, true);
    public static Dialogo_Modificar_Asignatura dialogo_Modificar_Asignatura=new Dialogo_Modificar_Asignatura(ventana_Principal, true);
    public static Dialogo_Agregar_Profesor dialogo_Agregar_Profesor=new Dialogo_Agregar_Profesor(ventana_Principal, true);
    public static Dialogo_Modificar_Profesor dialogo_Modificar_Profesor=new Dialogo_Modificar_Profesor(ventana_Principal, true);
    public static Dialogo_Agregar_Estudiante dialogo_Agregar_Estudiante=new Dialogo_Agregar_Estudiante(ventana_Principal, true);
    public static Dialogo_Modificar_Estudiante dialogo_Modificar_Estudiante=new Dialogo_Modificar_Estudiante(ventana_Principal, true);
    public static Dialogo_Agregar_Examen dialogo_Agregar_Examen=new Dialogo_Agregar_Examen(ventana_Principal, true);
    public static Dialogo_Modificar_Examen dialogo_Modificar_Examen=new Dialogo_Modificar_Examen(ventana_Principal, true);
}
