/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Christopher
 */
@ManagedBean
@RequestScoped
public class CleanMaster {

    /**
     * Creates a new instance of CleanMaster
     */
    public CleanMaster() {
    }

    public String cleanPoBean() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PoaBean", null);
        return "poa";
    }

}
