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
import modelo.CedulasExcluidas;
import modelo.FuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class CedulasExcluidasJpaController implements Serializable {

    public CedulasExcluidasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CedulasExcluidas cedulasExcluidas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioNormal idFuncionario = cedulasExcluidas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdFuncionario());
                cedulasExcluidas.setIdFuncionario(idFuncionario);
            }
            em.persist(cedulasExcluidas);
            if (idFuncionario != null) {
                idFuncionario.getCedulasExcluidasList().add(cedulasExcluidas);
                idFuncionario = em.merge(idFuncionario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CedulasExcluidas cedulasExcluidas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CedulasExcluidas persistentCedulasExcluidas = em.find(CedulasExcluidas.class, cedulasExcluidas.getIdCedulaExcluida());
            FuncionarioNormal idFuncionarioOld = persistentCedulasExcluidas.getIdFuncionario();
            FuncionarioNormal idFuncionarioNew = cedulasExcluidas.getIdFuncionario();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdFuncionario());
                cedulasExcluidas.setIdFuncionario(idFuncionarioNew);
            }
            cedulasExcluidas = em.merge(cedulasExcluidas);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getCedulasExcluidasList().remove(cedulasExcluidas);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getCedulasExcluidasList().add(cedulasExcluidas);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cedulasExcluidas.getIdCedulaExcluida();
                if (findCedulasExcluidas(id) == null) {
                    throw new NonexistentEntityException("The cedulasExcluidas with id " + id + " no longer exists.");
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
            CedulasExcluidas cedulasExcluidas;
            try {
                cedulasExcluidas = em.getReference(CedulasExcluidas.class, id);
                cedulasExcluidas.getIdCedulaExcluida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cedulasExcluidas with id " + id + " no longer exists.", enfe);
            }
            FuncionarioNormal idFuncionario = cedulasExcluidas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getCedulasExcluidasList().remove(cedulasExcluidas);
                idFuncionario = em.merge(idFuncionario);
            }
            em.remove(cedulasExcluidas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CedulasExcluidas> findCedulasExcluidasEntities() {
        return findCedulasExcluidasEntities(true, -1, -1);
    }

    public List<CedulasExcluidas> findCedulasExcluidasEntities(int maxResults, int firstResult) {
        return findCedulasExcluidasEntities(false, maxResults, firstResult);
    }

    private List<CedulasExcluidas> findCedulasExcluidasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CedulasExcluidas.class));
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

    public CedulasExcluidas findCedulasExcluidas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CedulasExcluidas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCedulasExcluidasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CedulasExcluidas> rt = cq.from(CedulasExcluidas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
