/**
 * Licensee: 
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreatePracticas1Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = entidades.Practicas1PersistentManager.instance().getSession().beginTransaction();
		try {
			entidades.Asignatura lentidadesAsignatura = entidades.Asignatura.createAsignatura();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : convocatoria, asignatura_estudiante, id_carrera, semestre, modalidad, asignatura
			lentidadesAsignatura.save();
			entidades.Asignatura_estudiante lentidadesAsignatura_estudiante = entidades.Asignatura_estudiante.createAsignatura_estudiante();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : id_estudiante, id_asignatura
			lentidadesAsignatura_estudiante.save();
			entidades.Carrera lentidadesCarrera = entidades.Carrera.createCarrera();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : asignatura, carrera, id_facultad
			lentidadesCarrera.save();
			entidades.Convocatoria lentidadesConvocatoria = entidades.Convocatoria.createConvocatoria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : numero, nota, fecha, id_asignatura, id_estudiante
			lentidadesConvocatoria.save();
			entidades.Estudiante lentidadesEstudiante = entidades.Estudiante.createEstudiante();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : convocatoria, asignatura_estudiante, grupo, apellidos, nombre
			lentidadesEstudiante.save();
			entidades.Facultad lentidadesFacultad = entidades.Facultad.createFacultad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : carrera, facultad
			lentidadesFacultad.save();
			entidades.Profesor lentidadesProfesor = entidades.Profesor.createProfesor();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : apellidos, nombre
			lentidadesProfesor.save();
			entidades.Usuario lentidadesUsuario = entidades.Usuario.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, username
			lentidadesUsuario.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreatePracticas1Data createPracticas1Data = new CreatePracticas1Data();
			try {
				createPracticas1Data.createTestData();
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
