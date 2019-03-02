/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.com.cruzplest.www.entities.PoTableEntity;
import sv.com.cruzplest.www.model.PoaModel;
import java.util.List;

/**
 *
 * @author Christopher
 */
@ManagedBean
@ViewScoped
public class PoaBean {
    
    public PoaModel model = new PoaModel();
    public List<PoTableEntity> listPoaSA;
    public List<PoTableEntity> listPoaSAFiltered;

    /**
     * Creates a new instance of PoaBean
     */
    public PoaBean() {
        listPoStrategicAreas();
    }
    
    public void listPoStrategicAreas() {
        try {
            this.listPoaSA=model.listSAreas(5);
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
    
}
