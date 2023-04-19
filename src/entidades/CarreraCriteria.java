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

public class CarreraCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_facultadId;
	public final AssociationExpression id_facultad;
	public final StringExpression carrera;
	public final CollectionExpression asignatura;
	
	public CarreraCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		id_facultadId = new IntegerExpression("id_facultad.id", this);
		id_facultad = new AssociationExpression("id_facultad", this);
		carrera = new StringExpression("carrera", this);
		asignatura = new CollectionExpression("ORM_Asignatura", this);
	}
	
	public CarreraCriteria(PersistentSession session) {
		this(session.createCriteria(Carrera.class));
	}
	
	public CarreraCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public FacultadCriteria createId_facultadCriteria() {
		return new FacultadCriteria(createCriteria("id_facultad"));
	}
	
	public AsignaturaCriteria createAsignaturaCriteria() {
		return new AsignaturaCriteria(createCriteria("ORM_Asignatura"));
	}
	
	public Carrera uniqueCarrera() {
		return (Carrera) super.uniqueResult();
	}
	
	public Carrera[] listCarrera() {
		java.util.List list = super.list();
		return (Carrera[]) list.toArray(new Carrera[list.size()]);
	}
}

