/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.SolicitudPiezaRecambio;
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
public class SolicitudPiezaRecambioJpaController implements Serializable {

    public SolicitudPiezaRecambioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitudPiezaRecambio solicitudPiezaRecambio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solicitudPiezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitudPiezaRecambio solicitudPiezaRecambio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solicitudPiezaRecambio = em.merge(solicitudPiezaRecambio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = solicitudPiezaRecambio.getCodigo();
                if (findSolicitudPiezaRecambio(id) == null) {
                    throw new NonexistentEntityException("The solicitudPiezaRecambio with id " + id + " no longer exists.");
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
            SolicitudPiezaRecambio solicitudPiezaRecambio;
            try {
                solicitudPiezaRecambio = em.getReference(SolicitudPiezaRecambio.class, id);
                solicitudPiezaRecambio.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitudPiezaRecambio with id " + id + " no longer exists.", enfe);
            }
            em.remove(solicitudPiezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudPiezaRecambio> findSolicitudPiezaRecambioEntities() {
        return findSolicitudPiezaRecambioEntities(true, -1, -1);
    }

    public List<SolicitudPiezaRecambio> findSolicitudPiezaRecambioEntities(int maxResults, int firstResult) {
        return findSolicitudPiezaRecambioEntities(false, maxResults, firstResult);
    }

    private List<SolicitudPiezaRecambio> findSolicitudPiezaRecambioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitudPiezaRecambio.class));
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

    public SolicitudPiezaRecambio findSolicitudPiezaRecambio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudPiezaRecambio.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitudPiezaRecambioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitudPiezaRecambio> rt = cq.from(SolicitudPiezaRecambio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
