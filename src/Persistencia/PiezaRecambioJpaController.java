/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Modelo;
import Modelo.PiezaRecambio;
import Modelo.Proceso;
import Modelo.TipoReparacion;
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
public class PiezaRecambioJpaController implements Serializable {
    
    public PiezaRecambioJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public PiezaRecambioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PiezaRecambio piezaRecambio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(piezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PiezaRecambio piezaRecambio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            piezaRecambio = em.merge(piezaRecambio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = piezaRecambio.getCodigo();
                if (findPiezaRecambio(id) == null) {
                    throw new NonexistentEntityException("The piezaRecambio with id " + id + " no longer exists.");
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
            PiezaRecambio piezaRecambio;
            try {
                piezaRecambio = em.getReference(PiezaRecambio.class, id);
                piezaRecambio.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The piezaRecambio with id " + id + " no longer exists.", enfe);
            }
            em.remove(piezaRecambio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PiezaRecambio> findPiezaRecambioEntities() {
        return findPiezaRecambioEntities(true, -1, -1);
    }

    public List<PiezaRecambio> findPiezaRecambioEntities(int maxResults, int firstResult) {
        return findPiezaRecambioEntities(false, maxResults, firstResult);
    }

    private List<PiezaRecambio> findPiezaRecambioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PiezaRecambio.class));
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

    public PiezaRecambio findPiezaRecambio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PiezaRecambio.class, id);
        } finally {
            em.close();
        }
    }

    public int getPiezaRecambioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PiezaRecambio> rt = cq.from(PiezaRecambio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<PiezaRecambio> traerPiezaRecambios(boolean activo){
        String sql ="SELECT object(pr) FROM PiezaRecambio pr WHERE pr.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<PiezaRecambio>)query.getResultList();
    }
    
    public List<PiezaRecambio> traerPiezaRecambiosBusqueda(boolean activo, String nombre, TipoReparacion tipo){
        String sql ="SELECT object(pr) FROM PiezaRecambio pr WHERE pr.activo = "+activo;
        if(!nombre.equals("")){
            sql = sql + " AND pr.nombre LIKE '%"+nombre+"%'";
        }
        if(tipo != null){
            sql = sql + " AND pr.grupoParte.codigo = "+tipo.getCodigo();
        }
        Query query = getEntityManager().createQuery(sql);
        return (List<PiezaRecambio>)query.getResultList();
    }
    
    List<PiezaRecambio> traerPiezasSinVinculoConProceso(Proceso unProceso) {
        String sql ="SELECT Object(p) from PiezaRecambio p where p.codigo NOT IN (SELECT po.codigo FROM  Proceso o INNER JOIN o.misPiezasRecambios po WHERE o.codigo ="+unProceso.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<PiezaRecambio>)query.getResultList();    
    }

    List<PiezaRecambio> traerPiezasConVinculoSinProceso(Proceso unProceso) {
    String sql ="SELECT Object(p) from PiezaRecambio p where p.codigo IN (SELECT po.codigo FROM  Proceso o INNER JOIN o.misPiezasRecambios po WHERE o.codigo ="+unProceso.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<PiezaRecambio>)query.getResultList();   
    }
        
    
}
