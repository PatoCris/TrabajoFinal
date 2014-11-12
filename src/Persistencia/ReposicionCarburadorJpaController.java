/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.ReposicionCarburador;
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
public class ReposicionCarburadorJpaController implements Serializable {

    public ReposicionCarburadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReposicionCarburador reposicionCarburador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reposicionCarburador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReposicionCarburador reposicionCarburador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reposicionCarburador = em.merge(reposicionCarburador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reposicionCarburador.getCodigo();
                if (findReposicionCarburador(id) == null) {
                    throw new NonexistentEntityException("The reposicionCarburador with id " + id + " no longer exists.");
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
            ReposicionCarburador reposicionCarburador;
            try {
                reposicionCarburador = em.getReference(ReposicionCarburador.class, id);
                reposicionCarburador.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reposicionCarburador with id " + id + " no longer exists.", enfe);
            }
            em.remove(reposicionCarburador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReposicionCarburador> findReposicionCarburadorEntities() {
        return findReposicionCarburadorEntities(true, -1, -1);
    }

    public List<ReposicionCarburador> findReposicionCarburadorEntities(int maxResults, int firstResult) {
        return findReposicionCarburadorEntities(false, maxResults, firstResult);
    }

    private List<ReposicionCarburador> findReposicionCarburadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReposicionCarburador.class));
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

    public ReposicionCarburador findReposicionCarburador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReposicionCarburador.class, id);
        } finally {
            em.close();
        }
    }

    public int getReposicionCarburadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReposicionCarburador> rt = cq.from(ReposicionCarburador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
