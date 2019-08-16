/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.List;
import sv.com.cruzplest.www.utils.JpaUtil;
import sv.com.cruzplest.www.entities.UsersEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author RRDESC04
 */
public class UserModel {

    public UsersEntity login(String user, String pass) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsersEntity.findByAuten").setParameter("codigouser", user).setParameter("pass", pass);
//            primer createnamedquery ejecutado
            List<UsersEntity> listado = consulta.getResultList();
            if (!listado.isEmpty()) {
                return listado.get(0);
            } else {
                System.out.print("No hay usuarios");
            }
            em.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verificarcontraseña(String user, String pass) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNativeQuery("select s.codigouser from users s where s.pass='" + pass + "' AND s.codigouser='" + user + "'");
            int querySize = consulta.getResultList().size();
            if (querySize > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public int verificarIntentos(String user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNativeQuery("select count(i.userintentos) from intentos i where i.userintentos='" + user + "'");
            List countAttemptsList = consulta.getResultList();
            int countAttempts = Integer.parseInt(countAttemptsList.get(0).toString());
            return countAttempts;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<UsersEntity> listarAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsersEntity.findAll");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
        public List<UsersEntity> listarAllPlanificacion() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsersEntity.findAllwithoutAdmins");
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<UsersEntity> listarInfo(String codigo) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsersEntity.findByCodigouser").setParameter("codigouser", codigo);
            return consulta.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public int changeEmail(UsersEntity user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(user);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateUser(UsersEntity user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(user);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Boolean guardar(UsersEntity user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(user);
            tran.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(String cod){
        
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction tran = em.getTransaction();
        try {    
            tran.begin();
            em.remove(em.find(UsersEntity.class, cod));
            tran.commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            return false;
        }
    }
}
