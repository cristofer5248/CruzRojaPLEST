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
import sv.com.cruzplest.www.entities.StrategicareasEntity;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
public class AreasModel {

    public List<StrategicareasEntity> listAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("StrategicareasEntity.findAll");
            List<StrategicareasEntity> list = consulta.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            mandarerror();
            return null;
        }

    }

    public boolean deletearea(int id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.find(StrategicareasEntity.class, id));
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    public boolean insertAreas(StrategicareasEntity strategic) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(strategic);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            mandarerror();
            return false;
        }
    }

    public boolean updateArea(StrategicareasEntity strategic) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.merge(strategic);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            mandarerror();
            return false;

        }

    }

    public void mandarerror() {
        JsfUtil.setErrorMessage("modelerror", "Error grave en el Modelo de Areas");
    }

}
