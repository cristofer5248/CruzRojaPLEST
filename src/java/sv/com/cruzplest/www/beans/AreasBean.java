/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import sv.com.cruzplest.www.entities.StrategicareasEntity;
import sv.com.cruzplest.www.model.AreasModel;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class AreasBean {

    public AreasModel model = new AreasModel();
    private StrategicareasEntity strategicareas;
    private List<StrategicareasEntity> strategicAreas;
    public List<StrategicareasEntity> areasfiltered;
//    private StrategicareasEntity strategicareas = new StrategicareasEntity();
    private boolean areasL = true;

    /**
     * Creates a new instance of AreasBean
     */
    public AreasBean() {
        strategicAreas = listAll();

    }

    public void loadPoa() {
        int cod = Integer.parseInt(JsfUtil.getRequest().getParameter("idSA"));
    }

    public List<StrategicareasEntity> listAll() {
        try {
            return model.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            this.areasL = false;
            JsfUtil.setErrorMessage("error", "No hay datos para mostrar");
            return null;
        }

    }

    /**
     * @return the strategicareas
     */
    public StrategicareasEntity getStrategicareas() {
        return strategicareas;
    }

    /**
     * @param strategicareas the strategicareas to set
     */
    public void setStrategicareas(StrategicareasEntity strategicareas) {
        this.strategicareas = strategicareas;
    }

    /**
     * @return the areasL
     */
    public boolean isAreasL() {
        return areasL;
    }

    /**
     * @param areasL the areasL to set
     */
    public void setAreasL(boolean areasL) {
        this.areasL = areasL;
    }

    /**
     * @return the areasfiltered
     */
    public List<StrategicareasEntity> getAreasfiltered() {
        return areasfiltered;
    }

    /**
     * @param areasfiltered the areasfiltered to set
     */
    public void setAreasfiltered(List<StrategicareasEntity> areasfiltered) {
        this.areasfiltered = areasfiltered;
    }

    /**
     * @return the strategicAreas
     */
    public List<StrategicareasEntity> getStrategicAreas() {
        return strategicAreas;
    }

    /**
     * @param strategicAreas the strategicAreas to set
     */
    public void setStrategicAreas(List<StrategicareasEntity> strategicAreas) {
        this.strategicAreas = strategicAreas;
    }

}
