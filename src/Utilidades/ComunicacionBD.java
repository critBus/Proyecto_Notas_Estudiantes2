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
import static Utilidades.Control.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controles.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ComunicacionBD {
    public static final String TABLA_ASIGNATURA="Asignatura";
    public static final String TABLA_ASIGNATURA_ESTUDIANTE="Asignatura_Estudiante";
    public static final String TABLA_CARRERA="Carrera";
    public static final String TABLA_CONVOCATORIA="Convocatoria";
    public static final String TABLA_ESTUDIANTE="Estudiante";
    public static final String TABLA_FACULTAD="Facultad";
    public static final String TABLA_PROFESOR="Profesor";
    public static final String TABLA_USUARIO="Usuario";
    
    public Asignatura obtenerPorID_Asignatura(Asignatura a){
        return obtenerPorID_Asignatura(a.getId());
    }
    public Asignatura obtenerPorID_Asignatura(int id){
        return asignaturaJpaController.findAsignatura(id);
    }
    public Carrera obtenerPorID_Carrera(Carrera a){
        return obtenerPorID_Carrera(a.getId());
    }
    public Carrera obtenerPorID_Carrera(int id){
        return carreraJpaController.findCarrera(id);
    }
    public Convocatoria obtenerPorID_Convocatoria(Convocatoria a){
        return obtenerPorID_Convocatoria(a.getId());
    }
    public Convocatoria obtenerPorID_Convocatoria(int id){
        return convocatoriaJpaController.findConvocatoria(id);
    }
    public Estudiante obtenerPorID_Estudiante(int id){
        return estudianteJpaController.findEstudiante(id);
    }
    public Estudiante obtenerPorID_Estudiante(Estudiante e){
        return obtenerPorID_Estudiante(e.getId());
    }
    public Facultad obtenerPorID_Facultad(int id){
        return facultadJpaController.findFacultad(id);
    }
    public Facultad obtenerPorID_Facultad(Facultad a){
        return obtenerPorID_Facultad(a.getId());
    }
    public Profesor obtenerPorID_Profesor(int id){
        return profesorJpaController.findProfesor(id);
    }
    public Profesor obtenerPorID_Profesor(Profesor p){
        return obtenerPorID_Profesor(p.getId());
    }
    public Usuario obtenerPorID_Usuario(int id){
        return usuarioJpaController.findUsuario(id);
    }
    public Usuario obtenerPorID_Usuario(Usuario u){
        return obtenerPorID_Usuario(u.getId());
    }
    
    
    public void eliminarFacultad(Facultad c) throws Exception{
        Carrera A[]=obtenerTodos_Carrera(c);
        for (Carrera carrera : A) {
            eliminarCarrera(carrera);
        }
        
        facultadJpaController.destroy(c.getId());
        //c.deleteAndDissociate();
    }
    public void eliminarCarrera(Carrera c) throws Exception{
        Asignatura A[]=obtenerTodos_Asignatura(c);
        for (Asignatura asignatura : A) {
            eliminarAsignatura(asignatura);
        }
        //c.deleteAndDissociate();
        carreraJpaController.destroy(c.getId());
    }
    public void eliminarAsignatura(Asignatura c) throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(c);  
        for (Convocatoria convocatoria : C) {
            eliminarConvocatoria(convocatoria);
        }
        AsignaturaEstudiante AE[]=obtenerTodos_AsignaturaEstudiante(c);
        for (AsignaturaEstudiante asignatura_estudiante : AE) {
            eliminarAsignaturaEstudiante(asignatura_estudiante);
        }
        //c.deleteAndDissociate();
        asignaturaJpaController.destroy(c.getId());
    }
    public void eliminarProfesor(Profesor c) throws Exception{
        Asignatura A[]=obtenerTodos_Asignatura(c);
        for (Asignatura asignatura : A) {
            eliminarAsignatura(asignatura);
        }
        //c.deleteAndDissociate();
        profesorJpaController.destroy(c.getId());
    }
    public void eliminarEstudiante(Estudiante c) throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(c);
        for (Convocatoria convocatoria : C) {
            eliminarConvocatoria(convocatoria);
        }
        AsignaturaEstudiante AE[]=obtenerTodos_AsignaturaEstudiante(c);
        for (AsignaturaEstudiante asignatura_estudiante : AE) {
            eliminarAsignaturaEstudiante(asignatura_estudiante);
        }
        //c.deleteAndDissociate();
        estudianteJpaController.destroy(c.getId());
    }
    public void eliminarAsignaturaEstudiante(AsignaturaEstudiante c) throws Exception{
        //c.deleteAndDissociate();
        asignaturaEstudianteJpaController.destroy(c.getId());
    }
    public void eliminarConvocatoria(Convocatoria c) throws Exception{
        //c.deleteAndDissociate();
        convocatoriaJpaController.destroy(c.getId());
    }
    public Facultad modificarFacultad(Facultad l) throws Exception {
        facultadJpaController.edit(l);
        return facultadJpaController.findFacultad(l.getId());
        //l.save();
        //return l;
    }
    public Estudiante modificarEstudiante(Estudiante l) throws Exception {
        estudianteJpaController.edit(l);
        return estudianteJpaController.findEstudiante(l.getId());
        //l.save();
        //return l;
    }

    public Facultad[] obtenerTodos_Facultad() throws Exception {
        //return Facultad.listFacultadByQuery(null, null);
        return facultadJpaController.findFacultadEntities().toArray(new Facultad[0]);
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
        //l.save();
        //return l;
        
        int id=getUltimoID_Facultad();
        l.setId(++id);
        facultadJpaController.create(l);
       
        return facultadJpaController.findFacultad(id);
    }

    
    public Usuario agregarUsuario(String username, String password) throws Exception {
        Usuario u = new Usuario();
        u.setPassword(MetodoEncriptar.encriptar(password));
        u.setUsername(username);
       // u.save();
        //return u;
        int id=getUltimoID_Usuario();
        u.setId(++id);
        usuarioJpaController.create(u);
        return usuarioJpaController.findUsuario(id);
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
        return usuarioJpaController.findUsuarioEntities().toArray(new Usuario[0]);
//        Usuario[] us=Usuario.listUsuarioByQuery(null, null);
//        return us;
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
        
        List<Carrera> la=carreraJpaController.findCarreraEntities();
        List<Carrera> lr=new LinkedList<>();
        for (Carrera a : la) {
            if(a.getIdFacultad()!=null&&a.getIdFacultad().getId()==l.getId()){
                lr.add(a);
            }
        }
        return lr.toArray(new Carrera[0]);
        
        //return l.getCarreraList().toArray(new Carrera[0]);
        //return l.carrera.toArray();
    }
    public Asignatura[] obtenerTodos_Asignatura(Carrera l) throws Exception {
        List<Asignatura> la=asignaturaJpaController.findAsignaturaEntities();
        List<Asignatura> lr=new LinkedList<>();
        for (Asignatura asignatura : la) {
            if(asignatura.getIdCarrera()!=null&&asignatura.getIdCarrera().getId()==l.getId()){
                lr.add(asignatura);
            }
        }
        return lr.toArray(new Asignatura[0]);
        //List<Asignatura> la=getQueryListaPorID(TABLA_ASIGNATURA,"id_carrera",l.getId());
        //return la.toArray(new Asignatura[0]);
        //return comentarioJpaController.getEntityManager().createQuery("SELECT c FROM Comentario c WHERE  c.publicacionid.id = \"" + p.getId() + "\"").getResultList();
        
        //return l.getAsignaturaList().toArray(new Asignatura[0]);
        //return l.asignatura.toArray();
    }
    
//    private List getQueryListaPorID(String tabla,String columna,int id){
//        //return obtenerEntityManagerCorrespondiente(tabla).createQuery("SELECT c FROM "+tabla+" c WHERE  c."+columna+" = \"" + id + "\"").getResultList();
//        //return obtenerEntityManagerCorrespondiente(tabla).createQuery("SELECT c FROM "+tabla+" c WHERE  c.\""+columna+"\" = '" + id + "'").getResultList();
//        return obtenerEntityManagerCorrespondiente(tabla).createQuery("SELECT c FROM "+tabla+" c WHERE  c."+columna+" = " + id + "").getResultList();
//    }
    public Asignatura[] obtenerTodos_Asignatura(Profesor l) throws Exception {
        
        List<Asignatura> la=asignaturaJpaController.findAsignaturaEntities();
        List<Asignatura> lr=new LinkedList<>();
        for (Asignatura asignatura : la) {

            if(asignatura.getIdProfesor()!=null&&asignatura.getIdProfesor().getId()==l.getId()){
                lr.add(asignatura);
            }
        }
        return lr.toArray(new Asignatura[0]);
        
        //return l.getAsignaturaList().toArray(new Asignatura[0]);
        //return l.asignatura.toArray();
    }
    public AsignaturaEstudiante[] obtenerTodos_AsignaturaEstudiante(Asignatura l) throws Exception {
        
        List<AsignaturaEstudiante> la=asignaturaEstudianteJpaController.findAsignaturaEstudianteEntities();
        List<AsignaturaEstudiante> lr=new LinkedList<>();
        for (AsignaturaEstudiante a : la) {
            if(a.getIdAsignatura()!=null&&a.getIdAsignatura().getId()==l.getId()){
                lr.add(a);
            }
        }
        return lr.toArray(new AsignaturaEstudiante[0]);
        
        //return l.getAsignaturaEstudianteList().toArray(new AsignaturaEstudiante[0]);
        //return l.asignatura_Estudiante.toArray();
    }
    public AsignaturaEstudiante[] obtenerTodos_AsignaturaEstudiante(Estudiante l) throws Exception {
        List<AsignaturaEstudiante> la=asignaturaEstudianteJpaController.findAsignaturaEstudianteEntities();
        List<AsignaturaEstudiante> lr=new LinkedList<>();
        for (AsignaturaEstudiante a : la) {
            if(a.getIdEstudiante()!=null&&a.getIdEstudiante().getId()==l.getId()){
                lr.add(a);
            }
        }
        return lr.toArray(new AsignaturaEstudiante[0]);
        //return l.getAsignaturaEstudianteList().toArray(new AsignaturaEstudiante[0]);
        //return l.asignatura_Estudiante.toArray();
    }
    public Estudiante[] obtenerTodos_Estudiante(Asignatura l) throws Exception {
        ArrayList<Estudiante> la=new ArrayList<>();
         AsignaturaEstudiante[] AE=obtenerTodos_AsignaturaEstudiante(l);
         for (AsignaturaEstudiante asignatura_estudiante : AE) {
             
            la.add(asignatura_estudiante.getIdEstudiante());
        }
        return la.toArray(new Estudiante[0]);
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Estudiante e) throws Exception {
        
        List<Convocatoria> la=convocatoriaJpaController.findConvocatoriaEntities();
        List<Convocatoria> lr=new LinkedList<>();
        for (Convocatoria a : la) {
            if(a.getIdEstudiante()!=null&&a.getIdEstudiante().getId()==e.getId()){
                lr.add(a);
            }
        }
        return lr.toArray(new Convocatoria[0]);
        
        //return e.convocatoria.toArray();
        //return e.getConvocatoriaList().toArray(new Convocatoria[0]);
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Asignatura e) throws Exception {
        List<Convocatoria> la=convocatoriaJpaController.findConvocatoriaEntities();
        List<Convocatoria> lr=new LinkedList<>();
        for (Convocatoria a : la) {
            if(a.getIdAsignatura()!=null&&a.getIdAsignatura().getId()==e.getId()){
                lr.add(a);
            }
        }
        return lr.toArray(new Convocatoria[0]);
        //return e.convocatoria.toArray();
        //return e.getConvocatoriaList().toArray(new Convocatoria[0]);
    }
    public Convocatoria[] obtenerTodos_Convocatoria(Asignatura as,Estudiante e) throws Exception {
        Convocatoria[] lce=obtenerTodos_Convocatoria(e);
        
        ArrayList<Convocatoria> lc=new ArrayList<>();
        for (Convocatoria convocatoria : lce) {
            if(convocatoria.getIdAsignatura()!=null&&convocatoria.getIdAsignatura().getId()==as.getId()){
                lc.add(convocatoria);
            }
        }
        
        return lc.toArray(new Convocatoria[0]);
    }
    
    public Profesor obtenerProfesor(Asignatura a){
        
        
        //return a.getId_profesor();
        return a.getIdProfesor();
    }
    public Carrera[] obtenerTodos_Carrera() throws Exception {
        //return Carrera.listCarreraByQuery(null, null);
        return carreraJpaController.findCarreraEntities().toArray(new Carrera[0]);
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
        m.setIdFacultad(l);
        //m.setId_facultad(l);
        m.setCarrera(nombre);
//        m.save();
//        return m;
int id=getUltimoID_Carrera();
        m.setId(++id);
    carreraJpaController.create(m);
    return carreraJpaController.findCarrera(id);

    }
    public Carrera modificarCarrera(Carrera l) throws Exception {
        carreraJpaController.edit(l);
        return carreraJpaController.findCarrera(l.getId());
        //l.save();
        //return l;
    }
    public Convocatoria modificarConvocatoria(Convocatoria l) throws Exception {
        //l.save();
        //return l;
        convocatoriaJpaController.edit(l);
        return  convocatoriaJpaController.findConvocatoria(l.getId());
    }
    public Asignatura modificarAsignatura(Asignatura l) throws Exception {
         asignaturaJpaController.edit(l);
        return  asignaturaJpaController.findAsignatura(l.getId());
    }
    public Profesor modificarProfesor(Profesor l) throws Exception {
         profesorJpaController.edit(l);
        return  profesorJpaController.findProfesor(l.getId());
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
        //p.save();
        //a.setId_profesor(p);
        //a.save();
        //p.save();
        //return p;
        
        int id=getUltimoID_Profesor();
        p.setId(++id);
        profesorJpaController.create(p);
        
        p=profesorJpaController.findProfesor(id);
        a.setIdProfesor(p);
        a=modificarAsignatura(a);
        return profesorJpaController.findProfesor(p.getId());
    }
    public Estudiante agregarEstudiante(Asignatura a,String nombre,String apellidos,String grupo) throws Exception {
        Estudiante p=new Estudiante();
        p.setApellidos(apellidos);
        p.setNombre(nombre);
        p.setGrupo(grupo);
        //p.save();
        
        int id=getUltimoID_Estudiante();
        p.setId(++id);
        estudianteJpaController.create(p);
        p=estudianteJpaController.findEstudiante(id);
        
        a=obtenerPorID_Asignatura(a);
        agregarAsignaturaEstudiante(a,p);
        
        //return p;
        return estudianteJpaController.findEstudiante(p.getId());

    }
    public AsignaturaEstudiante agregarAsignaturaEstudiante(Asignatura a,Estudiante e)throws Exception {
        AsignaturaEstudiante ae=new AsignaturaEstudiante();
//        ae.setId_asignatura(a);
//        ae.setId_estudiante(e);
//        ae.save();
//        a.save();
//        e.save();
//        return ae;
        int id=getUltimoID_AsignaturaEstudiante();
        ae.setId(++id);
        ae.setIdAsignatura(a);
        ae.setIdEstudiante(e);
        asignaturaEstudianteJpaController.create(ae);
        
        return asignaturaEstudianteJpaController.findAsignaturaEstudiante(id);
    }
    public void quitarProfesorDeAsignaturaYEliminarlo(Asignatura a,Profesor c) throws Exception{
        if(a!=null&&c!=null){
            Profesor anterior=a.getIdProfesor();
            if(anterior!=null&&c.getId()==anterior.getId()){
                a.setIdProfesor(null);
                a=modificarAsignatura(a);
                //anterior.save();
                anterior=obtenerPorID_Profesor(anterior);
                eliminarProfesor(anterior);
            }else{
                eliminarProfesor(c);
            }
        }
        
    }
    public Profesor sustituirProfesor(Asignatura a,String nombre,String apellidos) throws Exception {
        Profesor anterior=a.getIdProfesor();
        
        if(anterior!=null){
            a.setIdProfesor(null);
            a=modificarAsignatura(a);
            //a.save();
            //anterior.save();
            anterior=obtenerPorID_Profesor(anterior);
            eliminarProfesor(anterior);
        }
        
        Profesor p=new Profesor();
        p.setApellidos(apellidos);
        p.setNombre(nombre);
//        p.save();
//        a.setId_profesor(p);
//        a.save();
//        p.save();
//        return p;
        
        int id=getUltimoID_Profesor();
        p.setId(++id);
        profesorJpaController.create(p);
        p=profesorJpaController.findProfesor(id);
        a.setIdProfesor(p);
        a=modificarAsignatura(a);
        return profesorJpaController.findProfesor(p.getId());

    }
    public Asignatura agregarAsignatura(Carrera c, String nombre,String modalidad,int semestre) throws Exception {
        Asignatura a=new Asignatura();
        
        a.setAsignatura(nombre);
        a.setModalidad(modalidad);
        a.setSemestre(semestre+"");
//        a.setId_carrera(c);
//        a.save();
//        return a;
        int id=getUltimoID_Asignatura();
        a.setId(++id);
        a.setIdCarrera(c);
        asignaturaJpaController.create(a);
        return asignaturaJpaController.findAsignatura(id);
    }
    public boolean estaFechaDeExamenEnTemporaridadCorrecta(Asignatura a,Estudiante e
            ,int numero
            ,Date fecha)throws Exception{
        return estaFechaDeExamenEnTemporaridadCorrecta(a, e, numero, fecha,-1);
    }
    public static Date obtenerFecha(String fecha)throws Exception{
        if(fecha==null||fecha.trim().isEmpty()){
            return null;
        }
        return UtilidadesParaVentana.obtenerFecha(fecha);
    }
    public boolean estaFechaDeExamenEnTemporaridadCorrecta(Asignatura a,Estudiante e
            ,int numero
            ,Date fecha,int idAIgnorar)throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(a, e);
        for (Convocatoria convocatoria : C) {
            if(idAIgnorar!=-1&&convocatoria.getId()==idAIgnorar){
                continue;
            }
            int numeroConvocatoria=Integer.parseInt(convocatoria.getNumero());
            Date fechaConvocatoria=obtenerFecha(convocatoria.getFecha());
            if(numeroConvocatoria<numero
                    &&fechaConvocatoria.compareTo(fecha)>=0){
                
                return false;
            }
            if(numeroConvocatoria>numero
                    &&fechaConvocatoria.compareTo(fecha)<=0){
                return false;
            }
        }
        return true;
    }
    
    public boolean existeConvocatoria(Asignatura a,Estudiante e,int numero)throws Exception{
        Convocatoria C[]=obtenerTodos_Convocatoria(a, e);
        for (Convocatoria convocatoria : C) {
            int numeroConvocatoria=Integer.parseInt(convocatoria.getNumero());
            if(numeroConvocatoria==numero){
                return true;
            }
        }
        return false;
    }
    public Convocatoria agregarConvocatoria(Asignatura a,Estudiante e, String nota,String numero,Date fecha) throws Exception {
        Convocatoria c=new Convocatoria();
        c.setFecha(UtilidadesParaVentana.obtenerFechaConFormato(fecha));
        c.setIdAsignatura(a);
        c.setIdEstudiante(e);
        c.setNota(nota);
        c.setNumero(numero);
        
//        c.save();
//        a.save();
//        e.save();
//        return c;
        int id=getUltimoID_Convocatoria();
        c.setId(++id);
        convocatoriaJpaController.create(c);
        return convocatoriaJpaController.findConvocatoria(id);

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
//        u.save();
//        
//        return u;
        usuarioJpaController.edit(u);
        return usuarioJpaController.findUsuario(u.getId());
    }
    public void eliminarUsuario(Usuario u) throws Exception{
      //u.delete();
      usuarioJpaController.destroy(u.getId());
    } 
    
    
    private  int getUltimoID_Asignatura(){
        return obtenerUltimoID(TABLA_ASIGNATURA);
    }
    private  int getUltimoID_AsignaturaEstudiante(){
        List<AsignaturaEstudiante> l=asignaturaEstudianteJpaController.findAsignaturaEstudianteEntities();
        int mayor=0;
        for (AsignaturaEstudiante asignaturaEstudiante : l) {
            if(asignaturaEstudiante.getId()>mayor){
                mayor=asignaturaEstudiante.getId();
            }
        }
        return mayor;
        
        //return obtenerUltimoID(TABLA_ASIGNATURA_ESTUDIANTE);
    }
    private  int getUltimoID_Carrera(){
        return obtenerUltimoID(TABLA_CARRERA);
    }
    private  int getUltimoID_Convocatoria(){
        return obtenerUltimoID(TABLA_CONVOCATORIA);
    }
    private  int getUltimoID_Estudiante(){
        return obtenerUltimoID(TABLA_ESTUDIANTE);
    }
    public  int getUltimoID_Facultad(){
        return obtenerUltimoID(TABLA_FACULTAD);
    }
    private  int getUltimoID_Profesor(){
        return obtenerUltimoID(TABLA_PROFESOR);
    }
    private  int getUltimoID_Usuario(){
        return obtenerUltimoID(TABLA_USUARIO);
    }
    private int obtenerUltimoID(String nombreTabla){
        EntityManager en=obtenerEntityManagerCorrespondiente(nombreTabla);
        return realizarConsultaUltimoID(en,nombreTabla);
    }
    public static EntityManager obtenerEntityManagerCorrespondiente(String nombreTabla) {
        switch (nombreTabla) {
            case TABLA_ASIGNATURA:
                return asignaturaJpaController.getEntityManager();
            case TABLA_ASIGNATURA_ESTUDIANTE:
                return asignaturaEstudianteJpaController.getEntityManager();
            case TABLA_CARRERA:
                return carreraJpaController.getEntityManager();
            case TABLA_CONVOCATORIA:
                return convocatoriaJpaController.getEntityManager();
            case TABLA_ESTUDIANTE:
                return estudianteJpaController.getEntityManager();
            case TABLA_FACULTAD:
                return facultadJpaController.getEntityManager();
            case TABLA_PROFESOR:
                return profesorJpaController.getEntityManager();
            case TABLA_USUARIO:
                return usuarioJpaController.getEntityManager();
        }
        return null;
    }
    public static int realizarConsultaUltimoID(EntityManager em, String nombreTabla) {
        String nombreTablaMayuscula = nombreTabla.substring(0, 1).toUpperCase() + nombreTabla.substring(1);
        String consulta = "SELECT MAX(p.id) FROM " + nombreTablaMayuscula + " p ";
       Query q = em.createQuery(consulta);
        boolean paso = q != null && q.getResultList() != null && !q.getResultList().isEmpty() && q.getResultList().get(0) != null;

        int id = 0;
        if (paso) {
            id = (int) ((Integer) q.getSingleResult()).intValue();
       }
        return id;
    }
}
