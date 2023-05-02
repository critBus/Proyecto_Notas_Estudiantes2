/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.IllegalOrphanException;
import controles.exceptions.NonexistentEntityException;
import controles.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Facultad;
import entidades.Asignatura;
import entidades.Carrera;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class CarreraJpaController implements Serializable {

    public CarreraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carrera carrera) throws PreexistingEntityException, Exception {
        if (carrera.getAsignaturaList() == null) {
            carrera.setAsignaturaList(new ArrayList<Asignatura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Facultad idFacultad = carrera.getIdFacultad();
            if (idFacultad != null) {
                idFacultad = em.getReference(idFacultad.getClass(), idFacultad.getId());
                carrera.setIdFacultad(idFacultad);
            }
            List<Asignatura> attachedAsignaturaList = new ArrayList<Asignatura>();
            for (Asignatura asignaturaListAsignaturaToAttach : carrera.getAsignaturaList()) {
                asignaturaListAsignaturaToAttach = em.getReference(asignaturaListAsignaturaToAttach.getClass(), asignaturaListAsignaturaToAttach.getId());
                attachedAsignaturaList.add(asignaturaListAsignaturaToAttach);
            }
            carrera.setAsignaturaList(attachedAsignaturaList);
            em.persist(carrera);
            if (idFacultad != null) {
                idFacultad.getCarreraList().add(carrera);
                idFacultad = em.merge(idFacultad);
            }
            for (Asignatura asignaturaListAsignatura : carrera.getAsignaturaList()) {
                Carrera oldIdCarreraOfAsignaturaListAsignatura = asignaturaListAsignatura.getIdCarrera();
                asignaturaListAsignatura.setIdCarrera(carrera);
                asignaturaListAsignatura = em.merge(asignaturaListAsignatura);
                if (oldIdCarreraOfAsignaturaListAsignatura != null) {
                    oldIdCarreraOfAsignaturaListAsignatura.getAsignaturaList().remove(asignaturaListAsignatura);
                    oldIdCarreraOfAsignaturaListAsignatura = em.merge(oldIdCarreraOfAsignaturaListAsignatura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCarrera(carrera.getId()) != null) {
                throw new PreexistingEntityException("Carrera " + carrera + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carrera carrera) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrera persistentCarrera = em.find(Carrera.class, carrera.getId());
            Facultad idFacultadOld = persistentCarrera.getIdFacultad();
            Facultad idFacultadNew = carrera.getIdFacultad();
            List<Asignatura> asignaturaListOld = persistentCarrera.getAsignaturaList();
            List<Asignatura> asignaturaListNew = carrera.getAsignaturaList();
            List<String> illegalOrphanMessages = null;
            for (Asignatura asignaturaListOldAsignatura : asignaturaListOld) {
                if (!asignaturaListNew.contains(asignaturaListOldAsignatura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Asignatura " + asignaturaListOldAsignatura + " since its idCarrera field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idFacultadNew != null) {
                idFacultadNew = em.getReference(idFacultadNew.getClass(), idFacultadNew.getId());
                carrera.setIdFacultad(idFacultadNew);
            }
            List<Asignatura> attachedAsignaturaListNew = new ArrayList<Asignatura>();
            for (Asignatura asignaturaListNewAsignaturaToAttach : asignaturaListNew) {
                asignaturaListNewAsignaturaToAttach = em.getReference(asignaturaListNewAsignaturaToAttach.getClass(), asignaturaListNewAsignaturaToAttach.getId());
                attachedAsignaturaListNew.add(asignaturaListNewAsignaturaToAttach);
            }
            asignaturaListNew = attachedAsignaturaListNew;
            carrera.setAsignaturaList(asignaturaListNew);
            carrera = em.merge(carrera);
            if (idFacultadOld != null && !idFacultadOld.equals(idFacultadNew)) {
                idFacultadOld.getCarreraList().remove(carrera);
                idFacultadOld = em.merge(idFacultadOld);
            }
            if (idFacultadNew != null && !idFacultadNew.equals(idFacultadOld)) {
                idFacultadNew.getCarreraList().add(carrera);
                idFacultadNew = em.merge(idFacultadNew);
            }
            for (Asignatura asignaturaListNewAsignatura : asignaturaListNew) {
                if (!asignaturaListOld.contains(asignaturaListNewAsignatura)) {
                    Carrera oldIdCarreraOfAsignaturaListNewAsignatura = asignaturaListNewAsignatura.getIdCarrera();
                    asignaturaListNewAsignatura.setIdCarrera(carrera);
                    asignaturaListNewAsignatura = em.merge(asignaturaListNewAsignatura);
                    if (oldIdCarreraOfAsignaturaListNewAsignatura != null && !oldIdCarreraOfAsignaturaListNewAsignatura.equals(carrera)) {
                        oldIdCarreraOfAsignaturaListNewAsignatura.getAsignaturaList().remove(asignaturaListNewAsignatura);
                        oldIdCarreraOfAsignaturaListNewAsignatura = em.merge(oldIdCarreraOfAsignaturaListNewAsignatura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = carrera.getId();
                if (findCarrera(id) == null) {
                    throw new NonexistentEntityException("The carrera with id " + id + " no longer exists.");
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
            Carrera carrera;
            try {
                carrera = em.getReference(Carrera.class, id);
                carrera.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrera with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Asignatura> asignaturaListOrphanCheck = carrera.getAsignaturaList();
            for (Asignatura asignaturaListOrphanCheckAsignatura : asignaturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Carrera (" + carrera + ") cannot be destroyed since the Asignatura " + asignaturaListOrphanCheckAsignatura + " in its asignaturaList field has a non-nullable idCarrera field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Facultad idFacultad = carrera.getIdFacultad();
            if (idFacultad != null) {
                idFacultad.getCarreraList().remove(carrera);
                idFacultad = em.merge(idFacultad);
            }
            em.remove(carrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carrera> findCarreraEntities() {
        return findCarreraEntities(true, -1, -1);
    }

    public List<Carrera> findCarreraEntities(int maxResults, int firstResult) {
        return findCarreraEntities(false, maxResults, firstResult);
    }

    private List<Carrera> findCarreraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrera.class));
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

    public Carrera findCarrera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrera.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarreraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrera> rt = cq.from(Carrera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
