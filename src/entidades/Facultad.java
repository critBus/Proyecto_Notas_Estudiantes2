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
public class Facultad implements Serializable {
	public Facultad() {
	}
	
	public static Facultad loadFacultadByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadFacultadByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad getFacultadByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getFacultadByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadFacultadByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad getFacultadByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getFacultadByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Facultad) session.load(entidades.Facultad.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad getFacultadByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Facultad) session.get(entidades.Facultad.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facultad) session.load(entidades.Facultad.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad getFacultadByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facultad) session.get(entidades.Facultad.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacultad(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryFacultad(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacultad(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryFacultad(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad[] listFacultadByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listFacultadByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad[] listFacultadByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listFacultadByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacultad(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Facultad as Facultad");
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
	
	public static List queryFacultad(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Facultad as Facultad");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Facultad", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad[] listFacultadByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFacultad(session, condition, orderBy);
			return (Facultad[]) list.toArray(new Facultad[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad[] listFacultadByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFacultad(session, condition, orderBy, lockMode);
			return (Facultad[]) list.toArray(new Facultad[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadFacultadByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadFacultadByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Facultad[] facultads = listFacultadByQuery(session, condition, orderBy);
		if (facultads != null && facultads.length > 0)
			return facultads[0];
		else
			return null;
	}
	
	public static Facultad loadFacultadByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Facultad[] facultads = listFacultadByQuery(session, condition, orderBy, lockMode);
		if (facultads != null && facultads.length > 0)
			return facultads[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFacultadByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateFacultadByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacultadByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateFacultadByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacultadByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Facultad as Facultad");
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
	
	public static java.util.Iterator iterateFacultadByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Facultad as Facultad");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Facultad", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facultad loadFacultadByCriteria(FacultadCriteria facultadCriteria) {
		Facultad[] facultads = listFacultadByCriteria(facultadCriteria);
		if(facultads == null || facultads.length == 0) {
			return null;
		}
		return facultads[0];
	}
	
	public static Facultad[] listFacultadByCriteria(FacultadCriteria facultadCriteria) {
		return facultadCriteria.listFacultad();
	}
	
	public static Facultad createFacultad() {
		return new entidades.Facultad();
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
			entidades.Carrera[] lCarreras = carrera.toArray();
			for(int i = 0; i < lCarreras.length; i++) {
				lCarreras[i].setId_facultad(null);
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
			entidades.Carrera[] lCarreras = carrera.toArray();
			for(int i = 0; i < lCarreras.length; i++) {
				lCarreras[i].setId_facultad(null);
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
		if (key == ORMConstants.KEY_FACULTAD_CARRERA) {
			return ORM_carrera;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String facultad;
	
	private java.util.Set ORM_carrera = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setFacultad(String value) {
		this.facultad = value;
	}
	
	public String getFacultad() {
		return facultad;
	}
	
	private void setORM_Carrera(java.util.Set value) {
		this.ORM_carrera = value;
	}
	
	private java.util.Set getORM_Carrera() {
		return ORM_carrera;
	}
	
	public final entidades.CarreraSetCollection carrera = new entidades.CarreraSetCollection(this, _ormAdapter, ORMConstants.KEY_FACULTAD_CARRERA, ORMConstants.KEY_CARRERA_ID_FACULTAD, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
