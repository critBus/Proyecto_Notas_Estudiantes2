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
import entidades.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class ProfesorJpaController implements Serializable {

    public ProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesor profesor) throws PreexistingEntityException, Exception {
        if (profesor.getAsignaturaList() == null) {
            profesor.setAsignaturaList(new ArrayList<Asignatura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Asignatura> attachedAsignaturaList = new ArrayList<Asignatura>();
            for (Asignatura asignaturaListAsignaturaToAttach : profesor.getAsignaturaList()) {
                asignaturaListAsignaturaToAttach = em.getReference(asignaturaListAsignaturaToAttach.getClass(), asignaturaListAsignaturaToAttach.getId());
                attachedAsignaturaList.add(asignaturaListAsignaturaToAttach);
            }
            profesor.setAsignaturaList(attachedAsignaturaList);
            em.persist(profesor);
            for (Asignatura asignaturaListAsignatura : profesor.getAsignaturaList()) {
                Profesor oldIdProfesorOfAsignaturaListAsignatura = asignaturaListAsignatura.getIdProfesor();
                asignaturaListAsignatura.setIdProfesor(profesor);
                asignaturaListAsignatura = em.merge(asignaturaListAsignatura);
                if (oldIdProfesorOfAsignaturaListAsignatura != null) {
                    oldIdProfesorOfAsignaturaListAsignatura.getAsignaturaList().remove(asignaturaListAsignatura);
                    oldIdProfesorOfAsignaturaListAsignatura = em.merge(oldIdProfesorOfAsignaturaListAsignatura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProfesor(profesor.getId()) != null) {
                throw new PreexistingEntityException("Profesor " + profesor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesor profesor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor persistentProfesor = em.find(Profesor.class, profesor.getId());
            List<Asignatura> asignaturaListOld = persistentProfesor.getAsignaturaList();
            List<Asignatura> asignaturaListNew = profesor.getAsignaturaList();
            List<Asignatura> attachedAsignaturaListNew = new ArrayList<Asignatura>();
            for (Asignatura asignaturaListNewAsignaturaToAttach : asignaturaListNew) {
                asignaturaListNewAsignaturaToAttach = em.getReference(asignaturaListNewAsignaturaToAttach.getClass(), asignaturaListNewAsignaturaToAttach.getId());
                attachedAsignaturaListNew.add(asignaturaListNewAsignaturaToAttach);
            }
            asignaturaListNew = attachedAsignaturaListNew;
            profesor.setAsignaturaList(asignaturaListNew);
            profesor = em.merge(profesor);
            for (Asignatura asignaturaListOldAsignatura : asignaturaListOld) {
                if (!asignaturaListNew.contains(asignaturaListOldAsignatura)) {
                    asignaturaListOldAsignatura.setIdProfesor(null);
                    asignaturaListOldAsignatura = em.merge(asignaturaListOldAsignatura);
                }
            }
            for (Asignatura asignaturaListNewAsignatura : asignaturaListNew) {
                if (!asignaturaListOld.contains(asignaturaListNewAsignatura)) {
                    Profesor oldIdProfesorOfAsignaturaListNewAsignatura = asignaturaListNewAsignatura.getIdProfesor();
                    asignaturaListNewAsignatura.setIdProfesor(profesor);
                    asignaturaListNewAsignatura = em.merge(asignaturaListNewAsignatura);
                    if (oldIdProfesorOfAsignaturaListNewAsignatura != null && !oldIdProfesorOfAsignaturaListNewAsignatura.equals(profesor)) {
                        oldIdProfesorOfAsignaturaListNewAsignatura.getAsignaturaList().remove(asignaturaListNewAsignatura);
                        oldIdProfesorOfAsignaturaListNewAsignatura = em.merge(oldIdProfesorOfAsignaturaListNewAsignatura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profesor.getId();
                if (findProfesor(id) == null) {
                    throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.");
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
            Profesor profesor;
            try {
                profesor = em.getReference(Profesor.class, id);
                profesor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.", enfe);
            }
            List<Asignatura> asignaturaList = profesor.getAsignaturaList();
            for (Asignatura asignaturaListAsignatura : asignaturaList) {
                asignaturaListAsignatura.setIdProfesor(null);
                asignaturaListAsignatura = em.merge(asignaturaListAsignatura);
            }
            em.remove(profesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profesor> findProfesorEntities() {
        return findProfesorEntities(true, -1, -1);
    }

    public List<Profesor> findProfesorEntities(int maxResults, int firstResult) {
        return findProfesorEntities(false, maxResults, firstResult);
    }

    private List<Profesor> findProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesor.class));
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

    public Profesor findProfesor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesor> rt = cq.from(Profesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
