/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPresentac;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPresentacPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240
 */
public class M4ccbCvPresentacJpaController implements Serializable {

    public M4ccbCvPresentacJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvPresentac m4ccbCvPresentac) throws PreexistingEntityException, Exception {
        if (m4ccbCvPresentac.getM4ccbCvPresentacPK() == null) {
            m4ccbCvPresentac.setM4ccbCvPresentacPK(new M4ccbCvPresentacPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvPresentac);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvPresentac(m4ccbCvPresentac.getM4ccbCvPresentacPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvPresentac " + m4ccbCvPresentac + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvPresentac m4ccbCvPresentac) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvPresentac = em.merge(m4ccbCvPresentac);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvPresentacPK id = m4ccbCvPresentac.getM4ccbCvPresentacPK();
                if (findM4ccbCvPresentac(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvPresentac with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvPresentacPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvPresentac m4ccbCvPresentac;
            try {
                m4ccbCvPresentac = em.getReference(M4ccbCvPresentac.class, id);
                m4ccbCvPresentac.getM4ccbCvPresentacPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvPresentac with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvPresentac);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvPresentac> findM4ccbCvPresentacEntities() {
        return findM4ccbCvPresentacEntities(true, -1, -1);
    }

    public List<M4ccbCvPresentac> findM4ccbCvPresentacEntities(int maxResults, int firstResult) {
        return findM4ccbCvPresentacEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvPresentac> findM4ccbCvPresentacEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvPresentac.class));
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

    public M4ccbCvPresentac findM4ccbCvPresentac(M4ccbCvPresentacPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvPresentac.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvPresentacCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvPresentac> rt = cq.from(M4ccbCvPresentac.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Looks if there is a registry with the CCB_CARGUE_ACT equals to the
     * awardId parameter.
     *
     * @return An M4ccbCvPresentac object that represents the database registry.
     * <code>null</null> otherwise.
     * @param awardId The ActivityInsight is for the award.
     *
     * @since 2012-09-19 by damanzano
     */
    public M4ccbCvPresentac findM4ccbCvPresentacByCcbCargueAct(String awardId) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<M4ccbCvPresentac> q = em.createNamedQuery("M4ccbCvPresentac.findByCcbCargueAct", M4ccbCvPresentac.class);
            q.setParameter("ccbCargueAct", awardId);
            M4ccbCvPresentac award = q.getSingleResult();
            return award;
        } catch (NoResultException | NonUniqueResultException ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

    /**
     * Get tha max value of CCB_OR_PROD_DIV for an user-organization key
     *
     * @return The max value of CCB_OR_PROD_DIV, 1 if there are not result for
     * the query
     * @param stdIdHr PeopleNet user Id
     * @param idOrganization PeopleNet organization id most of time is "0000"
     *
     * @since 2012-09-19 by damanzano
     */
    public short getMaxCcbOrProdDiv(String stdIdHr, String idOrganization) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select max(m.m4ccbCvPresentacPK.ccbOrProdDiv) "
                    + "from M4ccbCvPresentac m "
                    + "where m.m4ccbCvPresentacPK.stdIdHr = :stdIdHr "
                    + "and m.m4ccbCvPresentacPK.idOrganization = :idOrganization");
            q.setParameter("stdIdHr", stdIdHr);
            q.setParameter("idOrganization", idOrganization);

            Object maxObject = q.getSingleResult();
            if (maxObject == null) {
                return 0;
            }
            return (Short) maxObject;
        } catch (NoResultException ex) {
            //if there are no registries, this is the first one.
            return 0;
        }
    }
}
