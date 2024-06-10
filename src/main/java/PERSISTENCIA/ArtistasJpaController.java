/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERSISTENCIA;

import LOGICA.Artistas;
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
public class ArtistasJpaController implements Serializable {

    public ArtistasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ArtistasJpaController() {
       emf = Persistence.createEntityManagerFactory ("Artianction_PU");
    
    
    }
    
    public void create(Artistas artistas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(artistas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Artistas artistas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            artistas = em.merge(artistas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = artistas.getId();
                if (findArtistas(id) == null) {
                    throw new NonexistentEntityException("The artistas with id " + id + " no longer exists.");
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
            Artistas artistas;
            try {
                artistas = em.getReference(Artistas.class, id);
                artistas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artistas with id " + id + " no longer exists.", enfe);
            }
            em.remove(artistas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artistas> findArtistasEntities() {
        return findArtistasEntities(true, -1, -1);
    }

    public List<Artistas> findArtistasEntities(int maxResults, int firstResult) {
        return findArtistasEntities(false, maxResults, firstResult);
    }

    private List<Artistas> findArtistasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artistas.class));
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

    public Artistas findArtistas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Artistas.class, id);
        } finally {
            em.close();
        }
    }

    public int getArtistasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Artistas> rt = cq.from(Artistas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
