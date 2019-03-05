/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.com.cruzplest.www.entities.PhysicalGoalEntity;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
public class PhysicalGModel {

    public List<PhysicalGoalEntity> listAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("PhysicalGoalEntity.findAll");
            List<PhysicalGoalEntity> list = consulta.getResultList();
            if (list.isEmpty()) {
                JsfUtil.setErrorMessage("model", "No hay resultados que mostrar");
            }
            em.close();
            return list;
        } catch (Exception e) {
            em.close();
            JsfUtil.setErrorMessage("model", "No hay resultados que mostrar");
            return null;
        }
    }

}
