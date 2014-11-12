/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.JefeDeposito;
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
public class JefeDepositoJpaController implements Serializable {

    public JefeDepositoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(JefeDeposito jefeDeposito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(jefeDeposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(JefeDeposito jefeDeposito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            jefeDeposito = em.merge(jefeDeposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = jefeDeposito.getCodigo();
                if (findJefeDeposito(id) == null) {
                    throw new NonexistentEntityException("The jefeDeposito with id " + id + " no longer exists.");
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
            JefeDeposito jefeDeposito;
            try {
                jefeDeposito = em.getReference(JefeDeposito.class, id);
                jefeDeposito.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jefeDeposito with id " + id + " no longer exists.", enfe);
            }
            em.remove(jefeDeposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<JefeDeposito> findJefeDepositoEntities() {
        return findJefeDepositoEntities(true, -1, -1);
    }

    public List<JefeDeposito> findJefeDepositoEntities(int maxResults, int firstResult) {
        return findJefeDepositoEntities(false, maxResults, firstResult);
    }

    private List<JefeDeposito> findJefeDepositoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(JefeDeposito.class));
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

    public JefeDeposito findJefeDeposito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(JefeDeposito.class, id);
        } finally {
            em.close();
        }
    }

    public int getJefeDepositoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<JefeDeposito> rt = cq.from(JefeDeposito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
