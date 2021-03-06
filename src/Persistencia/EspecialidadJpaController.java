/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Especialidad;
import Modelo.Mecanico;
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
public class EspecialidadJpaController implements Serializable {

    public EspecialidadJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public EspecialidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidad especialidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidad especialidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            especialidad = em.merge(especialidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = especialidad.getCodigo();
                if (findEspecialidad(id) == null) {
                    throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.");
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
            Especialidad especialidad;
            try {
                especialidad = em.getReference(Especialidad.class, id);
                especialidad.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidad> findEspecialidadEntities() {
        return findEspecialidadEntities(true, -1, -1);
    }

    public List<Especialidad> findEspecialidadEntities(int maxResults, int firstResult) {
        return findEspecialidadEntities(false, maxResults, firstResult);
    }

    private List<Especialidad> findEspecialidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidad.class));
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

    public Especialidad findEspecialidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidad> rt = cq.from(Especialidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Especialidad> traerEspecialidades(boolean activo) {
        String sql = "SELECT Object(e) FROM Especialidad e WHERE e.activo =" + activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Especialidad>) query.getResultList();
    }

    public List<Especialidad> traerEspecialidadesNombre(boolean activo, String nombre) {
        String sql = "SELECT Object(e) FROM Especialidad e WHERE e.activo =" + activo + " AND e.nombre LIKE '%" + nombre + "%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Especialidad>) query.getResultList();
    }

    public List<Especialidad> traerEspecialidadesSinVinculo(Mecanico unMecanico){
        String sql ="SELECT Object(e) from Especialidad e where e.codigo NOT IN (SELECT eo.codigo FROM  Mecanico m INNER JOIN m.misEspecialidades eo WHERE m.codigo ="+unMecanico.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Especialidad>)query.getResultList();
    }
    
    public List<Especialidad> traerEspecialidadesConVinculo(Mecanico unMecanico){
        String sql ="SELECT Object(e) from Especialidad e where e.codigo IN (SELECT eo.codigo FROM  Mecanico m INNER JOIN m.misEspecialidades eo WHERE m.codigo ="+unMecanico.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Especialidad>)query.getResultList();
    }

}
