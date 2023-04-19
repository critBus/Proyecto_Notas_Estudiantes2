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

public class FacultadDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression facultad;
	public final CollectionExpression carrera;
	
	public FacultadDetachedCriteria() {
		super(entidades.Facultad.class, entidades.FacultadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		facultad = new StringExpression("facultad", this.getDetachedCriteria());
		carrera = new CollectionExpression("ORM_Carrera", this.getDetachedCriteria());
	}
	
	public FacultadDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.FacultadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		facultad = new StringExpression("facultad", this.getDetachedCriteria());
		carrera = new CollectionExpression("ORM_Carrera", this.getDetachedCriteria());
	}
	
	public CarreraDetachedCriteria createCarreraCriteria() {
		return new CarreraDetachedCriteria(createCriteria("ORM_Carrera"));
	}
	
	public Facultad uniqueFacultad(PersistentSession session) {
		return (Facultad) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Facultad[] listFacultad(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Facultad[]) list.toArray(new Facultad[list.size()]);
	}
}

