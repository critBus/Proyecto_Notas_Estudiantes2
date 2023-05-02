/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;


import controles.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rene2
 */
public class Control {
    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Proyecto_Notas_Estudiantes2PU");
    public static UsuarioJpaController usuarioJpaController= new UsuarioJpaController(EMF);
    public static AsignaturaJpaController asignaturaJpaController=new AsignaturaJpaController(EMF);
    public static AsignaturaEstudianteJpaController asignaturaEstudianteJpaController=new AsignaturaEstudianteJpaController(EMF);
    public static CarreraJpaController carreraJpaController=new CarreraJpaController(EMF);
    public static ConvocatoriaJpaController convocatoriaJpaController=new ConvocatoriaJpaController(EMF);
    public static EstudianteJpaController estudianteJpaController=new EstudianteJpaController(EMF);
    public static FacultadJpaController facultadJpaController=new FacultadJpaController(EMF);
    public static ProfesorJpaController profesorJpaController=new ProfesorJpaController(EMF);
    
}
