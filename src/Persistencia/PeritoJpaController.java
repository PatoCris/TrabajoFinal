/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Perito;
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
public class PeritoJpaController implements Serializable {

    public PeritoJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    public PeritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perito perito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perito perito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            perito = em.merge(perito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = perito.getCodigo();
                if (findPerito(id) == null) {
                    throw new NonexistentEntityException("The perito with id " + id + " no longer exists.");
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
            Perito perito;
            try {
                perito = em.getReference(Perito.class, id);
                perito.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perito with id " + id + " no longer exists.", enfe);
            }
            em.remove(perito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perito> findPeritoEntities() {
        return findPeritoEntities(true, -1, -1);
    }

    public List<Perito> findPeritoEntities(int maxResults, int firstResult) {
        return findPeritoEntities(false, maxResults, firstResult);
    }

    private List<Perito> findPeritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perito.class));
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

    public Perito findPerito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perito.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perito> rt = cq.from(Perito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Perito> traerPeritos(boolean activo){
        String sql ="SELECT object(p) FROM Perito p WHERE p.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Perito>)query.getResultList();
    }
    
    public List<Perito> traerPeritosBusqueda(boolean activo, String apellido, int dni){
        String sql ="SELECT object(p) FROM Perito p WHERE p.activo = "+activo;
        if(!apellido.equals(""))
            sql = sql + " AND p.apellido LIKE '%"+apellido+"%'";
        if(dni != 0)
            sql = sql + " AND p.dni ="+dni;
        Query query = getEntityManager().createQuery(sql);
        return (List<Perito>)query.getResultList();
    }
    
    public boolean existePerito(int dni){
        boolean retorno = true;
        try{
            String sql = "SELECT Object(p) FROM Perito p WHERE p.dni = "+dni;
            Query query = getEntityManager().createQuery(sql);
            query.getSingleResult();
        }catch(Exception ex){
            retorno = false;
        }
        return retorno;
    }
    public boolean existePerito(int dni, int codigo) {
        boolean existe = true;
        try {
            String consulta = "SELECT object(p) FROM Perito p WHERE p.dni = " + dni + " and p.codigo <> " + codigo;
            Query query = this.getEntityManager().createQuery(consulta);
            query.getSingleResult();
        } catch (Exception e) {
            existe = false;
        }
        return existe;
    }
    
}
