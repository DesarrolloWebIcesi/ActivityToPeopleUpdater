/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvEmpBtec;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvEmpBtecPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvEmpBtecJpaController implements Serializable {

    public M4ccbCvEmpBtecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvEmpBtec m4ccbCvEmpBtec) throws PreexistingEntityException, Exception {
        if (m4ccbCvEmpBtec.getM4ccbCvEmpBtecPK() == null) {
            m4ccbCvEmpBtec.setM4ccbCvEmpBtecPK(new M4ccbCvEmpBtecPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvEmpBtec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvEmpBtec(m4ccbCvEmpBtec.getM4ccbCvEmpBtecPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvEmpBtec " + m4ccbCvEmpBtec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvEmpBtec m4ccbCvEmpBtec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvEmpBtec = em.merge(m4ccbCvEmpBtec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvEmpBtecPK id = m4ccbCvEmpBtec.getM4ccbCvEmpBtecPK();
                if (findM4ccbCvEmpBtec(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvEmpBtec with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvEmpBtecPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvEmpBtec m4ccbCvEmpBtec;
            try {
                m4ccbCvEmpBtec = em.getReference(M4ccbCvEmpBtec.class, id);
                m4ccbCvEmpBtec.getM4ccbCvEmpBtecPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvEmpBtec with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvEmpBtec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvEmpBtec> findM4ccbCvEmpBtecEntities() {
        return findM4ccbCvEmpBtecEntities(true, -1, -1);
    }

    public List<M4ccbCvEmpBtec> findM4ccbCvEmpBtecEntities(int maxResults, int firstResult) {
        return findM4ccbCvEmpBtecEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvEmpBtec> findM4ccbCvEmpBtecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvEmpBtec.class));
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

    public M4ccbCvEmpBtec findM4ccbCvEmpBtec(M4ccbCvEmpBtecPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvEmpBtec.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvEmpBtecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvEmpBtec> rt = cq.from(M4ccbCvEmpBtec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
     public  M4ccbCvEmpBtec findM4ccBActEmpBtecByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvEmpBtec> q= em.createNamedQuery("M4ccbCvEmpBtec.findByCcbCargueAct", M4ccbCvEmpBtec.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvEmpBtec activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
}
