/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsult;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsultPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvConsultJpaController implements Serializable {

    public M4ccbCvConsultJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvConsult m4ccbCvConsult) throws PreexistingEntityException, Exception {
        if (m4ccbCvConsult.getM4ccbCvConsultPK() == null) {
            m4ccbCvConsult.setM4ccbCvConsultPK(new M4ccbCvConsultPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvConsult);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvConsult(m4ccbCvConsult.getM4ccbCvConsultPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvConsult " + m4ccbCvConsult + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvConsult m4ccbCvConsult) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvConsult = em.merge(m4ccbCvConsult);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvConsultPK id = m4ccbCvConsult.getM4ccbCvConsultPK();
                if (findM4ccbCvConsult(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvConsult with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvConsultPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvConsult m4ccbCvConsult;
            try {
                m4ccbCvConsult = em.getReference(M4ccbCvConsult.class, id);
                m4ccbCvConsult.getM4ccbCvConsultPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvConsult with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvConsult);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvConsult> findM4ccbCvConsultEntities() {
        return findM4ccbCvConsultEntities(true, -1, -1);
    }

    public List<M4ccbCvConsult> findM4ccbCvConsultEntities(int maxResults, int firstResult) {
        return findM4ccbCvConsultEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvConsult> findM4ccbCvConsultEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvConsult.class));
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

    public M4ccbCvConsult findM4ccbCvConsult(M4ccbCvConsultPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvConsult.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvConsultCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvConsult> rt = cq.from(M4ccbCvConsult.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
        public  M4ccbCvConsult findM4ccBActConsultByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvConsult> q= em.createNamedQuery("M4ccbCvConsult.findByCcbCargueAct", M4ccbCvConsult.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvConsult activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
        
        /** 
     * Get tha max value of CCB_OR_CONSULT for an user-organization key
     * 
     * @return  The max value of CCB_OR_CONSULT,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrConsult(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvConsultPK.ccbOrConsult) "+
                                   "from M4ccbCvConsult m "+
                                   "where m.m4ccbCvConsultPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvConsultPK.idOrganization = :idOrganization");
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
