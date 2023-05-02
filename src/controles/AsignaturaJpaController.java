/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.IllegalOrphanException;
import controles.exceptions.NonexistentEntityException;
import controles.exceptions.PreexistingEntityException;
import entidades.Asignatura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Profesor;
import entidades.Carrera;
import entidades.AsignaturaEstudiante;
import java.util.ArrayList;
import java.util.List;
import entidades.Convocatoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class AsignaturaJpaController implements Serializable {

    public AsignaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Asignatura asignatura) throws PreexistingEntityException, Exception {
        if (asignatura.getAsignaturaEstudianteList() == null) {
            asignatura.setAsignaturaEstudianteList(new ArrayList<AsignaturaEstudiante>());
        }
        if (asignatura.getConvocatoriaList() == null) {
            asignatura.setConvocatoriaList(new ArrayList<Convocatoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor idProfesor = asignatura.getIdProfesor();
            if (idProfesor != null) {
                idProfesor = em.getReference(idProfesor.getClass(), idProfesor.getId());
                asignatura.setIdProfesor(idProfesor);
            }
            Carrera idCarrera = asignatura.getIdCarrera();
            if (idCarrera != null) {
                idCarrera = em.getReference(idCarrera.getClass(), idCarrera.getId());
                asignatura.setIdCarrera(idCarrera);
            }
            List<AsignaturaEstudiante> attachedAsignaturaEstudianteList = new ArrayList<AsignaturaEstudiante>();
            for (AsignaturaEstudiante asignaturaEstudianteListAsignaturaEstudianteToAttach : asignatura.getAsignaturaEstudianteList()) {
                asignaturaEstudianteListAsignaturaEstudianteToAttach = em.getReference(asignaturaEstudianteListAsignaturaEstudianteToAttach.getClass(), asignaturaEstudianteListAsignaturaEstudianteToAttach.getId());
                attachedAsignaturaEstudianteList.add(asignaturaEstudianteListAsignaturaEstudianteToAttach);
            }
            asignatura.setAsignaturaEstudianteList(attachedAsignaturaEstudianteList);
            List<Convocatoria> attachedConvocatoriaList = new ArrayList<Convocatoria>();
            for (Convocatoria convocatoriaListConvocatoriaToAttach : asignatura.getConvocatoriaList()) {
                convocatoriaListConvocatoriaToAttach = em.getReference(convocatoriaListConvocatoriaToAttach.getClass(), convocatoriaListConvocatoriaToAttach.getId());
                attachedConvocatoriaList.add(convocatoriaListConvocatoriaToAttach);
            }
            asignatura.setConvocatoriaList(attachedConvocatoriaList);
            em.persist(asignatura);
            if (idProfesor != null) {
                idProfesor.getAsignaturaList().add(asignatura);
                idProfesor = em.merge(idProfesor);
            }
            if (idCarrera != null) {
                idCarrera.getAsignaturaList().add(asignatura);
                idCarrera = em.merge(idCarrera);
            }
            for (AsignaturaEstudiante asignaturaEstudianteListAsignaturaEstudiante : asignatura.getAsignaturaEstudianteList()) {
                Asignatura oldIdAsignaturaOfAsignaturaEstudianteListAsignaturaEstudiante = asignaturaEstudianteListAsignaturaEstudiante.getIdAsignatura();
                asignaturaEstudianteListAsignaturaEstudiante.setIdAsignatura(asignatura);
                asignaturaEstudianteListAsignaturaEstudiante = em.merge(asignaturaEstudianteListAsignaturaEstudiante);
                if (oldIdAsignaturaOfAsignaturaEstudianteListAsignaturaEstudiante != null) {
                    oldIdAsignaturaOfAsignaturaEstudianteListAsignaturaEstudiante.getAsignaturaEstudianteList().remove(asignaturaEstudianteListAsignaturaEstudiante);
                    oldIdAsignaturaOfAsignaturaEstudianteListAsignaturaEstudiante = em.merge(oldIdAsignaturaOfAsignaturaEstudianteListAsignaturaEstudiante);
                }
            }
            for (Convocatoria convocatoriaListConvocatoria : asignatura.getConvocatoriaList()) {
                Asignatura oldIdAsignaturaOfConvocatoriaListConvocatoria = convocatoriaListConvocatoria.getIdAsignatura();
                convocatoriaListConvocatoria.setIdAsignatura(asignatura);
                convocatoriaListConvocatoria = em.merge(convocatoriaListConvocatoria);
                if (oldIdAsignaturaOfConvocatoriaListConvocatoria != null) {
                    oldIdAsignaturaOfConvocatoriaListConvocatoria.getConvocatoriaList().remove(convocatoriaListConvocatoria);
                    oldIdAsignaturaOfConvocatoriaListConvocatoria = em.merge(oldIdAsignaturaOfConvocatoriaListConvocatoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsignatura(asignatura.getId()) != null) {
                throw new PreexistingEntityException("Asignatura " + asignatura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asignatura asignatura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asignatura persistentAsignatura = em.find(Asignatura.class, asignatura.getId());
            Profesor idProfesorOld = persistentAsignatura.getIdProfesor();
            Profesor idProfesorNew = asignatura.getIdProfesor();
            Carrera idCarreraOld = persistentAsignatura.getIdCarrera();
            Carrera idCarreraNew = asignatura.getIdCarrera();
            List<AsignaturaEstudiante> asignaturaEstudianteListOld = persistentAsignatura.getAsignaturaEstudianteList();
            List<AsignaturaEstudiante> asignaturaEstudianteListNew = asignatura.getAsignaturaEstudianteList();
            List<Convocatoria> convocatoriaListOld = persistentAsignatura.getConvocatoriaList();
            List<Convocatoria> convocatoriaListNew = asignatura.getConvocatoriaList();
            List<String> illegalOrphanMessages = null;
            for (AsignaturaEstudiante asignaturaEstudianteListOldAsignaturaEstudiante : asignaturaEstudianteListOld) {
                if (!asignaturaEstudianteListNew.contains(asignaturaEstudianteListOldAsignaturaEstudiante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsignaturaEstudiante " + asignaturaEstudianteListOldAsignaturaEstudiante + " since its idAsignatura field is not nullable.");
                }
            }
            for (Convocatoria convocatoriaListOldConvocatoria : convocatoriaListOld) {
                if (!convocatoriaListNew.contains(convocatoriaListOldConvocatoria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Convocatoria " + convocatoriaListOldConvocatoria + " since its idAsignatura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idProfesorNew != null) {
                idProfesorNew = em.getReference(idProfesorNew.getClass(), idProfesorNew.getId());
                asignatura.setIdProfesor(idProfesorNew);
            }
            if (idCarreraNew != null) {
                idCarreraNew = em.getReference(idCarreraNew.getClass(), idCarreraNew.getId());
                asignatura.setIdCarrera(idCarreraNew);
            }
            List<AsignaturaEstudiante> attachedAsignaturaEstudianteListNew = new ArrayList<AsignaturaEstudiante>();
            for (AsignaturaEstudiante asignaturaEstudianteListNewAsignaturaEstudianteToAttach : asignaturaEstudianteListNew) {
                asignaturaEstudianteListNewAsignaturaEstudianteToAttach = em.getReference(asignaturaEstudianteListNewAsignaturaEstudianteToAttach.getClass(), asignaturaEstudianteListNewAsignaturaEstudianteToAttach.getId());
                attachedAsignaturaEstudianteListNew.add(asignaturaEstudianteListNewAsignaturaEstudianteToAttach);
            }
            asignaturaEstudianteListNew = attachedAsignaturaEstudianteListNew;
            asignatura.setAsignaturaEstudianteList(asignaturaEstudianteListNew);
            List<Convocatoria> attachedConvocatoriaListNew = new ArrayList<Convocatoria>();
            for (Convocatoria convocatoriaListNewConvocatoriaToAttach : convocatoriaListNew) {
                convocatoriaListNewConvocatoriaToAttach = em.getReference(convocatoriaListNewConvocatoriaToAttach.getClass(), convocatoriaListNewConvocatoriaToAttach.getId());
                attachedConvocatoriaListNew.add(convocatoriaListNewConvocatoriaToAttach);
            }
            convocatoriaListNew = attachedConvocatoriaListNew;
            asignatura.setConvocatoriaList(convocatoriaListNew);
            asignatura = em.merge(asignatura);
            if (idProfesorOld != null && !idProfesorOld.equals(idProfesorNew)) {
                idProfesorOld.getAsignaturaList().remove(asignatura);
                idProfesorOld = em.merge(idProfesorOld);
            }
            if (idProfesorNew != null && !idProfesorNew.equals(idProfesorOld)) {
                idProfesorNew.getAsignaturaList().add(asignatura);
                idProfesorNew = em.merge(idProfesorNew);
            }
            if (idCarreraOld != null && !idCarreraOld.equals(idCarreraNew)) {
                idCarreraOld.getAsignaturaList().remove(asignatura);
                idCarreraOld = em.merge(idCarreraOld);
            }
            if (idCarreraNew != null && !idCarreraNew.equals(idCarreraOld)) {
                idCarreraNew.getAsignaturaList().add(asignatura);
                idCarreraNew = em.merge(idCarreraNew);
            }
            for (AsignaturaEstudiante asignaturaEstudianteListNewAsignaturaEstudiante : asignaturaEstudianteListNew) {
                if (!asignaturaEstudianteListOld.contains(asignaturaEstudianteListNewAsignaturaEstudiante)) {
                    Asignatura oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante = asignaturaEstudianteListNewAsignaturaEstudiante.getIdAsignatura();
                    asignaturaEstudianteListNewAsignaturaEstudiante.setIdAsignatura(asignatura);
                    asignaturaEstudianteListNewAsignaturaEstudiante = em.merge(asignaturaEstudianteListNewAsignaturaEstudiante);
                    if (oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante != null && !oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante.equals(asignatura)) {
                        oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante.getAsignaturaEstudianteList().remove(asignaturaEstudianteListNewAsignaturaEstudiante);
                        oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante = em.merge(oldIdAsignaturaOfAsignaturaEstudianteListNewAsignaturaEstudiante);
                    }
                }
            }
            for (Convocatoria convocatoriaListNewConvocatoria : convocatoriaListNew) {
                if (!convocatoriaListOld.contains(convocatoriaListNewConvocatoria)) {
                    Asignatura oldIdAsignaturaOfConvocatoriaListNewConvocatoria = convocatoriaListNewConvocatoria.getIdAsignatura();
                    convocatoriaListNewConvocatoria.setIdAsignatura(asignatura);
                    convocatoriaListNewConvocatoria = em.merge(convocatoriaListNewConvocatoria);
                    if (oldIdAsignaturaOfConvocatoriaListNewConvocatoria != null && !oldIdAsignaturaOfConvocatoriaListNewConvocatoria.equals(asignatura)) {
                        oldIdAsignaturaOfConvocatoriaListNewConvocatoria.getConvocatoriaList().remove(convocatoriaListNewConvocatoria);
                        oldIdAsignaturaOfConvocatoriaListNewConvocatoria = em.merge(oldIdAsignaturaOfConvocatoriaListNewConvocatoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asignatura.getId();
                if (findAsignatura(id) == null) {
                    throw new NonexistentEntityException("The asignatura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asignatura asignatura;
            try {
                asignatura = em.getReference(Asignatura.class, id);
                asignatura.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignatura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsignaturaEstudiante> asignaturaEstudianteListOrphanCheck = asignatura.getAsignaturaEstudianteList();
            for (AsignaturaEstudiante asignaturaEstudianteListOrphanCheckAsignaturaEstudiante : asignaturaEstudianteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asignatura (" + asignatura + ") cannot be destroyed since the AsignaturaEstudiante " + asignaturaEstudianteListOrphanCheckAsignaturaEstudiante + " in its asignaturaEstudianteList field has a non-nullable idAsignatura field.");
            }
            List<Convocatoria> convocatoriaListOrphanCheck = asignatura.getConvocatoriaList();
            for (Convocatoria convocatoriaListOrphanCheckConvocatoria : convocatoriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Asignatura (" + asignatura + ") cannot be destroyed since the Convocatoria " + convocatoriaListOrphanCheckConvocatoria + " in its convocatoriaList field has a non-nullable idAsignatura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Profesor idProfesor = asignatura.getIdProfesor();
            if (idProfesor != null) {
                idProfesor.getAsignaturaList().remove(asignatura);
                idProfesor = em.merge(idProfesor);
            }
            Carrera idCarrera = asignatura.getIdCarrera();
            if (idCarrera != null) {
                idCarrera.getAsignaturaList().remove(asignatura);
                idCarrera = em.merge(idCarrera);
            }
            em.remove(asignatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asignatura> findAsignaturaEntities() {
        return findAsignaturaEntities(true, -1, -1);
    }

    public List<Asignatura> findAsignaturaEntities(int maxResults, int firstResult) {
        return findAsignaturaEntities(false, maxResults, firstResult);
    }

    private List<Asignatura> findAsignaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asignatura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Asignatura findAsignatura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asignatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asignatura> rt = cq.from(Asignatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
