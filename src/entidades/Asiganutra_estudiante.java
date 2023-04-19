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
public class Asiganutra_estudiante implements Serializable {
	public Asiganutra_estudiante() {
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsiganutra_estudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante getAsiganutra_estudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsiganutra_estudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsiganutra_estudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante getAsiganutra_estudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsiganutra_estudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asiganutra_estudiante) session.load(entidades.Asiganutra_estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante getAsiganutra_estudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asiganutra_estudiante) session.get(entidades.Asiganutra_estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asiganutra_estudiante) session.load(entidades.Asiganutra_estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante getAsiganutra_estudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asiganutra_estudiante) session.get(entidades.Asiganutra_estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsiganutra_estudiante(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsiganutra_estudiante(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsiganutra_estudiante(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsiganutra_estudiante(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante[] listAsiganutra_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsiganutra_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante[] listAsiganutra_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsiganutra_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsiganutra_estudiante(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asiganutra_estudiante as Asiganutra_estudiante");
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
	
	public static List queryAsiganutra_estudiante(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asiganutra_estudiante as Asiganutra_estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asiganutra_estudiante", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante[] listAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAsiganutra_estudiante(session, condition, orderBy);
			return (Asiganutra_estudiante[]) list.toArray(new Asiganutra_estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante[] listAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAsiganutra_estudiante(session, condition, orderBy, lockMode);
			return (Asiganutra_estudiante[]) list.toArray(new Asiganutra_estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsiganutra_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsiganutra_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Asiganutra_estudiante[] asiganutra_estudiantes = listAsiganutra_estudianteByQuery(session, condition, orderBy);
		if (asiganutra_estudiantes != null && asiganutra_estudiantes.length > 0)
			return asiganutra_estudiantes[0];
		else
			return null;
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Asiganutra_estudiante[] asiganutra_estudiantes = listAsiganutra_estudianteByQuery(session, condition, orderBy, lockMode);
		if (asiganutra_estudiantes != null && asiganutra_estudiantes.length > 0)
			return asiganutra_estudiantes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAsiganutra_estudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsiganutra_estudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsiganutra_estudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsiganutra_estudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asiganutra_estudiante as Asiganutra_estudiante");
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
	
	public static java.util.Iterator iterateAsiganutra_estudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asiganutra_estudiante as Asiganutra_estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asiganutra_estudiante", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asiganutra_estudiante loadAsiganutra_estudianteByCriteria(Asiganutra_estudianteCriteria asiganutra_estudianteCriteria) {
		Asiganutra_estudiante[] asiganutra_estudiantes = listAsiganutra_estudianteByCriteria(asiganutra_estudianteCriteria);
		if(asiganutra_estudiantes == null || asiganutra_estudiantes.length == 0) {
			return null;
		}
		return asiganutra_estudiantes[0];
	}
	
	public static Asiganutra_estudiante[] listAsiganutra_estudianteByCriteria(Asiganutra_estudianteCriteria asiganutra_estudianteCriteria) {
		return asiganutra_estudianteCriteria.listAsiganutra_estudiante();
	}
	
	public static Asiganutra_estudiante createAsiganutra_estudiante() {
		return new entidades.Asiganutra_estudiante();
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
				getId_asignatura().asiganutra_estudiante.remove(this);
			}
			
			if(getId_estudiante() != null) {
				getId_estudiante().asiganutra_estudiante.remove(this);
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
				getId_asignatura().asiganutra_estudiante.remove(this);
			}
			
			if(getId_estudiante() != null) {
				getId_estudiante().asiganutra_estudiante.remove(this);
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
		if (key == ORMConstants.KEY_ASIGANUTRA_ESTUDIANTE_ID_ASIGNATURA) {
			this.id_asignatura = (entidades.Asignatura) owner;
		}
		
		else if (key == ORMConstants.KEY_ASIGANUTRA_ESTUDIANTE_ID_ESTUDIANTE) {
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
			id_asignatura.asiganutra_estudiante.remove(this);
		}
		if (value != null) {
			value.asiganutra_estudiante.add(this);
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
		if (id_estudiante != null) {
			id_estudiante.asiganutra_estudiante.remove(this);
		}
		if (value != null) {
			value.asiganutra_estudiante.add(this);
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
