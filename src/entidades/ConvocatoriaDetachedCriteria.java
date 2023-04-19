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

public class ConvocatoriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_estudianteId;
	public final AssociationExpression id_estudiante;
	public final IntegerExpression id_asignaturaId;
	public final AssociationExpression id_asignatura;
	public final DateExpression fecha;
	public final DoubleExpression nota;
	public final IntegerExpression numero;
	
	public ConvocatoriaDetachedCriteria() {
		super(entidades.Convocatoria.class, entidades.ConvocatoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_estudianteId = new IntegerExpression("id_estudiante.id", this.getDetachedCriteria());
		id_estudiante = new AssociationExpression("id_estudiante", this.getDetachedCriteria());
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this.getDetachedCriteria());
		id_asignatura = new AssociationExpression("id_asignatura", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		nota = new DoubleExpression("nota", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public ConvocatoriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.ConvocatoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_estudianteId = new IntegerExpression("id_estudiante.id", this.getDetachedCriteria());
		id_estudiante = new AssociationExpression("id_estudiante", this.getDetachedCriteria());
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this.getDetachedCriteria());
		id_asignatura = new AssociationExpression("id_asignatura", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		nota = new DoubleExpression("nota", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public EstudianteDetachedCriteria createId_estudianteCriteria() {
		return new EstudianteDetachedCriteria(createCriteria("id_estudiante"));
	}
	
	public AsignaturaDetachedCriteria createId_asignaturaCriteria() {
		return new AsignaturaDetachedCriteria(createCriteria("id_asignatura"));
	}
	
	public Convocatoria uniqueConvocatoria(PersistentSession session) {
		return (Convocatoria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Convocatoria[] listConvocatoria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Convocatoria[]) list.toArray(new Convocatoria[list.size()]);
	}
}

