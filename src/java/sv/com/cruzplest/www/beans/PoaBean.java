/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import javax.faces.bean.ManagedBean;
import sv.com.cruzplest.www.entities.PoTableEntity;
import sv.com.cruzplest.www.model.PoaModel;
import java.util.List;
import javax.faces.bean.SessionScoped;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author Christopher
 */
@ManagedBean
@SessionScoped
public class PoaBean {

    public PoaModel model = new PoaModel();
    public List<PoTableEntity> listPoaSA;
    public List<PoTableEntity> listPoaSAFiltered;
    private int yearselected;
    private int poacod;

    /**
     * Creates a new instance of PoaBean
     */
    public PoaBean() {
        if (yearselected > 0) {
        }
        listAll();
    }

    public void insertPoacod() {
        try {
            int cod = Integer.parseInt(JsfUtil.getRequest().getParameter("codigo"));
            poacod = cod;
            System.out.print("ENTREA insertPoacod");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error get parameter insertPoacod");
        }

    }

    public void listAll() {
        try {
            listPoaSA = model.listAll();
        } catch (Exception e) {
        }
    }

    public void listPoStrategicAreas() {
        try {
            this.listPoaSA = model.listSAreas(5);
//            return 1;
        } catch (Exception e) {
            e.printStackTrace();
//            return 0;
        }
    }

    /**
     * @return the listPoaSA
     */
    public List<PoTableEntity> getListPoaSA() {
        return listPoaSA;
    }

    /**
     * @param listPoaSA the listPoaSA to set
     */
    public void setListPoaSA(List<PoTableEntity> listPoaSA) {
        this.listPoaSA = listPoaSA;
    }

    /**
     * @return the listPoaSAFiltered
     */
    public List<PoTableEntity> getListPoaSAFiltered() {
        return listPoaSAFiltered;
    }

    /**
     * @param listPoaSAFiltered the listPoaSAFiltered to set
     */
    public void setListPoaSAFiltered(List<PoTableEntity> listPoaSAFiltered) {
        this.listPoaSAFiltered = listPoaSAFiltered;
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

}
