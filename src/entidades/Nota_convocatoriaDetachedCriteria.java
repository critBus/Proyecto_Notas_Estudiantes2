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

public class Nota_convocatoriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression id_convocatoriaId;
	public final AssociationExpression id_convocatoria;
	public final DoubleExpression nota_final;
	
	public Nota_convocatoriaDetachedCriteria() {
		super(entidades.Nota_convocatoria.class, entidades.Nota_convocatoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_convocatoriaId = new IntegerExpression("id_convocatoria.id", this.getDetachedCriteria());
		id_convocatoria = new AssociationExpression("id_convocatoria", this.getDetachedCriteria());
		nota_final = new DoubleExpression("nota_final", this.getDetachedCriteria());
	}
	
	public Nota_convocatoriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, entidades.Nota_convocatoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		id_convocatoriaId = new IntegerExpression("id_convocatoria.id", this.getDetachedCriteria());
		id_convocatoria = new AssociationExpression("id_convocatoria", this.getDetachedCriteria());
		nota_final = new DoubleExpression("nota_final", this.getDetachedCriteria());
	}
	
	public ConvocatoriaDetachedCriteria createId_convocatoriaCriteria() {
		return new ConvocatoriaDetachedCriteria(createCriteria("id_convocatoria"));
	}
	
	public Nota_convocatoria uniqueNota_convocatoria(PersistentSession session) {
		return (Nota_convocatoria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Nota_convocatoria[] listNota_convocatoria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Nota_convocatoria[]) list.toArray(new Nota_convocatoria[list.size()]);
	}
}

