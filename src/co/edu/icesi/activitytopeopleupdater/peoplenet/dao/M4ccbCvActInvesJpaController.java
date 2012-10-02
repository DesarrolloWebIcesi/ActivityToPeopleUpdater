/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInves;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInvesPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvActInvesJpaController implements Serializable {

    public M4ccbCvActInvesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvActInves m4ccbCvActInves) throws PreexistingEntityException, Exception {
        if (m4ccbCvActInves.getM4ccbCvActInvesPK() == null) {
            m4ccbCvActInves.setM4ccbCvActInvesPK(new M4ccbCvActInvesPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvActInves);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvActInves(m4ccbCvActInves.getM4ccbCvActInvesPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvActInves " + m4ccbCvActInves + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvActInves m4ccbCvActInves) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvActInves = em.merge(m4ccbCvActInves);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvActInvesPK id = m4ccbCvActInves.getM4ccbCvActInvesPK();
                if (findM4ccbCvActInves(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvActInves with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvActInvesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvActInves m4ccbCvActInves;
            try {
                m4ccbCvActInves = em.getReference(M4ccbCvActInves.class, id);
                m4ccbCvActInves.getM4ccbCvActInvesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvActInves with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvActInves);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvActInves> findM4ccbCvActInvesEntities() {
        return findM4ccbCvActInvesEntities(true, -1, -1);
    }

    public List<M4ccbCvActInves> findM4ccbCvActInvesEntities(int maxResults, int firstResult) {
        return findM4ccbCvActInvesEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvActInves> findM4ccbCvActInvesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvActInves.class));
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

    public M4ccbCvActInves findM4ccbCvActInves(M4ccbCvActInvesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvActInves.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvActInvesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvActInves> rt = cq.from(M4ccbCvActInves.class);
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
     * @since 2012-09-14 by damanzano
     */
    public M4ccbCvActInves findM4ccbActInvesByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvActInves> q= em.createNamedQuery("M4ccbCvActInves.findByCcbCargueAct", M4ccbCvActInves.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvActInves activity = q.getSingleResult();
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
     * @since 2012-09-19 by damanzano
     */
    public short getMaxCcbOrActInv(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvActInvesPK.ccbOrActInv) "+
                                   "from M4ccbCvActInves m "+
                                   "where m.m4ccbCvActInvesPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvActInvesPK.idOrganization = :idOrganization");
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
