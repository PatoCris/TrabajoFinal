/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Cliente;
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
public class ClienteJpaController implements Serializable {
    
    public ClienteJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getCodigo();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Cliente> traerClientes(boolean activo){
        String sql ="SELECT object(c) FROM Cliente c WHERE c.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Cliente>)query.getResultList();
    }
    
    public List<Cliente> traerClientesBusqueda(boolean activo, String apellido, int dni){
        String sql ="SELECT Object(c) FROM Cliente c WHERE c.activo = "+activo;
        if(!apellido.equals(""))
            sql = sql + " AND c.apellido = '"+apellido+"'";
        if(dni != 0)
            sql = sql + " AND c.dni = '"+dni+"'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Cliente>)query.getResultList();
    }
    public boolean exiteCliente(int dni){
        boolean retorno = true;
        try{

            String sql = "SELECT Object(c) FROM Cliente c WHERE c.dni = "+dni;

            

            Query query = getEntityManager().createQuery(sql);
            query.getSingleResult();
        }catch(Exception ex){
            retorno = false;
        }
        return retorno;
    }
    public boolean exiteCliente(int dni, int codigo) {
        boolean existe = true;
        try {
            String consulta = "SELECT object(c) FROM Cliente c WHERE c.activo = TRUE AND c.dni = " + dni + " AND c.codigo <> " + codigo;
            Query query = this.getEntityManager().createQuery(consulta);
            query.getSingleResult();//si lanza excepcion el Cliente no existe
        } catch (Exception e) {
            existe = false;
        }
        return existe;
    }
    
    public void borrarClienteVehiculo(int codigoCliente, int codigoVehiculo){
        String sql ="DELETE FROM Cliente c INNER JOIN c.misVehiculos mv";
        Query query = getEntityManager().createQuery(sql);
        query.executeUpdate();
    }
}
