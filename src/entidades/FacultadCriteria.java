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

public class FacultadCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression facultad;
	public final CollectionExpression carrera;
	
	public FacultadCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		facultad = new StringExpression("facultad", this);
		carrera = new CollectionExpression("ORM_Carrera", this);
	}
	
	public FacultadCriteria(PersistentSession session) {
		this(session.createCriteria(Facultad.class));
	}
	
	public FacultadCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public CarreraCriteria createCarreraCriteria() {
		return new CarreraCriteria(createCriteria("ORM_Carrera"));
	}
	
	public Facultad uniqueFacultad() {
		return (Facultad) super.uniqueResult();
	}
	
	public Facultad[] listFacultad() {
		java.util.List list = super.list();
		return (Facultad[]) list.toArray(new Facultad[list.size()]);
	}
}

