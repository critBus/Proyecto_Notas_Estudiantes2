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

public class Asignatura_estudianteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_asignaturaId;
	public final AssociationExpression id_asignatura;
	public final IntegerExpression id_estudianteId;
	public final AssociationExpression id_estudiante;
	
	public Asignatura_estudianteCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this);
		id_asignatura = new AssociationExpression("id_asignatura", this);
		id_estudianteId = new IntegerExpression("id_estudiante.id", this);
		id_estudiante = new AssociationExpression("id_estudiante", this);
	}
	
	public Asignatura_estudianteCriteria(PersistentSession session) {
		this(session.createCriteria(Asignatura_estudiante.class));
	}
	
	public Asignatura_estudianteCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public AsignaturaCriteria createId_asignaturaCriteria() {
		return new AsignaturaCriteria(createCriteria("id_asignatura"));
	}
	
	public EstudianteCriteria createId_estudianteCriteria() {
		return new EstudianteCriteria(createCriteria("id_estudiante"));
	}
	
	public Asignatura_estudiante uniqueAsignatura_estudiante() {
		return (Asignatura_estudiante) super.uniqueResult();
	}
	
	public Asignatura_estudiante[] listAsignatura_estudiante() {
		java.util.List list = super.list();
		return (Asignatura_estudiante[]) list.toArray(new Asignatura_estudiante[list.size()]);
	}
}

