/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.com.cruzplest.www.entities.PhysicalGoalEntity;
import sv.com.cruzplest.www.model.PhysicalGModel;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@RequestScoped
public class PhysicalGBean {

    PhysicalGModel model = new PhysicalGModel();
    PhysicalGoalEntity physicalGoal;

    /**
     * Creates a new instance of PhysicalGBean
     */
    public PhysicalGBean() {
        physicalGoal = new PhysicalGoalEntity();
    }

    public List<PhysicalGoalEntity> listAll() {
        try {
            List<PhysicalGoalEntity> list = model.listAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
