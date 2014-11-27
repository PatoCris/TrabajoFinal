/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.Diagnostico;
import Modelo.Modulo;
import Modelo.Proceso;
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
public class ModuloJpaController implements Serializable {

    public ModuloJpaController() {
        emf=Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }

    
    public ModuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modulo modulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(modulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modulo modulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            modulo = em.merge(modulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = modulo.getCodigo();
                if (findModulo(id) == null) {
                    throw new NonexistentEntityException("The modulo with id " + id + " no longer exists.");
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
            Modulo modulo;
            try {
                modulo = em.getReference(Modulo.class, id);
                modulo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modulo with id " + id + " no longer exists.", enfe);
            }
            em.remove(modulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modulo> findModuloEntities() {
        return findModuloEntities(true, -1, -1);
    }

    public List<Modulo> findModuloEntities(int maxResults, int firstResult) {
        return findModuloEntities(false, maxResults, firstResult);
    }

    private List<Modulo> findModuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modulo.class));
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

    public Modulo findModulo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getModuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modulo> rt = cq.from(Modulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public int ultimoModulo(){
        String sql ="SELECT MAX(m.codigo) FROM Modulo m";
        Query query = getEntityManager().createQuery(sql);
        return (int)query.getSingleResult();
    }
    
    public List<Modulo> traerModulosLibres(boolean activo, int codigoAg, int cantidadModulos){
        String sql ="SELECT object(m) FROM Modulo m WHERE m.libre = TRUE AND m.activo = "+activo+" AND m.codigo IN ( SELECT mt.codigo FROM AgendaMensual v INNER jOIN v.misModulos mt WHERE v.codigo="+codigoAg+") ORDER BY m.codigo ASC";
        Query query = getEntityManager().createQuery(sql);
        return (List<Modulo>)query.getResultList();
    }
}
