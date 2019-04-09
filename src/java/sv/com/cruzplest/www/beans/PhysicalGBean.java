/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.entities.PhysicalGoalEntity;
import sv.com.cruzplest.www.model.PhysicalGModel;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class PhysicalGBean {

    PhysicalGModel model = new PhysicalGModel();
    private PhysicalGoalEntity physicalGoal;
    private boolean boolphy;

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

    public void insertorupdatePh() throws IOException {
        try {
            if (boolphy) {
                if (model.updatephy(physicalGoal)) {
                    JsfUtil.setFlashMessage("update", "Meta fisic actualizada correctamente");
                }
            } else {
                model.insertphy(physicalGoal);
                JsfUtil.setFlashMessage("add", "Meta fisica agregada satisfactoriamente");
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("metafisica.xhtml");
        } catch (Exception e) {
            JsfUtil.setFlashMessage("error", "Error interno");
            FacesContext.getCurrentInstance().getExternalContext().redirect("metafisica.xhtml");
        }
    }

    public void delete() throws IOException {
        try {
            if (model.deletephy(physicalGoal.getCodigo())) {
                JsfUtil.setFlashMessage("error", "La meta " + physicalGoal.getMeta() + " ha sido borrada correctamente");
            } else {
                JsfUtil.setFlashMessage("error", "Error interno, posiblemente la meta ya esta siendo usada");
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("metafisica.xhtml");
        } catch (Exception e) {
            JsfUtil.setFlashMessage("error", "Error interno");
            FacesContext.getCurrentInstance().getExternalContext().redirect("metafisica.xhtml");
        }
    }

    public void changebool() {
        setBoolphy(true);
    }

    /**
     * @return the physicalGoal
     */
    public PhysicalGoalEntity getPhysicalGoal() {
        return physicalGoal;
    }

    /**
     * @param physicalGoal the physicalGoal to set
     */
    public void setPhysicalGoal(PhysicalGoalEntity physicalGoal) {
        this.physicalGoal = physicalGoal;
    }

    /**
     * @return the boolphy
     */
    public boolean isBoolphy() {
        return boolphy;
    }

    /**
     * @param boolphy the boolphy to set
     */
    public void setBoolphy(boolean boolphy) {
        this.boolphy = boolphy;
    }

}
