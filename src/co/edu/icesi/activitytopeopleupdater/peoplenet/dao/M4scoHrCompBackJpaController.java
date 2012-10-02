/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBack;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBackPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4scoHrCompBackJpaController implements Serializable {

    public M4scoHrCompBackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4scoHrCompBack m4scoHrCompBack) throws PreexistingEntityException, Exception {
        if (m4scoHrCompBack.getM4scoHrCompBackPK() == null) {
            m4scoHrCompBack.setM4scoHrCompBackPK(new M4scoHrCompBackPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4scoHrCompBack);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4scoHrCompBack(m4scoHrCompBack.getM4scoHrCompBackPK()) != null) {
                throw new PreexistingEntityException("M4scoHrCompBack " + m4scoHrCompBack + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4scoHrCompBack m4scoHrCompBack) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4scoHrCompBack = em.merge(m4scoHrCompBack);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4scoHrCompBackPK id = m4scoHrCompBack.getM4scoHrCompBackPK();
                if (findM4scoHrCompBack(id) == null) {
                    throw new NonexistentEntityException("The m4scoHrCompBack with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4scoHrCompBackPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4scoHrCompBack m4scoHrCompBack;
            try {
                m4scoHrCompBack = em.getReference(M4scoHrCompBack.class, id);
                m4scoHrCompBack.getM4scoHrCompBackPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4scoHrCompBack with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4scoHrCompBack);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4scoHrCompBack> findM4scoHrCompBackEntities() {
        return findM4scoHrCompBackEntities(true, -1, -1);
    }

    public List<M4scoHrCompBack> findM4scoHrCompBackEntities(int maxResults, int firstResult) {
        return findM4scoHrCompBackEntities(false, maxResults, firstResult);
    }

    private List<M4scoHrCompBack> findM4scoHrCompBackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoHrCompBack.class));
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

    public M4scoHrCompBack findM4scoHrCompBack(M4scoHrCompBackPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoHrCompBack.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoHrCompBackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoHrCompBack> rt = cq.from(M4scoHrCompBack.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /** 
     * Looks if there is a registry with the CCB_CARGUE_ACT equals to the
     * activityId parameter.
     * 
     * @return  An M4ccbCvActInves object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param activityId The ActivityInsight is for the activity.
     * 
     * @since 2012-09-24 by damanzano
     */
    public M4scoHrCompBack findM4scoHrCompBackByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4scoHrCompBack> q= em.createNamedQuery("M4scoHrCompBack.findByCcbCargueAct", M4scoHrCompBack.class);
            q.setParameter("ccbCargueAct", activityId);
            M4scoHrCompBack activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }

    /** 
     * Get tha max value of CCB_OR_ACT_INV for an user-organization key
     * 
     * @return  The max value of CCB_OR_ACT_INV,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-24 by damanzano
     */
    public int getMaxScoOrCompBg(String stdIdHr, String idOrganization) {
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4scoHrCompBackPK.scoOrCompBg) "+
                                   "from M4scoHrCompBack m "+
                                   "where m.m4scoHrCompBackPK.stdIdHr = :stdIdHr "+
                                   "and m.m4scoHrCompBackPK.idOrganization = :idOrganization");
            q.setParameter("stdIdHr", stdIdHr);
            q.setParameter("idOrganization", idOrganization);
            
            Object maxObject= q.getSingleResult();
            if(maxObject==null){
                return 0;
            }
            return (Short)maxObject;            
        }catch(NoResultException ex){
            //if there are no registries, this is the first one.
            return 0;
        }
    }
    
}
