/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.PruebaRodaje;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cristian
 */
public class PruebaRodajeJpaController implements Serializable {

    public PruebaRodajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PruebaRodaje pruebaRodaje) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pruebaRodaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PruebaRodaje pruebaRodaje) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pruebaRodaje = em.merge(pruebaRodaje);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pruebaRodaje.getCodigo();
                if (findPruebaRodaje(id) == null) {
                    throw new NonexistentEntityException("The pruebaRodaje with id " + id + " no longer exists.");
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
            PruebaRodaje pruebaRodaje;
            try {
                pruebaRodaje = em.getReference(PruebaRodaje.class, id);
                pruebaRodaje.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pruebaRodaje with id " + id + " no longer exists.", enfe);
            }
            em.remove(pruebaRodaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PruebaRodaje> findPruebaRodajeEntities() {
        return findPruebaRodajeEntities(true, -1, -1);
    }

    public List<PruebaRodaje> findPruebaRodajeEntities(int maxResults, int firstResult) {
        return findPruebaRodajeEntities(false, maxResults, firstResult);
    }

    private List<PruebaRodaje> findPruebaRodajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PruebaRodaje.class));
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

    public PruebaRodaje findPruebaRodaje(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PruebaRodaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getPruebaRodajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PruebaRodaje> rt = cq.from(PruebaRodaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
