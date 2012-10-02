/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMe;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4scoAssocMeJpaController implements Serializable {

    public M4scoAssocMeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4scoAssocMe m4scoAssocMe) throws PreexistingEntityException, Exception {
        if (m4scoAssocMe.getM4scoAssocMePK() == null) {
            m4scoAssocMe.setM4scoAssocMePK(new M4scoAssocMePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4scoAssocMe);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4scoAssocMe(m4scoAssocMe.getM4scoAssocMePK()) != null) {
                throw new PreexistingEntityException("M4scoAssocMe " + m4scoAssocMe + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4scoAssocMe m4scoAssocMe) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4scoAssocMe = em.merge(m4scoAssocMe);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4scoAssocMePK id = m4scoAssocMe.getM4scoAssocMePK();
                if (findM4scoAssocMe(id) == null) {
                    throw new NonexistentEntityException("The m4scoAssocMe with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4scoAssocMePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4scoAssocMe m4scoAssocMe;
            try {
                m4scoAssocMe = em.getReference(M4scoAssocMe.class, id);
                m4scoAssocMe.getM4scoAssocMePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4scoAssocMe with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4scoAssocMe);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4scoAssocMe> findM4scoAssocMeEntities() {
        return findM4scoAssocMeEntities(true, -1, -1);
    }

    public List<M4scoAssocMe> findM4scoAssocMeEntities(int maxResults, int firstResult) {
        return findM4scoAssocMeEntities(false, maxResults, firstResult);
    }

    private List<M4scoAssocMe> findM4scoAssocMeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoAssocMe.class));
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

    public M4scoAssocMe findM4scoAssocMe(M4scoAssocMePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoAssocMe.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoAssocMeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoAssocMe> rt = cq.from(M4scoAssocMe.class);
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
     * @return  An M4scoAssocMe object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param activityId The ActivityInsight is for the activity.
     * 
     * @since 2012-09-24 by damanzano
     */
    public M4scoAssocMe findM4scoAssocMeByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4scoAssocMe> q= em.createNamedQuery("M4scoAssocMe.findByCcbCargueAct", M4scoAssocMe.class);
            q.setParameter("ccbCargueAct", activityId);
            M4scoAssocMe activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    /** 
     * Get tha max value of SCO_OR_ASSOC_MEMB for an user-organization key
     * 
     * @return  The max value of CCB_OR_ACT_INV,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-24 by damanzano
     */
    public synchronized short getMaxScoOrAssocMemb(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4scoAssocMePK.scoOrAssocMemb) "+
                                   "from M4scoAssocMe m "+
                                   "where m.m4scoAssocMePK.scoIdHr = :scoIdHr "+
                                   "and m.m4scoAssocMePK.idOrganization = :idOrganization");
            q.setParameter("scoIdHr", stdIdHr);
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
