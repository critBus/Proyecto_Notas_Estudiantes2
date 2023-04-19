/**
 * Licensee: 
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class DeletePracticas1Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = entidades.Practicas1PersistentManager.instance().getSession().beginTransaction();
		try {
			entidades.Asignatura lentidadesAsignatura = entidades.Asignatura.loadAsignaturaByQuery(null, null);
			lentidadesAsignatura.delete();
			entidades.Asignatura_estudiante lentidadesAsignatura_estudiante = entidades.Asignatura_estudiante.loadAsignatura_estudianteByQuery(null, null);
			lentidadesAsignatura_estudiante.delete();
			entidades.Carrera lentidadesCarrera = entidades.Carrera.loadCarreraByQuery(null, null);
			lentidadesCarrera.delete();
			entidades.Convocatoria lentidadesConvocatoria = entidades.Convocatoria.loadConvocatoriaByQuery(null, null);
			lentidadesConvocatoria.delete();
			entidades.Estudiante lentidadesEstudiante = entidades.Estudiante.loadEstudianteByQuery(null, null);
			lentidadesEstudiante.delete();
			entidades.Facultad lentidadesFacultad = entidades.Facultad.loadFacultadByQuery(null, null);
			lentidadesFacultad.delete();
			entidades.Profesor lentidadesProfesor = entidades.Profesor.loadProfesorByQuery(null, null);
			lentidadesProfesor.delete();
			entidades.Usuario lentidadesUsuario = entidades.Usuario.loadUsuarioByQuery(null, null);
			lentidadesUsuario.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeletePracticas1Data deletePracticas1Data = new DeletePracticas1Data();
			try {
				deletePracticas1Data.deleteTestData();
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
