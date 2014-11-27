/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Cliente;
import Modelo.Equipamiento;
import Modelo.EstadoVehiculo;
import Modelo.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
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
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(){
        emf= Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    
    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        if (vehiculo.getMisEstados() == null) {
            vehiculo.setMisEstados(new ArrayList<EstadoVehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<EstadoVehiculo> attachedMisEstados = new ArrayList<EstadoVehiculo>();
            for (EstadoVehiculo misEstadosEstadoVehiculoToAttach : vehiculo.getMisEstados()) {
                misEstadosEstadoVehiculoToAttach = em.getReference(misEstadosEstadoVehiculoToAttach.getClass(), misEstadosEstadoVehiculoToAttach.getCodigo());
                attachedMisEstados.add(misEstadosEstadoVehiculoToAttach);
            }
            vehiculo.setMisEstados(attachedMisEstados);
            em.persist(vehiculo);
            for (EstadoVehiculo misEstadosEstadoVehiculo : vehiculo.getMisEstados()) {
                Vehiculo oldUnVehiculoOfMisEstadosEstadoVehiculo = misEstadosEstadoVehiculo.getUnVehiculo();
                misEstadosEstadoVehiculo.setUnVehiculo(vehiculo);
                misEstadosEstadoVehiculo = em.merge(misEstadosEstadoVehiculo);
                if (oldUnVehiculoOfMisEstadosEstadoVehiculo != null) {
                    oldUnVehiculoOfMisEstadosEstadoVehiculo.getMisEstados().remove(misEstadosEstadoVehiculo);
                    oldUnVehiculoOfMisEstadosEstadoVehiculo = em.merge(oldUnVehiculoOfMisEstadosEstadoVehiculo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getCodigo());
            List<EstadoVehiculo> misEstadosOld = persistentVehiculo.getMisEstados();
            List<EstadoVehiculo> misEstadosNew = vehiculo.getMisEstados();
            List<EstadoVehiculo> attachedMisEstadosNew = new ArrayList<EstadoVehiculo>();
            for (EstadoVehiculo misEstadosNewEstadoVehiculoToAttach : misEstadosNew) {
                misEstadosNewEstadoVehiculoToAttach = em.getReference(misEstadosNewEstadoVehiculoToAttach.getClass(), misEstadosNewEstadoVehiculoToAttach.getCodigo());
                attachedMisEstadosNew.add(misEstadosNewEstadoVehiculoToAttach);
            }
            misEstadosNew = attachedMisEstadosNew;
            vehiculo.setMisEstados(misEstadosNew);
            vehiculo = em.merge(vehiculo);
            for (EstadoVehiculo misEstadosOldEstadoVehiculo : misEstadosOld) {
                if (!misEstadosNew.contains(misEstadosOldEstadoVehiculo)) {
                    misEstadosOldEstadoVehiculo.setUnVehiculo(null);
                    misEstadosOldEstadoVehiculo = em.merge(misEstadosOldEstadoVehiculo);
                }
            }
            for (EstadoVehiculo misEstadosNewEstadoVehiculo : misEstadosNew) {
                if (!misEstadosOld.contains(misEstadosNewEstadoVehiculo)) {
                    Vehiculo oldUnVehiculoOfMisEstadosNewEstadoVehiculo = misEstadosNewEstadoVehiculo.getUnVehiculo();
                    misEstadosNewEstadoVehiculo.setUnVehiculo(vehiculo);
                    misEstadosNewEstadoVehiculo = em.merge(misEstadosNewEstadoVehiculo);
                    if (oldUnVehiculoOfMisEstadosNewEstadoVehiculo != null && !oldUnVehiculoOfMisEstadosNewEstadoVehiculo.equals(vehiculo)) {
                        oldUnVehiculoOfMisEstadosNewEstadoVehiculo.getMisEstados().remove(misEstadosNewEstadoVehiculo);
                        oldUnVehiculoOfMisEstadosNewEstadoVehiculo = em.merge(oldUnVehiculoOfMisEstadosNewEstadoVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vehiculo.getCodigo();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
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
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            List<EstadoVehiculo> misEstados = vehiculo.getMisEstados();
            for (EstadoVehiculo misEstadosEstadoVehiculo : misEstados) {
                misEstadosEstadoVehiculo.setUnVehiculo(null);
                misEstadosEstadoVehiculo = em.merge(misEstadosEstadoVehiculo);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<Vehiculo> traerVehiculos(boolean activo){
        String sql="SELECT object (v) FROM Vehiculo v WHERE v.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<Vehiculo>)query.getResultList();
    }
    
    public List<Vehiculo> traerVehiculoDominio(boolean activo, String dominio){
        String sql="SELECT object (v) FROM Vehiculo v WHERE v.activo = "+activo+" AND v.dominio LIKE '%"+dominio+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (List<Vehiculo>)query.getResultList();
    }
    public List<Vehiculo> traerVehiculosSinCliente(){
        String sql ="SELECT Object(ve) from Vehiculo ve where ve.codigo NOT IN (SELECT mv.codigo FROM  Cliente c INNER JOIN c.misVehiculos mv)";
        Query query = getEntityManager().createQuery(sql);
        return (List<Vehiculo>)query.getResultList();
    }
    
    public List<Vehiculo> traerVehiculosConCliente(Cliente cliente){
        String sql ="SELECT Object(ve) from Vehiculo ve where ve.codigo IN (SELECT mv.codigo FROM  Cliente c INNER JOIN c.misVehiculos mv WHERE c.codigo ="+cliente.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<Vehiculo>)query.getResultList();
    }
    public Vehiculo traerVehiculoDominio(String dominio){
        String sql="SELECT object (v) FROM Vehiculo v WHERE v.dominio LIKE '%"+dominio+"%'";
        Query query = getEntityManager().createQuery(sql);
        return (Vehiculo)query.getSingleResult();
    }
}
