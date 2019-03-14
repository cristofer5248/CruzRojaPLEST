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

    public List<Object[]> forRowSpam2() {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query consulta = em.createNativeQuery("select @row_number:=CASE when @customer_no = codigoPO then @row_number + 1 else 1 END AS num, @customer_no:= codigoPO from consolidatorpo c group by codigocon");
            List<Object[]> list1 = consulta.getResultList();
            return list1;
        } catch (Exception e) {

        }
        return null;
    }

    public List<Object[]> listotal() {
        System.out.print("eoooooooooooooooooooooooo");
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNativeQuery("select codigopo, sum(planificado) as planificado,sum(ejecutado) as ejecutado, sum((p.ejecutado/p.planificado)*100) as total from consolidatorpo p group by  codigopo order by codigopo, rowspan desc");
            List<Object[]> list1 = consulta.getResultList();
            if (list1.isEmpty()) {
                System.out.print("Hee Hee!");
            }
            em.close();
            return list1;
        } catch (Exception e) {             
            e.printStackTrace();
            em.close();
            return null;
        }
    }

    public List<String> XX() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNativeQuery("select codigopo, sum(planificado) as planificado,sum(ejecutado) as ejecutado, sum((p.ejecutado/p.planificado)*100) as total from consolidatorpo p group by  codigopo");
            List<String> list1 = consulta.getResultList();
            em.close();
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            return null;
        }
    }
}
