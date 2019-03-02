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
            e.printStackTrace();
            return null;
        }
    }
    
}
