/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Empleado;
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
public class EmpleadoJpaController implements Serializable {
    
    public EmpleadoJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleado = em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getCodigo();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Empleado> traerEmpleados(boolean activo){
        String sql ="SELECT object(e) FROM Empleado e WHERE e.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Empleado>)query.getResultList();
    }
    
    public List<Empleado> traerEmpleadosBusqueda(boolean activo, String apellido, int dni){
        String sql ="SELECT object(e) FROM Empleado e WHERE e.activo = "+activo;
        if(!apellido.equals(""))
            sql = sql + " AND e.apellido LIKE '%"+apellido+"%'";
        if(dni != 0)
            sql = sql + " AND e.dni LIKE '%"+dni+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Empleado>)query.getResultList();
    }
    
    public boolean exiteEmpleado(int dni){
        boolean retorno = true;
        try{
            String sql = "SELECT object(e) FORM Empleado c WHERE e.dni = "+dni;
            Query query = getEntityManager().createQuery(sql);
            query.getSingleResult();
        }catch(Exception ex){
            retorno = false;
        }
        return retorno;
    }
    public boolean exiteEmpleado(int dni, int codigo) {
        boolean existe = true;
        try {
            String consulta = "SELECT object(e) FROM Empleado e WHERE e.dni = " + dni + " and e.codigo <> " + codigo;
            Query query = this.getEntityManager().createQuery(consulta);
            query.getSingleResult();//si lanza excepcion el Cliente no existe
        } catch (Exception e) {
            existe = false;
        }
        return existe;
    }
}

