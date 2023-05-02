/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.NonexistentEntityException;
import controles.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Estudiante;
import entidades.Asignatura;
import entidades.AsignaturaEstudiante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class AsignaturaEstudianteJpaController implements Serializable {

    public AsignaturaEstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignaturaEstudiante asignaturaEstudiante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante idEstudiante = asignaturaEstudiante.getIdEstudiante();
            if (idEstudiante != null) {
                idEstudiante = em.getReference(idEstudiante.getClass(), idEstudiante.getId());
                asignaturaEstudiante.setIdEstudiante(idEstudiante);
            }
            Asignatura idAsignatura = asignaturaEstudiante.getIdAsignatura();
            if (idAsignatura != null) {
                idAsignatura = em.getReference(idAsignatura.getClass(), idAsignatura.getId());
                asignaturaEstudiante.setIdAsignatura(idAsignatura);
            }
            em.persist(asignaturaEstudiante);
            if (idEstudiante != null) {
                idEstudiante.getAsignaturaEstudianteList().add(asignaturaEstudiante);
                idEstudiante = em.merge(idEstudiante);
            }
            if (idAsignatura != null) {
                idAsignatura.getAsignaturaEstudianteList().add(asignaturaEstudiante);
                idAsignatura = em.merge(idAsignatura);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsignaturaEstudiante(asignaturaEstudiante.getId()) != null) {
                throw new PreexistingEntityException("AsignaturaEstudiante " + asignaturaEstudiante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsignaturaEstudiante asignaturaEstudiante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AsignaturaEstudiante persistentAsignaturaEstudiante = em.find(AsignaturaEstudiante.class, asignaturaEstudiante.getId());
            Estudiante idEstudianteOld = persistentAsignaturaEstudiante.getIdEstudiante();
            Estudiante idEstudianteNew = asignaturaEstudiante.getIdEstudiante();
            Asignatura idAsignaturaOld = persistentAsignaturaEstudiante.getIdAsignatura();
            Asignatura idAsignaturaNew = asignaturaEstudiante.getIdAsignatura();
            if (idEstudianteNew != null) {
                idEstudianteNew = em.getReference(idEstudianteNew.getClass(), idEstudianteNew.getId());
                asignaturaEstudiante.setIdEstudiante(idEstudianteNew);
            }
            if (idAsignaturaNew != null) {
                idAsignaturaNew = em.getReference(idAsignaturaNew.getClass(), idAsignaturaNew.getId());
                asignaturaEstudiante.setIdAsignatura(idAsignaturaNew);
            }
            asignaturaEstudiante = em.merge(asignaturaEstudiante);
            if (idEstudianteOld != null && !idEstudianteOld.equals(idEstudianteNew)) {
                idEstudianteOld.getAsignaturaEstudianteList().remove(asignaturaEstudiante);
                idEstudianteOld = em.merge(idEstudianteOld);
            }
            if (idEstudianteNew != null && !idEstudianteNew.equals(idEstudianteOld)) {
                idEstudianteNew.getAsignaturaEstudianteList().add(asignaturaEstudiante);
                idEstudianteNew = em.merge(idEstudianteNew);
            }
            if (idAsignaturaOld != null && !idAsignaturaOld.equals(idAsignaturaNew)) {
                idAsignaturaOld.getAsignaturaEstudianteList().remove(asignaturaEstudiante);
                idAsignaturaOld = em.merge(idAsignaturaOld);
            }
            if (idAsignaturaNew != null && !idAsignaturaNew.equals(idAsignaturaOld)) {
                idAsignaturaNew.getAsignaturaEstudianteList().add(asignaturaEstudiante);
                idAsignaturaNew = em.merge(idAsignaturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asignaturaEstudiante.getId();
                if (findAsignaturaEstudiante(id) == null) {
                    throw new NonexistentEntityException("The asignaturaEstudiante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AsignaturaEstudiante asignaturaEstudiante;
            try {
                asignaturaEstudiante = em.getReference(AsignaturaEstudiante.class, id);
                asignaturaEstudiante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignaturaEstudiante with id " + id + " no longer exists.", enfe);
            }
            Estudiante idEstudiante = asignaturaEstudiante.getIdEstudiante();
            if (idEstudiante != null) {
                idEstudiante.getAsignaturaEstudianteList().remove(asignaturaEstudiante);
                idEstudiante = em.merge(idEstudiante);
            }
            Asignatura idAsignatura = asignaturaEstudiante.getIdAsignatura();
            if (idAsignatura != null) {
                idAsignatura.getAsignaturaEstudianteList().remove(asignaturaEstudiante);
                idAsignatura = em.merge(idAsignatura);
            }
            em.remove(asignaturaEstudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsignaturaEstudiante> findAsignaturaEstudianteEntities() {
        return findAsignaturaEstudianteEntities(true, -1, -1);
    }

    public List<AsignaturaEstudiante> findAsignaturaEstudianteEntities(int maxResults, int firstResult) {
        return findAsignaturaEstudianteEntities(false, maxResults, firstResult);
    }

    private List<AsignaturaEstudiante> findAsignaturaEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignaturaEstudiante.class));
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

    public AsignaturaEstudiante findAsignaturaEstudiante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignaturaEstudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignaturaEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignaturaEstudiante> rt = cq.from(AsignaturaEstudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
