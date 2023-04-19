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

public class EstudianteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression grupo;
	public final CollectionExpression asiganutra_estudiante;
	public final CollectionExpression convocatoria;
	
	public EstudianteCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		grupo = new StringExpression("grupo", this);
		asiganutra_estudiante = new CollectionExpression("ORM_Asiganutra_estudiante", this);
		convocatoria = new CollectionExpression("ORM_Convocatoria", this);
	}
	
	public EstudianteCriteria(PersistentSession session) {
		this(session.createCriteria(Estudiante.class));
	}
	
	public EstudianteCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public Asiganutra_estudianteCriteria createAsiganutra_estudianteCriteria() {
		return new Asiganutra_estudianteCriteria(createCriteria("ORM_Asiganutra_estudiante"));
	}
	
	public ConvocatoriaCriteria createConvocatoriaCriteria() {
		return new ConvocatoriaCriteria(createCriteria("ORM_Convocatoria"));
	}
	
	public Estudiante uniqueEstudiante() {
		return (Estudiante) super.uniqueResult();
	}
	
	public Estudiante[] listEstudiante() {
		java.util.List list = super.list();
		return (Estudiante[]) list.toArray(new Estudiante[list.size()]);
	}
}
