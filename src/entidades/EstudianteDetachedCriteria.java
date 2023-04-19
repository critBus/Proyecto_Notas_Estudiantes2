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

public class EstudianteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression grupo;
	public final CollectionExpression asiganutra_estudiante;
	public final CollectionExpression convocatoria;
	
	public EstudianteDetachedCriteria() {
		super(entidades.Estudiante.class, entidades.EstudianteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		grupo = new StringExpression("grupo", this.getDetachedCriteria());
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this.getDetachedCriteria());
		convocatoria = new CollectionExpression("ORM_Convocatoria", this.getDetachedCriteria());
	}
	
	public EstudianteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.EstudianteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		grupo = new StringExpression("grupo", this.getDetachedCriteria());
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this.getDetachedCriteria());
		convocatoria = new CollectionExpression("ORM_Convocatoria", this.getDetachedCriteria());
	}
	
	public Asiganutra_estudianteDetachedCriteria createAsiganutra_estudianteCriteria() {
		return new Asiganutra_estudianteDetachedCriteria(createCriteria("ORM_Asiganutra_estudiante"));
	}
	
	public ConvocatoriaDetachedCriteria createConvocatoriaCriteria() {
		return new ConvocatoriaDetachedCriteria(createCriteria("ORM_Convocatoria"));
	}
	
	public Estudiante uniqueEstudiante(PersistentSession session) {
		return (Estudiante) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Estudiante[] listEstudiante(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Estudiante[]) list.toArray(new Estudiante[list.size()]);
	}
}
