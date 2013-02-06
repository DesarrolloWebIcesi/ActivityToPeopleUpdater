/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabDir;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabDirPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvTrabDirJpaController implements Serializable {

    public M4ccbCvTrabDirJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvTrabDir m4ccbCvTrabDir) throws PreexistingEntityException, Exception {
        if (m4ccbCvTrabDir.getM4ccbCvTrabDirPK() == null) {
            m4ccbCvTrabDir.setM4ccbCvTrabDirPK(new M4ccbCvTrabDirPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvTrabDir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvTrabDir(m4ccbCvTrabDir.getM4ccbCvTrabDirPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvTrabDir " + m4ccbCvTrabDir + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvTrabDir m4ccbCvTrabDir) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvTrabDir = em.merge(m4ccbCvTrabDir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvTrabDirPK id = m4ccbCvTrabDir.getM4ccbCvTrabDirPK();
                if (findM4ccbCvTrabDir(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvTrabDir with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvTrabDirPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvTrabDir m4ccbCvTrabDir;
            try {
                m4ccbCvTrabDir = em.getReference(M4ccbCvTrabDir.class, id);
                m4ccbCvTrabDir.getM4ccbCvTrabDirPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvTrabDir with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvTrabDir);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvTrabDir> findM4ccbCvTrabDirEntities() {
        return findM4ccbCvTrabDirEntities(true, -1, -1);
    }

    public List<M4ccbCvTrabDir> findM4ccbCvTrabDirEntities(int maxResults, int firstResult) {
        return findM4ccbCvTrabDirEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvTrabDir> findM4ccbCvTrabDirEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvTrabDir.class));
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

    public M4ccbCvTrabDir findM4ccbCvTrabDir(M4ccbCvTrabDirPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvTrabDir.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvTrabDirCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvTrabDir> rt = cq.from(M4ccbCvTrabDir.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public  M4ccbCvTrabDir findM4ccBActTrabDirByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvTrabDir> q= em.createNamedQuery("M4ccbCvTrabDir.findByCcbCargueAct", M4ccbCvTrabDir.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvTrabDir activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
