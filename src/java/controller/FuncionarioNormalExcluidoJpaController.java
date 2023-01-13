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
import modelo.FuncionarioAdmin;
import modelo.FuncionarioNormalExcluido;

/**
 *
 * @author Jozino M. Abubacar
 */
public class FuncionarioNormalExcluidoJpaController implements Serializable {

    public FuncionarioNormalExcluidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioNormalExcluido funcionarioNormalExcluido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioAdmin idFuncionario = funcionarioNormalExcluido.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdFuncionario());
                funcionarioNormalExcluido.setIdFuncionario(idFuncionario);
            }
            em.persist(funcionarioNormalExcluido);
            if (idFuncionario != null) {
                idFuncionario.getFuncionarioNormalExcluidoList().add(funcionarioNormalExcluido);
                idFuncionario = em.merge(idFuncionario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioNormalExcluido funcionarioNormalExcluido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioNormalExcluido persistentFuncionarioNormalExcluido = em.find(FuncionarioNormalExcluido.class, funcionarioNormalExcluido.getIdFuncionarioNormalExcluido());
            FuncionarioAdmin idFuncionarioOld = persistentFuncionarioNormalExcluido.getIdFuncionario();
            FuncionarioAdmin idFuncionarioNew = funcionarioNormalExcluido.getIdFuncionario();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdFuncionario());
                funcionarioNormalExcluido.setIdFuncionario(idFuncionarioNew);
            }
            funcionarioNormalExcluido = em.merge(funcionarioNormalExcluido);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getFuncionarioNormalExcluidoList().remove(funcionarioNormalExcluido);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getFuncionarioNormalExcluidoList().add(funcionarioNormalExcluido);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionarioNormalExcluido.getIdFuncionarioNormalExcluido();
                if (findFuncionarioNormalExcluido(id) == null) {
                    throw new NonexistentEntityException("The funcionarioNormalExcluido with id " + id + " no longer exists.");
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
            FuncionarioNormalExcluido funcionarioNormalExcluido;
            try {
                funcionarioNormalExcluido = em.getReference(FuncionarioNormalExcluido.class, id);
                funcionarioNormalExcluido.getIdFuncionarioNormalExcluido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioNormalExcluido with id " + id + " no longer exists.", enfe);
            }
            FuncionarioAdmin idFuncionario = funcionarioNormalExcluido.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getFuncionarioNormalExcluidoList().remove(funcionarioNormalExcluido);
                idFuncionario = em.merge(idFuncionario);
            }
            em.remove(funcionarioNormalExcluido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioNormalExcluido> findFuncionarioNormalExcluidoEntities() {
        return findFuncionarioNormalExcluidoEntities(true, -1, -1);
    }

    public List<FuncionarioNormalExcluido> findFuncionarioNormalExcluidoEntities(int maxResults, int firstResult) {
        return findFuncionarioNormalExcluidoEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioNormalExcluido> findFuncionarioNormalExcluidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioNormalExcluido.class));
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

    public FuncionarioNormalExcluido findFuncionarioNormalExcluido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioNormalExcluido.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioNormalExcluidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioNormalExcluido> rt = cq.from(FuncionarioNormalExcluido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
