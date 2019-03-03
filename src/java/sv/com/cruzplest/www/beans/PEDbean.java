/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.application.resource.barcode.EAN13Generator;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.model.PEDmodel;

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
    private int poacod;

    /**
     * Creates a new instance of PEDbean
     */
    public PEDbean() {
        listAll();
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

}
