/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDocTrab;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDocTrabPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvDocTrabJpaController implements Serializable {

    public M4ccbCvDocTrabJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvDocTrab m4ccbCvDocTrab) throws PreexistingEntityException, Exception {
        if (m4ccbCvDocTrab.getM4ccbCvDocTrabPK() == null) {
            m4ccbCvDocTrab.setM4ccbCvDocTrabPK(new M4ccbCvDocTrabPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvDocTrab);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvDocTrab(m4ccbCvDocTrab.getM4ccbCvDocTrabPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvDocTrab " + m4ccbCvDocTrab + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvDocTrab m4ccbCvDocTrab) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvDocTrab = em.merge(m4ccbCvDocTrab);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvDocTrabPK id = m4ccbCvDocTrab.getM4ccbCvDocTrabPK();
                if (findM4ccbCvDocTrab(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvDocTrab with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvDocTrabPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvDocTrab m4ccbCvDocTrab;
            try {
                m4ccbCvDocTrab = em.getReference(M4ccbCvDocTrab.class, id);
                m4ccbCvDocTrab.getM4ccbCvDocTrabPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvDocTrab with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvDocTrab);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities() {
        return findM4ccbCvDocTrabEntities(true, -1, -1);
    }

    public List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities(int maxResults, int firstResult) {
        return findM4ccbCvDocTrabEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvDocTrab.class));
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

    public M4ccbCvDocTrab findM4ccbCvDocTrab(M4ccbCvDocTrabPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvDocTrab.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvDocTrabCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvDocTrab> rt = cq.from(M4ccbCvDocTrab.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public  M4ccbCvDocTrab findM4ccBActDocTrabByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvDocTrab> q= em.createNamedQuery("M4ccbCvDocTrab.findByCcbCargueAct", M4ccbCvDocTrab.class);
            q.setParameter("ccbCargueAct", activityId);
           M4ccbCvDocTrab activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
     
     /** 
     * Get tha max value of CCB_OR_DOC_TRAB for an user-organization key
     * 
     * @return  The max value of CCB_OR_DOC_TRAB,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrDocTrab(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvDocTrabPK.ccbOrDocTrab) "+
                                   "from M4ccbCvDocTrab m "+
                                   "where m.m4ccbCvDocTrabPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvDocTrabPK.idOrganization = :idOrganization");
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
