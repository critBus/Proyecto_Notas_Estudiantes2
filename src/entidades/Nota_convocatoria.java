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
public class Nota_convocatoria implements Serializable {
	public Nota_convocatoria() {
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadNota_convocatoriaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria getNota_convocatoriaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getNota_convocatoriaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadNota_convocatoriaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria getNota_convocatoriaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getNota_convocatoriaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Nota_convocatoria) session.load(entidades.Nota_convocatoria.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria getNota_convocatoriaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Nota_convocatoria) session.get(entidades.Nota_convocatoria.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Nota_convocatoria) session.load(entidades.Nota_convocatoria.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria getNota_convocatoriaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Nota_convocatoria) session.get(entidades.Nota_convocatoria.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNota_convocatoria(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryNota_convocatoria(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNota_convocatoria(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryNota_convocatoria(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria[] listNota_convocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listNota_convocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria[] listNota_convocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listNota_convocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNota_convocatoria(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Nota_convocatoria as Nota_convocatoria");
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
	
	public static List queryNota_convocatoria(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Nota_convocatoria as Nota_convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Nota_convocatoria", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria[] listNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryNota_convocatoria(session, condition, orderBy);
			return (Nota_convocatoria[]) list.toArray(new Nota_convocatoria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria[] listNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryNota_convocatoria(session, condition, orderBy, lockMode);
			return (Nota_convocatoria[]) list.toArray(new Nota_convocatoria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadNota_convocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadNota_convocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Nota_convocatoria[] nota_convocatorias = listNota_convocatoriaByQuery(session, condition, orderBy);
		if (nota_convocatorias != null && nota_convocatorias.length > 0)
			return nota_convocatorias[0];
		else
			return null;
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Nota_convocatoria[] nota_convocatorias = listNota_convocatoriaByQuery(session, condition, orderBy, lockMode);
		if (nota_convocatorias != null && nota_convocatorias.length > 0)
			return nota_convocatorias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateNota_convocatoriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateNota_convocatoriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNota_convocatoriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateNota_convocatoriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Nota_convocatoria as Nota_convocatoria");
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
	
	public static java.util.Iterator iterateNota_convocatoriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Nota_convocatoria as Nota_convocatoria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Nota_convocatoria", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Nota_convocatoria loadNota_convocatoriaByCriteria(Nota_convocatoriaCriteria nota_convocatoriaCriteria) {
		Nota_convocatoria[] nota_convocatorias = listNota_convocatoriaByCriteria(nota_convocatoriaCriteria);
		if(nota_convocatorias == null || nota_convocatorias.length == 0) {
			return null;
		}
		return nota_convocatorias[0];
	}
	
	public static Nota_convocatoria[] listNota_convocatoriaByCriteria(Nota_convocatoriaCriteria nota_convocatoriaCriteria) {
		return nota_convocatoriaCriteria.listNota_convocatoria();
	}
	
	public static Nota_convocatoria createNota_convocatoria() {
		return new entidades.Nota_convocatoria();
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
			if(getId_convocatoria() != null) {
				getId_convocatoria().nota_convocatoria.remove(this);
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
			if(getId_convocatoria() != null) {
				getId_convocatoria().nota_convocatoria.remove(this);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_NOTA_CONVOCATORIA_ID_CONVOCATORIA) {
			this.id_convocatoria = (entidades.Convocatoria) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private entidades.Convocatoria id_convocatoria;
	
	private double nota_final;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNota_final(double value) {
		this.nota_final = value;
	}
	
	public double getNota_final() {
		return nota_final;
	}
	
	public void setId_convocatoria(entidades.Convocatoria value) {
		if (id_convocatoria != null) {
			id_convocatoria.nota_convocatoria.remove(this);
		}
		if (value != null) {
			value.nota_convocatoria.add(this);
		}
	}
	
	public entidades.Convocatoria getId_convocatoria() {
		return id_convocatoria;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_convocatoria(entidades.Convocatoria value) {
		this.id_convocatoria = value;
	}
	
	private entidades.Convocatoria getORM_Id_convocatoria() {
		return id_convocatoria;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
