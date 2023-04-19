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

public class ConvocatoriaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_estudianteId;
	public final AssociationExpression id_estudiante;
	public final IntegerExpression id_asignaturaId;
	public final AssociationExpression id_asignatura;
	public final DateExpression fecha;
	public final DoubleExpression nota;
	public final IntegerExpression numero;
	public final CollectionExpression nota_convocatoria;
	
	public ConvocatoriaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		id_estudianteId = new IntegerExpression("id_estudiante.id", this);
		id_estudiante = new AssociationExpression("id_estudiante", this);
		id_asignaturaId = new IntegerExpression("id_asignatura.id", this);
		id_asignatura = new AssociationExpression("id_asignatura", this);
		fecha = new DateExpression("fecha", this);
		nota = new DoubleExpression("nota", this);
		numero = new IntegerExpression("numero", this);
		nota_convocatoria = new CollectionExpression("ORM_Nota_convocatoria", this);
	}
	
	public ConvocatoriaCriteria(PersistentSession session) {
		this(session.createCriteria(Convocatoria.class));
	}
	
	public ConvocatoriaCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public EstudianteCriteria createId_estudianteCriteria() {
		return new EstudianteCriteria(createCriteria("id_estudiante"));
	}
	
	public AsignaturaCriteria createId_asignaturaCriteria() {
		return new AsignaturaCriteria(createCriteria("id_asignatura"));
	}
	
	public Nota_convocatoriaCriteria createNota_convocatoriaCriteria() {
		return new Nota_convocatoriaCriteria(createCriteria("ORM_Nota_convocatoria"));
	}
	
	public Convocatoria uniqueConvocatoria() {
		return (Convocatoria) super.uniqueResult();
	}
	
	public Convocatoria[] listConvocatoria() {
		java.util.List list = super.list();
		return (Convocatoria[]) list.toArray(new Convocatoria[list.size()]);
	}
}

