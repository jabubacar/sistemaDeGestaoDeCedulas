/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Connection.Connection;
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
import modelo.FuncionarioAdmin;
import modelo.FuncionarioNormalExcluido;

/**
 *
 * @author Jozino M. Abubacar
 */
public class FuncionarioAdminJpaController implements Serializable {
    public FuncionarioAdminJpaController() {
       
    }

    public FuncionarioAdminJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioAdmin funcionarioAdmin) {
        if (funcionarioAdmin.getFuncionarioAceiteList() == null) {
            funcionarioAdmin.setFuncionarioAceiteList(new ArrayList<FuncionarioAceite>());
        }
        if (funcionarioAdmin.getFuncionarioNormalExcluidoList() == null) {
            funcionarioAdmin.setFuncionarioNormalExcluidoList(new ArrayList<FuncionarioNormalExcluido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<FuncionarioAceite> attachedFuncionarioAceiteList = new ArrayList<FuncionarioAceite>();
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceiteToAttach : funcionarioAdmin.getFuncionarioAceiteList()) {
                funcionarioAceiteListFuncionarioAceiteToAttach = em.getReference(funcionarioAceiteListFuncionarioAceiteToAttach.getClass(), funcionarioAceiteListFuncionarioAceiteToAttach.getSenha());
                attachedFuncionarioAceiteList.add(funcionarioAceiteListFuncionarioAceiteToAttach);
            }
            funcionarioAdmin.setFuncionarioAceiteList(attachedFuncionarioAceiteList);
            List<FuncionarioNormalExcluido> attachedFuncionarioNormalExcluidoList = new ArrayList<FuncionarioNormalExcluido>();
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListFuncionarioNormalExcluidoToAttach : funcionarioAdmin.getFuncionarioNormalExcluidoList()) {
                funcionarioNormalExcluidoListFuncionarioNormalExcluidoToAttach = em.getReference(funcionarioNormalExcluidoListFuncionarioNormalExcluidoToAttach.getClass(), funcionarioNormalExcluidoListFuncionarioNormalExcluidoToAttach.getIdFuncionarioNormalExcluido());
                attachedFuncionarioNormalExcluidoList.add(funcionarioNormalExcluidoListFuncionarioNormalExcluidoToAttach);
            }
            funcionarioAdmin.setFuncionarioNormalExcluidoList(attachedFuncionarioNormalExcluidoList);
            em.persist(funcionarioAdmin);
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceite : funcionarioAdmin.getFuncionarioAceiteList()) {
                FuncionarioAdmin oldIdFuncionarioOfFuncionarioAceiteListFuncionarioAceite = funcionarioAceiteListFuncionarioAceite.getIdFuncionario();
                funcionarioAceiteListFuncionarioAceite.setIdFuncionario(funcionarioAdmin);
                funcionarioAceiteListFuncionarioAceite = em.merge(funcionarioAceiteListFuncionarioAceite);
                if (oldIdFuncionarioOfFuncionarioAceiteListFuncionarioAceite != null) {
                    oldIdFuncionarioOfFuncionarioAceiteListFuncionarioAceite.getFuncionarioAceiteList().remove(funcionarioAceiteListFuncionarioAceite);
                    oldIdFuncionarioOfFuncionarioAceiteListFuncionarioAceite = em.merge(oldIdFuncionarioOfFuncionarioAceiteListFuncionarioAceite);
                }
            }
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListFuncionarioNormalExcluido : funcionarioAdmin.getFuncionarioNormalExcluidoList()) {
                FuncionarioAdmin oldIdFuncionarioOfFuncionarioNormalExcluidoListFuncionarioNormalExcluido = funcionarioNormalExcluidoListFuncionarioNormalExcluido.getIdFuncionario();
                funcionarioNormalExcluidoListFuncionarioNormalExcluido.setIdFuncionario(funcionarioAdmin);
                funcionarioNormalExcluidoListFuncionarioNormalExcluido = em.merge(funcionarioNormalExcluidoListFuncionarioNormalExcluido);
                if (oldIdFuncionarioOfFuncionarioNormalExcluidoListFuncionarioNormalExcluido != null) {
                    oldIdFuncionarioOfFuncionarioNormalExcluidoListFuncionarioNormalExcluido.getFuncionarioNormalExcluidoList().remove(funcionarioNormalExcluidoListFuncionarioNormalExcluido);
                    oldIdFuncionarioOfFuncionarioNormalExcluidoListFuncionarioNormalExcluido = em.merge(oldIdFuncionarioOfFuncionarioNormalExcluidoListFuncionarioNormalExcluido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioAdmin funcionarioAdmin) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioAdmin persistentFuncionarioAdmin = em.find(FuncionarioAdmin.class, funcionarioAdmin.getIdFuncionario());
            List<FuncionarioAceite> funcionarioAceiteListOld = persistentFuncionarioAdmin.getFuncionarioAceiteList();
            List<FuncionarioAceite> funcionarioAceiteListNew = funcionarioAdmin.getFuncionarioAceiteList();
            List<FuncionarioNormalExcluido> funcionarioNormalExcluidoListOld = persistentFuncionarioAdmin.getFuncionarioNormalExcluidoList();
            List<FuncionarioNormalExcluido> funcionarioNormalExcluidoListNew = funcionarioAdmin.getFuncionarioNormalExcluidoList();
            List<FuncionarioAceite> attachedFuncionarioAceiteListNew = new ArrayList<FuncionarioAceite>();
            for (FuncionarioAceite funcionarioAceiteListNewFuncionarioAceiteToAttach : funcionarioAceiteListNew) {
                funcionarioAceiteListNewFuncionarioAceiteToAttach = em.getReference(funcionarioAceiteListNewFuncionarioAceiteToAttach.getClass(), funcionarioAceiteListNewFuncionarioAceiteToAttach.getSenha());
                attachedFuncionarioAceiteListNew.add(funcionarioAceiteListNewFuncionarioAceiteToAttach);
            }
            funcionarioAceiteListNew = attachedFuncionarioAceiteListNew;
            funcionarioAdmin.setFuncionarioAceiteList(funcionarioAceiteListNew);
            List<FuncionarioNormalExcluido> attachedFuncionarioNormalExcluidoListNew = new ArrayList<FuncionarioNormalExcluido>();
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListNewFuncionarioNormalExcluidoToAttach : funcionarioNormalExcluidoListNew) {
                funcionarioNormalExcluidoListNewFuncionarioNormalExcluidoToAttach = em.getReference(funcionarioNormalExcluidoListNewFuncionarioNormalExcluidoToAttach.getClass(), funcionarioNormalExcluidoListNewFuncionarioNormalExcluidoToAttach.getIdFuncionarioNormalExcluido());
                attachedFuncionarioNormalExcluidoListNew.add(funcionarioNormalExcluidoListNewFuncionarioNormalExcluidoToAttach);
            }
            funcionarioNormalExcluidoListNew = attachedFuncionarioNormalExcluidoListNew;
            funcionarioAdmin.setFuncionarioNormalExcluidoList(funcionarioNormalExcluidoListNew);
            funcionarioAdmin = em.merge(funcionarioAdmin);
            for (FuncionarioAceite funcionarioAceiteListOldFuncionarioAceite : funcionarioAceiteListOld) {
                if (!funcionarioAceiteListNew.contains(funcionarioAceiteListOldFuncionarioAceite)) {
                    funcionarioAceiteListOldFuncionarioAceite.setIdFuncionario(null);
                    funcionarioAceiteListOldFuncionarioAceite = em.merge(funcionarioAceiteListOldFuncionarioAceite);
                }
            }
            for (FuncionarioAceite funcionarioAceiteListNewFuncionarioAceite : funcionarioAceiteListNew) {
                if (!funcionarioAceiteListOld.contains(funcionarioAceiteListNewFuncionarioAceite)) {
                    FuncionarioAdmin oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite = funcionarioAceiteListNewFuncionarioAceite.getIdFuncionario();
                    funcionarioAceiteListNewFuncionarioAceite.setIdFuncionario(funcionarioAdmin);
                    funcionarioAceiteListNewFuncionarioAceite = em.merge(funcionarioAceiteListNewFuncionarioAceite);
                    if (oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite != null && !oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite.equals(funcionarioAdmin)) {
                        oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite.getFuncionarioAceiteList().remove(funcionarioAceiteListNewFuncionarioAceite);
                        oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite = em.merge(oldIdFuncionarioOfFuncionarioAceiteListNewFuncionarioAceite);
                    }
                }
            }
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListOldFuncionarioNormalExcluido : funcionarioNormalExcluidoListOld) {
                if (!funcionarioNormalExcluidoListNew.contains(funcionarioNormalExcluidoListOldFuncionarioNormalExcluido)) {
                    funcionarioNormalExcluidoListOldFuncionarioNormalExcluido.setIdFuncionario(null);
                    funcionarioNormalExcluidoListOldFuncionarioNormalExcluido = em.merge(funcionarioNormalExcluidoListOldFuncionarioNormalExcluido);
                }
            }
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListNewFuncionarioNormalExcluido : funcionarioNormalExcluidoListNew) {
                if (!funcionarioNormalExcluidoListOld.contains(funcionarioNormalExcluidoListNewFuncionarioNormalExcluido)) {
                    FuncionarioAdmin oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido = funcionarioNormalExcluidoListNewFuncionarioNormalExcluido.getIdFuncionario();
                    funcionarioNormalExcluidoListNewFuncionarioNormalExcluido.setIdFuncionario(funcionarioAdmin);
                    funcionarioNormalExcluidoListNewFuncionarioNormalExcluido = em.merge(funcionarioNormalExcluidoListNewFuncionarioNormalExcluido);
                    if (oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido != null && !oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido.equals(funcionarioAdmin)) {
                        oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido.getFuncionarioNormalExcluidoList().remove(funcionarioNormalExcluidoListNewFuncionarioNormalExcluido);
                        oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido = em.merge(oldIdFuncionarioOfFuncionarioNormalExcluidoListNewFuncionarioNormalExcluido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionarioAdmin.getIdFuncionario();
                if (findFuncionarioAdmin(id) == null) {
                    throw new NonexistentEntityException("The funcionarioAdmin with id " + id + " no longer exists.");
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
            FuncionarioAdmin funcionarioAdmin;
            try {
                funcionarioAdmin = em.getReference(FuncionarioAdmin.class, id);
                funcionarioAdmin.getIdFuncionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioAdmin with id " + id + " no longer exists.", enfe);
            }
            List<FuncionarioAceite> funcionarioAceiteList = funcionarioAdmin.getFuncionarioAceiteList();
            for (FuncionarioAceite funcionarioAceiteListFuncionarioAceite : funcionarioAceiteList) {
                funcionarioAceiteListFuncionarioAceite.setIdFuncionario(null);
                funcionarioAceiteListFuncionarioAceite = em.merge(funcionarioAceiteListFuncionarioAceite);
            }
            List<FuncionarioNormalExcluido> funcionarioNormalExcluidoList = funcionarioAdmin.getFuncionarioNormalExcluidoList();
            for (FuncionarioNormalExcluido funcionarioNormalExcluidoListFuncionarioNormalExcluido : funcionarioNormalExcluidoList) {
                funcionarioNormalExcluidoListFuncionarioNormalExcluido.setIdFuncionario(null);
                funcionarioNormalExcluidoListFuncionarioNormalExcluido = em.merge(funcionarioNormalExcluidoListFuncionarioNormalExcluido);
            }
            em.remove(funcionarioAdmin);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioAdmin> findFuncionarioAdminEntities() {
        return findFuncionarioAdminEntities(true, -1, -1);
    }

    public List<FuncionarioAdmin> findFuncionarioAdminEntities(int maxResults, int firstResult) {
        return findFuncionarioAdminEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioAdmin> findFuncionarioAdminEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioAdmin.class));
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

    public FuncionarioAdmin findFuncionarioAdmin(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioAdmin.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioAdminCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioAdmin> rt = cq.from(FuncionarioAdmin.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
