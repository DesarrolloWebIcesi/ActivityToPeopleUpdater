/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsDet;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsDetPK;
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
public class M4ccbCvConsDetJpaController implements Serializable {

    public M4ccbCvConsDetJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvConsDet m4ccbCvConsDet) throws PreexistingEntityException, Exception {
        if (m4ccbCvConsDet.getM4ccbCvConsDetPK() == null) {
            m4ccbCvConsDet.setM4ccbCvConsDetPK(new M4ccbCvConsDetPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvConsDet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvConsDet(m4ccbCvConsDet.getM4ccbCvConsDetPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvConsDet " + m4ccbCvConsDet + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvConsDet m4ccbCvConsDet) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvConsDet = em.merge(m4ccbCvConsDet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvConsDetPK id = m4ccbCvConsDet.getM4ccbCvConsDetPK();
                if (findM4ccbCvConsDet(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvConsDet with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvConsDetPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvConsDet m4ccbCvConsDet;
            try {
                m4ccbCvConsDet = em.getReference(M4ccbCvConsDet.class, id);
                m4ccbCvConsDet.getM4ccbCvConsDetPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvConsDet with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvConsDet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvConsDet> findM4ccbCvConsDetEntities() {
        return findM4ccbCvConsDetEntities(true, -1, -1);
    }

    public List<M4ccbCvConsDet> findM4ccbCvConsDetEntities(int maxResults, int firstResult) {
        return findM4ccbCvConsDetEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvConsDet> findM4ccbCvConsDetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvConsDet.class));
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

    public M4ccbCvConsDet findM4ccbCvConsDet(M4ccbCvConsDetPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvConsDet.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvConsDetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvConsDet> rt = cq.from(M4ccbCvConsDet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
