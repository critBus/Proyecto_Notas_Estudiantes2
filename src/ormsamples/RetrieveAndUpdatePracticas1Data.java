/**
 * Licensee: 
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdatePracticas1Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = entidades.Practicas1PersistentManager.instance().getSession().beginTransaction();
		try {
			entidades.Asignatura lentidadesAsignatura = entidades.Asignatura.loadAsignaturaByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesAsignatura.save();
			entidades.Asignatura_estudiante lentidadesAsignatura_estudiante = entidades.Asignatura_estudiante.loadAsignatura_estudianteByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesAsignatura_estudiante.save();
			entidades.Carrera lentidadesCarrera = entidades.Carrera.loadCarreraByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesCarrera.save();
			entidades.Convocatoria lentidadesConvocatoria = entidades.Convocatoria.loadConvocatoriaByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesConvocatoria.save();
			entidades.Estudiante lentidadesEstudiante = entidades.Estudiante.loadEstudianteByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesEstudiante.save();
			entidades.Facultad lentidadesFacultad = entidades.Facultad.loadFacultadByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesFacultad.save();
			entidades.Profesor lentidadesProfesor = entidades.Profesor.loadProfesorByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesProfesor.save();
			entidades.Usuario lentidadesUsuario = entidades.Usuario.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesUsuario.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Asignatura by AsignaturaCriteria");
		entidades.AsignaturaCriteria lentidadesAsignaturaCriteria = new entidades.AsignaturaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesAsignaturaCriteria.id.eq();
		System.out.println(lentidadesAsignaturaCriteria.uniqueAsignatura());
		
		System.out.println("Retrieving Asignatura_estudiante by Asignatura_estudianteCriteria");
		entidades.Asignatura_estudianteCriteria lentidadesAsignatura_estudianteCriteria = new entidades.Asignatura_estudianteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesAsignatura_estudianteCriteria.id.eq();
		System.out.println(lentidadesAsignatura_estudianteCriteria.uniqueAsignatura_estudiante());
		
		System.out.println("Retrieving Carrera by CarreraCriteria");
		entidades.CarreraCriteria lentidadesCarreraCriteria = new entidades.CarreraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesCarreraCriteria.id.eq();
		System.out.println(lentidadesCarreraCriteria.uniqueCarrera());
		
		System.out.println("Retrieving Convocatoria by ConvocatoriaCriteria");
		entidades.ConvocatoriaCriteria lentidadesConvocatoriaCriteria = new entidades.ConvocatoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesConvocatoriaCriteria.id.eq();
		System.out.println(lentidadesConvocatoriaCriteria.uniqueConvocatoria());
		
		System.out.println("Retrieving Estudiante by EstudianteCriteria");
		entidades.EstudianteCriteria lentidadesEstudianteCriteria = new entidades.EstudianteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesEstudianteCriteria.id.eq();
		System.out.println(lentidadesEstudianteCriteria.uniqueEstudiante());
		
		System.out.println("Retrieving Facultad by FacultadCriteria");
		entidades.FacultadCriteria lentidadesFacultadCriteria = new entidades.FacultadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesFacultadCriteria.id.eq();
		System.out.println(lentidadesFacultadCriteria.uniqueFacultad());
		
		System.out.println("Retrieving Profesor by ProfesorCriteria");
		entidades.ProfesorCriteria lentidadesProfesorCriteria = new entidades.ProfesorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesProfesorCriteria.id.eq();
		System.out.println(lentidadesProfesorCriteria.uniqueProfesor());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		entidades.UsuarioCriteria lentidadesUsuarioCriteria = new entidades.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesUsuarioCriteria.id.eq();
		System.out.println(lentidadesUsuarioCriteria.uniqueUsuario());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdatePracticas1Data retrieveAndUpdatePracticas1Data = new RetrieveAndUpdatePracticas1Data();
			try {
				retrieveAndUpdatePracticas1Data.retrieveAndUpdateTestData();
				//retrieveAndUpdatePracticas1Data.retrieveByCriteria();
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
