/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvNormaN;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvNormaNPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvNormaNJpaController implements Serializable {

    public M4ccbCvNormaNJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvNormaN m4ccbCvNormaN) throws PreexistingEntityException, Exception {
        if (m4ccbCvNormaN.getM4ccbCvNormaNPK() == null) {
            m4ccbCvNormaN.setM4ccbCvNormaNPK(new M4ccbCvNormaNPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvNormaN);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvNormaN(m4ccbCvNormaN.getM4ccbCvNormaNPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvNormaN " + m4ccbCvNormaN + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvNormaN m4ccbCvNormaN) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvNormaN = em.merge(m4ccbCvNormaN);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvNormaNPK id = m4ccbCvNormaN.getM4ccbCvNormaNPK();
                if (findM4ccbCvNormaN(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvNormaN with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvNormaNPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvNormaN m4ccbCvNormaN;
            try {
                m4ccbCvNormaN = em.getReference(M4ccbCvNormaN.class, id);
                m4ccbCvNormaN.getM4ccbCvNormaNPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvNormaN with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvNormaN);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvNormaN> findM4ccbCvNormaNEntities() {
        return findM4ccbCvNormaNEntities(true, -1, -1);
    }

    public List<M4ccbCvNormaN> findM4ccbCvNormaNEntities(int maxResults, int firstResult) {
        return findM4ccbCvNormaNEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvNormaN> findM4ccbCvNormaNEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvNormaN.class));
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

    public M4ccbCvNormaN findM4ccbCvNormaN(M4ccbCvNormaNPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvNormaN.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvNormaNCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvNormaN> rt = cq.from(M4ccbCvNormaN.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public  M4ccbCvNormaN findM4ccBActNormaNByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvNormaN> q= em.createNamedQuery("M4ccbCvNormaN.findByCcbCargueAct", M4ccbCvNormaN.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvNormaN activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
}
