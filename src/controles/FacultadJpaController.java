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
import entidades.Carrera;
import entidades.Facultad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class FacultadJpaController implements Serializable {

    public FacultadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Facultad facultad) throws PreexistingEntityException, Exception {
        if (facultad.getCarreraList() == null) {
            facultad.setCarreraList(new ArrayList<Carrera>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Carrera> attachedCarreraList = new ArrayList<Carrera>();
            for (Carrera carreraListCarreraToAttach : facultad.getCarreraList()) {
                carreraListCarreraToAttach = em.getReference(carreraListCarreraToAttach.getClass(), carreraListCarreraToAttach.getId());
                attachedCarreraList.add(carreraListCarreraToAttach);
            }
            facultad.setCarreraList(attachedCarreraList);
            em.persist(facultad);
            for (Carrera carreraListCarrera : facultad.getCarreraList()) {
                Facultad oldIdFacultadOfCarreraListCarrera = carreraListCarrera.getIdFacultad();
                carreraListCarrera.setIdFacultad(facultad);
                carreraListCarrera = em.merge(carreraListCarrera);
                if (oldIdFacultadOfCarreraListCarrera != null) {
                    oldIdFacultadOfCarreraListCarrera.getCarreraList().remove(carreraListCarrera);
                    oldIdFacultadOfCarreraListCarrera = em.merge(oldIdFacultadOfCarreraListCarrera);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFacultad(facultad.getId()) != null) {
                throw new PreexistingEntityException("Facultad " + facultad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Facultad facultad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Facultad persistentFacultad = em.find(Facultad.class, facultad.getId());
            List<Carrera> carreraListOld = persistentFacultad.getCarreraList();
            List<Carrera> carreraListNew = facultad.getCarreraList();
            List<String> illegalOrphanMessages = null;
            for (Carrera carreraListOldCarrera : carreraListOld) {
                if (!carreraListNew.contains(carreraListOldCarrera)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Carrera " + carreraListOldCarrera + " since its idFacultad field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Carrera> attachedCarreraListNew = new ArrayList<Carrera>();
            for (Carrera carreraListNewCarreraToAttach : carreraListNew) {
                carreraListNewCarreraToAttach = em.getReference(carreraListNewCarreraToAttach.getClass(), carreraListNewCarreraToAttach.getId());
                attachedCarreraListNew.add(carreraListNewCarreraToAttach);
            }
            carreraListNew = attachedCarreraListNew;
            facultad.setCarreraList(carreraListNew);
            facultad = em.merge(facultad);
            for (Carrera carreraListNewCarrera : carreraListNew) {
                if (!carreraListOld.contains(carreraListNewCarrera)) {
                    Facultad oldIdFacultadOfCarreraListNewCarrera = carreraListNewCarrera.getIdFacultad();
                    carreraListNewCarrera.setIdFacultad(facultad);
                    carreraListNewCarrera = em.merge(carreraListNewCarrera);
                    if (oldIdFacultadOfCarreraListNewCarrera != null && !oldIdFacultadOfCarreraListNewCarrera.equals(facultad)) {
                        oldIdFacultadOfCarreraListNewCarrera.getCarreraList().remove(carreraListNewCarrera);
                        oldIdFacultadOfCarreraListNewCarrera = em.merge(oldIdFacultadOfCarreraListNewCarrera);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facultad.getId();
                if (findFacultad(id) == null) {
                    throw new NonexistentEntityException("The facultad with id " + id + " no longer exists.");
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
            Facultad facultad;
            try {
                facultad = em.getReference(Facultad.class, id);
                facultad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facultad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Carrera> carreraListOrphanCheck = facultad.getCarreraList();
            for (Carrera carreraListOrphanCheckCarrera : carreraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Facultad (" + facultad + ") cannot be destroyed since the Carrera " + carreraListOrphanCheckCarrera + " in its carreraList field has a non-nullable idFacultad field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(facultad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Facultad> findFacultadEntities() {
        return findFacultadEntities(true, -1, -1);
    }

    public List<Facultad> findFacultadEntities(int maxResults, int firstResult) {
        return findFacultadEntities(false, maxResults, firstResult);
    }

    private List<Facultad> findFacultadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Facultad.class));
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

    public Facultad findFacultad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Facultad.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacultadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Facultad> rt = cq.from(Facultad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
