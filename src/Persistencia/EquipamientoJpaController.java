/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Equipamiento;
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
public class EquipamientoJpaController implements Serializable {

    public EquipamientoJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public EquipamientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipamiento equipamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(equipamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipamiento equipamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            equipamiento = em.merge(equipamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = equipamiento.getCodigo();
                if (findEquipamiento(id) == null) {
                    throw new NonexistentEntityException("The equipamiento with id " + id + " no longer exists.");
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
            Equipamiento equipamiento;
            try {
                equipamiento = em.getReference(Equipamiento.class, id);
                equipamiento.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(equipamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipamiento> findEquipamientoEntities() {
        return findEquipamientoEntities(true, -1, -1);
    }

    public List<Equipamiento> findEquipamientoEntities(int maxResults, int firstResult) {
        return findEquipamientoEntities(false, maxResults, firstResult);
    }

    private List<Equipamiento> findEquipamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipamiento.class));
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

    public Equipamiento findEquipamiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipamiento> rt = cq.from(Equipamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Equipamiento> traerEquipamientos(boolean activo){
        String sql ="SELECT object(e) FROM Equipamiento e WHERE e.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Equipamiento>)query.getResultList();
    }
    
    public List<Equipamiento> traerEquipamientosNombre(boolean activo, String nombre){
        String sql ="SELECT object(e) FROM Equipamiento e WHERE e.activo = "+activo+" AND e.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Equipamiento>)query.getResultList();
    }
}
