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
			entidades.Asiganutra_estudiante lentidadesAsiganutra_estudiante = entidades.Asiganutra_estudiante.loadAsiganutra_estudianteByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesAsiganutra_estudiante.save();
			entidades.Asignatura lentidadesAsignatura = entidades.Asignatura.loadAsignaturaByQuery(null, null);
			// Update the properties of the persistent object
			lentidadesAsignatura.save();
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
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Asiganutra_estudiante by Asiganutra_estudianteCriteria");
		entidades.Asiganutra_estudianteCriteria lentidadesAsiganutra_estudianteCriteria = new entidades.Asiganutra_estudianteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesAsiganutra_estudianteCriteria.id.eq();
		System.out.println(lentidadesAsiganutra_estudianteCriteria.uniqueAsiganutra_estudiante());
		
		System.out.println("Retrieving Asignatura by AsignaturaCriteria");
		entidades.AsignaturaCriteria lentidadesAsignaturaCriteria = new entidades.AsignaturaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lentidadesAsignaturaCriteria.id.eq();
		System.out.println(lentidadesAsignaturaCriteria.uniqueAsignatura());
		
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
