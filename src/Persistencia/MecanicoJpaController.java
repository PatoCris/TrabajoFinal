/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

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
public class MecanicoJpaController implements Serializable {

    public MecanicoJpaController(){
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public MecanicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mecanico mecanico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mecanico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mecanico mecanico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mecanico = em.merge(mecanico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mecanico.getCodigo();
                if (findMecanico(id) == null) {
                    throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.");
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
            Mecanico mecanico;
            try {
                mecanico = em.getReference(Mecanico.class, id);
                mecanico.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.", enfe);
            }
            em.remove(mecanico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mecanico> findMecanicoEntities() {
        return findMecanicoEntities(true, -1, -1);
    }

    public List<Mecanico> findMecanicoEntities(int maxResults, int firstResult) {
        return findMecanicoEntities(false, maxResults, firstResult);
    }

    private List<Mecanico> findMecanicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mecanico.class));
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

    public Mecanico findMecanico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mecanico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMecanicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mecanico> rt = cq.from(Mecanico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Mecanico> traerMecanicos(boolean activo){
        String sql ="SELECT object(m) FROM Mecanico m WHERE m.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Mecanico>)query.getResultList();
    }
    
    public List<Mecanico> traerMecanicosBusqueda(boolean activo, String apellido, int dni){
        String sql ="SELECT object(m) FROM Mecanico m WHERE m.activo = "+activo;
        if(!apellido.equals(""))
            sql = sql + " AND m.apellido LIKE '%"+apellido+"%'";
        if(dni != 0)
            sql = sql + " AND m.dni ="+dni;
        Query query = getEntityManager().createQuery(sql);
        return (List<Mecanico>)query.getResultList();
    }
    
    public boolean existeMecanico(int dni){
        boolean retorno = true;
        try{
            String sql = "SELECT Object(m) FROM Mecanico m WHERE m.dni = "+dni;
            Query query = getEntityManager().createQuery(sql);
            query.getSingleResult();
        }catch(Exception ex){
            retorno = false;
        }
        return retorno;
    }
    public boolean existeMecanico(int dni, int codigo) {
        boolean existe = true;
        try {
            String consulta = "SELECT object(m) FROM Mecanico m WHERE m.dni = " + dni + " and m.codigo <> " + codigo;
            Query query = this.getEntityManager().createQuery(consulta);
            query.getSingleResult();
        } catch (Exception e) {
            existe = false;
        }
        return existe;
    }
}
