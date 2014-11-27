/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Modelo.InformePiezaPedido;
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
 * @author Asus
 */
public class InformePiezaPedidoJpaController implements Serializable {
    
    public InformePiezaPedidoJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerMecanicoPU");
    }
    public InformePiezaPedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InformePiezaPedido informePiezaPedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(informePiezaPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InformePiezaPedido informePiezaPedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            informePiezaPedido = em.merge(informePiezaPedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = informePiezaPedido.getCodigo();
                if (findInformePiezaPedido(id) == null) {
                    throw new NonexistentEntityException("The informePiezaPedido with id " + id + " no longer exists.");
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
            InformePiezaPedido informePiezaPedido;
            try {
                informePiezaPedido = em.getReference(InformePiezaPedido.class, id);
                informePiezaPedido.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The informePiezaPedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(informePiezaPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InformePiezaPedido> findInformePiezaPedidoEntities() {
        return findInformePiezaPedidoEntities(true, -1, -1);
    }

    public List<InformePiezaPedido> findInformePiezaPedidoEntities(int maxResults, int firstResult) {
        return findInformePiezaPedidoEntities(false, maxResults, firstResult);
    }

    private List<InformePiezaPedido> findInformePiezaPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InformePiezaPedido.class));
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

    public InformePiezaPedido findInformePiezaPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InformePiezaPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getInformePiezaPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InformePiezaPedido> rt = cq.from(InformePiezaPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    List<InformePiezaPedido> traerInformeSinVinculo(Perito unPerito) {
        String sql ="SELECT Object(i) from InformePiezaPedido i where i.codigo NOT IN (SELECT ip.codigo FROM  Perito p INNER JOIN p.misInformesPPedido ip WHERE p.codigo ="+unPerito.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<InformePiezaPedido>)query.getResultList();    
    }

    List<InformePiezaPedido> traerInformesConVinculo(Perito unPerito) {
    String sql ="SELECT Object(i) from InformePiezaPedido i where i.codigo IN (SELECT ip.codigo FROM  Perito p INNER JOIN p.misInformesPPedido ip WHERE p.codigo ="+unPerito.getCodigo()+")";
        Query query = getEntityManager().createQuery(sql);
        return (List<InformePiezaPedido>)query.getResultList();   
    }
    
    public int ultimoInformePiezaPedido(){
        String sql ="SELECT MAX(ipp.codigo) FROM InformePiezaPedido ipp";
        Query query = getEntityManager().createQuery(sql);
        return (int)query.getSingleResult();
    }
    
    public List<InformePiezaPedido> traerInformes(boolean activo){
        String sql ="SELECT object(ipp) FROM InformePiezaPedido ipp WHERE ipp.activo = "+activo;
        Query query = getEntityManager().createQuery(sql);
        return (List<InformePiezaPedido>)query.getResultList();
    }
}
