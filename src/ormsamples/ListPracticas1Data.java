/**
 * Licensee: 
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class ListPracticas1Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Asignatura...");
		entidades.Asignatura[] entidadesAsignaturas = entidades.Asignatura.listAsignaturaByQuery(null, null);
		int length = Math.min(entidadesAsignaturas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesAsignaturas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Asignatura_estudiante...");
		entidades.Asignatura_estudiante[] entidadesAsignatura_estudiantes = entidades.Asignatura_estudiante.listAsignatura_estudianteByQuery(null, null);
		length = Math.min(entidadesAsignatura_estudiantes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesAsignatura_estudiantes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Carrera...");
		entidades.Carrera[] entidadesCarreras = entidades.Carrera.listCarreraByQuery(null, null);
		length = Math.min(entidadesCarreras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesCarreras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Convocatoria...");
		entidades.Convocatoria[] entidadesConvocatorias = entidades.Convocatoria.listConvocatoriaByQuery(null, null);
		length = Math.min(entidadesConvocatorias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesConvocatorias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Estudiante...");
		entidades.Estudiante[] entidadesEstudiantes = entidades.Estudiante.listEstudianteByQuery(null, null);
		length = Math.min(entidadesEstudiantes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesEstudiantes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Facultad...");
		entidades.Facultad[] entidadesFacultads = entidades.Facultad.listFacultadByQuery(null, null);
		length = Math.min(entidadesFacultads.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesFacultads[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Profesor...");
		entidades.Profesor[] entidadesProfesors = entidades.Profesor.listProfesorByQuery(null, null);
		length = Math.min(entidadesProfesors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesProfesors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		entidades.Usuario[] entidadesUsuarios = entidades.Usuario.listUsuarioByQuery(null, null);
		length = Math.min(entidadesUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(entidadesUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Asignatura by Criteria...");
		entidades.AsignaturaCriteria lentidadesAsignaturaCriteria = new entidades.AsignaturaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesAsignaturaCriteria.id.eq();
		lentidadesAsignaturaCriteria.setMaxResults(ROW_COUNT);
		entidades.Asignatura[] entidadesAsignaturas = lentidadesAsignaturaCriteria.listAsignatura();
		int length =entidadesAsignaturas== null ? 0 : Math.min(entidadesAsignaturas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesAsignaturas[i]);
		}
		System.out.println(length + " Asignatura record(s) retrieved."); 
		
		System.out.println("Listing Asignatura_estudiante by Criteria...");
		entidades.Asignatura_estudianteCriteria lentidadesAsignatura_estudianteCriteria = new entidades.Asignatura_estudianteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesAsignatura_estudianteCriteria.id.eq();
		lentidadesAsignatura_estudianteCriteria.setMaxResults(ROW_COUNT);
		entidades.Asignatura_estudiante[] entidadesAsignatura_estudiantes = lentidadesAsignatura_estudianteCriteria.listAsignatura_estudiante();
		length =entidadesAsignatura_estudiantes== null ? 0 : Math.min(entidadesAsignatura_estudiantes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesAsignatura_estudiantes[i]);
		}
		System.out.println(length + " Asignatura_estudiante record(s) retrieved."); 
		
		System.out.println("Listing Carrera by Criteria...");
		entidades.CarreraCriteria lentidadesCarreraCriteria = new entidades.CarreraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesCarreraCriteria.id.eq();
		lentidadesCarreraCriteria.setMaxResults(ROW_COUNT);
		entidades.Carrera[] entidadesCarreras = lentidadesCarreraCriteria.listCarrera();
		length =entidadesCarreras== null ? 0 : Math.min(entidadesCarreras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesCarreras[i]);
		}
		System.out.println(length + " Carrera record(s) retrieved."); 
		
		System.out.println("Listing Convocatoria by Criteria...");
		entidades.ConvocatoriaCriteria lentidadesConvocatoriaCriteria = new entidades.ConvocatoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesConvocatoriaCriteria.id.eq();
		lentidadesConvocatoriaCriteria.setMaxResults(ROW_COUNT);
		entidades.Convocatoria[] entidadesConvocatorias = lentidadesConvocatoriaCriteria.listConvocatoria();
		length =entidadesConvocatorias== null ? 0 : Math.min(entidadesConvocatorias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesConvocatorias[i]);
		}
		System.out.println(length + " Convocatoria record(s) retrieved."); 
		
		System.out.println("Listing Estudiante by Criteria...");
		entidades.EstudianteCriteria lentidadesEstudianteCriteria = new entidades.EstudianteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesEstudianteCriteria.id.eq();
		lentidadesEstudianteCriteria.setMaxResults(ROW_COUNT);
		entidades.Estudiante[] entidadesEstudiantes = lentidadesEstudianteCriteria.listEstudiante();
		length =entidadesEstudiantes== null ? 0 : Math.min(entidadesEstudiantes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesEstudiantes[i]);
		}
		System.out.println(length + " Estudiante record(s) retrieved."); 
		
		System.out.println("Listing Facultad by Criteria...");
		entidades.FacultadCriteria lentidadesFacultadCriteria = new entidades.FacultadCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesFacultadCriteria.id.eq();
		lentidadesFacultadCriteria.setMaxResults(ROW_COUNT);
		entidades.Facultad[] entidadesFacultads = lentidadesFacultadCriteria.listFacultad();
		length =entidadesFacultads== null ? 0 : Math.min(entidadesFacultads.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesFacultads[i]);
		}
		System.out.println(length + " Facultad record(s) retrieved."); 
		
		System.out.println("Listing Profesor by Criteria...");
		entidades.ProfesorCriteria lentidadesProfesorCriteria = new entidades.ProfesorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesProfesorCriteria.id.eq();
		lentidadesProfesorCriteria.setMaxResults(ROW_COUNT);
		entidades.Profesor[] entidadesProfesors = lentidadesProfesorCriteria.listProfesor();
		length =entidadesProfesors== null ? 0 : Math.min(entidadesProfesors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesProfesors[i]);
		}
		System.out.println(length + " Profesor record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		entidades.UsuarioCriteria lentidadesUsuarioCriteria = new entidades.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lentidadesUsuarioCriteria.id.eq();
		lentidadesUsuarioCriteria.setMaxResults(ROW_COUNT);
		entidades.Usuario[] entidadesUsuarios = lentidadesUsuarioCriteria.listUsuario();
		length =entidadesUsuarios== null ? 0 : Math.min(entidadesUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(entidadesUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListPracticas1Data listPracticas1Data = new ListPracticas1Data();
			try {
				listPracticas1Data.listTestData();
				//listPracticas1Data.listByCriteria();
			}
			finally {
				entidades.Practicas1PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
