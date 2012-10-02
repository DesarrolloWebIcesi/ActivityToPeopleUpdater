/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTec;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTecPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvTrabTecJpaController implements Serializable {

    public M4ccbCvTrabTecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvTrabTec m4ccbCvTrabTec) throws PreexistingEntityException, Exception {
        if (m4ccbCvTrabTec.getM4ccbCvTrabTecPK() == null) {
            m4ccbCvTrabTec.setM4ccbCvTrabTecPK(new M4ccbCvTrabTecPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvTrabTec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvTrabTec(m4ccbCvTrabTec.getM4ccbCvTrabTecPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvTrabTec " + m4ccbCvTrabTec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvTrabTec m4ccbCvTrabTec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvTrabTec = em.merge(m4ccbCvTrabTec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvTrabTecPK id = m4ccbCvTrabTec.getM4ccbCvTrabTecPK();
                if (findM4ccbCvTrabTec(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvTrabTec with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvTrabTecPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvTrabTec m4ccbCvTrabTec;
            try {
                m4ccbCvTrabTec = em.getReference(M4ccbCvTrabTec.class, id);
                m4ccbCvTrabTec.getM4ccbCvTrabTecPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvTrabTec with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvTrabTec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvTrabTec> findM4ccbCvTrabTecEntities() {
        return findM4ccbCvTrabTecEntities(true, -1, -1);
    }

    public List<M4ccbCvTrabTec> findM4ccbCvTrabTecEntities(int maxResults, int firstResult) {
        return findM4ccbCvTrabTecEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvTrabTec> findM4ccbCvTrabTecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvTrabTec.class));
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

    public M4ccbCvTrabTec findM4ccbCvTrabTec(M4ccbCvTrabTecPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvTrabTec.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvTrabTecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvTrabTec> rt = cq.from(M4ccbCvTrabTec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
}
