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
import modelo.CedulasExcluidas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.CedulasConfirmadas;
import modelo.CedulasEditadas;
import modelo.FuncionarioNormal;

/**
 *
 * @author Jozino M. Abubacar
 */
public class FuncionarioNormalJpaController implements Serializable {

    public FuncionarioNormalJpaController() {
    }
    public FuncionarioNormalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioNormal funcionarioNormal) {
        if (funcionarioNormal.getCedulasExcluidasList() == null) {
            funcionarioNormal.setCedulasExcluidasList(new ArrayList<CedulasExcluidas>());
        }
        if (funcionarioNormal.getCedulasConfirmadasList() == null) {
            funcionarioNormal.setCedulasConfirmadasList(new ArrayList<CedulasConfirmadas>());
        }
        if (funcionarioNormal.getCedulasEditadasList() == null) {
            funcionarioNormal.setCedulasEditadasList(new ArrayList<CedulasEditadas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CedulasExcluidas> attachedCedulasExcluidasList = new ArrayList<CedulasExcluidas>();
            for (CedulasExcluidas cedulasExcluidasListCedulasExcluidasToAttach : funcionarioNormal.getCedulasExcluidasList()) {
                cedulasExcluidasListCedulasExcluidasToAttach = em.getReference(cedulasExcluidasListCedulasExcluidasToAttach.getClass(), cedulasExcluidasListCedulasExcluidasToAttach.getIdCedulaExcluida());
                attachedCedulasExcluidasList.add(cedulasExcluidasListCedulasExcluidasToAttach);
            }
            funcionarioNormal.setCedulasExcluidasList(attachedCedulasExcluidasList);
            List<CedulasConfirmadas> attachedCedulasConfirmadasList = new ArrayList<CedulasConfirmadas>();
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadasToAttach : funcionarioNormal.getCedulasConfirmadasList()) {
                cedulasConfirmadasListCedulasConfirmadasToAttach = em.getReference(cedulasConfirmadasListCedulasConfirmadasToAttach.getClass(), cedulasConfirmadasListCedulasConfirmadasToAttach.getNumeroAssento());
                attachedCedulasConfirmadasList.add(cedulasConfirmadasListCedulasConfirmadasToAttach);
            }
            funcionarioNormal.setCedulasConfirmadasList(attachedCedulasConfirmadasList);
            List<CedulasEditadas> attachedCedulasEditadasList = new ArrayList<CedulasEditadas>();
            for (CedulasEditadas cedulasEditadasListCedulasEditadasToAttach : funcionarioNormal.getCedulasEditadasList()) {
                cedulasEditadasListCedulasEditadasToAttach = em.getReference(cedulasEditadasListCedulasEditadasToAttach.getClass(), cedulasEditadasListCedulasEditadasToAttach.getIdCedulaEditadas());
                attachedCedulasEditadasList.add(cedulasEditadasListCedulasEditadasToAttach);
            }
            funcionarioNormal.setCedulasEditadasList(attachedCedulasEditadasList);
            em.persist(funcionarioNormal);
            for (CedulasExcluidas cedulasExcluidasListCedulasExcluidas : funcionarioNormal.getCedulasExcluidasList()) {
                FuncionarioNormal oldIdFuncionarioOfCedulasExcluidasListCedulasExcluidas = cedulasExcluidasListCedulasExcluidas.getIdFuncionario();
                cedulasExcluidasListCedulasExcluidas.setIdFuncionario(funcionarioNormal);
                cedulasExcluidasListCedulasExcluidas = em.merge(cedulasExcluidasListCedulasExcluidas);
                if (oldIdFuncionarioOfCedulasExcluidasListCedulasExcluidas != null) {
                    oldIdFuncionarioOfCedulasExcluidasListCedulasExcluidas.getCedulasExcluidasList().remove(cedulasExcluidasListCedulasExcluidas);
                    oldIdFuncionarioOfCedulasExcluidasListCedulasExcluidas = em.merge(oldIdFuncionarioOfCedulasExcluidasListCedulasExcluidas);
                }
            }
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadas : funcionarioNormal.getCedulasConfirmadasList()) {
                FuncionarioNormal oldIdFuncionarioOfCedulasConfirmadasListCedulasConfirmadas = cedulasConfirmadasListCedulasConfirmadas.getIdFuncionario();
                cedulasConfirmadasListCedulasConfirmadas.setIdFuncionario(funcionarioNormal);
                cedulasConfirmadasListCedulasConfirmadas = em.merge(cedulasConfirmadasListCedulasConfirmadas);
                if (oldIdFuncionarioOfCedulasConfirmadasListCedulasConfirmadas != null) {
                    oldIdFuncionarioOfCedulasConfirmadasListCedulasConfirmadas.getCedulasConfirmadasList().remove(cedulasConfirmadasListCedulasConfirmadas);
                    oldIdFuncionarioOfCedulasConfirmadasListCedulasConfirmadas = em.merge(oldIdFuncionarioOfCedulasConfirmadasListCedulasConfirmadas);
                }
            }
            for (CedulasEditadas cedulasEditadasListCedulasEditadas : funcionarioNormal.getCedulasEditadasList()) {
                FuncionarioNormal oldIdFuncionarioOfCedulasEditadasListCedulasEditadas = cedulasEditadasListCedulasEditadas.getIdFuncionario();
                cedulasEditadasListCedulasEditadas.setIdFuncionario(funcionarioNormal);
                cedulasEditadasListCedulasEditadas = em.merge(cedulasEditadasListCedulasEditadas);
                if (oldIdFuncionarioOfCedulasEditadasListCedulasEditadas != null) {
                    oldIdFuncionarioOfCedulasEditadasListCedulasEditadas.getCedulasEditadasList().remove(cedulasEditadasListCedulasEditadas);
                    oldIdFuncionarioOfCedulasEditadasListCedulasEditadas = em.merge(oldIdFuncionarioOfCedulasEditadasListCedulasEditadas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioNormal funcionarioNormal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioNormal persistentFuncionarioNormal = em.find(FuncionarioNormal.class, funcionarioNormal.getIdFuncionario());
            List<CedulasExcluidas> cedulasExcluidasListOld = persistentFuncionarioNormal.getCedulasExcluidasList();
            List<CedulasExcluidas> cedulasExcluidasListNew = funcionarioNormal.getCedulasExcluidasList();
            List<CedulasConfirmadas> cedulasConfirmadasListOld = persistentFuncionarioNormal.getCedulasConfirmadasList();
            List<CedulasConfirmadas> cedulasConfirmadasListNew = funcionarioNormal.getCedulasConfirmadasList();
            List<CedulasEditadas> cedulasEditadasListOld = persistentFuncionarioNormal.getCedulasEditadasList();
            List<CedulasEditadas> cedulasEditadasListNew = funcionarioNormal.getCedulasEditadasList();
            List<CedulasExcluidas> attachedCedulasExcluidasListNew = new ArrayList<CedulasExcluidas>();
            for (CedulasExcluidas cedulasExcluidasListNewCedulasExcluidasToAttach : cedulasExcluidasListNew) {
                cedulasExcluidasListNewCedulasExcluidasToAttach = em.getReference(cedulasExcluidasListNewCedulasExcluidasToAttach.getClass(), cedulasExcluidasListNewCedulasExcluidasToAttach.getIdCedulaExcluida());
                attachedCedulasExcluidasListNew.add(cedulasExcluidasListNewCedulasExcluidasToAttach);
            }
            cedulasExcluidasListNew = attachedCedulasExcluidasListNew;
            funcionarioNormal.setCedulasExcluidasList(cedulasExcluidasListNew);
            List<CedulasConfirmadas> attachedCedulasConfirmadasListNew = new ArrayList<CedulasConfirmadas>();
            for (CedulasConfirmadas cedulasConfirmadasListNewCedulasConfirmadasToAttach : cedulasConfirmadasListNew) {
                cedulasConfirmadasListNewCedulasConfirmadasToAttach = em.getReference(cedulasConfirmadasListNewCedulasConfirmadasToAttach.getClass(), cedulasConfirmadasListNewCedulasConfirmadasToAttach.getNumeroAssento());
                attachedCedulasConfirmadasListNew.add(cedulasConfirmadasListNewCedulasConfirmadasToAttach);
            }
            cedulasConfirmadasListNew = attachedCedulasConfirmadasListNew;
            funcionarioNormal.setCedulasConfirmadasList(cedulasConfirmadasListNew);
            List<CedulasEditadas> attachedCedulasEditadasListNew = new ArrayList<CedulasEditadas>();
            for (CedulasEditadas cedulasEditadasListNewCedulasEditadasToAttach : cedulasEditadasListNew) {
                cedulasEditadasListNewCedulasEditadasToAttach = em.getReference(cedulasEditadasListNewCedulasEditadasToAttach.getClass(), cedulasEditadasListNewCedulasEditadasToAttach.getIdCedulaEditadas());
                attachedCedulasEditadasListNew.add(cedulasEditadasListNewCedulasEditadasToAttach);
            }
            cedulasEditadasListNew = attachedCedulasEditadasListNew;
            funcionarioNormal.setCedulasEditadasList(cedulasEditadasListNew);
            funcionarioNormal = em.merge(funcionarioNormal);
            for (CedulasExcluidas cedulasExcluidasListOldCedulasExcluidas : cedulasExcluidasListOld) {
                if (!cedulasExcluidasListNew.contains(cedulasExcluidasListOldCedulasExcluidas)) {
                    cedulasExcluidasListOldCedulasExcluidas.setIdFuncionario(null);
                    cedulasExcluidasListOldCedulasExcluidas = em.merge(cedulasExcluidasListOldCedulasExcluidas);
                }
            }
            for (CedulasExcluidas cedulasExcluidasListNewCedulasExcluidas : cedulasExcluidasListNew) {
                if (!cedulasExcluidasListOld.contains(cedulasExcluidasListNewCedulasExcluidas)) {
                    FuncionarioNormal oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas = cedulasExcluidasListNewCedulasExcluidas.getIdFuncionario();
                    cedulasExcluidasListNewCedulasExcluidas.setIdFuncionario(funcionarioNormal);
                    cedulasExcluidasListNewCedulasExcluidas = em.merge(cedulasExcluidasListNewCedulasExcluidas);
                    if (oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas != null && !oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas.equals(funcionarioNormal)) {
                        oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas.getCedulasExcluidasList().remove(cedulasExcluidasListNewCedulasExcluidas);
                        oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas = em.merge(oldIdFuncionarioOfCedulasExcluidasListNewCedulasExcluidas);
                    }
                }
            }
            for (CedulasConfirmadas cedulasConfirmadasListOldCedulasConfirmadas : cedulasConfirmadasListOld) {
                if (!cedulasConfirmadasListNew.contains(cedulasConfirmadasListOldCedulasConfirmadas)) {
                 //   cedulasConfirmadasListOldCedulasConfirmadas.setIdFuncionario(null);
                    cedulasConfirmadasListOldCedulasConfirmadas = em.merge(cedulasConfirmadasListOldCedulasConfirmadas);
                }
            }
            for (CedulasConfirmadas cedulasConfirmadasListNewCedulasConfirmadas : cedulasConfirmadasListNew) {
                if (!cedulasConfirmadasListOld.contains(cedulasConfirmadasListNewCedulasConfirmadas)) {
                    FuncionarioNormal oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas = cedulasConfirmadasListNewCedulasConfirmadas.getIdFuncionario();
                    cedulasConfirmadasListNewCedulasConfirmadas.setIdFuncionario(funcionarioNormal);
                    cedulasConfirmadasListNewCedulasConfirmadas = em.merge(cedulasConfirmadasListNewCedulasConfirmadas);
                    if (oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas != null && !oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas.equals(funcionarioNormal)) {
                        oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas.getCedulasConfirmadasList().remove(cedulasConfirmadasListNewCedulasConfirmadas);
                        oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas = em.merge(oldIdFuncionarioOfCedulasConfirmadasListNewCedulasConfirmadas);
                    }
                }
            }
            for (CedulasEditadas cedulasEditadasListOldCedulasEditadas : cedulasEditadasListOld) {
                if (!cedulasEditadasListNew.contains(cedulasEditadasListOldCedulasEditadas)) {
                    cedulasEditadasListOldCedulasEditadas.setIdFuncionario(null);
                    cedulasEditadasListOldCedulasEditadas = em.merge(cedulasEditadasListOldCedulasEditadas);
                }
            }
            for (CedulasEditadas cedulasEditadasListNewCedulasEditadas : cedulasEditadasListNew) {
                if (!cedulasEditadasListOld.contains(cedulasEditadasListNewCedulasEditadas)) {
                    FuncionarioNormal oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas = cedulasEditadasListNewCedulasEditadas.getIdFuncionario();
                    cedulasEditadasListNewCedulasEditadas.setIdFuncionario(funcionarioNormal);
                    cedulasEditadasListNewCedulasEditadas = em.merge(cedulasEditadasListNewCedulasEditadas);
                    if (oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas != null && !oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas.equals(funcionarioNormal)) {
                        oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas.getCedulasEditadasList().remove(cedulasEditadasListNewCedulasEditadas);
                        oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas = em.merge(oldIdFuncionarioOfCedulasEditadasListNewCedulasEditadas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionarioNormal.getIdFuncionario();
                if (findFuncionarioNormal(id) == null) {
                    throw new NonexistentEntityException("The funcionarioNormal with id " + id + " no longer exists.");
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
            FuncionarioNormal funcionarioNormal;
            try {
                funcionarioNormal = em.getReference(FuncionarioNormal.class, id);
                funcionarioNormal.getIdFuncionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioNormal with id " + id + " no longer exists.", enfe);
            }
            List<CedulasExcluidas> cedulasExcluidasList = funcionarioNormal.getCedulasExcluidasList();
            for (CedulasExcluidas cedulasExcluidasListCedulasExcluidas : cedulasExcluidasList) {
                cedulasExcluidasListCedulasExcluidas.setIdFuncionario(null);
                cedulasExcluidasListCedulasExcluidas = em.merge(cedulasExcluidasListCedulasExcluidas);
            }
            List<CedulasConfirmadas> cedulasConfirmadasList = funcionarioNormal.getCedulasConfirmadasList();
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadas : cedulasConfirmadasList) {
               // cedulasConfirmadasListCedulasConfirmadas.setIdFuncionario(null);
                cedulasConfirmadasListCedulasConfirmadas = em.merge(cedulasConfirmadasListCedulasConfirmadas);
            }
            List<CedulasEditadas> cedulasEditadasList = funcionarioNormal.getCedulasEditadasList();
            for (CedulasEditadas cedulasEditadasListCedulasEditadas : cedulasEditadasList) {
                cedulasEditadasListCedulasEditadas.setIdFuncionario(null);
                cedulasEditadasListCedulasEditadas = em.merge(cedulasEditadasListCedulasEditadas);
            }
            em.remove(funcionarioNormal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioNormal> findFuncionarioNormalEntities() {
        return findFuncionarioNormalEntities(true, -1, -1);
    }

    public List<FuncionarioNormal> findFuncionarioNormalEntities(int maxResults, int firstResult) {
        return findFuncionarioNormalEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioNormal> findFuncionarioNormalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioNormal.class));
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

    public FuncionarioNormal findFuncionarioNormal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioNormal.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioNormalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioNormal> rt = cq.from(FuncionarioNormal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
