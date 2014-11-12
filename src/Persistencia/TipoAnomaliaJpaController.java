/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.TipoAnomalia;
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
public class TipoAnomaliaJpaController implements Serializable {

    public TipoAnomaliaJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    
    public TipoAnomaliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoAnomalia tipoAnomalia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoAnomalia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoAnomalia tipoAnomalia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoAnomalia = em.merge(tipoAnomalia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoAnomalia.getCodigo();
                if (findTipoAnomalia(id) == null) {
                    throw new NonexistentEntityException("The tipoAnomalia with id " + id + " no longer exists.");
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
            TipoAnomalia tipoAnomalia;
            try {
                tipoAnomalia = em.getReference(TipoAnomalia.class, id);
                tipoAnomalia.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoAnomalia with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoAnomalia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoAnomalia> findTipoAnomaliaEntities() {
        return findTipoAnomaliaEntities(true, -1, -1);
    }

    public List<TipoAnomalia> findTipoAnomaliaEntities(int maxResults, int firstResult) {
        return findTipoAnomaliaEntities(false, maxResults, firstResult);
    }

    private List<TipoAnomalia> findTipoAnomaliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoAnomalia.class));
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

    public TipoAnomalia findTipoAnomalia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoAnomalia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoAnomaliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoAnomalia> rt = cq.from(TipoAnomalia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<TipoAnomalia> traerTipoAnomalia(boolean activo){
        String sql ="SELECT object(ta) FROM TipoAnomalia ta WHERE ta.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<TipoAnomalia>)query.getResultList();
    }
    public List traerTipoAnomaliaList(boolean activo){
        String sql ="SELECT object(ta) FROM TipoAnomalia ta WHERE ta.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return query.getResultList();
    }
    
    public List<TipoAnomalia> traerTipoAnomaliaNombre(boolean activo, String nombre){
        String sql ="SELECT object(ta) FROM TipoAnomalia ta WHERE ta.activo = "+activo+" AND ta.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<TipoAnomalia>)query.getResultList();
    }
}
