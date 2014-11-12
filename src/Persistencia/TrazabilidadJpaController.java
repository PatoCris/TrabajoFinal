/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Trazabilidad;
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
public class TrazabilidadJpaController implements Serializable {

    public TrazabilidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Trazabilidad trazabilidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trazabilidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trazabilidad trazabilidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trazabilidad = em.merge(trazabilidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = trazabilidad.getCodigo();
                if (findTrazabilidad(id) == null) {
                    throw new NonexistentEntityException("The trazabilidad with id " + id + " no longer exists.");
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
            Trazabilidad trazabilidad;
            try {
                trazabilidad = em.getReference(Trazabilidad.class, id);
                trazabilidad.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trazabilidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(trazabilidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Trazabilidad> findTrazabilidadEntities() {
        return findTrazabilidadEntities(true, -1, -1);
    }

    public List<Trazabilidad> findTrazabilidadEntities(int maxResults, int firstResult) {
        return findTrazabilidadEntities(false, maxResults, firstResult);
    }

    private List<Trazabilidad> findTrazabilidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trazabilidad.class));
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

    public Trazabilidad findTrazabilidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Trazabilidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrazabilidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trazabilidad> rt = cq.from(Trazabilidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
