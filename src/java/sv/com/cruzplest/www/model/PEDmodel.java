/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author Christopher
 */
public class PEDmodel {

    public List<ConsolidatorpoEntity> listAll() {
        try {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            Query consulta = em.createNamedQuery("ConsolidatorpoEntity.findAll");
            List<ConsolidatorpoEntity> list = consulta.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.setErrorMessage("model", "Error entitymanager findall");
            return null;
        }
    }
}
