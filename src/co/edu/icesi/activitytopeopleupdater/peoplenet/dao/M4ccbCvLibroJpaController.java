/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvLibro;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvLibroPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvLibroJpaController implements Serializable {

    public M4ccbCvLibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvLibro m4ccbCvLibro) throws PreexistingEntityException, Exception {
        if (m4ccbCvLibro.getM4ccbCvLibroPK() == null) {
            m4ccbCvLibro.setM4ccbCvLibroPK(new M4ccbCvLibroPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvLibro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvLibro(m4ccbCvLibro.getM4ccbCvLibroPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvLibro " + m4ccbCvLibro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvLibro m4ccbCvLibro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvLibro = em.merge(m4ccbCvLibro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvLibroPK id = m4ccbCvLibro.getM4ccbCvLibroPK();
                if (findM4ccbCvLibro(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvLibro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvLibroPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvLibro m4ccbCvLibro;
            try {
                m4ccbCvLibro = em.getReference(M4ccbCvLibro.class, id);
                m4ccbCvLibro.getM4ccbCvLibroPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvLibro with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvLibro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvLibro> findM4ccbCvLibroEntities() {
        return findM4ccbCvLibroEntities(true, -1, -1);
    }

    public List<M4ccbCvLibro> findM4ccbCvLibroEntities(int maxResults, int firstResult) {
        return findM4ccbCvLibroEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvLibro> findM4ccbCvLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvLibro.class));
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

    public M4ccbCvLibro findM4ccbCvLibro(M4ccbCvLibroPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvLibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvLibro> rt = cq.from(M4ccbCvLibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
       public  M4ccbCvLibro findM4ccBActLibroByCcbCargueAct(String activityId) {
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvLibro> q= em.createNamedQuery("M4ccbCvLibro.findByCcbCargueAct", M4ccbCvLibro.class);
            q.setParameter("ccbCargueAct", activityId);
            M4ccbCvLibro activity = q.getSingleResult();
            return activity;
        }catch(NoResultException | NonUniqueResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
       /** 
     * Get tha max value of CCB_OR_LIBRO for an user-organization key
     * 
     * @return  The max value of CCB_OR_LIBRO,
     *          1 if there are not result for the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000" 
     */
    public short getMaxCcbOrActLbr(String stdIdHr, String idOrganization){
        EntityManager em=getEntityManager();
        try{
            Query q=em.createQuery("select max(m.m4ccbCvLibroPK.ccbOrLibro) "+
                                   "from M4ccbCvLibro m "+
                                   "where m.m4ccbCvLibroPK.stdIdHr = :stdIdHr "+
                                   "and m.m4ccbCvLibroPK.idOrganization = :idOrganization");
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
