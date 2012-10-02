/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurCom;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurComPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvJurComJpaController implements Serializable {

    public M4ccbCvJurComJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvJurCom m4ccbCvJurCom) throws PreexistingEntityException, Exception {
        if (m4ccbCvJurCom.getM4ccbCvJurComPK() == null) {
            m4ccbCvJurCom.setM4ccbCvJurComPK(new M4ccbCvJurComPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvJurCom);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvJurCom(m4ccbCvJurCom.getM4ccbCvJurComPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvJurCom " + m4ccbCvJurCom + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvJurCom m4ccbCvJurCom) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvJurCom = em.merge(m4ccbCvJurCom);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvJurComPK id = m4ccbCvJurCom.getM4ccbCvJurComPK();
                if (findM4ccbCvJurCom(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvJurCom with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvJurComPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvJurCom m4ccbCvJurCom;
            try {
                m4ccbCvJurCom = em.getReference(M4ccbCvJurCom.class, id);
                m4ccbCvJurCom.getM4ccbCvJurComPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvJurCom with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvJurCom);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvJurCom> findM4ccbCvJurComEntities() {
        return findM4ccbCvJurComEntities(true, -1, -1);
    }

    public List<M4ccbCvJurCom> findM4ccbCvJurComEntities(int maxResults, int firstResult) {
        return findM4ccbCvJurComEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvJurCom> findM4ccbCvJurComEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvJurCom.class));
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

    public M4ccbCvJurCom findM4ccbCvJurCom(M4ccbCvJurComPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvJurCom.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvJurComCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvJurCom> rt = cq.from(M4ccbCvJurCom.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /** 
     * Looks if there is a registry with the CCB_CARGUE_ACT equals to the
     * dslId parameter.
     * 
     * @return  An M4ccbCvJurCom object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param dslId The ActivityInsight is for the dsl.
     */
    public M4ccbCvJurCom findM4ccbCvJurComByCcbCargueAct(String dslId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvJurCom> q= em.createNamedQuery("M4ccbCvJurCom.findByCcbCargueAct", M4ccbCvJurCom.class);
            q.setParameter("ccbCargueAct", dslId);
            M4ccbCvJurCom dsl = q.getSingleResult();
            return dsl;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    /** 
     * Get tha max value of CCB_OR_JUR_COM for an user-organization key
     * 
     * @return  The max value of CCB_OR_JUR_COM,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2012-09-19 by damanzano
     */
    public short getMaxCcbOrJurCom(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvJurComPK.ccbOrJurCom) "+
                                   "from M4ccbCvJurCom m "+
                                   "where m.m4ccbCvJurComPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvJurComPK.idOrganization = :idOrganization");
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
