/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNamedQuery("ConsolidatorpoEntity.findAll");
            List<ConsolidatorpoEntity> list = consulta.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            JsfUtil.setErrorMessage("model", "Error entitymanager findall");
            return null;
        }
    }

    public boolean findifpo(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNamedQuery("ConsolidatorpoEntity.findByCodigopo").setParameter("cod", cod);
            List<ConsolidatorpoEntity> list = con.getResultList();
            if (list.isEmpty()) {
                return true;
            }
            em.close();
            return false;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    public List findRowspanHigher(int cod1) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query consulta = em.createNativeQuery("select c.codigocon from consolidatorpo c where codigoPO=" + cod1 + " and rowspan2>0 and rowspan=1 order by rowspan2 DESC limit 1");
            List Lconsu = consulta.getResultList();
            em.close();
            return Lconsu;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int findRowspan3mother(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNamedQuery("select c.codigocon from consolidatorpo c inner join po_table po on po.codigopo = c.codigoPO where areaest=? and rowspan2>0 and rowspan=1 order by rowspan3 DESC limit 1;");
            con.setParameter(1, cod);
            List list1 = con.getResultList();
            em.close();
            int aja = Integer.parseInt(list1.get(0).toString());
            return aja;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public boolean findyear(int year1, int poa, int ped) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select c.year from consolidatorpo c where c.year='" + year1 + "' and c.codigoPO='" + poa + "' and c.codigocon !=" + ped + "");
            List list1 = con.getResultList();
            return list1.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveped(ConsolidatorpoEntity conso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(conso);
            tran.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List nstrategicAreasBind(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select count(c.codigoPO) from consolidatorpo c inner join po_table po on po.codigopo=c.codigoPO where po.areaest=? and c.rowspan3!=0;");
            con.setParameter(1, cod);
            List list1 = con.getResultList();
            return list1;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public List strategicAreasBind(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select count(po.areaest) from consolidatorpo c inner join po_table po on po.codigopo=c.codigoPO where po.areaest=?");
            con.setParameter(1, cod);
            List list1 = con.getResultList();
            return list1;
        } catch (Exception e) {
            em.close();
            return null;
        }

    }
    //llenar entity forms

    public ConsolidatorpoEntity findbyIdPED(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            ConsolidatorpoEntity conso = em.find(ConsolidatorpoEntity.class, cod);
            em.close();
            return conso;
        } catch (Exception e) {
            em.close();
            System.out.println("Errrrrrrror en findbyidped");
            JsfUtil.setErrorMessage("model", "error en findbyPED");
            return null;
        }
    }

    public boolean delete1(int conso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            EntityTransaction trans = em.getTransaction();
            ConsolidatorpoEntity conso1 = em.find(ConsolidatorpoEntity.class, conso);
            trans.begin();
            em.remove(conso1);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePED(ConsolidatorpoEntity conso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(conso);
            trans.commit();
            JsfUtil.setFlashMessage("update", "PED actualizado correctamente");
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            System.out.println("Errrrrrrror en updatePED");
            JsfUtil.setErrorMessage("model", "error en updatePED");
        }
        return false;
    }

    public ConsolidatorpoEntity getpEDRowspan(int codigopo) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            ConsolidatorpoEntity con = (ConsolidatorpoEntity) em.createNativeQuery("select * from consolidatorpo WHERE codigoPO = '" + codigopo + "' and rowspan2>0 ORDER BY rowspan2 DESC limit 1;", ConsolidatorpoEntity.class).getSingleResult();
            System.out.print("Impeimiendo primer querynativo1 " + con.getCodigoPO().getActividad() + " rowspan " + con.getRowspan2());

            em.close();
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            System.out.println("Errrrrrrror en updatePED");
            JsfUtil.setErrorMessage("model", "error en updatePED");
        }
        return null;
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

    public List<ConsolidatorpoEntity> findbypo(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNamedQuery("ConsolidatorpoEntity.findByCodigopo").setParameter("cod", cod);
            List<ConsolidatorpoEntity> list1 = con.getResultList();
            if (list1.isEmpty()) {
                return null;
            } else {
                return list1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List maxejecutado(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select c.ejecutado from consolidatorpo c where c.codigoPO = ? order by c.ejecutado desc limit 1");
            con.setParameter(1, cod);
            List list = con.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            em.close();
            e.printStackTrace();
            return null;
        }
    }

    public List maxplanificado(int cod) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select c.planificado from consolidatorpo c where c.codigoPO = ? order by c.planificado desc limit 1");
            con.setParameter(1, cod);
            List list = con.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            em.close();
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
            Query consulta = em.createNativeQuery("select p.codigopo, sum(p.planificado) as planificado,sum(p.ejecutado) as ejecutado, sum((p.ejecutado/p.planificado)*100) as total from consolidatorpo p inner join po_table po on po.codigopo=p.codigoPO group by p.codigopo order by po.areaest, p.codigopo, p.rowspan2 desc");
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

    public boolean checkPoainped(int codigo) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query con = em.createNativeQuery("select c.codigopo from consolidatorpo c where c.codigopo=" + codigo + "");
            List list1 = con.getResultList();
            return list1.isEmpty();
        } catch (Exception e) {
            return false;
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
