/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Marca;
import Modelo.TipoReparacion;
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
public class TipoReparacionJpaController implements Serializable {

    public TipoReparacionJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public TipoReparacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoReparacion tipoReparacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoReparacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoReparacion tipoReparacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoReparacion = em.merge(tipoReparacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoReparacion.getCodigo();
                if (findTipoReparacion(id) == null) {
                    throw new NonexistentEntityException("The tipoReparacion with id " + id + " no longer exists.");
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
            TipoReparacion tipoReparacion;
            try {
                tipoReparacion = em.getReference(TipoReparacion.class, id);
                tipoReparacion.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoReparacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoReparacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoReparacion> findTipoReparacionEntities() {
        return findTipoReparacionEntities(true, -1, -1);
    }

    public List<TipoReparacion> findTipoReparacionEntities(int maxResults, int firstResult) {
        return findTipoReparacionEntities(false, maxResults, firstResult);
    }

    private List<TipoReparacion> findTipoReparacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoReparacion.class));
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

    public TipoReparacion findTipoReparacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoReparacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoReparacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoReparacion> rt = cq.from(TipoReparacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<TipoReparacion> traerTipoReparacion(boolean activo){
        String sql ="SELECT object(t) FROM TipoReparacion t WHERE t.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<TipoReparacion>)query.getResultList();
    }
    
    public List<TipoReparacion> traerTipoReparacionNombre(boolean activo, String nombre){
        String sql ="SELECT object(tr) FROM TipoReparacion tr WHERE tr.activo = "+activo+" AND tr.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<TipoReparacion>)query.getResultList();
    }
    
}
