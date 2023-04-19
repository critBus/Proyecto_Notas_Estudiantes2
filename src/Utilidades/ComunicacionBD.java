/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.*;
import java.util.ArrayList;
import org.orm.PersistentException;

/**
 *
 * @author Rene2
 */
public class ComunicacionBD {
    public void eliminarFacultad(Facultad c) throws Exception{
        Carrera A[]=obtenerTodos_Carrera(c);
        for (Carrera carrera : A) {
            eliminarCarrera(carrera);
        }
        c.deleteAndDissociate();
    }
    public void eliminarCarrera(Carrera c) throws Exception{
        Asignatura A[]=obtenerTodos_Asignatura(c);
        for (Asignatura asignatura : A) {
            eliminarAsignatura(asignatura);
        }
        c.deleteAndDissociate();
    }
    public void eliminarAsignatura(Asignatura c) throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(c);  
        for (Convocatoria convocatoria : C) {
            eliminarConvocatoria(convocatoria);
        }
        Asignatura_estudiante AE[]=obtenerTodos_AsignaturaEstudiante(c);
        for (Asignatura_estudiante asignatura_estudiante : AE) {
            eliminarAsignaturaEstudiante(asignatura_estudiante);
        }
        c.deleteAndDissociate();
    }
    public void eliminarProfesor(Profesor c) throws Exception{
        Asignatura A[]=obtenerTodos_Asignatura(c);
        for (Asignatura asignatura : A) {
            eliminarAsignatura(asignatura);
        }
        c.deleteAndDissociate();
    }
    public void eliminarEstudiante(Estudiante c) throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(c);
        for (Convocatoria convocatoria : C) {
            eliminarConvocatoria(convocatoria);
        }
        Asignatura_estudiante AE[]=obtenerTodos_AsignaturaEstudiante(c);
        for (Asignatura_estudiante asignatura_estudiante : AE) {
            eliminarAsignaturaEstudiante(asignatura_estudiante);
        }
        c.deleteAndDissociate();
    }
    public void eliminarAsignaturaEstudiante(Asignatura_estudiante c) throws PersistentException{
        c.deleteAndDissociate();
    }
    public void eliminarConvocatoria(Convocatoria c) throws PersistentException{
        c.deleteAndDissociate();
    }
    public Facultad modificarFacultad(Facultad l) throws Exception {
        l.save();
        return l;
    }

    public Facultad[] obtenerTodos_Facultad() throws Exception {
        return Facultad.listFacultadByQuery(null, null);
    }

    public boolean existeFacultad(String nombre) throws Exception {
        Facultad[] L = obtenerTodos_Facultad();
        for (Facultad l : L) {
            if (l.getFacultad().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Facultad agregarFacultad(String nombre) throws Exception {
        Facultad l = new Facultad();
        l.setFacultad(nombre);
        l.save();
        return l;
    }

    
    public Usuario agregarUsuario(String username, String password) throws Exception {
        Usuario u = new Usuario();
        u.setPassword(MetodoEncriptar.encriptar(password));
        u.setUsername(username);
        u.save();
        

        
        return u;
    }

    public boolean existeUsuario(String username, String password) throws Exception {
        Usuario[] U = obtenerTodos_Usuarios();
        password = MetodoEncriptar.encriptar(password);
        for (int i = 0; i < U.length; i++) {
         if (U[i].getUsername().equals(username) && U[i].getPassword().equals(password)) {
                return true;
            }
        }
       return false;
    }
    public boolean existeUsuario(String username) throws Exception {
        Usuario[] U = obtenerTodos_Usuarios();
        
        for (int i = 0; i < U.length; i++) {
            if (U[i].getUsername().equals(username) ) {
                return true;
            }
        }
        return false;
    }

    public Usuario[] obtenerTodos_Usuarios() throws Exception {
        Usuario[] us=Usuario.listUsuarioByQuery(null, null);
        return us;
    }

    public Usuario obtenerUsuario(String username) throws Exception {
        Usuario[] U = obtenerTodos_Usuarios();
        for (int i = 0; i < U.length; i++) {
            if (U[i].getUsername().equals(username)) {
                return U[i];
            }
        }
        return null;
    }

    
    public Carrera[] obtenerTodos_Carrera(Facultad l) throws Exception {
        return l.carrera.toArray();
    }
    public Asignatura[] obtenerTodos_Asignatura(Carrera l) throws Exception {
        return l.asignatura.toArray();
    }
    public Asignatura[] obtenerTodos_Asignatura(Profesor l) throws Exception {
        return l.asignatura.toArray();
    }
    public Asignatura_estudiante[] obtenerTodos_AsignaturaEstudiante(Asignatura l) throws Exception {
        return l.asignatura_estudiante.toArray();
    }
    public Asignatura_estudiante[] obtenerTodos_AsignaturaEstudiante(Estudiante l) throws Exception {
        return l.asignatura_estudiante.toArray();
    }
    public Estudiante[] obtenerTodos_Estudiante(Asignatura l) throws Exception {
        ArrayList<Estudiante> la=new ArrayList<>();
         Asignatura_estudiante[] AE=obtenerTodos_AsignaturaEstudiante(l);
         for (Asignatura_estudiante asignatura_estudiante : AE) {
            la.add(asignatura_estudiante.getId_estudiante());
        }
        return la.toArray(new Estudiante[0]);
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Estudiante e) throws Exception {
        return e.convocatoria.toArray();
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Asignatura e) throws Exception {
        return e.convocatoria.toArray();
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Asignatura as,Estudiante e) throws Exception {
        Convocatoria[] lce=obtenerTodos_Convocatoria(e);
        
        ArrayList<Convocatoria> lc=new ArrayList<>();
        for (Convocatoria convocatoria : lce) {
            if(convocatoria.getId_asignatura().getId()==as.getId()){
                lc.add(convocatoria);
            }
        }
        
        return lc.toArray(new Convocatoria[0]);
    }
    
    public Profesor obtenerProfesor(Asignatura a){
        return a.getId_profesor();
    }
    public Carrera[] obtenerTodos_Carrera() throws Exception {
        return Carrera.listCarreraByQuery(null, null);
    }
    public boolean existeCarrera(String nombre) throws Exception {
        Carrera[] L = obtenerTodos_Carrera();
        for (Carrera l : L) {
            if (l.getCarrera().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public Carrera agregarCarrera(Facultad l, String nombre) throws Exception {
        Carrera m = new Carrera();
        m.setId_facultad(l);
        m.setCarrera(nombre);
        m.save();
        return m;

    }
    public Carrera modificarCarrera(Carrera l) throws Exception {
        l.save();
        return l;
    }
}
