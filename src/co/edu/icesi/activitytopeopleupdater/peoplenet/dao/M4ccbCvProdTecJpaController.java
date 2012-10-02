/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvProdTec;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvProdTecPK;
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
public class M4ccbCvProdTecJpaController implements Serializable {

    public M4ccbCvProdTecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvProdTec m4ccbCvProdTec) throws PreexistingEntityException, Exception {
        if (m4ccbCvProdTec.getM4ccbCvProdTecPK() == null) {
            m4ccbCvProdTec.setM4ccbCvProdTecPK(new M4ccbCvProdTecPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvProdTec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvProdTec(m4ccbCvProdTec.getM4ccbCvProdTecPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvProdTec " + m4ccbCvProdTec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvProdTec m4ccbCvProdTec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvProdTec = em.merge(m4ccbCvProdTec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvProdTecPK id = m4ccbCvProdTec.getM4ccbCvProdTecPK();
                if (findM4ccbCvProdTec(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvProdTec with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvProdTecPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvProdTec m4ccbCvProdTec;
            try {
                m4ccbCvProdTec = em.getReference(M4ccbCvProdTec.class, id);
                m4ccbCvProdTec.getM4ccbCvProdTecPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvProdTec with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvProdTec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvProdTec> findM4ccbCvProdTecEntities() {
        return findM4ccbCvProdTecEntities(true, -1, -1);
    }

    public List<M4ccbCvProdTec> findM4ccbCvProdTecEntities(int maxResults, int firstResult) {
        return findM4ccbCvProdTecEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvProdTec> findM4ccbCvProdTecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvProdTec.class));
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

    public M4ccbCvProdTec findM4ccbCvProdTec(M4ccbCvProdTecPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvProdTec.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvProdTecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvProdTec> rt = cq.from(M4ccbCvProdTec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
