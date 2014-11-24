/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Taller;
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
public class TallerJpaController implements Serializable {

    public TallerJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public TallerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Taller taller) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(taller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Taller taller) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            taller = em.merge(taller);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = taller.getCodigo();
                if (findTaller(id) == null) {
                    throw new NonexistentEntityException("The taller with id " + id + " no longer exists.");
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
            Taller taller;
            try {
                taller = em.getReference(Taller.class, id);
                taller.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taller with id " + id + " no longer exists.", enfe);
            }
            em.remove(taller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Taller> findTallerEntities() {
        return findTallerEntities(true, -1, -1);
    }

    public List<Taller> findTallerEntities(int maxResults, int firstResult) {
        return findTallerEntities(false, maxResults, firstResult);
    }

    private List<Taller> findTallerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Taller.class));
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

    public Taller findTaller(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Taller.class, id);
        } finally {
            em.close();
        }
    }

    public int getTallerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Taller> rt = cq.from(Taller.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Taller> traerTalleres(boolean activo){
        String sql ="SELECT object(t) FROM Taller t WHERE t.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Taller>)query.getResultList();
    }
    
    public List<Taller> traerTalleresNombre(boolean activo, String nombre){
        String sql ="SELECT object(t) FROM Taller t WHERE t.activo = "+activo+" AND t.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Taller>)query.getResultList();
    }
}
