/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.TipoPiezaRecambio;
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
public class TipoPiezaRecambioJpaController implements Serializable {

    public TipoPiezaRecambioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoPiezaRecambio tipoPiezaRecambio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoPiezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoPiezaRecambio tipoPiezaRecambio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoPiezaRecambio = em.merge(tipoPiezaRecambio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoPiezaRecambio.getCodigo();
                if (findTipoPiezaRecambio(id) == null) {
                    throw new NonexistentEntityException("The tipoPiezaRecambio with id " + id + " no longer exists.");
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
            TipoPiezaRecambio tipoPiezaRecambio;
            try {
                tipoPiezaRecambio = em.getReference(TipoPiezaRecambio.class, id);
                tipoPiezaRecambio.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoPiezaRecambio with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoPiezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoPiezaRecambio> findTipoPiezaRecambioEntities() {
        return findTipoPiezaRecambioEntities(true, -1, -1);
    }

    public List<TipoPiezaRecambio> findTipoPiezaRecambioEntities(int maxResults, int firstResult) {
        return findTipoPiezaRecambioEntities(false, maxResults, firstResult);
    }

    private List<TipoPiezaRecambio> findTipoPiezaRecambioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoPiezaRecambio.class));
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

    public TipoPiezaRecambio findTipoPiezaRecambio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoPiezaRecambio.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoPiezaRecambioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoPiezaRecambio> rt = cq.from(TipoPiezaRecambio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
