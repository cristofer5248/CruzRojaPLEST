/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.ArrayList;
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

    public List<ConsolidatorpoEntity> findMeasurementU(int cod) {
        try {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            Query consulta = em.createNamedQuery("ConsolidatorpoEntity.findByMeasurementU").setParameter("cod", cod);
            List<ConsolidatorpoEntity> list = consulta.getResultList();
            if (list.size() > 0) {
                return list;
            } else {
                JsfUtil.setFlashMessage("null", "NO HAY REGISTROS");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Integer> forRowSpam() {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        ArrayList<Integer> arl = new ArrayList<Integer>();
        try {
            Query consulta = em.createNativeQuery("select count(codigoPO) as veces from consolidatorpo group by codigoPO");
            List list1 = consulta.getResultList();
            for (int i = 0; i < list1.size(); i++) {
                arl.add(Integer.parseInt(list1.get(i).toString()));
            }
        } catch (Exception e) {
        }
        return arl;
    }

    public ArrayList<Integer> forRowSpam2() {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        ArrayList<Integer> arl = new ArrayList<Integer>();
        try {
            String var;
            Query consulta = em.createNativeQuery("select @row_number:=CASE when @customer_no = codigoPO then @row_number + 1 else 1 END AS num, @customer_no:= codigoPO  from consolidatorpo c");
            List<Object[]> list1 = consulta.getResultList();            
            for (Object[] obj: list1) {
                var = (String) obj[0];
                arl.add(Integer.parseInt(var));
            }
        } catch (Exception e) {
            
        }
        return arl;
    }
}
