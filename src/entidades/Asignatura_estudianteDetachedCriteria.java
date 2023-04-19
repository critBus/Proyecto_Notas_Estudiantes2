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

public class Asignatura_estudianteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_asignaturaId;
	public final AssociationExpression id_asignatura;
	public final IntegerExpression id_estudianteId;
	public final AssociationExpression id_estudiante;
	
	public Asignatura_estudianteDetachedCriteria() {
		super(entidades.Asignatura_estudiante.class, entidades.Asignatura_estudianteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this.getDetachedCriteria());
		id_asignatura = new AssociationExpression("id_asignatura", this.getDetachedCriteria());
		id_estudianteId = new IntegerExpression("id_estudiante.id", this.getDetachedCriteria());
		id_estudiante = new AssociationExpression("id_estudiante", this.getDetachedCriteria());
	}
	
	public Asignatura_estudianteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.Asignatura_estudianteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this.getDetachedCriteria());
		id_asignatura = new AssociationExpression("id_asignatura", this.getDetachedCriteria());
		id_estudianteId = new IntegerExpression("id_estudiante.id", this.getDetachedCriteria());
		id_estudiante = new AssociationExpression("id_estudiante", this.getDetachedCriteria());
	}
	
	public AsignaturaDetachedCriteria createId_asignaturaCriteria() {
		return new AsignaturaDetachedCriteria(createCriteria("id_asignatura"));
	}
	
	public EstudianteDetachedCriteria createId_estudianteCriteria() {
		return new EstudianteDetachedCriteria(createCriteria("id_estudiante"));
	}
	
	public Asignatura_estudiante uniqueAsignatura_estudiante(PersistentSession session) {
		return (Asignatura_estudiante) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Asignatura_estudiante[] listAsignatura_estudiante(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Asignatura_estudiante[]) list.toArray(new Asignatura_estudiante[list.size()]);
	}
}
