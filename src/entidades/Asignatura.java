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
public class Asignatura implements Serializable {
	public Asignatura() {
	}
	
	public static Asignatura loadAsignaturaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignaturaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsignaturaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignaturaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getAsignaturaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asignatura) session.load(entidades.Asignatura.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Asignatura) session.get(entidades.Asignatura.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura) session.load(entidades.Asignatura.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura) session.get(entidades.Asignatura.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsignatura(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryAsignatura(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura as Asignatura");
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
	
	public static List queryAsignatura(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura as Asignatura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAsignatura(session, condition, orderBy);
			return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAsignatura(session, condition, orderBy, lockMode);
			return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Asignatura[] asignaturas = listAsignaturaByQuery(session, condition, orderBy);
		if (asignaturas != null && asignaturas.length > 0)
			return asignaturas[0];
		else
			return null;
	}
	
	public static Asignatura loadAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Asignatura[] asignaturas = listAsignaturaByQuery(session, condition, orderBy, lockMode);
		if (asignaturas != null && asignaturas.length > 0)
			return asignaturas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura as Asignatura");
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
	
	public static java.util.Iterator iterateAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Asignatura as Asignatura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByCriteria(AsignaturaCriteria asignaturaCriteria) {
		Asignatura[] asignaturas = listAsignaturaByCriteria(asignaturaCriteria);
		if(asignaturas == null || asignaturas.length == 0) {
			return null;
		}
		return asignaturas[0];
	}
	
	public static Asignatura[] listAsignaturaByCriteria(AsignaturaCriteria asignaturaCriteria) {
		return asignaturaCriteria.listAsignatura();
	}
	
	public static Asignatura createAsignatura() {
		return new entidades.Asignatura();
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
			if(getId_carrera() != null) {
				getId_carrera().asignatura.remove(this);
			}
			
			if(getId_profesor() != null) {
				getId_profesor().asignatura.remove(this);
			}
			
			entidades.Asiganutra_estudiante[] lAsiganutra_estudiantes = asiganutra_estudiante.toArray();
			for(int i = 0; i < lAsiganutra_estudiantes.length; i++) {
				lAsiganutra_estudiantes[i].setId_asignatura(null);
			}
			entidades.Convocatoria[] lConvocatorias = convocatoria.toArray();
			for(int i = 0; i < lConvocatorias.length; i++) {
				lConvocatorias[i].setId_asignatura(null);
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
			if(getId_carrera() != null) {
				getId_carrera().asignatura.remove(this);
			}
			
			if(getId_profesor() != null) {
				getId_profesor().asignatura.remove(this);
			}
			
			entidades.Asiganutra_estudiante[] lAsiganutra_estudiantes = asiganutra_estudiante.toArray();
			for(int i = 0; i < lAsiganutra_estudiantes.length; i++) {
				lAsiganutra_estudiantes[i].setId_asignatura(null);
			}
			entidades.Convocatoria[] lConvocatorias = convocatoria.toArray();
			for(int i = 0; i < lConvocatorias.length; i++) {
				lConvocatorias[i].setId_asignatura(null);
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
		if (key == ORMConstants.KEY_ASIGNATURA_ASIGANUTRA_ESTUDIANTE) {
			return ORM_asiganutra_estudiante;
		}
		else if (key == ORMConstants.KEY_ASIGNATURA_CONVOCATORIA) {
			return ORM_convocatoria;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ASIGNATURA_ID_CARRERA) {
			this.id_carrera = (entidades.Carrera) owner;
		}
		
		else if (key == ORMConstants.KEY_ASIGNATURA_ID_PROFESOR) {
			this.id_profesor = (entidades.Profesor) owner;
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
	
	private String asignatura;
	
	private String modalidad;
	
	private String semestre;
	
	private entidades.Carrera id_carrera;
	
	private entidades.Profesor id_profesor;
	
	private java.util.Set ORM_asiganutra_estudiante = new java.util.HashSet();
	
	private java.util.Set ORM_convocatoria = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setAsignatura(String value) {
		this.asignatura = value;
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	
	public void setModalidad(String value) {
		this.modalidad = value;
	}
	
	public String getModalidad() {
		return modalidad;
	}
	
	public void setSemestre(String value) {
		this.semestre = value;
	}
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setId_carrera(entidades.Carrera value) {
		if (id_carrera != null) {
			id_carrera.asignatura.remove(this);
		}
		if (value != null) {
			value.asignatura.add(this);
		}
	}
	
	public entidades.Carrera getId_carrera() {
		return id_carrera;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_carrera(entidades.Carrera value) {
		this.id_carrera = value;
	}
	
	private entidades.Carrera getORM_Id_carrera() {
		return id_carrera;
	}
	
	public void setId_profesor(entidades.Profesor value) {
		if (id_profesor != null) {
			id_profesor.asignatura.remove(this);
		}
		if (value != null) {
			value.asignatura.add(this);
		}
	}
	
	public entidades.Profesor getId_profesor() {
		return id_profesor;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Id_profesor(entidades.Profesor value) {
		this.id_profesor = value;
	}
	
	private entidades.Profesor getORM_Id_profesor() {
		return id_profesor;
	}
	
	private void setORM_Asiganutra_estudiante(java.util.Set value) {
		this.ORM_asiganutra_estudiante = value;
	}
	
	private java.util.Set getORM_Asiganutra_estudiante() {
		return ORM_asiganutra_estudiante;
	}
	
	public final entidades.Asiganutra_estudianteSetCollection asiganutra_estudiante = new entidades.Asiganutra_estudianteSetCollection(this, _ormAdapter, ORMConstants.KEY_ASIGNATURA_ASIGANUTRA_ESTUDIANTE, ORMConstants.KEY_ASIGANUTRA_ESTUDIANTE_ID_ASIGNATURA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Convocatoria(java.util.Set value) {
		this.ORM_convocatoria = value;
	}
	
	private java.util.Set getORM_Convocatoria() {
		return ORM_convocatoria;
	}
	
	public final entidades.ConvocatoriaSetCollection convocatoria = new entidades.ConvocatoriaSetCollection(this, _ormAdapter, ORMConstants.KEY_ASIGNATURA_CONVOCATORIA, ORMConstants.KEY_CONVOCATORIA_ID_ASIGNATURA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
