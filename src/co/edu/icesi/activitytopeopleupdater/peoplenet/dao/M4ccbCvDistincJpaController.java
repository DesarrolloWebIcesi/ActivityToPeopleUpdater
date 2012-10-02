/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistinc;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistincPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvDistincJpaController implements Serializable {

    public M4ccbCvDistincJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvDistinc m4ccbCvDistinc) throws PreexistingEntityException, Exception {
        if (m4ccbCvDistinc.getM4ccbCvDistincPK() == null) {
            m4ccbCvDistinc.setM4ccbCvDistincPK(new M4ccbCvDistincPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvDistinc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvDistinc(m4ccbCvDistinc.getM4ccbCvDistincPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvDistinc " + m4ccbCvDistinc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvDistinc m4ccbCvDistinc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvDistinc = em.merge(m4ccbCvDistinc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvDistincPK id = m4ccbCvDistinc.getM4ccbCvDistincPK();
                if (findM4ccbCvDistinc(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvDistinc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvDistincPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvDistinc m4ccbCvDistinc;
            try {
                m4ccbCvDistinc = em.getReference(M4ccbCvDistinc.class, id);
                m4ccbCvDistinc.getM4ccbCvDistincPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvDistinc with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvDistinc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvDistinc> findM4ccbCvDistincEntities() {
        return findM4ccbCvDistincEntities(true, -1, -1);
    }

    public List<M4ccbCvDistinc> findM4ccbCvDistincEntities(int maxResults, int firstResult) {
        return findM4ccbCvDistincEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvDistinc> findM4ccbCvDistincEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvDistinc.class));
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

    public M4ccbCvDistinc findM4ccbCvDistinc(M4ccbCvDistincPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvDistinc.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvDistincCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvDistinc> rt = cq.from(M4ccbCvDistinc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     /** 
     * Looks if there is a registry with the CCB_CARGUE_ACT equals to the
     * awardId parameter.
     * 
     * @return  An M4ccbCvDistinc object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param awardId The ActivityInsight is for the award.
     * 
     * @since 2012-09-19 by damanzano
     */
    public M4ccbCvDistinc findM4ccbCvDistincByCcbCargueAct(String awardId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvDistinc> q= em.createNamedQuery("M4ccbCvDistinc.findByCcbCargueAct", M4ccbCvDistinc.class);
            q.setParameter("ccbCargueAct", awardId);
            M4ccbCvDistinc award = q.getSingleResult();
            return award;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    /** 
     * Get tha max value of CCB_ORD_DISTINC for an user-organization key
     * 
     * @return  The max value of CCB_ORD_DISTINC,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-19 by damanzano
     */
    public short getMaxCcbOrDistinc(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvDistincPK.ccbOrDistinc) "+
                                   "from M4ccbCvDistinc m "+
                                   "where m.m4ccbCvDistincPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvDistincPK.idOrganization = :idOrganization");
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
