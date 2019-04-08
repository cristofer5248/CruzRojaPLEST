/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import sv.com.cruzplest.www.entities.MeasurementunitsEntity;
import sv.com.cruzplest.www.utils.JpaUtil;

/**
 *
 * @author cristofer5248
 */
public class MeasurementUModel {

    public List<MeasurementunitsEntity> listAll() {
        try {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            Query consulta = em.createNamedQuery("MeasurementunitsEntity.findAll");
            return consulta.getResultList();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public boolean addmea(MeasurementunitsEntity mea) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(mea);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    public boolean deletemea(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.find(MeasurementunitsEntity.class, cod));
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    public boolean updatemea(MeasurementunitsEntity mea) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(mea);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }
    

}
