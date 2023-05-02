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
import entidades.AsignaturaEstudiante;
import java.util.ArrayList;
import java.util.List;
import entidades.Convocatoria;
import entidades.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rene2
 */
public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudiante estudiante) throws PreexistingEntityException, Exception {
        if (estudiante.getAsignaturaEstudianteList() == null) {
            estudiante.setAsignaturaEstudianteList(new ArrayList<AsignaturaEstudiante>());
        }
        if (estudiante.getConvocatoriaList() == null) {
            estudiante.setConvocatoriaList(new ArrayList<Convocatoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AsignaturaEstudiante> attachedAsignaturaEstudianteList = new ArrayList<AsignaturaEstudiante>();
            for (AsignaturaEstudiante asignaturaEstudianteListAsignaturaEstudianteToAttach : estudiante.getAsignaturaEstudianteList()) {
                asignaturaEstudianteListAsignaturaEstudianteToAttach = em.getReference(asignaturaEstudianteListAsignaturaEstudianteToAttach.getClass(), asignaturaEstudianteListAsignaturaEstudianteToAttach.getId());
                attachedAsignaturaEstudianteList.add(asignaturaEstudianteListAsignaturaEstudianteToAttach);
            }
            estudiante.setAsignaturaEstudianteList(attachedAsignaturaEstudianteList);
            List<Convocatoria> attachedConvocatoriaList = new ArrayList<Convocatoria>();
            for (Convocatoria convocatoriaListConvocatoriaToAttach : estudiante.getConvocatoriaList()) {
                convocatoriaListConvocatoriaToAttach = em.getReference(convocatoriaListConvocatoriaToAttach.getClass(), convocatoriaListConvocatoriaToAttach.getId());
                attachedConvocatoriaList.add(convocatoriaListConvocatoriaToAttach);
            }
            estudiante.setConvocatoriaList(attachedConvocatoriaList);
            em.persist(estudiante);
            for (AsignaturaEstudiante asignaturaEstudianteListAsignaturaEstudiante : estudiante.getAsignaturaEstudianteList()) {
                Estudiante oldIdEstudianteOfAsignaturaEstudianteListAsignaturaEstudiante = asignaturaEstudianteListAsignaturaEstudiante.getIdEstudiante();
                asignaturaEstudianteListAsignaturaEstudiante.setIdEstudiante(estudiante);
                asignaturaEstudianteListAsignaturaEstudiante = em.merge(asignaturaEstudianteListAsignaturaEstudiante);
                if (oldIdEstudianteOfAsignaturaEstudianteListAsignaturaEstudiante != null) {
                    oldIdEstudianteOfAsignaturaEstudianteListAsignaturaEstudiante.getAsignaturaEstudianteList().remove(asignaturaEstudianteListAsignaturaEstudiante);
                    oldIdEstudianteOfAsignaturaEstudianteListAsignaturaEstudiante = em.merge(oldIdEstudianteOfAsignaturaEstudianteListAsignaturaEstudiante);
                }
            }
            for (Convocatoria convocatoriaListConvocatoria : estudiante.getConvocatoriaList()) {
                Estudiante oldIdEstudianteOfConvocatoriaListConvocatoria = convocatoriaListConvocatoria.getIdEstudiante();
                convocatoriaListConvocatoria.setIdEstudiante(estudiante);
                convocatoriaListConvocatoria = em.merge(convocatoriaListConvocatoria);
                if (oldIdEstudianteOfConvocatoriaListConvocatoria != null) {
                    oldIdEstudianteOfConvocatoriaListConvocatoria.getConvocatoriaList().remove(convocatoriaListConvocatoria);
                    oldIdEstudianteOfConvocatoriaListConvocatoria = em.merge(oldIdEstudianteOfConvocatoriaListConvocatoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstudiante(estudiante.getId()) != null) {
                throw new PreexistingEntityException("Estudiante " + estudiante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudiante estudiante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getId());
            List<AsignaturaEstudiante> asignaturaEstudianteListOld = persistentEstudiante.getAsignaturaEstudianteList();
            List<AsignaturaEstudiante> asignaturaEstudianteListNew = estudiante.getAsignaturaEstudianteList();
            List<Convocatoria> convocatoriaListOld = persistentEstudiante.getConvocatoriaList();
            List<Convocatoria> convocatoriaListNew = estudiante.getConvocatoriaList();
            List<String> illegalOrphanMessages = null;
            for (AsignaturaEstudiante asignaturaEstudianteListOldAsignaturaEstudiante : asignaturaEstudianteListOld) {
                if (!asignaturaEstudianteListNew.contains(asignaturaEstudianteListOldAsignaturaEstudiante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsignaturaEstudiante " + asignaturaEstudianteListOldAsignaturaEstudiante + " since its idEstudiante field is not nullable.");
                }
            }
            for (Convocatoria convocatoriaListOldConvocatoria : convocatoriaListOld) {
                if (!convocatoriaListNew.contains(convocatoriaListOldConvocatoria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Convocatoria " + convocatoriaListOldConvocatoria + " since its idEstudiante field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<AsignaturaEstudiante> attachedAsignaturaEstudianteListNew = new ArrayList<AsignaturaEstudiante>();
            for (AsignaturaEstudiante asignaturaEstudianteListNewAsignaturaEstudianteToAttach : asignaturaEstudianteListNew) {
                asignaturaEstudianteListNewAsignaturaEstudianteToAttach = em.getReference(asignaturaEstudianteListNewAsignaturaEstudianteToAttach.getClass(), asignaturaEstudianteListNewAsignaturaEstudianteToAttach.getId());
                attachedAsignaturaEstudianteListNew.add(asignaturaEstudianteListNewAsignaturaEstudianteToAttach);
            }
            asignaturaEstudianteListNew = attachedAsignaturaEstudianteListNew;
            estudiante.setAsignaturaEstudianteList(asignaturaEstudianteListNew);
            List<Convocatoria> attachedConvocatoriaListNew = new ArrayList<Convocatoria>();
            for (Convocatoria convocatoriaListNewConvocatoriaToAttach : convocatoriaListNew) {
                convocatoriaListNewConvocatoriaToAttach = em.getReference(convocatoriaListNewConvocatoriaToAttach.getClass(), convocatoriaListNewConvocatoriaToAttach.getId());
                attachedConvocatoriaListNew.add(convocatoriaListNewConvocatoriaToAttach);
            }
            convocatoriaListNew = attachedConvocatoriaListNew;
            estudiante.setConvocatoriaList(convocatoriaListNew);
            estudiante = em.merge(estudiante);
            for (AsignaturaEstudiante asignaturaEstudianteListNewAsignaturaEstudiante : asignaturaEstudianteListNew) {
                if (!asignaturaEstudianteListOld.contains(asignaturaEstudianteListNewAsignaturaEstudiante)) {
                    Estudiante oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante = asignaturaEstudianteListNewAsignaturaEstudiante.getIdEstudiante();
                    asignaturaEstudianteListNewAsignaturaEstudiante.setIdEstudiante(estudiante);
                    asignaturaEstudianteListNewAsignaturaEstudiante = em.merge(asignaturaEstudianteListNewAsignaturaEstudiante);
                    if (oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante != null && !oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante.equals(estudiante)) {
                        oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante.getAsignaturaEstudianteList().remove(asignaturaEstudianteListNewAsignaturaEstudiante);
                        oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante = em.merge(oldIdEstudianteOfAsignaturaEstudianteListNewAsignaturaEstudiante);
                    }
                }
            }
            for (Convocatoria convocatoriaListNewConvocatoria : convocatoriaListNew) {
                if (!convocatoriaListOld.contains(convocatoriaListNewConvocatoria)) {
                    Estudiante oldIdEstudianteOfConvocatoriaListNewConvocatoria = convocatoriaListNewConvocatoria.getIdEstudiante();
                    convocatoriaListNewConvocatoria.setIdEstudiante(estudiante);
                    convocatoriaListNewConvocatoria = em.merge(convocatoriaListNewConvocatoria);
                    if (oldIdEstudianteOfConvocatoriaListNewConvocatoria != null && !oldIdEstudianteOfConvocatoriaListNewConvocatoria.equals(estudiante)) {
                        oldIdEstudianteOfConvocatoriaListNewConvocatoria.getConvocatoriaList().remove(convocatoriaListNewConvocatoria);
                        oldIdEstudianteOfConvocatoriaListNewConvocatoria = em.merge(oldIdEstudianteOfConvocatoriaListNewConvocatoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudiante.getId();
                if (findEstudiante(id) == null) {
                    throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.");
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
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsignaturaEstudiante> asignaturaEstudianteListOrphanCheck = estudiante.getAsignaturaEstudianteList();
            for (AsignaturaEstudiante asignaturaEstudianteListOrphanCheckAsignaturaEstudiante : asignaturaEstudianteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the AsignaturaEstudiante " + asignaturaEstudianteListOrphanCheckAsignaturaEstudiante + " in its asignaturaEstudianteList field has a non-nullable idEstudiante field.");
            }
            List<Convocatoria> convocatoriaListOrphanCheck = estudiante.getConvocatoriaList();
            for (Convocatoria convocatoriaListOrphanCheckConvocatoria : convocatoriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Convocatoria " + convocatoriaListOrphanCheckConvocatoria + " in its convocatoriaList field has a non-nullable idEstudiante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
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

    public Estudiante findEstudiante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
