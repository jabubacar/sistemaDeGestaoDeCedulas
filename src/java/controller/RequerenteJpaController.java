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
import modelo.CedulasConfirmadas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Requerente;

/**
 *
 * @author Jozino M. Abubacar
 */
public class RequerenteJpaController implements Serializable {
     public RequerenteJpaController(){
     }
    public RequerenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Requerente requerente) {
        if (requerente.getCedulasConfirmadasList() == null) {
            requerente.setCedulasConfirmadasList(new ArrayList<CedulasConfirmadas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CedulasConfirmadas> attachedCedulasConfirmadasList = new ArrayList<CedulasConfirmadas>();
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadasToAttach : requerente.getCedulasConfirmadasList()) {
                cedulasConfirmadasListCedulasConfirmadasToAttach = em.getReference(cedulasConfirmadasListCedulasConfirmadasToAttach.getClass(), cedulasConfirmadasListCedulasConfirmadasToAttach.getNumeroAssento());
                attachedCedulasConfirmadasList.add(cedulasConfirmadasListCedulasConfirmadasToAttach);
            }
            requerente.setCedulasConfirmadasList(attachedCedulasConfirmadasList);
            em.persist(requerente);
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadas : requerente.getCedulasConfirmadasList()) {
                Requerente oldIdRequerenteOfCedulasConfirmadasListCedulasConfirmadas = cedulasConfirmadasListCedulasConfirmadas.getIdRequerente();
                cedulasConfirmadasListCedulasConfirmadas.setIdRequerente(requerente);
                cedulasConfirmadasListCedulasConfirmadas = em.merge(cedulasConfirmadasListCedulasConfirmadas);
                if (oldIdRequerenteOfCedulasConfirmadasListCedulasConfirmadas != null) {
                    oldIdRequerenteOfCedulasConfirmadasListCedulasConfirmadas.getCedulasConfirmadasList().remove(cedulasConfirmadasListCedulasConfirmadas);
                    oldIdRequerenteOfCedulasConfirmadasListCedulasConfirmadas = em.merge(oldIdRequerenteOfCedulasConfirmadasListCedulasConfirmadas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Requerente requerente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Requerente persistentRequerente = em.find(Requerente.class, requerente.getIdRequerente());
            List<CedulasConfirmadas> cedulasConfirmadasListOld = persistentRequerente.getCedulasConfirmadasList();
            List<CedulasConfirmadas> cedulasConfirmadasListNew = requerente.getCedulasConfirmadasList();
            List<CedulasConfirmadas> attachedCedulasConfirmadasListNew = new ArrayList<CedulasConfirmadas>();
            for (CedulasConfirmadas cedulasConfirmadasListNewCedulasConfirmadasToAttach : cedulasConfirmadasListNew) {
                cedulasConfirmadasListNewCedulasConfirmadasToAttach = em.getReference(cedulasConfirmadasListNewCedulasConfirmadasToAttach.getClass(), cedulasConfirmadasListNewCedulasConfirmadasToAttach.getNumeroAssento());
                attachedCedulasConfirmadasListNew.add(cedulasConfirmadasListNewCedulasConfirmadasToAttach);
            }
            cedulasConfirmadasListNew = attachedCedulasConfirmadasListNew;
            requerente.setCedulasConfirmadasList(cedulasConfirmadasListNew);
            requerente = em.merge(requerente);
            for (CedulasConfirmadas cedulasConfirmadasListOldCedulasConfirmadas : cedulasConfirmadasListOld) {
                if (!cedulasConfirmadasListNew.contains(cedulasConfirmadasListOldCedulasConfirmadas)) {
                    cedulasConfirmadasListOldCedulasConfirmadas.setIdRequerente(null);
                    cedulasConfirmadasListOldCedulasConfirmadas = em.merge(cedulasConfirmadasListOldCedulasConfirmadas);
                }
            }
            for (CedulasConfirmadas cedulasConfirmadasListNewCedulasConfirmadas : cedulasConfirmadasListNew) {
                if (!cedulasConfirmadasListOld.contains(cedulasConfirmadasListNewCedulasConfirmadas)) {
                    Requerente oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas = cedulasConfirmadasListNewCedulasConfirmadas.getIdRequerente();
                    cedulasConfirmadasListNewCedulasConfirmadas.setIdRequerente(requerente);
                    cedulasConfirmadasListNewCedulasConfirmadas = em.merge(cedulasConfirmadasListNewCedulasConfirmadas);
                    if (oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas != null && !oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas.equals(requerente)) {
                        oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas.getCedulasConfirmadasList().remove(cedulasConfirmadasListNewCedulasConfirmadas);
                        oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas = em.merge(oldIdRequerenteOfCedulasConfirmadasListNewCedulasConfirmadas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = requerente.getIdRequerente();
                if (findRequerente(id) == null) {
                    throw new NonexistentEntityException("The requerente with id " + id + " no longer exists.");
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
            Requerente requerente;
            try {
                requerente = em.getReference(Requerente.class, id);
                requerente.getIdRequerente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The requerente with id " + id + " no longer exists.", enfe);
            }
            List<CedulasConfirmadas> cedulasConfirmadasList = requerente.getCedulasConfirmadasList();
            for (CedulasConfirmadas cedulasConfirmadasListCedulasConfirmadas : cedulasConfirmadasList) {
                cedulasConfirmadasListCedulasConfirmadas.setIdRequerente(null);
                cedulasConfirmadasListCedulasConfirmadas = em.merge(cedulasConfirmadasListCedulasConfirmadas);
            }
            em.remove(requerente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Requerente> findRequerenteEntities() {
        return findRequerenteEntities(true, -1, -1);
    }

    public List<Requerente> findRequerenteEntities(int maxResults, int firstResult) {
        return findRequerenteEntities(false, maxResults, firstResult);
    }

    private List<Requerente> findRequerenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Requerente.class));
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

    public Requerente findRequerente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Requerente.class, id);
        } finally {
            em.close();
        }
    }

    public int getRequerenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Requerente> rt = cq.from(Requerente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
