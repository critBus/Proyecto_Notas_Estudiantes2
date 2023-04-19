/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Purchased
 */
package entidades;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AsignaturaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression asignatura;
	public final StringExpression modalidad;
	public final StringExpression semestre;
	public final IntegerExpression id_carreraId;
	public final AssociationExpression id_carrera;
	public final IntegerExpression id_profesorId;
	public final AssociationExpression id_profesor;
	public final CollectionExpression asiganutra_estudiante;
	public final CollectionExpression convocatoria;
	
	public AsignaturaDetachedCriteria() {
		super(entidades.Asignatura.class, entidades.AsignaturaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		asignatura = new StringExpression("asignatura", this.getDetachedCriteria());
		modalidad = new StringExpression("modalidad", this.getDetachedCriteria());
		semestre = new StringExpression("semestre", this.getDetachedCriteria());
		id_carreraId = new IntegerExpression("id_carrera.id", this.getDetachedCriteria());
		id_carrera = new AssociationExpression("id_carrera", this.getDetachedCriteria());
		id_profesorId = new IntegerExpression("id_profesor.id", this.getDetachedCriteria());
		id_profesor = new AssociationExpression("id_profesor", this.getDetachedCriteria());
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this.getDetachedCriteria());
		convocatoria = new CollectionExpression("ORM_Convocatoria", this.getDetachedCriteria());
	}
	
	public AsignaturaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.AsignaturaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		asignatura = new StringExpression("asignatura", this.getDetachedCriteria());
		modalidad = new StringExpression("modalidad", this.getDetachedCriteria());
		semestre = new StringExpression("semestre", this.getDetachedCriteria());
		id_carreraId = new IntegerExpression("id_carrera.id", this.getDetachedCriteria());
		id_carrera = new AssociationExpression("id_carrera", this.getDetachedCriteria());
		id_profesorId = new IntegerExpression("id_profesor.id", this.getDetachedCriteria());
		id_profesor = new AssociationExpression("id_profesor", this.getDetachedCriteria());
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this.getDetachedCriteria());
		convocatoria = new CollectionExpression("ORM_Convocatoria", this.getDetachedCriteria());
	}
	
	public CarreraDetachedCriteria createId_carreraCriteria() {
		return new CarreraDetachedCriteria(createCriteria("id_carrera"));
	}
	
	public ProfesorDetachedCriteria createId_profesorCriteria() {
		return new ProfesorDetachedCriteria(createCriteria("id_profesor"));
	}
	
	public Asiganutra_estudianteDetachedCriteria createAsiganutra_estudianteCriteria() {
		return new Asiganutra_estudianteDetachedCriteria(createCriteria("ORM_Asiganutra_estudiante"));
	}
	
	public ConvocatoriaDetachedCriteria createConvocatoriaCriteria() {
		return new ConvocatoriaDetachedCriteria(createCriteria("ORM_Convocatoria"));
	}
	
	public Asignatura uniqueAsignatura(PersistentSession session) {
		return (Asignatura) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Asignatura[] listAsignatura(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
	}
}

