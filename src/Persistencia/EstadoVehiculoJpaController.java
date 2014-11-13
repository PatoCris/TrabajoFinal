/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Vehiculo;
import Modelo.EstadoVehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Asus
 */
public class EstadoVehiculoJpaController implements Serializable {

    public EstadoVehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoVehiculo estadoVehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo unVehiculo = estadoVehiculo.getUnVehiculo();
            if (unVehiculo != null) {
                unVehiculo = em.getReference(unVehiculo.getClass(), unVehiculo.getCodigo());
                estadoVehiculo.setUnVehiculo(unVehiculo);
            }
            EstadoVehiculo miEstadoIngreso = estadoVehiculo.getMiEstadoIngreso();
            if (miEstadoIngreso != null) {
                miEstadoIngreso = em.getReference(miEstadoIngreso.getClass(), miEstadoIngreso.getCodigo());
                estadoVehiculo.setMiEstadoIngreso(miEstadoIngreso);
            }
            em.persist(estadoVehiculo);
            if (unVehiculo != null) {
                unVehiculo.getMisEstados().add(estadoVehiculo);
                unVehiculo = em.merge(unVehiculo);
            }
            if (miEstadoIngreso != null) {
                EstadoVehiculo oldMiEstadoIngresoOfMiEstadoIngreso = miEstadoIngreso.getMiEstadoIngreso();
                if (oldMiEstadoIngresoOfMiEstadoIngreso != null) {
                    oldMiEstadoIngresoOfMiEstadoIngreso.setMiEstadoIngreso(null);
                    oldMiEstadoIngresoOfMiEstadoIngreso = em.merge(oldMiEstadoIngresoOfMiEstadoIngreso);
                }
                miEstadoIngreso.setMiEstadoIngreso(estadoVehiculo);
                miEstadoIngreso = em.merge(miEstadoIngreso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoVehiculo estadoVehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadoVehiculo persistentEstadoVehiculo = em.find(EstadoVehiculo.class, estadoVehiculo.getCodigo());
            Vehiculo unVehiculoOld = persistentEstadoVehiculo.getUnVehiculo();
            Vehiculo unVehiculoNew = estadoVehiculo.getUnVehiculo();
            EstadoVehiculo miEstadoIngresoOld = persistentEstadoVehiculo.getMiEstadoIngreso();
            EstadoVehiculo miEstadoIngresoNew = estadoVehiculo.getMiEstadoIngreso();
            if (unVehiculoNew != null) {
                unVehiculoNew = em.getReference(unVehiculoNew.getClass(), unVehiculoNew.getCodigo());
                estadoVehiculo.setUnVehiculo(unVehiculoNew);
            }
            if (miEstadoIngresoNew != null) {
                miEstadoIngresoNew = em.getReference(miEstadoIngresoNew.getClass(), miEstadoIngresoNew.getCodigo());
                estadoVehiculo.setMiEstadoIngreso(miEstadoIngresoNew);
            }
            estadoVehiculo = em.merge(estadoVehiculo);
            if (unVehiculoOld != null && !unVehiculoOld.equals(unVehiculoNew)) {
                unVehiculoOld.getMisEstados().remove(estadoVehiculo);
                unVehiculoOld = em.merge(unVehiculoOld);
            }
            if (unVehiculoNew != null && !unVehiculoNew.equals(unVehiculoOld)) {
                unVehiculoNew.getMisEstados().add(estadoVehiculo);
                unVehiculoNew = em.merge(unVehiculoNew);
            }
            if (miEstadoIngresoOld != null && !miEstadoIngresoOld.equals(miEstadoIngresoNew)) {
                miEstadoIngresoOld.setMiEstadoIngreso(null);
                miEstadoIngresoOld = em.merge(miEstadoIngresoOld);
            }
            if (miEstadoIngresoNew != null && !miEstadoIngresoNew.equals(miEstadoIngresoOld)) {
                EstadoVehiculo oldMiEstadoIngresoOfMiEstadoIngreso = miEstadoIngresoNew.getMiEstadoIngreso();
                if (oldMiEstadoIngresoOfMiEstadoIngreso != null) {
                    oldMiEstadoIngresoOfMiEstadoIngreso.setMiEstadoIngreso(null);
                    oldMiEstadoIngresoOfMiEstadoIngreso = em.merge(oldMiEstadoIngresoOfMiEstadoIngreso);
                }
                miEstadoIngresoNew.setMiEstadoIngreso(estadoVehiculo);
                miEstadoIngresoNew = em.merge(miEstadoIngresoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = estadoVehiculo.getCodigo();
                if (findEstadoVehiculo(id) == null) {
                    throw new NonexistentEntityException("The estadoVehiculo with id " + id + " no longer exists.");
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
            EstadoVehiculo estadoVehiculo;
            try {
                estadoVehiculo = em.getReference(EstadoVehiculo.class, id);
                estadoVehiculo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoVehiculo with id " + id + " no longer exists.", enfe);
            }
            Vehiculo unVehiculo = estadoVehiculo.getUnVehiculo();
            if (unVehiculo != null) {
                unVehiculo.getMisEstados().remove(estadoVehiculo);
                unVehiculo = em.merge(unVehiculo);
            }
            EstadoVehiculo miEstadoIngreso = estadoVehiculo.getMiEstadoIngreso();
            if (miEstadoIngreso != null) {
                miEstadoIngreso.setMiEstadoIngreso(null);
                miEstadoIngreso = em.merge(miEstadoIngreso);
            }
            em.remove(estadoVehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoVehiculo> findEstadoVehiculoEntities() {
        return findEstadoVehiculoEntities(true, -1, -1);
    }

    public List<EstadoVehiculo> findEstadoVehiculoEntities(int maxResults, int firstResult) {
        return findEstadoVehiculoEntities(false, maxResults, firstResult);
    }

    private List<EstadoVehiculo> findEstadoVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoVehiculo.class));
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

    public EstadoVehiculo findEstadoVehiculo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoVehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoVehiculo> rt = cq.from(EstadoVehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
