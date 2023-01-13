/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.FuncionarioAceite;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.RequerimentoFuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class RequerimentoFuncionarioNormalJpaController implements Serializable {

    public RequerimentoFuncionarioNormalJpaController() {
    }
    public RequerimentoFuncionarioNormalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

   

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RequerimentoFuncionarioNormal requerimentoFuncionarioNormal) {
        if (requerimentoFuncionarioNormal.getFuncionarioAceiteList() == null) {
            requerimentoFuncionarioNormal.setFuncionarioAceiteList(new ArrayList<FuncionarioAceite>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<FuncionarioAceite> attachedFuncionarioAceiteList = new ArrayList<FuncionarioAceite>();
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceiteToAttach : requerimentoFuncionarioNormal.getFuncionarioAceiteList()) {
                funcionarioAceiteListFuncionarioAceiteToAttach = em.getReference(funcionarioAceiteListFuncionarioAceiteToAttach.getClass(), funcionarioAceiteListFuncionarioAceiteToAttach.getSenha());
                attachedFuncionarioAceiteList.add(funcionarioAceiteListFuncionarioAceiteToAttach);
            }
            requerimentoFuncionarioNormal.setFuncionarioAceiteList(attachedFuncionarioAceiteList);
            em.persist(requerimentoFuncionarioNormal);
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceite : requerimentoFuncionarioNormal.getFuncionarioAceiteList()) {
                RequerimentoFuncionarioNormal oldIdRequerimentoFuncOfFuncionarioAceiteListFuncionarioAceite = funcionarioAceiteListFuncionarioAceite.getIdRequerimentoFunc();
                funcionarioAceiteListFuncionarioAceite.setIdRequerimentoFunc(requerimentoFuncionarioNormal);
                funcionarioAceiteListFuncionarioAceite = em.merge(funcionarioAceiteListFuncionarioAceite);
                if (oldIdRequerimentoFuncOfFuncionarioAceiteListFuncionarioAceite != null) {
                    oldIdRequerimentoFuncOfFuncionarioAceiteListFuncionarioAceite.getFuncionarioAceiteList().remove(funcionarioAceiteListFuncionarioAceite);
                    oldIdRequerimentoFuncOfFuncionarioAceiteListFuncionarioAceite = em.merge(oldIdRequerimentoFuncOfFuncionarioAceiteListFuncionarioAceite);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RequerimentoFuncionarioNormal requerimentoFuncionarioNormal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RequerimentoFuncionarioNormal persistentRequerimentoFuncionarioNormal = em.find(RequerimentoFuncionarioNormal.class, requerimentoFuncionarioNormal.getIdRequerimentoFunc());
            List<FuncionarioAceite> funcionarioAceiteListOld = persistentRequerimentoFuncionarioNormal.getFuncionarioAceiteList();
            List<FuncionarioAceite> funcionarioAceiteListNew = requerimentoFuncionarioNormal.getFuncionarioAceiteList();
            List<FuncionarioAceite> attachedFuncionarioAceiteListNew = new ArrayList<FuncionarioAceite>();
            for (FuncionarioAceite funcionarioAceiteListNewFuncionarioAceiteToAttach : funcionarioAceiteListNew) {
                funcionarioAceiteListNewFuncionarioAceiteToAttach = em.getReference(funcionarioAceiteListNewFuncionarioAceiteToAttach.getClass(), funcionarioAceiteListNewFuncionarioAceiteToAttach.getSenha());
                attachedFuncionarioAceiteListNew.add(funcionarioAceiteListNewFuncionarioAceiteToAttach);
            }
            funcionarioAceiteListNew = attachedFuncionarioAceiteListNew;
            requerimentoFuncionarioNormal.setFuncionarioAceiteList(funcionarioAceiteListNew);
            requerimentoFuncionarioNormal = em.merge(requerimentoFuncionarioNormal);
            for (FuncionarioAceite funcionarioAceiteListOldFuncionarioAceite : funcionarioAceiteListOld) {
                if (!funcionarioAceiteListNew.contains(funcionarioAceiteListOldFuncionarioAceite)) {
                    funcionarioAceiteListOldFuncionarioAceite.setIdRequerimentoFunc(null);
                    funcionarioAceiteListOldFuncionarioAceite = em.merge(funcionarioAceiteListOldFuncionarioAceite);
                }
            }
            for (FuncionarioAceite funcionarioAceiteListNewFuncionarioAceite : funcionarioAceiteListNew) {
                if (!funcionarioAceiteListOld.contains(funcionarioAceiteListNewFuncionarioAceite)) {
                    RequerimentoFuncionarioNormal oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite = funcionarioAceiteListNewFuncionarioAceite.getIdRequerimentoFunc();
                    funcionarioAceiteListNewFuncionarioAceite.setIdRequerimentoFunc(requerimentoFuncionarioNormal);
                    funcionarioAceiteListNewFuncionarioAceite = em.merge(funcionarioAceiteListNewFuncionarioAceite);
                    if (oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite != null && !oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite.equals(requerimentoFuncionarioNormal)) {
                        oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite.getFuncionarioAceiteList().remove(funcionarioAceiteListNewFuncionarioAceite);
                        oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite = em.merge(oldIdRequerimentoFuncOfFuncionarioAceiteListNewFuncionarioAceite);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = requerimentoFuncionarioNormal.getIdRequerimentoFunc();
                if (findRequerimentoFuncionarioNormal(id) == null) {
                    throw new NonexistentEntityException("The requerimentoFuncionarioNormal with id " + id + " no longer exists.");
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
            RequerimentoFuncionarioNormal requerimentoFuncionarioNormal;
            try {
                requerimentoFuncionarioNormal = em.getReference(RequerimentoFuncionarioNormal.class, id);
                requerimentoFuncionarioNormal.getIdRequerimentoFunc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The requerimentoFuncionarioNormal with id " + id + " no longer exists.", enfe);
            }
            List<FuncionarioAceite> funcionarioAceiteList = requerimentoFuncionarioNormal.getFuncionarioAceiteList();
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceite : funcionarioAceiteList) {
                funcionarioAceiteListFuncionarioAceite.setIdRequerimentoFunc(null);
                funcionarioAceiteListFuncionarioAceite = em.merge(funcionarioAceiteListFuncionarioAceite);
            }
            em.remove(requerimentoFuncionarioNormal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RequerimentoFuncionarioNormal> findRequerimentoFuncionarioNormalEntities() {
        return findRequerimentoFuncionarioNormalEntities(true, -1, -1);
    }

    public List<RequerimentoFuncionarioNormal> findRequerimentoFuncionarioNormalEntities(int maxResults, int firstResult) {
        return findRequerimentoFuncionarioNormalEntities(false, maxResults, firstResult);
    }

    private List<RequerimentoFuncionarioNormal> findRequerimentoFuncionarioNormalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RequerimentoFuncionarioNormal.class));
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

    public RequerimentoFuncionarioNormal findRequerimentoFuncionarioNormal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RequerimentoFuncionarioNormal.class, id);
        } finally {
            em.close();
        }
    }

    public int getRequerimentoFuncionarioNormalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RequerimentoFuncionarioNormal> rt = cq.from(RequerimentoFuncionarioNormal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
