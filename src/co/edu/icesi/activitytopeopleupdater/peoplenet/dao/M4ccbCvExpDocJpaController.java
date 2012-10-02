/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvExpDoc;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvExpDocPK;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobs;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvExpDocJpaController implements Serializable {

    public M4ccbCvExpDocJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvExpDoc m4ccbCvExpDoc) throws PreexistingEntityException, Exception {
        if (m4ccbCvExpDoc.getM4ccbCvExpDocPK() == null) {
            m4ccbCvExpDoc.setM4ccbCvExpDocPK(new M4ccbCvExpDocPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvExpDoc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvExpDoc(m4ccbCvExpDoc.getM4ccbCvExpDocPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvExpDoc " + m4ccbCvExpDoc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvExpDoc m4ccbCvExpDoc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvExpDoc = em.merge(m4ccbCvExpDoc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvExpDocPK id = m4ccbCvExpDoc.getM4ccbCvExpDocPK();
                if (findM4ccbCvExpDoc(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvExpDoc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvExpDocPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvExpDoc m4ccbCvExpDoc;
            try {
                m4ccbCvExpDoc = em.getReference(M4ccbCvExpDoc.class, id);
                m4ccbCvExpDoc.getM4ccbCvExpDocPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvExpDoc with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvExpDoc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvExpDoc> findM4ccbCvExpDocEntities() {
        return findM4ccbCvExpDocEntities(true, -1, -1);
    }

    public List<M4ccbCvExpDoc> findM4ccbCvExpDocEntities(int maxResults, int firstResult) {
        return findM4ccbCvExpDocEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvExpDoc> findM4ccbCvExpDocEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvExpDoc.class));
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

    public M4ccbCvExpDoc findM4ccbCvExpDoc(M4ccbCvExpDocPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvExpDoc.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvExpDocCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvExpDoc> rt = cq.from(M4ccbCvExpDoc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
     public  M4ccbCvExpDoc findM4ccBActExpDocByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvExpDoc> q= em.createNamedQuery("M4ccbCvExpDoc.findByCcbCargueAct", M4ccbCvExpDoc.class);
            q.setParameter("ccbCargueAct", activityId);
           M4ccbCvExpDoc activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
      
      
       /** 
     * Get tha max value of CCB_OR_EXP_DOC for an user-organization key
     * 
     * @return  The max value of CCB_OR_EXP_DOC,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrExpDoc(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvExpDocPK.ccbOrExpDoc) "+
                                   "from M4ccbCvExpDoc m "+
                                   "where m.m4ccbCvExpDocPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvExpDocPK.idOrganization = :idOrganization");
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
