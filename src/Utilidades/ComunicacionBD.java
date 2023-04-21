/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.*;
import java.util.ArrayList;
import java.util.Date;
import org.orm.PersistentException;

/**
 *
 * @author PC
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
    public Estudiante modificarEstudiante(Estudiante l) throws Exception {
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
    public Convocatoria modificarConvocatoria(Convocatoria l) throws Exception {
        l.save();
        return l;
    }
    public Asignatura modificarAsignatura(Asignatura l) throws Exception {
        l.save();
        return l;
    }
    public Profesor modificarProfesor(Profesor l) throws Exception {
        l.save();
        return l;
    }
    public boolean existeAsignatura(Carrera c,String nombre) throws Exception {
        Asignatura [] A=obtenerTodos_Asignatura(c);
        for (Asignatura l : A) {
            if (l.getAsignatura().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    public boolean existeProfesor(Asignatura c,String nombre,String apellidos) throws Exception {
        Profesor p=obtenerProfesor(c);
        
        
        return p!=null?p.getNombre().equals(nombre)&&p.getApellidos().equals(apellidos):false;
    }
    public Profesor agregarProfesor(Asignatura a,String nombre,String apellidos) throws Exception {
        Profesor p=new Profesor();
        p.setApellidos(apellidos);
        p.setNombre(nombre);
        p.save();
        a.setId_profesor(p);
        a.save();
        p.save();
        return p;

    }
    public Estudiante agregarEstudiante(Asignatura a,String nombre,String apellidos,String grupo) throws Exception {
        Estudiante p=new Estudiante();
        p.setApellidos(apellidos);
        p.setNombre(nombre);
        p.setGrupo(grupo);
        p.save();
        
        agregarAsignaturaEstudiante(a,p);
        
        return p;

    }
    public Asignatura_estudiante agregarAsignaturaEstudiante(Asignatura a,Estudiante e)throws Exception {
        Asignatura_estudiante ae=new Asignatura_estudiante();
        ae.setId_asignatura(a);
        ae.setId_estudiante(e);
        ae.save();
        a.save();
        e.save();
        return ae;
    }
    public void quitarProfesorDeAsignaturaYEliminarlo(Asignatura a,Profesor c) throws Exception{
        if(a!=null&&c!=null){
            Profesor anterior=a.getId_profesor();
            if(anterior!=null&&c.getId()==anterior.getId()){
                a.setId_profesor(null);
                a.save();
                anterior.save();
                eliminarProfesor(anterior);
            }else{
                eliminarProfesor(c);
            }
        }
        
    }
    public Profesor sustituirProfesor(Asignatura a,String nombre,String apellidos) throws Exception {
        Profesor anterior=a.getId_profesor();
        if(anterior!=null){
            a.setId_profesor(null);
            a.save();
            anterior.save();
            eliminarProfesor(anterior);
        }
        
        Profesor p=new Profesor();
        p.setApellidos(apellidos);
        p.setNombre(nombre);
        p.save();
        a.setId_profesor(p);
        a.save();
        p.save();
        return p;

    }
    public Asignatura agregarAsignatura(Carrera c, String nombre,String modalidad,int semestre) throws Exception {
        Asignatura a=new Asignatura();
        a.setAsignatura(nombre);
        a.setModalidad(modalidad);
        a.setSemestre(semestre+"");
        a.setId_carrera(c);
        a.save();
        return a;

    }
    public boolean estaFechaDeExamenEnTemporaridadCorrecta(Asignatura a,Estudiante e
            ,int numero
            ,Date fecha)throws Exception{
        return estaFechaDeExamenEnTemporaridadCorrecta(a, e, numero, fecha,-1);
    }
    public boolean estaFechaDeExamenEnTemporaridadCorrecta(Asignatura a,Estudiante e
            ,int numero
            ,Date fecha,int idAIgnorar)throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(a, e);
        for (Convocatoria convocatoria : C) {
            if(idAIgnorar!=-1&&convocatoria.getId()==idAIgnorar){
                continue;
            }
            if(convocatoria.getNumero()<numero
                    &&convocatoria.getFecha().compareTo(fecha)>=0){
                
                return false;
            }
            if(convocatoria.getNumero()>numero
                    &&convocatoria.getFecha().compareTo(fecha)<=0){
                return false;
            }
        }
        return true;
    }
    
    public boolean existeConvocatoria(Asignatura a,Estudiante e,int numero)throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(a, e);
        for (Convocatoria convocatoria : C) {
            if(convocatoria.getNumero()==numero){
                return true;
            }
        }
        return false;
    }
    public Convocatoria agregarConvocatoria(Asignatura a,Estudiante e, String nota,String numero,Date fecha) throws Exception {
        Convocatoria c=new Convocatoria();
        c.setFecha(fecha);
        c.setId_asignatura(a);
        c.setId_estudiante(e);
        c.setNota(Double.parseDouble(nota));
        c.setNumero(Integer.parseInt(numero));
        c.save();
        a.save();
        e.save();
        return c;

    }
    
    public boolean existeEstudiante(Asignatura c,String nombre,String apellidos) throws Exception {
        Estudiante [] A=obtenerTodos_Estudiante(c);
        for (Estudiante l : A) {
            if (l.getNombre().equals(nombre)
                    &&l.getApellidos().equals(apellidos)) {
                return true;
            }
        }
        return false;
    }
    
    public Usuario modificarUsuario(Usuario u) throws Exception {
        u.save();
        
        return u;
    }
    public void eliminarUsuario(Usuario u) throws Exception{
      u.delete();
    } 
}
