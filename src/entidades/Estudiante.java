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
public class Estudiante implements Serializable {
	public Estudiante() {
	}
	
	public static Estudiante loadEstudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadEstudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante getEstudianteByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getEstudianteByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadEstudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante getEstudianteByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return getEstudianteByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Estudiante) session.load(entidades.Estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante getEstudianteByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Estudiante) session.get(entidades.Estudiante.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Estudiante) session.load(entidades.Estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante getEstudianteByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Estudiante) session.get(entidades.Estudiante.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstudiante(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryEstudiante(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstudiante(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return queryEstudiante(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante[] listEstudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listEstudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante[] listEstudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return listEstudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstudiante(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Estudiante as Estudiante");
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
	
	public static List queryEstudiante(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Estudiante as Estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Estudiante", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante[] listEstudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEstudiante(session, condition, orderBy);
			return (Estudiante[]) list.toArray(new Estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante[] listEstudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEstudiante(session, condition, orderBy, lockMode);
			return (Estudiante[]) list.toArray(new Estudiante[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadEstudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return loadEstudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Estudiante[] estudiantes = listEstudianteByQuery(session, condition, orderBy);
		if (estudiantes != null && estudiantes.length > 0)
			return estudiantes[0];
		else
			return null;
	}
	
	public static Estudiante loadEstudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Estudiante[] estudiantes = listEstudianteByQuery(session, condition, orderBy, lockMode);
		if (estudiantes != null && estudiantes.length > 0)
			return estudiantes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEstudianteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateEstudianteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEstudianteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Practicas1PersistentManager.instance().getSession();
			return iterateEstudianteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEstudianteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Estudiante as Estudiante");
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
	
	public static java.util.Iterator iterateEstudianteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From entidades.Estudiante as Estudiante");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Estudiante", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Estudiante loadEstudianteByCriteria(EstudianteCriteria estudianteCriteria) {
		Estudiante[] estudiantes = listEstudianteByCriteria(estudianteCriteria);
		if(estudiantes == null || estudiantes.length == 0) {
			return null;
		}
		return estudiantes[0];
	}
	
	public static Estudiante[] listEstudianteByCriteria(EstudianteCriteria estudianteCriteria) {
		return estudianteCriteria.listEstudiante();
	}
	
	public static Estudiante createEstudiante() {
		return new entidades.Estudiante();
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
			entidades.Asiganutra_estudiante[] lAsiganutra_estudiantes = asiganutra_estudiante.toArray();
			for(int i = 0; i < lAsiganutra_estudiantes.length; i++) {
				lAsiganutra_estudiantes[i].setId_estudiante(null);
			}
			entidades.Convocatoria[] lConvocatorias = convocatoria.toArray();
			for(int i = 0; i < lConvocatorias.length; i++) {
				lConvocatorias[i].setId_estudiante(null);
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
			entidades.Asiganutra_estudiante[] lAsiganutra_estudiantes = asiganutra_estudiante.toArray();
			for(int i = 0; i < lAsiganutra_estudiantes.length; i++) {
				lAsiganutra_estudiantes[i].setId_estudiante(null);
			}
			entidades.Convocatoria[] lConvocatorias = convocatoria.toArray();
			for(int i = 0; i < lConvocatorias.length; i++) {
				lConvocatorias[i].setId_estudiante(null);
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
		if (key == ORMConstants.KEY_ESTUDIANTE_ASIGANUTRA_ESTUDIANTE) {
			return ORM_asiganutra_estudiante;
		}
		else if (key == ORMConstants.KEY_ESTUDIANTE_CONVOCATORIA) {
			return ORM_convocatoria;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nombre;
	
	private String apellidos;
	
	private String grupo;
	
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
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellidos(String value) {
		this.apellidos = value;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setGrupo(String value) {
		this.grupo = value;
	}
	
	public String getGrupo() {
		return grupo;
	}
	
	private void setORM_Asiganutra_estudiante(java.util.Set value) {
		this.ORM_asiganutra_estudiante = value;
	}
	
	private java.util.Set getORM_Asiganutra_estudiante() {
		return ORM_asiganutra_estudiante;
	}
	
	public final entidades.Asiganutra_estudianteSetCollection asiganutra_estudiante = new entidades.Asiganutra_estudianteSetCollection(this, _ormAdapter, ORMConstants.KEY_ESTUDIANTE_ASIGANUTRA_ESTUDIANTE, ORMConstants.KEY_ASIGANUTRA_ESTUDIANTE_ID_ESTUDIANTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Convocatoria(java.util.Set value) {
		this.ORM_convocatoria = value;
	}
	
	private java.util.Set getORM_Convocatoria() {
		return ORM_convocatoria;
	}
	
	public final entidades.ConvocatoriaSetCollection convocatoria = new entidades.ConvocatoriaSetCollection(this, _ormAdapter, ORMConstants.KEY_ESTUDIANTE_CONVOCATORIA, ORMConstants.KEY_CONVOCATORIA_ID_ESTUDIANTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
