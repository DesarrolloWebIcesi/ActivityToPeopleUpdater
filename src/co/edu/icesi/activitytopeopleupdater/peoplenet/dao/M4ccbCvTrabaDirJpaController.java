/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurCom;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabaDir;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabaDirPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvTrabaDirJpaController implements Serializable {

    public M4ccbCvTrabaDirJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvTrabaDir m4ccbCvTrabaDir) throws PreexistingEntityException, Exception {
        if (m4ccbCvTrabaDir.getM4ccbCvTrabaDirPK() == null) {
            m4ccbCvTrabaDir.setM4ccbCvTrabaDirPK(new M4ccbCvTrabaDirPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvTrabaDir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvTrabaDir(m4ccbCvTrabaDir.getM4ccbCvTrabaDirPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvTrabaDir " + m4ccbCvTrabaDir + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvTrabaDir m4ccbCvTrabaDir) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvTrabaDir = em.merge(m4ccbCvTrabaDir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvTrabaDirPK id = m4ccbCvTrabaDir.getM4ccbCvTrabaDirPK();
                if (findM4ccbCvTrabaDir(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvTrabaDir with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvTrabaDirPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvTrabaDir m4ccbCvTrabaDir;
            try {
                m4ccbCvTrabaDir = em.getReference(M4ccbCvTrabaDir.class, id);
                m4ccbCvTrabaDir.getM4ccbCvTrabaDirPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvTrabaDir with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvTrabaDir);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvTrabaDir> findM4ccbCvTrabaDirEntities() {
        return findM4ccbCvTrabaDirEntities(true, -1, -1);
    }

    public List<M4ccbCvTrabaDir> findM4ccbCvTrabaDirEntities(int maxResults, int firstResult) {
        return findM4ccbCvTrabaDirEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvTrabaDir> findM4ccbCvTrabaDirEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvTrabaDir.class));
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

    public M4ccbCvTrabaDir findM4ccbCvTrabaDir(M4ccbCvTrabaDirPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvTrabaDir.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvTrabaDirCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvTrabaDir> rt = cq.from(M4ccbCvTrabaDir.class);
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
     * @return  An M4ccbCvTrabaDir object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param dslId The ActivityInsight is for the dsl.
     */
    public M4ccbCvTrabaDir findM4ccbCvTrabaDirByCcbCargueAct(String dslId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvTrabaDir> q= em.createNamedQuery("M4ccbCvTrabaDir.findByCcbCargueAct", M4ccbCvTrabaDir.class);
            q.setParameter("ccbCargueAct", dslId);
            M4ccbCvTrabaDir dsl = q.getSingleResult();
            return dsl;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    /** 
     * Get tha max value of CCB_OR_TRABA_DIR for an user-organization key
     * 
     * @return  The max value of CCB_OR_TRABA_DIR,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     * 
     * @since 2014-11-11 by damanzano, jhyela
     */
    
    public short getMaxCcbOrTrabaDir(String stdIdHr, String idOrganization) {
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvTrabaDirPK.ccbOrTrabDir) "+
                                   "from M4ccbCvTrabaDir m "+
                                   "where m.m4ccbCvTrabaDirPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvTrabaDirPK.idOrganization = :idOrganization");
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
