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
public class Asignatura_estudiante implements Serializable {
	public Asignatura_estudiante() {
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignatura_estudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante getAsignatura_estudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsignatura_estudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignatura_estudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante getAsignatura_estudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsignatura_estudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asignatura_estudiante) session.load(entidades.Asignatura_estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante getAsignatura_estudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asignatura_estudiante) session.get(entidades.Asignatura_estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura_estudiante) session.load(entidades.Asignatura_estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante getAsignatura_estudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura_estudiante) session.get(entidades.Asignatura_estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura_estudiante(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsignatura_estudiante(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura_estudiante(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsignatura_estudiante(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante[] listAsignatura_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsignatura_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante[] listAsignatura_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsignatura_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura_estudiante(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura_estudiante as Asignatura_estudiante");
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
	
	public static List queryAsignatura_estudiante(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura_estudiante as Asignatura_estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura_estudiante", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante[] listAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAsignatura_estudiante(session, condition, orderBy);
			return (Asignatura_estudiante[]) list.toArray(new Asignatura_estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante[] listAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAsignatura_estudiante(session, condition, orderBy, lockMode);
			return (Asignatura_estudiante[]) list.toArray(new Asignatura_estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignatura_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignatura_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Asignatura_estudiante[] asignatura_estudiantes = listAsignatura_estudianteByQuery(session, condition, orderBy);
		if (asignatura_estudiantes != null && asignatura_estudiantes.length > 0)
			return asignatura_estudiantes[0];
		else
			return null;
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Asignatura_estudiante[] asignatura_estudiantes = listAsignatura_estudianteByQuery(session, condition, orderBy, lockMode);
		if (asignatura_estudiantes != null && asignatura_estudiantes.length > 0)
			return asignatura_estudiantes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAsignatura_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsignatura_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignatura_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsignatura_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura_estudiante as Asignatura_estudiante");
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
	
	public static java.util.Iterator iterateAsignatura_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura_estudiante as Asignatura_estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura_estudiante", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura_estudiante loadAsignatura_estudianteByCriteria(Asignatura_estudianteCriteria asignatura_estudianteCriteria) {
		Asignatura_estudiante[] asignatura_estudiantes = listAsignatura_estudianteByCriteria(asignatura_estudianteCriteria);
		if(asignatura_estudiantes == null || asignatura_estudiantes.length == 0) {
			return null;
		}
		return asignatura_estudiantes[0];
	}
	
	public static Asignatura_estudiante[] listAsignatura_estudianteByCriteria(Asignatura_estudianteCriteria asignatura_estudianteCriteria) {
		return asignatura_estudianteCriteria.listAsignatura_estudiante();
	}
	
	public static Asignatura_estudiante createAsignatura_estudiante() {
		return new entidades.Asignatura_estudiante();
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
			if(getId_asignatura() != null) {
				getId_asignatura().asignatura_estudiante.remove(this);
			}
			
			if(getId_estudiante() != null) {
				getId_estudiante().setAsignatura_estudiante(null);
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
			if(getId_asignatura() != null) {
				getId_asignatura().asignatura_estudiante.remove(this);
			}
			
			if(getId_estudiante() != null) {
				getId_estudiante().setAsignatura_estudiante(null);
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
		if (key == ORMConstants.KEY_ASIGNATURA_ESTUDIANTE_ID_ASIGNATURA) {
			this.id_asignatura = (entidades.Asignatura) owner;
		}
		
		else if (key == ORMConstants.KEY_ASIGNATURA_ESTUDIANTE_ID_ESTUDIANTE) {
			this.id_estudiante = (entidades.Estudiante) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private entidades.Asignatura id_asignatura;
	
	private entidades.Estudiante id_estudiante;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setId_asignatura(entidades.Asignatura value) {
		if (id_asignatura != null) {
			id_asignatura.asignatura_estudiante.remove(this);
		}
		if (value != null) {
			value.asignatura_estudiante.add(this);
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
	
	public void setId_estudiante(entidades.Estudiante value) {
		if (this.id_estudiante != value) {
			entidades.Estudiante lid_estudiante = this.id_estudiante;
			this.id_estudiante = value;
			if (value != null) {
				id_estudiante.setAsignatura_estudiante(this);
			}
			if (lid_estudiante != null && lid_estudiante.getAsignatura_estudiante() == this) {
				lid_estudiante.setAsignatura_estudiante(null);
			}
		}
	}
	
	public entidades.Estudiante getId_estudiante() {
		return id_estudiante;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
