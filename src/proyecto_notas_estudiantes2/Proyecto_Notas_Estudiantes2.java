/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_notas_estudiantes2;
import entidades.*;
import Utilidades.*;
import org.orm.PersistentException;
/**
 *
 * @author PC
 */
public class Proyecto_Notas_Estudiantes2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistentException, Exception {
        // TODO code application logic here
//        Usuario u=new Usuario();
//        u.setPassword(MetodoEncriptar.encriptar("1234"));
//        u.setUsername("uno");
        //u.save();
        new ComunicacionBD().agregarUsuario("otro", "1234");
        
        //int n=new ComunicacionBD().getUltimoID_Facultad();
        //System.out.println(n);
        ComunicacionBD bd=new ComunicacionBD();
//            Facultad f=bd.obtenerTodos_Facultad()[0];
//            Carrera c1=bd.agregarCarrera(f, "carrera11xx");
//            System.out.println("c1:"+c1.getCarrera());
//            Carrera c2=bd.agregarCarrera(f, "carrera22xx");
//            System.out.println("c2:"+c2.getCarrera());

        Carrera c=bd.obtenerTodos_Carrera()[1];
        System.out.println("c:"+c.getCarrera()+" id="+c.getId());
        Asignatura A[]=bd.obtenerTodos_Asignatura(c);
        for (int i = 0; i < A.length; i++) {
            Asignatura a=A[i];
            System.out.println("i="+i+" a="+a.getAsignatura());
        }
//        Estudiante e=new Estudiante();
//        e.setNombre("estudiante1");
//        e.setApellidos("apellidos1");
//        e.setGrupo("grupo1");
//        e.save();
    }
    
}
