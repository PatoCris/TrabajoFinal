/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Accesorio;
import Modelo.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cristian
 */
public class AccesorioJpaController implements Serializable {

    public AccesorioJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public AccesorioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Accesorio accesorio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accesorio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accesorio accesorio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accesorio = em.merge(accesorio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = accesorio.getCodigo();
                if (findAccesorio(id) == null) {
                    throw new NonexistentEntityException("The accesorio with id " + id + " no longer exists.");
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
            Accesorio accesorio;
            try {
                accesorio = em.getReference(Accesorio.class, id);
                accesorio.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accesorio with id " + id + " no longer exists.", enfe);
            }
            em.remove(accesorio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Accesorio> findAccesorioEntities() {
        return findAccesorioEntities(true, -1, -1);
    }

    public List<Accesorio> findAccesorioEntities(int maxResults, int firstResult) {
        return findAccesorioEntities(false, maxResults, firstResult);
    }

    private List<Accesorio> findAccesorioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accesorio.class));
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

    public Accesorio findAccesorio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Accesorio.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccesorioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accesorio> rt = cq.from(Accesorio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Accesorio> traerAccesorios(boolean activo){
        String sql ="SELECT object(a) FROM Accesorio a WHERE a.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Accesorio>)query.getResultList();
    }
    
    public List<Accesorio> traerAccesoriosNombre(boolean activo, String nombre){
        String sql ="SELECT object(a) FROM Accesorio a WHERE a.activo = "+activo+" AND a.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Accesorio>)query.getResultList();
    }
    
    public List<Accesorio> traerAccesoriosSinVehiculo(Vehiculo vehiculo){
        String sql ="SELECT Object(a) from Accesorio a where a.codigo NOT IN (SELECT ma.codigo FROM  Vehiculo v INNER JOIN v.misAccesorios ma WHERE v.codigo ="+vehiculo.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Accesorio>)query.getResultList();
    }
    
    public List<Accesorio> traerAccesoriosConVehiculo(Vehiculo vehiculo){
        String sql ="SELECT Object(a) from Accesorio a where a.codigo IN (SELECT ma.codigo FROM  Vehiculo v INNER JOIN v.misAccesorios ma WHERE v.codigo ="+vehiculo.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Accesorio>)query.getResultList();
    }
}
