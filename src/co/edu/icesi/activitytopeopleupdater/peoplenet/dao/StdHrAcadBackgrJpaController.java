/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInves;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgr;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgrPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class StdHrAcadBackgrJpaController implements Serializable {

    public StdHrAcadBackgrJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdHrAcadBackgr stdHrAcadBackgr) throws PreexistingEntityException, Exception {
        if (stdHrAcadBackgr.getStdHrAcadBackgrPK() == null) {
            stdHrAcadBackgr.setStdHrAcadBackgrPK(new StdHrAcadBackgrPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdHrAcadBackgr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdHrAcadBackgr(stdHrAcadBackgr.getStdHrAcadBackgrPK()) != null) {
                throw new PreexistingEntityException("StdHrAcadBackgr " + stdHrAcadBackgr + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdHrAcadBackgr stdHrAcadBackgr) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdHrAcadBackgr = em.merge(stdHrAcadBackgr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdHrAcadBackgrPK id = stdHrAcadBackgr.getStdHrAcadBackgrPK();
                if (findStdHrAcadBackgr(id) == null) {
                    throw new NonexistentEntityException("The stdHrAcadBackgr with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdHrAcadBackgrPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdHrAcadBackgr stdHrAcadBackgr;
            try {
                stdHrAcadBackgr = em.getReference(StdHrAcadBackgr.class, id);
                stdHrAcadBackgr.getStdHrAcadBackgrPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdHrAcadBackgr with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdHrAcadBackgr);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities() {
        return findStdHrAcadBackgrEntities(true, -1, -1);
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(int maxResults, int firstResult) {
        return findStdHrAcadBackgrEntities(false, maxResults, firstResult);
    }

    private List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrAcadBackgr.class));
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

    public StdHrAcadBackgr findStdHrAcadBackgr(StdHrAcadBackgrPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrAcadBackgr.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrAcadBackgrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrAcadBackgr> rt = cq.from(StdHrAcadBackgr.class);
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
    public StdHrAcadBackgr findStdHrAcadBackgrByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<StdHrAcadBackgr> q= em.createNamedQuery("StdHrAcadBackgr.findByCcbCargueAct", StdHrAcadBackgr.class);
            q.setParameter("ccbCargueAct", activityId);
            StdHrAcadBackgr activity = q.getSingleResult();
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
    public short getMaxStdOrdAcdBack(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.stdHrAcadBackgrPK.stdOrdAcdBack) "+
                                   "from StdHrAcadBackgr m "+
                                   "where m.stdHrAcadBackgrPK.stdIdHr = :stdIdHr "+
                                   "and m.stdHrAcadBackgrPK.idOrganization = :idOrganization");
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
