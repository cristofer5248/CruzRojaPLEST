/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import javax.persistence.EntityManager;
import sv.com.cruzplest.www.entities.PoTableEntity;
import sv.com.cruzplest.www.utils.JpaUtil;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Christopher
 */
public class PoaModel {

    public List<PoTableEntity> listSAreas(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("PoTableEntity.findStrategicArea").setParameter("cod", 5);
            List<PoTableEntity> list = consulta.getResultList();
            System.out.print("Tamaño de la lista es iguaaaaaaaaal " + list.size());
            return list;

        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            return null;
        }
    }

    public boolean removepoa(int poa) {
        EntityManager ent = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = ent.getTransaction();
        try {
            trans.begin();
            ent.remove(ent.find(PoTableEntity.class, poa));
            trans.commit();
            return true;
        } catch (Exception e) {
            ent.close();
            return false;
        }
    }

    public boolean updatepoa(PoTableEntity poa) {
        EntityManager ent = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = ent.getTransaction();
        try {
            trans.begin();
            ent.merge(poa);
            trans.commit();
            ent.close();
            return true;
        } catch (Exception e) {
            ent.close();
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertpoa(PoTableEntity poa) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(poa);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            return false;
        }
    }

    public List<PoTableEntity> listAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("PoTableEntity.findAll");
            return consulta.getResultList();

        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            return null;
        }
    }

    public List<PoTableEntity> listYear() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query consulta = em.createNamedQuery("PoTableEntity.findStrategicArea");
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return null;
    }

}
