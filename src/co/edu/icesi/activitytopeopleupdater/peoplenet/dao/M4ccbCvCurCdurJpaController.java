/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCurCdur;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCurCdurPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvCurCdurJpaController implements Serializable {

    public M4ccbCvCurCdurJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvCurCdur m4ccbCvCurCdur) throws PreexistingEntityException, Exception {
        if (m4ccbCvCurCdur.getM4ccbCvCurCdurPK() == null) {
            m4ccbCvCurCdur.setM4ccbCvCurCdurPK(new M4ccbCvCurCdurPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvCurCdur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvCurCdur(m4ccbCvCurCdur.getM4ccbCvCurCdurPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvCurCdur " + m4ccbCvCurCdur + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvCurCdur m4ccbCvCurCdur) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvCurCdur = em.merge(m4ccbCvCurCdur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvCurCdurPK id = m4ccbCvCurCdur.getM4ccbCvCurCdurPK();
                if (findM4ccbCvCurCdur(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvCurCdur with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvCurCdurPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvCurCdur m4ccbCvCurCdur;
            try {
                m4ccbCvCurCdur = em.getReference(M4ccbCvCurCdur.class, id);
                m4ccbCvCurCdur.getM4ccbCvCurCdurPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvCurCdur with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvCurCdur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvCurCdur> findM4ccbCvCurCdurEntities() {
        return findM4ccbCvCurCdurEntities(true, -1, -1);
    }

    public List<M4ccbCvCurCdur> findM4ccbCvCurCdurEntities(int maxResults, int firstResult) {
        return findM4ccbCvCurCdurEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvCurCdur> findM4ccbCvCurCdurEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvCurCdur.class));
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

    public M4ccbCvCurCdur findM4ccbCvCurCdur(M4ccbCvCurCdurPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvCurCdur.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvCurCdurCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvCurCdur> rt = cq.from(M4ccbCvCurCdur.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /** 
     * Looks if there is a registry with the CCB_CARGUE_ACT equals to the
     * courseId parameter.
     * 
     * @return  An M4ccbCvCurCdur object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param courseId The ActivityInsight is for the activity.
     * 
     * @since 2012-09-14 by damanzano
     */
    public M4ccbCvCurCdur findM4ccbCvCurCdurByCcbCargueAct(String courseId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvCurCdur> q= em.createNamedQuery("M4ccbCvCurCdur.findByCcbCargueAct", M4ccbCvCurCdur.class);
            q.setParameter("ccbCargueAct", courseId);
            M4ccbCvCurCdur course = q.getSingleResult();
            return course;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    /** 
     * Get tha max value of CCB_OR_CUR_CDUR for an user-organization key
     * 
     * @return  The max value of CCB_OR_CUR_CDUR,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-21 by damanzano
     */
    public short getMaxCcbOrCurCdur(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvCurCdurPK.ccbOrCurCdur) "+
                                   "from M4ccbCvCurCdur m "+
                                   "where m.m4ccbCvCurCdurPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvCurCdurPK.idOrganization = :idOrganization");
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
