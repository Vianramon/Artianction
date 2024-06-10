/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERSISTENCIA;

import LOGICA.Expertos_arte;
import PERSISTENCIA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author vramirez
 */
public class Expertos_arteJpaController implements Serializable {

    public Expertos_arteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Expertos_arteJpaController() {
       emf = Persistence.createEntityManagerFactory ("Artianction_PU");
 }

    public void create(Expertos_arte expertos_arte) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(expertos_arte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Expertos_arte expertos_arte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            expertos_arte = em.merge(expertos_arte);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = expertos_arte.getId();
                if (findExpertos_arte(id) == null) {
                    throw new NonexistentEntityException("The expertos_arte with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Expertos_arte expertos_arte;
            try {
                expertos_arte = em.getReference(Expertos_arte.class, id);
                expertos_arte.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The expertos_arte with id " + id + " no longer exists.", enfe);
            }
            em.remove(expertos_arte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Expertos_arte> findExpertos_arteEntities() {
        return findExpertos_arteEntities(true, -1, -1);
    }

    public List<Expertos_arte> findExpertos_arteEntities(int maxResults, int firstResult) {
        return findExpertos_arteEntities(false, maxResults, firstResult);
    }

    private List<Expertos_arte> findExpertos_arteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Expertos_arte.class));
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

    public Expertos_arte findExpertos_arte(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Expertos_arte.class, id);
        } finally {
            em.close();
        }
    }

    public int getExpertos_arteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Expertos_arte> rt = cq.from(Expertos_arte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
