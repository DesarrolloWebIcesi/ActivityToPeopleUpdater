/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.dao;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbHrCc;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbHrCcPK;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdPerson;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdPersonPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 38555240 - Blanca Gómez
 */
public class StdPersonJpaController implements Serializable {

    private StdPerson stdPerson;
    private M4ccbHrCc m4ccbHrCc;
    private M4ccbHrCcPK m4ccbHrCcPk;
    private EntityManager emP;

    public StdPersonJpaController() {
        this.stdPerson = stdPerson;
        this.m4ccbHrCc = m4ccbHrCc;
        this.m4ccbHrCcPk = m4ccbHrCcPk;

    }

    public StdPersonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdPerson stdPerson) throws PreexistingEntityException, Exception {
        if (stdPerson.getStdPersonPK() == null) {
            stdPerson.setStdPersonPK(new StdPersonPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdPerson);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdPerson(stdPerson.getStdPersonPK()) != null) {
                throw new PreexistingEntityException("StdPerson " + stdPerson + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdPerson stdPerson) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdPerson = em.merge(stdPerson);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdPersonPK id = stdPerson.getStdPersonPK();
                if (findStdPerson(id) == null) {
                    throw new NonexistentEntityException("The stdPerson with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdPersonPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdPerson stdPerson;
            try {
                stdPerson = em.getReference(StdPerson.class, id);
                stdPerson.getStdPersonPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdPerson with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdPerson);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdPerson> findStdPersonEntities() {
        return findStdPersonEntities(true, -1, -1);
    }

    public List<StdPerson> findStdPersonEntities(int maxResults, int firstResult) {
        return findStdPersonEntities(false, maxResults, firstResult);
    }

    private List<StdPerson> findStdPersonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdPerson.class));
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

    public StdPerson findStdPerson(StdPersonPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdPerson.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdPersonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdPerson> rt = cq.from(StdPerson.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String userPeople(String idProfesor) throws NonexistentEntityException {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU");
        String idPeoplef;
        emP = getEntityManager();
        stdPerson = new StdPerson();
        m4ccbHrCc = new M4ccbHrCc();
        m4ccbHrCcPk = new M4ccbHrCcPK();
        try {
            /*
             * select p.STD_ID_PERSON from STD_PERSON p,M4CCB_HR_CC c where
             * p.STD_SSN=:DI and C.CCB_CENTRO_COSTO like 'CA01%' and
             * p.STD_ID_PERSON = C.STD_ID_HR order by STD_ID_PERSON asc
             */
            //Query q = emP.createQuery("select p from StdPerson p where p.stdSsn=:PROFESOR_ID");

            Query q = emP.createQuery("select p.stdPersonPK.stdIdPerson from StdPerson p,M4ccbHrCc c where p.stdSsn=:PROFESOR_ID and c.m4ccbHrCcPK.ccbCentroCosto  like 'CA01%' and p.stdPersonPK.stdIdPerson = c.m4ccbHrCcPK.stdIdHr");
            q.setParameter("PROFESOR_ID", idProfesor);
            q.setMaxResults(1);

            idPeoplef = (String) this.getSingleResultOrNull(q);
            //idPeoplef = miProfesorBuscado.getStdPersonPK().getStdIdPerson();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The stdPerson with id " + idProfesor + " no longer exists.", enfe);
        }
        //System.out.println("ID::::::"+miProfesorBuscado);
        return idPeoplef;
    }

    public static Object getSingleResultOrNull(Query query) {
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } else if (results.size() == 1) {
            return results.get(0);
        }
        throw new NonUniqueResultException();
    }
}