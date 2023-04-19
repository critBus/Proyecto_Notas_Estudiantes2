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

public class CarreraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_facultadId;
	public final AssociationExpression id_facultad;
	public final StringExpression carrera;
	public final CollectionExpression asignatura;
	
	public CarreraDetachedCriteria() {
		super(entidades.Carrera.class, entidades.CarreraCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_facultadId = new IntegerExpression("id_facultad.id", this.getDetachedCriteria());
		id_facultad = new AssociationExpression("id_facultad", this.getDetachedCriteria());
		carrera = new StringExpression("carrera", this.getDetachedCriteria());
		asignatura = new CollectionExpression("ORM_Asignatura", this.getDetachedCriteria());
	}
	
	public CarreraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.CarreraCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_facultadId = new IntegerExpression("id_facultad.id", this.getDetachedCriteria());
		id_facultad = new AssociationExpression("id_facultad", this.getDetachedCriteria());
		carrera = new StringExpression("carrera", this.getDetachedCriteria());
		asignatura = new CollectionExpression("ORM_Asignatura", this.getDetachedCriteria());
	}
	
	public FacultadDetachedCriteria createId_facultadCriteria() {
		return new FacultadDetachedCriteria(createCriteria("id_facultad"));
	}
	
	public AsignaturaDetachedCriteria createAsignaturaCriteria() {
		return new AsignaturaDetachedCriteria(createCriteria("ORM_Asignatura"));
	}
	
	public Carrera uniqueCarrera(PersistentSession session) {
		return (Carrera) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Carrera[] listCarrera(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Carrera[]) list.toArray(new Carrera[list.size()]);
	}
}

