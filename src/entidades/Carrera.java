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
public class Carrera implements Serializable {
	public Carrera() {
	}
	
	public static Carrera loadCarreraByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadCarreraByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera getCarreraByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getCarreraByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadCarreraByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera getCarreraByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getCarreraByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Carrera) session.load(entidades.Carrera.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera getCarreraByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Carrera) session.get(entidades.Carrera.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Carrera) session.load(entidades.Carrera.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera getCarreraByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Carrera) session.get(entidades.Carrera.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCarrera(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryCarrera(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCarrera(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryCarrera(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera[] listCarreraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listCarreraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera[] listCarreraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listCarreraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCarrera(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Carrera as Carrera");
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
	
	public static List queryCarrera(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Carrera as Carrera");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Carrera", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera[] listCarreraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCarrera(session, condition, orderBy);
			return (Carrera[]) list.toArray(new Carrera[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera[] listCarreraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCarrera(session, condition, orderBy, lockMode);
			return (Carrera[]) list.toArray(new Carrera[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadCarreraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadCarreraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Carrera[] carreras = listCarreraByQuery(session, condition, orderBy);
		if (carreras != null && carreras.length > 0)
			return carreras[0];
		else
			return null;
	}
	
	public static Carrera loadCarreraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Carrera[] carreras = listCarreraByQuery(session, condition, orderBy, lockMode);
		if (carreras != null && carreras.length > 0)
			return carreras[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCarreraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateCarreraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCarreraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateCarreraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCarreraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Carrera as Carrera");
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
	
	public static java.util.Iterator iterateCarreraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Carrera as Carrera");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Carrera", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Carrera loadCarreraByCriteria(CarreraCriteria carreraCriteria) {
		Carrera[] carreras = listCarreraByCriteria(carreraCriteria);
		if(carreras == null || carreras.length == 0) {
			return null;
		}
		return carreras[0];
	}
	
	public static Carrera[] listCarreraByCriteria(CarreraCriteria carreraCriteria) {
		return carreraCriteria.listCarrera();
	}
	
	public static Carrera createCarrera() {
		return new entidades.Carrera();
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
			if(getId_facultad() != null) {
				getId_facultad().carrera.remove(this);
			}
			
			entidades.Asignatura[] lAsignaturas = asignatura.toArray();
			for(int i = 0; i < lAsignaturas.length; i++) {
				lAsignaturas[i].setId_carrera(null);
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
			if(getId_facultad() != null) {
				getId_facultad().carrera.remove(this);
			}
			
			entidades.Asignatura[] lAsignaturas = asignatura.toArray();
			for(int i = 0; i < lAsignaturas.length; i++) {
				lAsignaturas[i].setId_carrera(null);
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
		if (key == ORMConstants.KEY_CARRERA_ASIGNATURA) {
			return ORM_asignatura;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_CARRERA_ID_FACULTAD) {
			this.id_facultad = (entidades.Facultad) owner;
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
	
	private entidades.Facultad id_facultad;
	
	private String carrera;
	
	private java.util.Set ORM_asignatura = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setCarrera(String value) {
		this.carrera = value;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public void setId_facultad(entidades.Facultad value) {
		if (id_facultad != null) {
			id_facultad.carrera.remove(this);
		}
		if (value != null) {
			value.carrera.add(this);
		}
	}
	
	public entidades.Facultad getId_facultad() {
		return id_facultad;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_facultad(entidades.Facultad value) {
		this.id_facultad = value;
	}
	
	private entidades.Facultad getORM_Id_facultad() {
		return id_facultad;
	}
	
	private void setORM_Asignatura(java.util.Set value) {
		this.ORM_asignatura = value;
	}
	
	private java.util.Set getORM_Asignatura() {
		return ORM_asignatura;
	}
	
	public final entidades.AsignaturaSetCollection asignatura = new entidades.AsignaturaSetCollection(this, _ormAdapter, ORMConstants.KEY_CARRERA_ASIGNATURA, ORMConstants.KEY_ASIGNATURA_ID_CARRERA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
