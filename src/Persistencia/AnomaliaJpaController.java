/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Anomalia;
import Modelo.Diagnostico;
import Modelo.TipoAnomalia;
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
public class AnomaliaJpaController implements Serializable {

    public AnomaliaJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public AnomaliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anomalia anomalia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(anomalia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anomalia anomalia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            anomalia = em.merge(anomalia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = anomalia.getCodigo();
                if (findAnomalia(id) == null) {
                    throw new NonexistentEntityException("The anomalia with id " + id + " no longer exists.");
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
            Anomalia anomalia;
            try {
                anomalia = em.getReference(Anomalia.class, id);
                anomalia.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anomalia with id " + id + " no longer exists.", enfe);
            }
            em.remove(anomalia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anomalia> findAnomaliaEntities() {
        return findAnomaliaEntities(true, -1, -1);
    }

    public List<Anomalia> findAnomaliaEntities(int maxResults, int firstResult) {
        return findAnomaliaEntities(false, maxResults, firstResult);
    }

    private List<Anomalia> findAnomaliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anomalia.class));
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

    public Anomalia findAnomalia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anomalia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnomaliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anomalia> rt = cq.from(Anomalia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Anomalia> traerAnomalias(boolean activo){
        String sql ="SELECT object(a) FROM Anomalia a WHERE a.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Anomalia>)query.getResultList();
    }
    
    public List<Anomalia> traerAnomaliasBusqueda(boolean activo, String nivel, TipoAnomalia tipo){
        String sql ="SELECT object(a) FROM Anomalia a WHERE a.activo = "+activo;
        if(!nivel.equals("")){
            sql = sql + " AND a.nivelSeveridad = '"+nivel+"'";
        }
        if(tipo != null){
            sql = sql + " AND a.unTipoAnomalia.codigo = "+tipo.getCodigo();
        }
        Query query = getEntityManager().createQuery(sql);
        return (List<Anomalia>)query.getResultList();
    }
    
    public List<Anomalia> traerAnomaliasSinVinculoConDiagnostico(Diagnostico unDiagnostico){
        String sql ="SELECT Object(a) from Anomalia a where a.codigo NOT IN (SELECT ad.codigo FROM  Diagnostico d INNER JOIN d.misAnomalias ad WHERE d.codigo ="+unDiagnostico.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Anomalia>)query.getResultList();
    }
    
    public List<Anomalia> traerAnomaliasVinculadoDiagnostico(Diagnostico unDiagnostico){
        String sql ="SELECT Object(a) from Anomalia a where a.codigo IN (SELECT ad.codigo FROM  Diagnostico d INNER JOIN d.misAnomalias ad WHERE d.codigo ="+unDiagnostico.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Anomalia>)query.getResultList();
    }
    
}
