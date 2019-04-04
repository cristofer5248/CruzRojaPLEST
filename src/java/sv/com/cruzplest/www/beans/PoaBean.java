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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.utils.JsfUtil;

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
    public PoTableEntity poa = new PoTableEntity();
    private int trimestreselected;
    private int metafisica;
    private int indicador;
    private int unidades;
    private int area;
    private int yearselected;
    private int poacod;
    private boolean boolpoa;

    /**
     * Creates a new instance of PoaBean
     */
    public PoaBean() {
        if (yearselected > 0) {
        }
        listAll();
    }

    public List<PoTableEntity> listarAll() {
        try {
            return model.listAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void deletepoa() {
        try {
            if (model.removepoa(poa.getCodigopo())) {
                JsfUtil.setFlashMessage("error", "POA ELIMINADO CORRECTAMENTE");
                FacesContext.getCurrentInstance().getExternalContext().redirect("poa.xhtml");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("poa.xhtml");
            }
        } catch (Exception e) {
            JsfUtil.setFlashMessage("error", "No se pudo eliminar el POA, probablemente este forma parte ya del PED");

        }
    }

    public void boolpoa() {
        try {
            setBoolpoa(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertpoaorupdate() {
        try {
            if (boolpoa == true) {
                if (model.updatepoa(poa)) {
                    JsfUtil.setFlashMessage("exito", "POA actualizado correctamente");
                }
                JsfUtil.setFlashMessage("exito", "POA actualizado correctamente");
            } else {
                if (model.insertpoa(poa)) {
                    JsfUtil.setFlashMessage("exito", "POA insertado correctamente");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("poa.xhtml");
                }
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("poa.xhtml");
        } catch (Exception e) {
            e.printStackTrace();

        }
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

    /**
     * @return the poa
     */
    public PoTableEntity getPoa() {
        return poa;
    }

    /**
     * @param poa the poa to set
     */
    public void setPoa(PoTableEntity poa) {
        this.poa = poa;
    }

    /**
     * @return the boolpoa
     */
    public boolean isBoolpoa() {
        return boolpoa;
    }

    /**
     * @param boolpoa the boolpoa to set
     */
    public void setBoolpoa(boolean boolpoa) {
        this.boolpoa = boolpoa;
    }

}
