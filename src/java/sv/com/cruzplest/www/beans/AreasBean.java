/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import sv.com.cruzplest.www.entities.StrategicareasEntity;
import sv.com.cruzplest.www.model.AreasModel;
import sv.com.cruzplest.www.utils.JsfUtil;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.diagram.connector.StraightConnector;

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
    private int yearselected;
//    private StrategicareasEntity strategicareas = new StrategicareasEntity();
    private boolean areasL = true;

    /**
     * Creates a new instance of AreasBean
     */
    public AreasBean() {
        strategicareas = new StrategicareasEntity();
        strategicAreas = listAll();

    }

    public void handleClose(CloseEvent event) {
        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
    }

    public void handleMove(MoveEvent event) {
        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());

    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String goesToped() {        
        return "PED?faces-redirect=true";
    }

    public String goesTopoa() {
        System.out.print("Qye pasoooooooo");
        this.yearselected = 2000;
        return "poa";
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

    public String newArea() {
        try {
            if (model.insertAreas(strategicareas)) {
                JsfUtil.setFlashMessage("add", "Area Estrategica insertada satisfactoriamente!");
            } else {
                model.updateArea(strategicareas);
                JsfUtil.setFlashMessage("update", "Area Estrategica actualizada satisfactoriamente!");
            }
            return "area";
        } catch (Exception e) {
        }
        return "area";
    }

    public void openLevel1() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("level1", options, null);
    }

    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
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

    /**
     * @return the yearselected
     */
    public int getYearselected() {
        return yearselected;
    }

    /**
     * @param yearselected the year to set
     */
    public void setYearselected(int yearselected) {
        this.yearselected = yearselected;
    }

}
