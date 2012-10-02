/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvOrgEven;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvOrgEvenPK;
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
public class M4ccbCvOrgEvenJpaController implements Serializable {

    public M4ccbCvOrgEvenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvOrgEven m4ccbCvOrgEven) throws PreexistingEntityException, Exception {
        if (m4ccbCvOrgEven.getM4ccbCvOrgEvenPK() == null) {
            m4ccbCvOrgEven.setM4ccbCvOrgEvenPK(new M4ccbCvOrgEvenPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvOrgEven);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvOrgEven(m4ccbCvOrgEven.getM4ccbCvOrgEvenPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvOrgEven " + m4ccbCvOrgEven + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvOrgEven m4ccbCvOrgEven) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvOrgEven = em.merge(m4ccbCvOrgEven);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvOrgEvenPK id = m4ccbCvOrgEven.getM4ccbCvOrgEvenPK();
                if (findM4ccbCvOrgEven(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvOrgEven with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvOrgEvenPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvOrgEven m4ccbCvOrgEven;
            try {
                m4ccbCvOrgEven = em.getReference(M4ccbCvOrgEven.class, id);
                m4ccbCvOrgEven.getM4ccbCvOrgEvenPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvOrgEven with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvOrgEven);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvOrgEven> findM4ccbCvOrgEvenEntities() {
        return findM4ccbCvOrgEvenEntities(true, -1, -1);
    }

    public List<M4ccbCvOrgEven> findM4ccbCvOrgEvenEntities(int maxResults, int firstResult) {
        return findM4ccbCvOrgEvenEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvOrgEven> findM4ccbCvOrgEvenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvOrgEven.class));
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

    public M4ccbCvOrgEven findM4ccbCvOrgEven(M4ccbCvOrgEvenPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvOrgEven.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvOrgEvenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvOrgEven> rt = cq.from(M4ccbCvOrgEven.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
