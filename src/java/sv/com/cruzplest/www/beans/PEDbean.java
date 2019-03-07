/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.model.PEDmodel;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author Christopher
 */
@ManagedBean
@SessionScoped
public class PEDbean {

    private ConsolidatorpoEntity consolidator;
    private List<ConsolidatorpoEntity> consolidatorList;
    private List<ConsolidatorpoEntity> consolidatorListfiltered;
    PEDmodel model = new PEDmodel();
    private int yearselected;
    private int trimestreselected;
    private int metafisica;
    private int indicador;
    private int unidad;
    private int area;
    private int poacod;
    private int yearsize;
    public ArrayList<Integer> forRS;
    public ArrayList<Integer> forRS2;
    

    /**
     * Creates a new instance of PEDbean
     */
    public PEDbean() {
        listAll();
        listForR();
        listForR2();
        if (yearselected == 0) {
        } else if (trimestreselected == 0) {

        } else {

        }

    }

    public String clearbeanPED() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().getSessionMap().remove("#{PEDbean}");
            return "PED?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "PED?faces-redirect=true";
        }
    }

    public void listForR() {
        try {
            forRS = model.forRowSpam();
        } catch (Exception e) {
        }
    }

    public void listForR2() {
        try {
            forRS2 = model.forRowSpam2();
        } catch (Exception e) {
        }
    }

    public void listMeasurementU() {
        try {
            consolidatorList = model.findMeasurementU(getPoacod());
        } catch (Exception e) {
        }
    }

    public void listAll() {
        try {
            consolidatorList = model.listAll();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * @return the consolidator
     */
    public ConsolidatorpoEntity getConsolidator() {
        return consolidator;
    }

    /**
     * @param consolidator the consolidator to set
     */
    public void setConsolidator(ConsolidatorpoEntity consolidator) {
        this.consolidator = consolidator;
    }

    /**
     * @return the yearselected
     */
    public int getYearselected() {
        return yearselected;
    }

    /**
     * @param yearselected the yearselected to set
     */
    public void setYearselected(int yearselected) {
        this.yearselected = yearselected;
    }

    /**
     * @return the poacod
     */
    public int getPoacod() {
        return poacod;
    }

    /**
     * @param poacod the poacod to set
     */
    public void setPoacod(int poacod) {
        this.poacod = poacod;
    }

    /**
     * @return the consolidatorList
     */
    public List<ConsolidatorpoEntity> getConsolidatorList() {
        return consolidatorList;
    }

    /**
     * @param consolidatorList the consolidatorList to set
     */
    public void setConsolidatorList(List<ConsolidatorpoEntity> consolidatorList) {
        this.consolidatorList = consolidatorList;
    }

    /**
     * @return the consolidatorListfiltered
     */
    public List<ConsolidatorpoEntity> getConsolidatorListfiltered() {
        return consolidatorListfiltered;
    }

    /**
     * @param consolidatorListfiltered the consolidatorListfiltered to set
     */
    public void setConsolidatorListfiltered(List<ConsolidatorpoEntity> consolidatorListfiltered) {
        this.consolidatorListfiltered = consolidatorListfiltered;
    }

    /**
     * @return the unidad
     */
    public int getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the trimestreselected
     */
    public int getTrimestreselected() {
        return trimestreselected;
    }

    /**
     * @param trimestreselected the trimestreselected to set
     */
    public void setTrimestreselected(int trimestreselected) {
        this.trimestreselected = trimestreselected;
    }

    /**
     * @return the metafisica
     */
    public int getMetafisica() {
        return metafisica;
    }

    /**
     * @param metafisica the metafisica to set
     */
    public void setMetafisica(int metafisica) {
        this.metafisica = metafisica;
    }

    /**
     * @return the indicador
     */
    public int getIndicador() {
        return indicador;
    }

    /**
     * @param indicador the indicador to set
     */
    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * @return the yearsize
     */
    public int getYearsize() {
        return yearsize;
    }

    /**
     * @param yearsize the yearsize to set
     */
    public void setYearsize(int yearsize) {
        this.yearsize = yearsize;
    }

    /**
     * @return the forRS
     */
    public ArrayList<Integer> getForRS() {
        return forRS;
    }

    /**
     * @param forRS the forRS to set
     */
    public void setForRS(ArrayList<Integer> forRS) {
        this.forRS = forRS;
    }

    /**
     * @return the forRS2
     */
    public ArrayList<Integer> getForRS2() {
        return forRS2;
    }

    /**
     * @param forRS2 the forRS2 to set
     */
    public void setForRS2(ArrayList<Integer> forRS2) {
        this.forRS2 = forRS2;
    }

}
