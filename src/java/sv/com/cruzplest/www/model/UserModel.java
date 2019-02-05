/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.entities.UsersEntity;
//import sv.com.cruzplest.www.entities.UsersEntity;C
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author RRDESC04
 */
public class UserModel {

    public UsersEntity login() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsersEntities.findAll");
//            primer createnamedquery ejecutado
            List<UsersEntity> listado = consulta.getResultList();
            if (!listado.isEmpty()) {
                return listado.get(0);
            }
            else{System.out.print("No hay usuarios");}
            em.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
