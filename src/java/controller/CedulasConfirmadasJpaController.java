/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Connection.Connection;
import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.CedulasConfirmadas;
import modelo.FuncionarioNormal;
import modelo.Requerente;

/**
 *
 * @author Jozino M. Abubacar
 */
public class CedulasConfirmadasJpaController implements Serializable {
     public CedulasConfirmadasJpaController() {
    }

    public CedulasConfirmadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return Connection.getConnection().getEmf().createEntityManager();
    }

    public void create(CedulasConfirmadas cedulasConfirmadas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioNormal idFuncionario = cedulasConfirmadas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdFuncionario());
                cedulasConfirmadas.setIdFuncionario(idFuncionario);
            }
            Requerente idRequerente = cedulasConfirmadas.getIdRequerente();
            if (idRequerente != null) {
                idRequerente = em.getReference(idRequerente.getClass(), idRequerente.getIdRequerente());
                cedulasConfirmadas.setIdRequerente(idRequerente);
            }
            em.persist(cedulasConfirmadas);
            if (idFuncionario != null) {
                idFuncionario.getCedulasConfirmadasList().add(cedulasConfirmadas);
                idFuncionario = em.merge(idFuncionario);
            }
            if (idRequerente != null) {
                idRequerente.getCedulasConfirmadasList().add(cedulasConfirmadas);
                idRequerente = em.merge(idRequerente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CedulasConfirmadas cedulasConfirmadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CedulasConfirmadas persistentCedulasConfirmadas = em.find(CedulasConfirmadas.class, cedulasConfirmadas.getNumeroAssento());
            FuncionarioNormal idFuncionarioOld = persistentCedulasConfirmadas.getIdFuncionario();
            FuncionarioNormal idFuncionarioNew = cedulasConfirmadas.getIdFuncionario();
            Requerente idRequerenteOld = persistentCedulasConfirmadas.getIdRequerente();
            Requerente idRequerenteNew = cedulasConfirmadas.getIdRequerente();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdFuncionario());
                cedulasConfirmadas.setIdFuncionario(idFuncionarioNew);
            }
            if (idRequerenteNew != null) {
                idRequerenteNew = em.getReference(idRequerenteNew.getClass(), idRequerenteNew.getIdRequerente());
                cedulasConfirmadas.setIdRequerente(idRequerenteNew);
            }
            cedulasConfirmadas = em.merge(cedulasConfirmadas);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getCedulasConfirmadasList().remove(cedulasConfirmadas);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getCedulasConfirmadasList().add(cedulasConfirmadas);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            if (idRequerenteOld != null && !idRequerenteOld.equals(idRequerenteNew)) {
                idRequerenteOld.getCedulasConfirmadasList().remove(cedulasConfirmadas);
                idRequerenteOld = em.merge(idRequerenteOld);
            }
            if (idRequerenteNew != null && !idRequerenteNew.equals(idRequerenteOld)) {
                idRequerenteNew.getCedulasConfirmadasList().add(cedulasConfirmadas);
                idRequerenteNew = em.merge(idRequerenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cedulasConfirmadas.getNumeroAssento();
                if (findCedulasConfirmadas(id) == null) {
                    throw new NonexistentEntityException("The cedulasConfirmadas with id " + id + " no longer exists.");
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
            CedulasConfirmadas cedulasConfirmadas;
            try {
                cedulasConfirmadas = em.getReference(CedulasConfirmadas.class, id);
                cedulasConfirmadas.getNumeroAssento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cedulasConfirmadas with id " + id + " no longer exists.", enfe);
            }
            FuncionarioNormal idFuncionario = cedulasConfirmadas.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getCedulasConfirmadasList().remove(cedulasConfirmadas);
                idFuncionario = em.merge(idFuncionario);
            }
            Requerente idRequerente = cedulasConfirmadas.getIdRequerente();
            if (idRequerente != null) {
                idRequerente.getCedulasConfirmadasList().remove(cedulasConfirmadas);
                idRequerente = em.merge(idRequerente);
            }
            em.remove(cedulasConfirmadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CedulasConfirmadas> findCedulasConfirmadasEntities() {
        return findCedulasConfirmadasEntities(true, -1, -1);
    }

    public List<CedulasConfirmadas> findCedulasConfirmadasEntities(int maxResults, int firstResult) {
        return findCedulasConfirmadasEntities(false, maxResults, firstResult);
    }

    private List<CedulasConfirmadas> findCedulasConfirmadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CedulasConfirmadas.class));
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

    public CedulasConfirmadas findCedulasConfirmadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CedulasConfirmadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCedulasConfirmadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CedulasConfirmadas> rt = cq.from(CedulasConfirmadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
