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

public class ProfesorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final CollectionExpression asignatura;
	
	public ProfesorCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		asignatura = new CollectionExpression("ORM_Asignatura", this);
	}
	
	public ProfesorCriteria(PersistentSession session) {
		this(session.createCriteria(Profesor.class));
	}
	
	public ProfesorCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public AsignaturaCriteria createAsignaturaCriteria() {
		return new AsignaturaCriteria(createCriteria("ORM_Asignatura"));
	}
	
	public Profesor uniqueProfesor() {
		return (Profesor) super.uniqueResult();
	}
	
	public Profesor[] listProfesor() {
		java.util.List list = super.list();
		return (Profesor[]) list.toArray(new Profesor[list.size()]);
	}
}

