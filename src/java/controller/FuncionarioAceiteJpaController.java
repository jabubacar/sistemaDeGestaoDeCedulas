/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.FuncionarioAceite;
import modelo.FuncionarioAdmin;
import modelo.RequerimentoFuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class FuncionarioAceiteJpaController implements Serializable {

    public FuncionarioAceiteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioAceite funcionarioAceite) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioAdmin idFuncionario = funcionarioAceite.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdFuncionario());
                funcionarioAceite.setIdFuncionario(idFuncionario);
            }
            RequerimentoFuncionarioNormal idRequerimentoFunc = funcionarioAceite.getIdRequerimentoFunc();
            if (idRequerimentoFunc != null) {
                idRequerimentoFunc = em.getReference(idRequerimentoFunc.getClass(), idRequerimentoFunc.getIdRequerimentoFunc());
                funcionarioAceite.setIdRequerimentoFunc(idRequerimentoFunc);
            }
            em.persist(funcionarioAceite);
            if (idFuncionario != null) {
                idFuncionario.getFuncionarioAceiteList().add(funcionarioAceite);
                idFuncionario = em.merge(idFuncionario);
            }
            if (idRequerimentoFunc != null) {
                idRequerimentoFunc.getFuncionarioAceiteList().add(funcionarioAceite);
                idRequerimentoFunc = em.merge(idRequerimentoFunc);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionarioAceite(funcionarioAceite.getSenha()) != null) {
                throw new PreexistingEntityException("FuncionarioAceite " + funcionarioAceite + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioAceite funcionarioAceite) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioAceite persistentFuncionarioAceite = em.find(FuncionarioAceite.class, funcionarioAceite.getSenha());
            FuncionarioAdmin idFuncionarioOld = persistentFuncionarioAceite.getIdFuncionario();
            FuncionarioAdmin idFuncionarioNew = funcionarioAceite.getIdFuncionario();
            RequerimentoFuncionarioNormal idRequerimentoFuncOld = persistentFuncionarioAceite.getIdRequerimentoFunc();
            RequerimentoFuncionarioNormal idRequerimentoFuncNew = funcionarioAceite.getIdRequerimentoFunc();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdFuncionario());
                funcionarioAceite.setIdFuncionario(idFuncionarioNew);
            }
            if (idRequerimentoFuncNew != null) {
                idRequerimentoFuncNew = em.getReference(idRequerimentoFuncNew.getClass(), idRequerimentoFuncNew.getIdRequerimentoFunc());
                funcionarioAceite.setIdRequerimentoFunc(idRequerimentoFuncNew);
            }
            funcionarioAceite = em.merge(funcionarioAceite);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getFuncionarioAceiteList().remove(funcionarioAceite);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getFuncionarioAceiteList().add(funcionarioAceite);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            if (idRequerimentoFuncOld != null && !idRequerimentoFuncOld.equals(idRequerimentoFuncNew)) {
                idRequerimentoFuncOld.getFuncionarioAceiteList().remove(funcionarioAceite);
                idRequerimentoFuncOld = em.merge(idRequerimentoFuncOld);
            }
            if (idRequerimentoFuncNew != null && !idRequerimentoFuncNew.equals(idRequerimentoFuncOld)) {
                idRequerimentoFuncNew.getFuncionarioAceiteList().add(funcionarioAceite);
                idRequerimentoFuncNew = em.merge(idRequerimentoFuncNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionarioAceite.getSenha();
                if (findFuncionarioAceite(id) == null) {
                    throw new NonexistentEntityException("The funcionarioAceite with id " + id + " no longer exists.");
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
            FuncionarioAceite funcionarioAceite;
            try {
                funcionarioAceite = em.getReference(FuncionarioAceite.class, id);
                funcionarioAceite.getSenha();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioAceite with id " + id + " no longer exists.", enfe);
            }
            FuncionarioAdmin idFuncionario = funcionarioAceite.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getFuncionarioAceiteList().remove(funcionarioAceite);
                idFuncionario = em.merge(idFuncionario);
            }
            RequerimentoFuncionarioNormal idRequerimentoFunc = funcionarioAceite.getIdRequerimentoFunc();
            if (idRequerimentoFunc != null) {
                idRequerimentoFunc.getFuncionarioAceiteList().remove(funcionarioAceite);
                idRequerimentoFunc = em.merge(idRequerimentoFunc);
            }
            em.remove(funcionarioAceite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioAceite> findFuncionarioAceiteEntities() {
        return findFuncionarioAceiteEntities(true, -1, -1);
    }

    public List<FuncionarioAceite> findFuncionarioAceiteEntities(int maxResults, int firstResult) {
        return findFuncionarioAceiteEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioAceite> findFuncionarioAceiteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioAceite.class));
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

    public FuncionarioAceite findFuncionarioAceite(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioAceite.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioAceiteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioAceite> rt = cq.from(FuncionarioAceite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
