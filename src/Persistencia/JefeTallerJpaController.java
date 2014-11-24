/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.JefeTaller;
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
public class JefeTallerJpaController implements Serializable {

    public JefeTallerJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    public JefeTallerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(JefeTaller jefeTaller) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(jefeTaller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(JefeTaller jefeTaller) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            jefeTaller = em.merge(jefeTaller);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = jefeTaller.getCodigo();
                if (findJefeTaller(id) == null) {
                    throw new NonexistentEntityException("The jefeTaller with id " + id + " no longer exists.");
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
            JefeTaller jefeTaller;
            try {
                jefeTaller = em.getReference(JefeTaller.class, id);
                jefeTaller.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jefeTaller with id " + id + " no longer exists.", enfe);
            }
            em.remove(jefeTaller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<JefeTaller> findJefeTallerEntities() {
        return findJefeTallerEntities(true, -1, -1);
    }

    public List<JefeTaller> findJefeTallerEntities(int maxResults, int firstResult) {
        return findJefeTallerEntities(false, maxResults, firstResult);
    }

    private List<JefeTaller> findJefeTallerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(JefeTaller.class));
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

    public JefeTaller findJefeTaller(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(JefeTaller.class, id);
        } finally {
            em.close();
        }
    }

    public int getJefeTallerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<JefeTaller> rt = cq.from(JefeTaller.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<JefeTaller> traerJefesTaller(boolean activo){
        String sql ="SELECT object(e) FROM JefeTaller e WHERE e.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<JefeTaller>)query.getResultList();
    }
    
    public List<JefeTaller> traerJefesTallerBusqueda(boolean activo, String apellido, int dni){
        String sql ="SELECT object(e) FROM JefeTaller e WHERE e.activo = "+activo;
        if(!apellido.equals(""))
            sql = sql + " AND e.apellido LIKE '%"+apellido+"%'";
        if(dni != 0)
            sql = sql + " AND e.dni ="+dni;
        Query query = getEntityManager().createQuery(sql);
        return (List<JefeTaller>)query.getResultList();
    }
    
    public boolean existeJefeTaller(int dni){
        boolean retorno = true;
        try{
            String sql = "SELECT Object(e) FROM JefeTaller e WHERE e.dni ="+dni;
            Query query = getEntityManager().createQuery(sql);
            query.getSingleResult();
        }catch(Exception ex){
            retorno = false;
        }
        return retorno;
    }
    public boolean existeJefeTaller(int dni, int codigo) {
        boolean existe = true;
        try {
            String consulta = "SELECT object(e) FROM JefeTaller e WHERE e.dni = " + dni + " and e.codigo <> " + codigo;
            Query query = this.getEntityManager().createQuery(consulta);
            query.getSingleResult();
        } catch (Exception e) {
            existe = false;
        }
        return existe;
    }
    
}
