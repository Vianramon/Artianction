/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERSISTENCIA;

import LOGICA.Coleccionistas;
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
public class ColeccionistasJpaController implements Serializable {

    public ColeccionistasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ColeccionistasJpaController() {
       emf = Persistence.createEntityManagerFactory ("Artianction_PU");
 }

    public void create(Coleccionistas coleccionistas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(coleccionistas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Coleccionistas coleccionistas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            coleccionistas = em.merge(coleccionistas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = coleccionistas.getId();
                if (findColeccionistas(id) == null) {
                    throw new NonexistentEntityException("The coleccionistas with id " + id + " no longer exists.");
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
            Coleccionistas coleccionistas;
            try {
                coleccionistas = em.getReference(Coleccionistas.class, id);
                coleccionistas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coleccionistas with id " + id + " no longer exists.", enfe);
            }
            em.remove(coleccionistas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Coleccionistas> findColeccionistasEntities() {
        return findColeccionistasEntities(true, -1, -1);
    }

    public List<Coleccionistas> findColeccionistasEntities(int maxResults, int firstResult) {
        return findColeccionistasEntities(false, maxResults, firstResult);
    }

    private List<Coleccionistas> findColeccionistasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Coleccionistas.class));
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

    public Coleccionistas findColeccionistas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Coleccionistas.class, id);
        } finally {
            em.close();
        }
    }

    public int getColeccionistasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Coleccionistas> rt = cq.from(Coleccionistas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
