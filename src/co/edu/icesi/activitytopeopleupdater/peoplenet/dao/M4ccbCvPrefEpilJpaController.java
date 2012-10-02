/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPrefEpil;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPrefEpilPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvPrefEpilJpaController implements Serializable {

    public M4ccbCvPrefEpilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvPrefEpil m4ccbCvPrefEpil) throws PreexistingEntityException, Exception {
        if (m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK() == null) {
            m4ccbCvPrefEpil.setM4ccbCvPrefEpilPK(new M4ccbCvPrefEpilPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvPrefEpil(m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvPrefEpil " + m4ccbCvPrefEpil + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvPrefEpil m4ccbCvPrefEpil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvPrefEpil = em.merge(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvPrefEpilPK id = m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK();
                if (findM4ccbCvPrefEpil(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvPrefEpil with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvPrefEpilPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvPrefEpil m4ccbCvPrefEpil;
            try {
                m4ccbCvPrefEpil = em.getReference(M4ccbCvPrefEpil.class, id);
                m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvPrefEpil with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities() {
        return findM4ccbCvPrefEpilEntities(true, -1, -1);
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(int maxResults, int firstResult) {
        return findM4ccbCvPrefEpilEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvPrefEpil.class));
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

    public M4ccbCvPrefEpil findM4ccbCvPrefEpil(M4ccbCvPrefEpilPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvPrefEpil.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvPrefEpilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvPrefEpil> rt = cq.from(M4ccbCvPrefEpil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
        public  M4ccbCvPrefEpil findM4ccBActPrefEpilByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvPrefEpil> q= em.createNamedQuery("M4ccbCvPrefEpil.findByCcbCargueAct", M4ccbCvPrefEpil.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvPrefEpil activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
        
           /** 
     * Get tha max value of CCB_OR_PREFACIO for an user-organization key
     * 
     * @return  The max value of CCB_OR_PREFACIO,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-19 by damanzano
     */
    public short getMaxCcbOrPrepil(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvPrefEpilPK.ccbOrPrefacio) "+
                                   "from M4ccbCvPrefEpil m "+
                                   "where m.m4ccbCvPrefEpilPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvPrefEpilPK.idOrganization = :idOrganization");
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
