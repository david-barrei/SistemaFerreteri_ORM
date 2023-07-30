/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.TipoCompra;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author davba
 */
public class TipoCompraJpaController implements Serializable {

    public TipoCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoCompra tipoCompra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoCompra(tipoCompra.getIdPro()) != null) {
                throw new PreexistingEntityException("TipoCompra " + tipoCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoCompra tipoCompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoCompra = em.merge(tipoCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoCompra.getIdPro();
                if (findTipoCompra(id) == null) {
                    throw new NonexistentEntityException("The tipoCompra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoCompra tipoCompra;
            try {
                tipoCompra = em.getReference(TipoCompra.class, id);
                tipoCompra.getIdPro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoCompra with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoCompra> findTipoCompraEntities() {
        return findTipoCompraEntities(true, -1, -1);
    }

    public List<TipoCompra> findTipoCompraEntities(int maxResults, int firstResult) {
        return findTipoCompraEntities(false, maxResults, firstResult);
    }

    private List<TipoCompra> findTipoCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoCompra.class));
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

    public TipoCompra findTipoCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoCompra> rt = cq.from(TipoCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
