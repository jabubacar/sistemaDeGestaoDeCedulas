/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.CedulasEditadas;
import modelo.FuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class CedulasEditadasJpaController implements Serializable {

    public CedulasEditadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CedulasEditadas cedulasEditadas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioNormal idFuncionario = cedulasEditadas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdFuncionario());
                cedulasEditadas.setIdFuncionario(idFuncionario);
            }
            em.persist(cedulasEditadas);
            if (idFuncionario != null) {
                idFuncionario.getCedulasEditadasList().add(cedulasEditadas);
                idFuncionario = em.merge(idFuncionario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CedulasEditadas cedulasEditadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CedulasEditadas persistentCedulasEditadas = em.find(CedulasEditadas.class, cedulasEditadas.getIdCedulaEditadas());
            FuncionarioNormal idFuncionarioOld = persistentCedulasEditadas.getIdFuncionario();
            FuncionarioNormal idFuncionarioNew = cedulasEditadas.getIdFuncionario();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdFuncionario());
                cedulasEditadas.setIdFuncionario(idFuncionarioNew);
            }
            cedulasEditadas = em.merge(cedulasEditadas);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getCedulasEditadasList().remove(cedulasEditadas);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getCedulasEditadasList().add(cedulasEditadas);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cedulasEditadas.getIdCedulaEditadas();
                if (findCedulasEditadas(id) == null) {
                    throw new NonexistentEntityException("The cedulasEditadas with id " + id + " no longer exists.");
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
            CedulasEditadas cedulasEditadas;
            try {
                cedulasEditadas = em.getReference(CedulasEditadas.class, id);
                cedulasEditadas.getIdCedulaEditadas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cedulasEditadas with id " + id + " no longer exists.", enfe);
            }
            FuncionarioNormal idFuncionario = cedulasEditadas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getCedulasEditadasList().remove(cedulasEditadas);
                idFuncionario = em.merge(idFuncionario);
            }
            em.remove(cedulasEditadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CedulasEditadas> findCedulasEditadasEntities() {
        return findCedulasEditadasEntities(true, -1, -1);
    }

    public List<CedulasEditadas> findCedulasEditadasEntities(int maxResults, int firstResult) {
        return findCedulasEditadasEntities(false, maxResults, firstResult);
    }

    private List<CedulasEditadas> findCedulasEditadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CedulasEditadas.class));
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

    public CedulasEditadas findCedulasEditadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CedulasEditadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCedulasEditadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CedulasEditadas> rt = cq.from(CedulasEditadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
