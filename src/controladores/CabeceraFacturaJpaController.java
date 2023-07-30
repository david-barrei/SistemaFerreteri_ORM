/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.CabeceraFactura;
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
public class CabeceraFacturaJpaController implements Serializable {

    public CabeceraFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CabeceraFactura cabeceraFactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cabeceraFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCabeceraFactura(cabeceraFactura.getNumFac()) != null) {
                throw new PreexistingEntityException("CabeceraFactura " + cabeceraFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CabeceraFactura cabeceraFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cabeceraFactura = em.merge(cabeceraFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cabeceraFactura.getNumFac();
                if (findCabeceraFactura(id) == null) {
                    throw new NonexistentEntityException("The cabeceraFactura with id " + id + " no longer exists.");
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
            CabeceraFactura cabeceraFactura;
            try {
                cabeceraFactura = em.getReference(CabeceraFactura.class, id);
                cabeceraFactura.getNumFac();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cabeceraFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(cabeceraFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CabeceraFactura> findCabeceraFacturaEntities() {
        return findCabeceraFacturaEntities(true, -1, -1);
    }

    public List<CabeceraFactura> findCabeceraFacturaEntities(int maxResults, int firstResult) {
        return findCabeceraFacturaEntities(false, maxResults, firstResult);
    }

    private List<CabeceraFactura> findCabeceraFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CabeceraFactura.class));
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

    public CabeceraFactura findCabeceraFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CabeceraFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getCabeceraFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CabeceraFactura> rt = cq.from(CabeceraFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
