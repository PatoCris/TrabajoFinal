/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Modelo;
import Modelo.PiezaRecambio;
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
public class ModeloJpaController implements Serializable {

    public ModeloJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public ModeloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modelo modelo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(modelo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modelo modelo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            modelo = em.merge(modelo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = modelo.getCodigo();
                if (findModelo(id) == null) {
                    throw new NonexistentEntityException("The modelo with id " + id + " no longer exists.");
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
            Modelo modelo;
            try {
                modelo = em.getReference(Modelo.class, id);
                modelo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modelo with id " + id + " no longer exists.", enfe);
            }
            em.remove(modelo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modelo> findModeloEntities() {
        return findModeloEntities(true, -1, -1);
    }

    public List<Modelo> findModeloEntities(int maxResults, int firstResult) {
        return findModeloEntities(false, maxResults, firstResult);
    }

    private List<Modelo> findModeloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modelo.class));
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

    public Modelo findModelo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modelo.class, id);
        } finally {
            em.close();
        }
    }

    public int getModeloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modelo> rt = cq.from(Modelo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Modelo> traerModelos(boolean activo){
        String sql ="SELECT object(m) FROM Modelo m WHERE m.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Modelo>)query.getResultList();
    }
    
    public List<Modelo> traerModelosNombre(boolean activo, String nombre){
        String sql ="SELECT object(m) FROM Modelo m WHERE m.activo = "+activo+" AND m.nombre LIKE '%"+nombre+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Modelo>)query.getResultList();
    }  	
    
    public List<Modelo> traerModelosSinVinculo(PiezaRecambio pieza){
        String sql ="SELECT Object(m) from Modelo m where m.codigo NOT IN (SELECT mo.codigo FROM  PiezaRecambio p INNER JOIN p.vehiculosCompatibles mo WHERE p.codigo ="+pieza.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Modelo>)query.getResultList();
    }
    
    public List<Modelo> traerModelosConVinculo(PiezaRecambio pieza){
        String sql ="SELECT Object(m) from Modelo m where m.codigo IN (SELECT mo.codigo FROM  PiezaRecambio p INNER JOIN p.vehiculosCompatibles mo WHERE p.codigo ="+pieza.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Modelo>)query.getResultList();
    }
}
