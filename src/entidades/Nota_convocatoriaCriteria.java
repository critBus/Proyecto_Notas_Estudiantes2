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

public class Nota_convocatoriaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_convocatoriaId;
	public final AssociationExpression id_convocatoria;
	public final DoubleExpression nota_final;
	
	public Nota_convocatoriaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		id_convocatoriaId = new IntegerExpression("id_convocatoria.id", this);
		id_convocatoria = new AssociationExpression("id_convocatoria", this);
		nota_final = new DoubleExpression("nota_final", this);
	}
	
	public Nota_convocatoriaCriteria(PersistentSession session) {
		this(session.createCriteria(Nota_convocatoria.class));
	}
	
	public Nota_convocatoriaCriteria() throws PersistentException {
		this(Practicas1PersistentManager.instance().getSession());
	}
	
	public ConvocatoriaCriteria createId_convocatoriaCriteria() {
		return new ConvocatoriaCriteria(createCriteria("id_convocatoria"));
	}
	
	public Nota_convocatoria uniqueNota_convocatoria() {
		return (Nota_convocatoria) super.uniqueResult();
	}
	
	public Nota_convocatoria[] listNota_convocatoria() {
		java.util.List list = super.list();
		return (Nota_convocatoria[]) list.toArray(new Nota_convocatoria[list.size()]);
	}
}

