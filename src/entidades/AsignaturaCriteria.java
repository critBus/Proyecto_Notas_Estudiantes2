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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AsignaturaCriteria extends AbstractORMCriteria {
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
	
	public AsignaturaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		asignatura = new StringExpression("asignatura", this);
		modalidad = new StringExpression("modalidad", this);
		semestre = new StringExpression("semestre", this);
		id_carreraId = new IntegerExpression("id_carrera.id", this);
		id_carrera = new AssociationExpression("id_carrera", this);
		id_profesorId = new IntegerExpression("id_profesor.id", this);
		id_profesor = new AssociationExpression("id_profesor", this);
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this);
		convocatoria = new CollectionExpression("ORM_Convocatoria", this);
	}
	
	public AsignaturaCriteria(PersistentSession session) {
		this(session.createCriteria(Asignatura.class));
	}
	
	public AsignaturaCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public CarreraCriteria createId_carreraCriteria() {
		return new CarreraCriteria(createCriteria("id_carrera"));
	}
	
	public ProfesorCriteria createId_profesorCriteria() {
		return new ProfesorCriteria(createCriteria("id_profesor"));
	}
	
	public Asiganutra_estudianteCriteria createAsiganutra_estudianteCriteria() {
		return new Asiganutra_estudianteCriteria(createCriteria("ORM_Asiganutra_estudiante"));
	}
	
	public ConvocatoriaCriteria createConvocatoriaCriteria() {
		return new ConvocatoriaCriteria(createCriteria("ORM_Convocatoria"));
	}
	
	public Asignatura uniqueAsignatura() {
		return (Asignatura) super.uniqueResult();
	}
	
	public Asignatura[] listAsignatura() {
		java.util.List list = super.list();
		return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
	}
}

