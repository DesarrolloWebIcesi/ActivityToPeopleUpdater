/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrLangTrans;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrLangTransPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class StdHrLangTransJpaController implements Serializable {

    public StdHrLangTransJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdHrLangTrans stdHrLangTrans) throws PreexistingEntityException, Exception {
        if (stdHrLangTrans.getStdHrLangTransPK() == null) {
            stdHrLangTrans.setStdHrLangTransPK(new StdHrLangTransPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdHrLangTrans);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdHrLangTrans(stdHrLangTrans.getStdHrLangTransPK()) != null) {
                throw new PreexistingEntityException("StdHrLangTrans " + stdHrLangTrans + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdHrLangTrans stdHrLangTrans) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdHrLangTrans = em.merge(stdHrLangTrans);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdHrLangTransPK id = stdHrLangTrans.getStdHrLangTransPK();
                if (findStdHrLangTrans(id) == null) {
                    throw new NonexistentEntityException("The stdHrLangTrans with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdHrLangTransPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdHrLangTrans stdHrLangTrans;
            try {
                stdHrLangTrans = em.getReference(StdHrLangTrans.class, id);
                stdHrLangTrans.getStdHrLangTransPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdHrLangTrans with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdHrLangTrans);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdHrLangTrans> findStdHrLangTransEntities() {
        return findStdHrLangTransEntities(true, -1, -1);
    }

    public List<StdHrLangTrans> findStdHrLangTransEntities(int maxResults, int firstResult) {
        return findStdHrLangTransEntities(false, maxResults, firstResult);
    }

    private List<StdHrLangTrans> findStdHrLangTransEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrLangTrans.class));
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

    public StdHrLangTrans findStdHrLangTrans(StdHrLangTransPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrLangTrans.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrLangTransCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrLangTrans> rt = cq.from(StdHrLangTrans.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
          
      
       /** 
     * Get tha max value of CCB_OR_TRADUCC for an user-organization key
     * 
     * @return  The max value of CCB_OR_TRADUCC,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrTranslang(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.stdHrLangTransPK.ccbOrTraducc) "+
                                   "from StdHrLangTrans m "+
                                   "where m.stdHrLangTransPK.stdIdHr = :stdIdHr "+
                                   "and m.stdHrLangTransPK.idOrganization = :idOrganization");
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
    
          public  StdHrLangTrans findM4ccBActTransLangByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<StdHrLangTrans> q= em.createNamedQuery("StdHrLangTrans.findByCcbCargueAct", StdHrLangTrans.class);
            q.setParameter("ccbCargueAct", activityId);
           StdHrLangTrans activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
}
