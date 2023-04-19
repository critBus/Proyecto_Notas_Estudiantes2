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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
public class Convocatoria implements Serializable {
	public Convocatoria() {
	}
	
	public static Convocatoria loadConvocatoriaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadConvocatoriaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria getConvocatoriaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getConvocatoriaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadConvocatoriaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria getConvocatoriaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getConvocatoriaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Convocatoria) session.load(entidades.Convocatoria.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria getConvocatoriaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Convocatoria) session.get(entidades.Convocatoria.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Convocatoria) session.load(entidades.Convocatoria.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria getConvocatoriaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Convocatoria) session.get(entidades.Convocatoria.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConvocatoria(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryConvocatoria(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConvocatoria(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryConvocatoria(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria[] listConvocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listConvocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria[] listConvocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listConvocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConvocatoria(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Convocatoria as Convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConvocatoria(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Convocatoria as Convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Convocatoria", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria[] listConvocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryConvocatoria(session, condition, orderBy);
			return (Convocatoria[]) list.toArray(new Convocatoria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria[] listConvocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryConvocatoria(session, condition, orderBy, lockMode);
			return (Convocatoria[]) list.toArray(new Convocatoria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadConvocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadConvocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Convocatoria[] convocatorias = listConvocatoriaByQuery(session, condition, orderBy);
		if (convocatorias != null && convocatorias.length > 0)
			return convocatorias[0];
		else
			return null;
	}
	
	public static Convocatoria loadConvocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Convocatoria[] convocatorias = listConvocatoriaByQuery(session, condition, orderBy, lockMode);
		if (convocatorias != null && convocatorias.length > 0)
			return convocatorias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateConvocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateConvocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConvocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateConvocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConvocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Convocatoria as Convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConvocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Convocatoria as Convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Convocatoria", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Convocatoria loadConvocatoriaByCriteria(ConvocatoriaCriteria convocatoriaCriteria) {
		Convocatoria[] convocatorias = listConvocatoriaByCriteria(convocatoriaCriteria);
		if(convocatorias == null || convocatorias.length == 0) {
			return null;
		}
		return convocatorias[0];
	}
	
	public static Convocatoria[] listConvocatoriaByCriteria(ConvocatoriaCriteria convocatoriaCriteria) {
		return convocatoriaCriteria.listConvocatoria();
	}
	
	public static Convocatoria createConvocatoria() {
		return new entidades.Convocatoria();
	}
	
	public boolean save() throws PersistentException {
		try {
			Practicas1PersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			Practicas1PersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			Practicas1PersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			Practicas1PersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getId_estudiante() != null) {
				getId_estudiante().convocatoria.remove(this);
			}
			
			if(getId_asignatura() != null) {
				getId_asignatura().convocatoria.remove(this);
			}
			
			entidades.Nota_convocatoria[] lNota_convocatorias = nota_convocatoria.toArray();
			for(int i = 0; i < lNota_convocatorias.length; i++) {
				lNota_convocatorias[i].setId_convocatoria(null);
			}
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getId_estudiante() != null) {
				getId_estudiante().convocatoria.remove(this);
			}
			
			if(getId_asignatura() != null) {
				getId_asignatura().convocatoria.remove(this);
			}
			
			entidades.Nota_convocatoria[] lNota_convocatorias = nota_convocatoria.toArray();
			for(int i = 0; i < lNota_convocatorias.length; i++) {
				lNota_convocatorias[i].setId_convocatoria(null);
			}
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CONVOCATORIA_NOTA_CONVOCATORIA) {
			return ORM_nota_convocatoria;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_CONVOCATORIA_ID_ESTUDIANTE) {
			this.id_estudiante = (entidades.Estudiante) owner;
		}
		
		else if (key == ORMConstants.KEY_CONVOCATORIA_ID_ASIGNATURA) {
			this.id_asignatura = (entidades.Asignatura) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private entidades.Estudiante id_estudiante;
	
	private entidades.Asignatura id_asignatura;
	
	private java.util.Date fecha;
	
	private double nota;
	
	private int numero;
	
	private java.util.Set ORM_nota_convocatoria = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	public void setNota(double value) {
		this.nota = value;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNumero(int value) {
		this.numero = value;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setId_estudiante(entidades.Estudiante value) {
		if (id_estudiante != null) {
			id_estudiante.convocatoria.remove(this);
		}
		if (value != null) {
			value.convocatoria.add(this);
		}
	}
	
	public entidades.Estudiante getId_estudiante() {
		return id_estudiante;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_estudiante(entidades.Estudiante value) {
		this.id_estudiante = value;
	}
	
	private entidades.Estudiante getORM_Id_estudiante() {
		return id_estudiante;
	}
	
	public void setId_asignatura(entidades.Asignatura value) {
		if (id_asignatura != null) {
			id_asignatura.convocatoria.remove(this);
		}
		if (value != null) {
			value.convocatoria.add(this);
		}
	}
	
	public entidades.Asignatura getId_asignatura() {
		return id_asignatura;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_asignatura(entidades.Asignatura value) {
		this.id_asignatura = value;
	}
	
	private entidades.Asignatura getORM_Id_asignatura() {
		return id_asignatura;
	}
	
	private void setORM_Nota_convocatoria(java.util.Set value) {
		this.ORM_nota_convocatoria = value;
	}
	
	private java.util.Set getORM_Nota_convocatoria() {
		return ORM_nota_convocatoria;
	}
	
	public final entidades.Nota_convocatoriaSetCollection nota_convocatoria = new entidades.Nota_convocatoriaSetCollection(this, _ormAdapter, ORMConstants.KEY_CONVOCATORIA_NOTA_CONVOCATORIA, ORMConstants.KEY_NOTA_CONVOCATORIA_ID_CONVOCATORIA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
