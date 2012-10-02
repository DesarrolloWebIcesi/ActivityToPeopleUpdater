/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCapLib;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCapLibPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvCapLibJpaController implements Serializable {

    public M4ccbCvCapLibJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvCapLib m4ccbCvCapLib) throws PreexistingEntityException, Exception {
        if (m4ccbCvCapLib.getM4ccbCvCapLibPK() == null) {
            m4ccbCvCapLib.setM4ccbCvCapLibPK(new M4ccbCvCapLibPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvCapLib);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvCapLib(m4ccbCvCapLib.getM4ccbCvCapLibPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvCapLib " + m4ccbCvCapLib + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvCapLib m4ccbCvCapLib) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvCapLib = em.merge(m4ccbCvCapLib);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvCapLibPK id = m4ccbCvCapLib.getM4ccbCvCapLibPK();
                if (findM4ccbCvCapLib(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvCapLib with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvCapLibPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvCapLib m4ccbCvCapLib;
            try {
                m4ccbCvCapLib = em.getReference(M4ccbCvCapLib.class, id);
                m4ccbCvCapLib.getM4ccbCvCapLibPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvCapLib with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvCapLib);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvCapLib> findM4ccbCvCapLibEntities() {
        return findM4ccbCvCapLibEntities(true, -1, -1);
    }

    public List<M4ccbCvCapLib> findM4ccbCvCapLibEntities(int maxResults, int firstResult) {
        return findM4ccbCvCapLibEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvCapLib> findM4ccbCvCapLibEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvCapLib.class));
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

    public M4ccbCvCapLib findM4ccbCvCapLib(M4ccbCvCapLibPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvCapLib.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvCapLibCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvCapLib> rt = cq.from(M4ccbCvCapLib.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
      public  M4ccbCvCapLib findM4ccBActCapLibByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvCapLib> q= em.createNamedQuery("M4ccbCvCapLib.findByCcbCargueAct", M4ccbCvCapLib.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvCapLib activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
      
          /** 
     * Get tha max value of CCB_OR_CAP_LIB for an user-organization key
     * 
     * @return  The max value of CCB_OR_CAP_LIB,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrActCapLib(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvCapLibPK.ccbOrCapLib) "+
                                   "from M4ccbCvCapLib m "+
                                   "where m.m4ccbCvCapLibPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvCapLibPK.idOrganization = :idOrganization");
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
