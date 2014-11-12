/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.InformePiezaPedido;
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
public class InformePiezaPedidoJpaController implements Serializable {

    public InformePiezaPedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InformePiezaPedido informePiezaPedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(informePiezaPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InformePiezaPedido informePiezaPedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            informePiezaPedido = em.merge(informePiezaPedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = informePiezaPedido.getCodigo();
                if (findInformePiezaPedido(id) == null) {
                    throw new NonexistentEntityException("The informePiezaPedido with id " + id + " no longer exists.");
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
            InformePiezaPedido informePiezaPedido;
            try {
                informePiezaPedido = em.getReference(InformePiezaPedido.class, id);
                informePiezaPedido.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The informePiezaPedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(informePiezaPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InformePiezaPedido> findInformePiezaPedidoEntities() {
        return findInformePiezaPedidoEntities(true, -1, -1);
    }

    public List<InformePiezaPedido> findInformePiezaPedidoEntities(int maxResults, int firstResult) {
        return findInformePiezaPedidoEntities(false, maxResults, firstResult);
    }

    private List<InformePiezaPedido> findInformePiezaPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InformePiezaPedido.class));
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

    public InformePiezaPedido findInformePiezaPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InformePiezaPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getInformePiezaPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InformePiezaPedido> rt = cq.from(InformePiezaPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
