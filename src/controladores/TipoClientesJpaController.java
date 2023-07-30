/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.TipoClientes;
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
public class TipoClientesJpaController implements Serializable {

    public TipoClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoClientes tipoClientes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoClientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoClientes(tipoClientes.getIdTipCli()) != null) {
                throw new PreexistingEntityException("TipoClientes " + tipoClientes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoClientes tipoClientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoClientes = em.merge(tipoClientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoClientes.getIdTipCli();
                if (findTipoClientes(id) == null) {
                    throw new NonexistentEntityException("The tipoClientes with id " + id + " no longer exists.");
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
            TipoClientes tipoClientes;
            try {
                tipoClientes = em.getReference(TipoClientes.class, id);
                tipoClientes.getIdTipCli();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoClientes with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoClientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoClientes> findTipoClientesEntities() {
        return findTipoClientesEntities(true, -1, -1);
    }

    public List<TipoClientes> findTipoClientesEntities(int maxResults, int firstResult) {
        return findTipoClientesEntities(false, maxResults, firstResult);
    }

    private List<TipoClientes> findTipoClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoClientes.class));
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

    public TipoClientes findTipoClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoClientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoClientes> rt = cq.from(TipoClientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
