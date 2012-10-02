/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTecn;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTecnPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvTrabTecnJpaController implements Serializable {

    public M4ccbCvTrabTecnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvTrabTecn m4ccbCvTrabTecn) throws PreexistingEntityException, Exception {
        if (m4ccbCvTrabTecn.getM4ccbCvTrabTecnPK() == null) {
            m4ccbCvTrabTecn.setM4ccbCvTrabTecnPK(new M4ccbCvTrabTecnPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvTrabTecn);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvTrabTecn(m4ccbCvTrabTecn.getM4ccbCvTrabTecnPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvTrabTecn " + m4ccbCvTrabTecn + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvTrabTecn m4ccbCvTrabTecn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvTrabTecn = em.merge(m4ccbCvTrabTecn);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvTrabTecnPK id = m4ccbCvTrabTecn.getM4ccbCvTrabTecnPK();
                if (findM4ccbCvTrabTecn(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvTrabTecn with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvTrabTecnPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvTrabTecn m4ccbCvTrabTecn;
            try {
                m4ccbCvTrabTecn = em.getReference(M4ccbCvTrabTecn.class, id);
                m4ccbCvTrabTecn.getM4ccbCvTrabTecnPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvTrabTecn with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvTrabTecn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities() {
        return findM4ccbCvTrabTecnEntities(true, -1, -1);
    }

    public List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities(int maxResults, int firstResult) {
        return findM4ccbCvTrabTecnEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvTrabTecn.class));
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

    public M4ccbCvTrabTecn findM4ccbCvTrabTecn(M4ccbCvTrabTecnPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvTrabTecn.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvTrabTecnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvTrabTecn> rt = cq.from(M4ccbCvTrabTecn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
        public  M4ccbCvTrabTecn findM4ccBActTrabTecnByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvTrabTecn> q= em.createNamedQuery("M4ccbCvTrabTecn.findByCcbCargueAct", M4ccbCvTrabTecn.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvTrabTecn activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
         /** 
     * Get tha max value of CCB_OR_TRAB_TEC for an user-organization key
     * 
     * @return  The max value of CCB_OR_TRAB_TEC,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrTrabTecn(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvTrabTecnPK.ccbOrTrabTec) "+
                                   "from M4ccbCvTrabTecn m "+
                                   "where m.m4ccbCvTrabTecnPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvTrabTecnPK.idOrganization = :idOrganization");
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
