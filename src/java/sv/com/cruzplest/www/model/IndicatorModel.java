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
import sv.com.cruzplest.www.entities.IndicatorpoEntity;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
public class IndicatorModel {

    public List<IndicatorpoEntity> listAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("IndicatorpoEntity.findAll");
            List<IndicatorpoEntity> list = consulta.getResultList();
            if (list.isEmpty()) {
                JsfUtil.setErrorMessage("model", "No hay datos que mostrar");
            }
            em.close();
            return list;
        } catch (Exception e) {
            JsfUtil.setErrorMessage("grave", "Error gravisimo");
            em.close();
            return null;
        }
    }

    public boolean save(IndicatorpoEntity indicador) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(indicador);
            tran.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            return false;
        }
    }

}
