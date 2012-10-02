/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobs;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobsPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class StdHrPrevJobsJpaController implements Serializable {

    public StdHrPrevJobsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdHrPrevJobs stdHrPrevJobs) throws PreexistingEntityException, Exception {
        if (stdHrPrevJobs.getStdHrPrevJobsPK() == null) {
            stdHrPrevJobs.setStdHrPrevJobsPK(new StdHrPrevJobsPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdHrPrevJobs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdHrPrevJobs(stdHrPrevJobs.getStdHrPrevJobsPK()) != null) {
                throw new PreexistingEntityException("StdHrPrevJobs " + stdHrPrevJobs + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdHrPrevJobs stdHrPrevJobs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdHrPrevJobs = em.merge(stdHrPrevJobs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdHrPrevJobsPK id = stdHrPrevJobs.getStdHrPrevJobsPK();
                if (findStdHrPrevJobs(id) == null) {
                    throw new NonexistentEntityException("The stdHrPrevJobs with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdHrPrevJobsPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdHrPrevJobs stdHrPrevJobs;
            try {
                stdHrPrevJobs = em.getReference(StdHrPrevJobs.class, id);
                stdHrPrevJobs.getStdHrPrevJobsPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdHrPrevJobs with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdHrPrevJobs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdHrPrevJobs> findStdHrPrevJobsEntities() {
        return findStdHrPrevJobsEntities(true, -1, -1);
    }

    public List<StdHrPrevJobs> findStdHrPrevJobsEntities(int maxResults, int firstResult) {
        return findStdHrPrevJobsEntities(false, maxResults, firstResult);
    }

    private List<StdHrPrevJobs> findStdHrPrevJobsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrPrevJobs.class));
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

    public StdHrPrevJobs findStdHrPrevJobs(StdHrPrevJobsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrPrevJobs.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrPrevJobsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrPrevJobs> rt = cq.from(StdHrPrevJobs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
      public  StdHrPrevJobs findM4ccBActPrevJobsByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<StdHrPrevJobs> q= em.createNamedQuery("StdHrPrevJobs.findByCcbCargueAct", StdHrPrevJobs.class);
            q.setParameter("ccbCargueAct", activityId);
           StdHrPrevJobs activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
      
      
    /** 
     * Get tha max value of STD_OR_PROF_BACKG for an user-organization key
     * 
     * @return  The max value of STD_OR_PROF_BACKG,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrPrevJobs(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.stdHrPrevJobsPK.stdOrProfBackg) "+
                                   "from StdHrPrevJobs m "+
                                   "where m.stdHrPrevJobsPK.stdIdHr = :stdIdHr "+
                                   "and m.stdHrPrevJobsPK.idOrganization = :idOrganization");
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
