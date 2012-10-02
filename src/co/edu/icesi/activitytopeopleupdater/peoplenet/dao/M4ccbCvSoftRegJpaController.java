/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvSoftReg;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvSoftRegPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvSoftRegJpaController implements Serializable {

    public M4ccbCvSoftRegJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvSoftReg m4ccbCvSoftReg) throws PreexistingEntityException, Exception {
        if (m4ccbCvSoftReg.getM4ccbCvSoftRegPK() == null) {
            m4ccbCvSoftReg.setM4ccbCvSoftRegPK(new M4ccbCvSoftRegPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvSoftReg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvSoftReg(m4ccbCvSoftReg.getM4ccbCvSoftRegPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvSoftReg " + m4ccbCvSoftReg + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvSoftReg m4ccbCvSoftReg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvSoftReg = em.merge(m4ccbCvSoftReg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvSoftRegPK id = m4ccbCvSoftReg.getM4ccbCvSoftRegPK();
                if (findM4ccbCvSoftReg(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvSoftReg with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvSoftRegPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvSoftReg m4ccbCvSoftReg;
            try {
                m4ccbCvSoftReg = em.getReference(M4ccbCvSoftReg.class, id);
                m4ccbCvSoftReg.getM4ccbCvSoftRegPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvSoftReg with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvSoftReg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities() {
        return findM4ccbCvSoftRegEntities(true, -1, -1);
    }

    public List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities(int maxResults, int firstResult) {
        return findM4ccbCvSoftRegEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvSoftReg.class));
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

    public M4ccbCvSoftReg findM4ccbCvSoftReg(M4ccbCvSoftRegPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvSoftReg.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvSoftRegCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvSoftReg> rt = cq.from(M4ccbCvSoftReg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
       public  M4ccbCvSoftReg findM4ccBActSoftRegByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvSoftReg> q= em.createNamedQuery("M4ccbCvSoftReg.findByCcbCargueAct", M4ccbCvSoftReg.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvSoftReg activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
       
         /** 
     * Get tha max value of CCB_OR_SOFT_REG for an user-organization key
     * 
     * @return  The max value of CCB_OR_SOFT_REG,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrSoftReg(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvSoftRegPK.ccbOrSoftReg) "+
                                   "from M4ccbCvSoftReg m "+
                                   "where m.m4ccbCvSoftRegPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvSoftRegPK.idOrganization = :idOrganization");
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
