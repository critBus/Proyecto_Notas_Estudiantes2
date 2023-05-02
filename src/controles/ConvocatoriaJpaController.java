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
import entidades.Asignatura;
import entidades.Convocatoria;
import entidades.Estudiante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class ConvocatoriaJpaController implements Serializable {

    public ConvocatoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Convocatoria convocatoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asignatura idAsignatura = convocatoria.getIdAsignatura();
            if (idAsignatura != null) {
                idAsignatura = em.getReference(idAsignatura.getClass(), idAsignatura.getId());
                convocatoria.setIdAsignatura(idAsignatura);
            }
            Estudiante idEstudiante = convocatoria.getIdEstudiante();
            if (idEstudiante != null) {
                idEstudiante = em.getReference(idEstudiante.getClass(), idEstudiante.getId());
                convocatoria.setIdEstudiante(idEstudiante);
            }
            em.persist(convocatoria);
            if (idAsignatura != null) {
                idAsignatura.getConvocatoriaList().add(convocatoria);
                idAsignatura = em.merge(idAsignatura);
            }
            if (idEstudiante != null) {
                idEstudiante.getConvocatoriaList().add(convocatoria);
                idEstudiante = em.merge(idEstudiante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConvocatoria(convocatoria.getId()) != null) {
                throw new PreexistingEntityException("Convocatoria " + convocatoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Convocatoria convocatoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Convocatoria persistentConvocatoria = em.find(Convocatoria.class, convocatoria.getId());
            Asignatura idAsignaturaOld = persistentConvocatoria.getIdAsignatura();
            Asignatura idAsignaturaNew = convocatoria.getIdAsignatura();
            Estudiante idEstudianteOld = persistentConvocatoria.getIdEstudiante();
            Estudiante idEstudianteNew = convocatoria.getIdEstudiante();
            if (idAsignaturaNew != null) {
                idAsignaturaNew = em.getReference(idAsignaturaNew.getClass(), idAsignaturaNew.getId());
                convocatoria.setIdAsignatura(idAsignaturaNew);
            }
            if (idEstudianteNew != null) {
                idEstudianteNew = em.getReference(idEstudianteNew.getClass(), idEstudianteNew.getId());
                convocatoria.setIdEstudiante(idEstudianteNew);
            }
            convocatoria = em.merge(convocatoria);
            if (idAsignaturaOld != null && !idAsignaturaOld.equals(idAsignaturaNew)) {
                idAsignaturaOld.getConvocatoriaList().remove(convocatoria);
                idAsignaturaOld = em.merge(idAsignaturaOld);
            }
            if (idAsignaturaNew != null && !idAsignaturaNew.equals(idAsignaturaOld)) {
                idAsignaturaNew.getConvocatoriaList().add(convocatoria);
                idAsignaturaNew = em.merge(idAsignaturaNew);
            }
            if (idEstudianteOld != null && !idEstudianteOld.equals(idEstudianteNew)) {
                idEstudianteOld.getConvocatoriaList().remove(convocatoria);
                idEstudianteOld = em.merge(idEstudianteOld);
            }
            if (idEstudianteNew != null && !idEstudianteNew.equals(idEstudianteOld)) {
                idEstudianteNew.getConvocatoriaList().add(convocatoria);
                idEstudianteNew = em.merge(idEstudianteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = convocatoria.getId();
                if (findConvocatoria(id) == null) {
                    throw new NonexistentEntityException("The convocatoria with id " + id + " no longer exists.");
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
            Convocatoria convocatoria;
            try {
                convocatoria = em.getReference(Convocatoria.class, id);
                convocatoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The convocatoria with id " + id + " no longer exists.", enfe);
            }
            Asignatura idAsignatura = convocatoria.getIdAsignatura();
            if (idAsignatura != null) {
                idAsignatura.getConvocatoriaList().remove(convocatoria);
                idAsignatura = em.merge(idAsignatura);
            }
            Estudiante idEstudiante = convocatoria.getIdEstudiante();
            if (idEstudiante != null) {
                idEstudiante.getConvocatoriaList().remove(convocatoria);
                idEstudiante = em.merge(idEstudiante);
            }
            em.remove(convocatoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Convocatoria> findConvocatoriaEntities() {
        return findConvocatoriaEntities(true, -1, -1);
    }

    public List<Convocatoria> findConvocatoriaEntities(int maxResults, int firstResult) {
        return findConvocatoriaEntities(false, maxResults, firstResult);
    }

    private List<Convocatoria> findConvocatoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Convocatoria.class));
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

    public Convocatoria findConvocatoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Convocatoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getConvocatoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Convocatoria> rt = cq.from(Convocatoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
