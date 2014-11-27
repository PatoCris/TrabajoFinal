/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Devolucion;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
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
public class DevolucionJpaController implements Serializable {

    public DevolucionJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public DevolucionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Devolucion devolucion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(devolucion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Devolucion devolucion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            devolucion = em.merge(devolucion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = devolucion.getCodigo();
                if (findDevolucion(id) == null) {
                    throw new NonexistentEntityException("The devolucion with id " + id + " no longer exists.");
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
            Devolucion devolucion;
            try {
                devolucion = em.getReference(Devolucion.class, id);
                devolucion.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devolucion with id " + id + " no longer exists.", enfe);
            }
            em.remove(devolucion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Devolucion> findDevolucionEntities() {
        return findDevolucionEntities(true, -1, -1);
    }

    public List<Devolucion> findDevolucionEntities(int maxResults, int firstResult) {
        return findDevolucionEntities(false, maxResults, firstResult);
    }

    private List<Devolucion> findDevolucionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Devolucion.class));
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

    public Devolucion findDevolucion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Devolucion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Devolucion> rt = cq.from(Devolucion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        
    public List<Devolucion> traerDevoluciones(boolean activo){
        String sql ="SELECT object(d) FROM Devolucion d WHERE d.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Devolucion>)query.getResultList();
    }
    
    public List<Devolucion> traerDevoluciones(boolean activo, java.util.Date fecha){
        String sql ="SELECT object(d) FROM Devolucion d WHERE d.activo = "+activo+" AND d.fecha = "+fecha;
        Query query = getEntityManager().createQuery(sql);
        return (List<Devolucion>)query.getResultList();
    }
    
    public List<Devolucion> traerDevolucionesSinDeposito(){
        String sql ="SELECT Object(d) FROM Devolucion d where d.codigo NOT IN (SELECT md.codigo FROM  Deposito dp INNER JOIN dp.misDevoluciones md)";
        Query query = getEntityManager().createQuery(sql);
        return (List<Devolucion>)query.getResultList();
    }
    
    public List<Devolucion> traerDevolucionesConDeposito(int deposito){
        String sql ="SELECT Object(d) FROM Devolucion d where d.codigo IN (SELECT md.codigo FROM  Deposito dp INNER JOIN dp.misDevoluciones md WHERE dp.codigo ="+deposito+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Devolucion>)query.getResultList();
    }
    public List<Devolucion> traerDevolucionesConDeposito(int deposito, String fecha){
        String sql ="SELECT Object(d) FROM Devolucion d where d.fecha = '"+fecha+"' AND d.codigo IN (SELECT md.codigo FROM  Deposito dp INNER JOIN dp.misDevoluciones md WHERE dp.codigo ="+deposito+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Devolucion>)query.getResultList();
    }
    
    public int ultimaDevolucion(){
        String sql ="SELECT MAX(d.codigo) FROM Devolucion d";
        Query query = getEntityManager().createQuery(sql);
        return (int)query.getSingleResult();
    }
}
