/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.*;
import java.util.ArrayList;

/**
 *
 * @author Rene2
 */
public class ComunicacionBD {
    
    
    public Facultad modificarFacultad(Facultad l) throws Exception {
        l.save();
        return l;
    }

    public Facultad[] obtenerTodos_Facultad() throws Exception {
        return Facultad.listFacultadByQuery(null, null);
    }

    public boolean existeFacultad(String nombre) throws Exception {
        Facultad[] L = obtenerTodos_Facultad();
        for (Facultad local : L) {
            if (local.getFacultad().equals(nombre)) {
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
    public Asignatura_estudiante[] obtenerTodos_AsignaturaEstudiante(Asignatura l) throws Exception {
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
}
