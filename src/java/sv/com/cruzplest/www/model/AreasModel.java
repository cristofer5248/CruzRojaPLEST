/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.com.cruzplest.www.entities.StrategicareasEntity;
import sv.com.cruzplest.www.utils.JpaUtil;

/**
 *
 * @author RRDESC04
 */
public class AreasModel {

    public List<StrategicareasEntity> listAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("StrategicareasEntity.findAll");
            return consulta.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
