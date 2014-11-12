/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Segmento;
import Persistencia.exceptions.NonexistentEntityException;
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
 * @author cristian
 */
public class SegmentoJpaController implements Serializable {

    public SegmentoJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public SegmentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Segmento segmento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(segmento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Segmento segmento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            segmento = em.merge(segmento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = segmento.getCodigo();
                if (findSegmento(id) == null) {
                    throw new NonexistentEntityException("The segmento with id " + id + " no longer exists.");
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
            Segmento segmento;
            try {
                segmento = em.getReference(Segmento.class, id);
                segmento.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The segmento with id " + id + " no longer exists.", enfe);
            }
            em.remove(segmento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Segmento> findSegmentoEntities() {
        return findSegmentoEntities(true, -1, -1);
    }

    public List<Segmento> findSegmentoEntities(int maxResults, int firstResult) {
        return findSegmentoEntities(false, maxResults, firstResult);
    }

    private List<Segmento> findSegmentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Segmento.class));
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

    public Segmento findSegmento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Segmento.class, id);
        } finally {
            em.close();
        }
    }

    public int getSegmentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Segmento> rt = cq.from(Segmento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Segmento> traerSegmentos(boolean activo){
        String sql ="SELECT object(s) FROM Segmento s WHERE s.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Segmento>)query.getResultList();
    }
    
    public List<Segmento> traerSegmentosNombre(boolean activo, String nombre){
        String sql ="SELECT object(s) FROM Segmento s WHERE s.activo = "+activo+" AND s.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Segmento>)query.getResultList();
    }
    
}
