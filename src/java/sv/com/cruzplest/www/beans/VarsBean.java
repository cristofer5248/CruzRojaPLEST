/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@SessionScoped
public class VarsBean {

    private String year1;
    private String trimestre;
    private Integer poselected;
    private ConsolidatorpoEntity consoOb;
    private int poa;

    /**
     * Creates a new instance of varsBean
     */
    public VarsBean() {
    }

    public String changepoa() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        setPoa(id);
        return "estadisticas";
    }

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    /**
     * @return the poselected
     */
    public Integer getPoselected() {
        return poselected;
    }

    /**
     * @param poselected the poselected to set
     */
    public void setPoselected(Integer poselected) {
        this.poselected = poselected;
    }

    public ConsolidatorpoEntity getConsoOb() {
        return consoOb;
    }

    public void setConsoOb(ConsolidatorpoEntity consoOb) {
        this.consoOb = consoOb;
    }

    /**
     * @return the poa
     */
    public int getPoa() {
        return poa;
    }

    /**
     * @param poa the poa to set
     */
    public void setPoa(int poa) {
        this.poa = poa;
    }

}
