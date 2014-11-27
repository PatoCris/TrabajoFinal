/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.AgendaMensual;
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
public class AgendaMensualJpaController implements Serializable {

    public AgendaMensualJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    public AgendaMensualJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AgendaMensual agendaMensual) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agendaMensual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AgendaMensual agendaMensual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agendaMensual = em.merge(agendaMensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = agendaMensual.getCodigo();
                if (findAgendaMensual(id) == null) {
                    throw new NonexistentEntityException("The agendaMensual with id " + id + " no longer exists.");
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
            AgendaMensual agendaMensual;
            try {
                agendaMensual = em.getReference(AgendaMensual.class, id);
                agendaMensual.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agendaMensual with id " + id + " no longer exists.", enfe);
            }
            em.remove(agendaMensual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AgendaMensual> findAgendaMensualEntities() {
        return findAgendaMensualEntities(true, -1, -1);
    }

    public List<AgendaMensual> findAgendaMensualEntities(int maxResults, int firstResult) {
        return findAgendaMensualEntities(false, maxResults, firstResult);
    }

    private List<AgendaMensual> findAgendaMensualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AgendaMensual.class));
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

    public AgendaMensual findAgendaMensual(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AgendaMensual.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendaMensualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AgendaMensual> rt = cq.from(AgendaMensual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<AgendaMensual> traerAgendaMensual(boolean activo){
        String sql ="SELECT object(am) FROM AgendaMensual am WHERE am.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<AgendaMensual>)query.getResultList();
    }
    
    public List<AgendaMensual> traerAgendaMensualAnio(boolean activo, int anio){
        String sql ="SELECT object(am) FROM AgendaMensual am WHERE am.activo = "+activo+" AND am.anio = "+anio;
        Query query = getEntityManager().createQuery(sql);
        return (List<AgendaMensual>)query.getResultList();
    }
    public List<AgendaMensual> traerAgendaMensualSinTaller(){
        String sql ="SELECT Object(am) from AgendaMensual am where am.codigo NOT IN (SELECT mam.codigo FROM  Taller t INNER JOIN t.misAgendasMensuales mam)";
        Query query = getEntityManager().createQuery(sql);
        return (List<AgendaMensual>)query.getResultList();
    }
    
    public List<AgendaMensual> traerAgendaMensualConTaller(int codigoTaller){
        String sql ="SELECT Object(am) from AgendaMensual am where am.codigo IN (SELECT mam.codigo FROM  Taller t INNER JOIN t.misAgendasMensuales mam WHERE t.codigo ="+codigoTaller+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<AgendaMensual>)query.getResultList();
    }
    public int ultimoAgendaMensual(){
        String sql ="SELECT MAX(am.codigo) FROM AgendaMensual am";
        Query query = getEntityManager().createQuery(sql);
        return (int)query.getSingleResult();
    }
}
