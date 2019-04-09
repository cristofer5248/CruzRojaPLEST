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
import sv.com.cruzplest.www.entities.MeasurementunitsEntity;
import sv.com.cruzplest.www.model.MeasurementUModel;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author cristofer5248
 */
@ManagedBean
@ViewScoped
public class MeasurementUBean {

    private MeasurementunitsEntity measurement;
    private List<MeasurementunitsEntity> measurementlist;
    private List<MeasurementunitsEntity> measurementlistselected;
    MeasurementUModel model = new MeasurementUModel();
    private boolean boolmea;

    /**
     * Creates a new instance of MeasurementUBean
     */
    public MeasurementUBean() {
        measurement = new MeasurementunitsEntity();
    }

    public List<MeasurementunitsEntity> listAllSelect() {
        try {
            List<MeasurementunitsEntity> mea = model.listAll();
            return mea;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletemea() throws IOException {
        try {
            if (model.deletemea(measurement.getCodigomea())) {
                JsfUtil.setFlashMessage("error", "Elimando correctamente");
            } else {
                JsfUtil.setFlashMessage("error", "No se pudo eliminar, la unidad podria estar ya siendo usada");
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("unidades.xhtml");
        } catch (Exception e) {
            JsfUtil.setFlashMessage("error", "No se pudo eliminar, la unidad podria estar ya siendo usada");
            FacesContext.getCurrentInstance().getExternalContext().redirect("unidades.xhtml");
        }
    }

    public void addmeasurementorupdate() throws IOException {
        try {
            if (!boolmea) {
                model.addmea(measurement);
                JsfUtil.setFlashMessage("add", "Unidad de medida " + measurement.getNombre() + " agregado satisfactoriamente!");
                FacesContext.getCurrentInstance().getExternalContext().redirect("unidades.xhtml");
            } else {
                model.updatemea(measurement);
                JsfUtil.setFlashMessage("exito", "Unidad de medida actualizado satisfactoriamente");
                FacesContext.getCurrentInstance().getExternalContext().redirect("unidades.xhtml");
            }

        } catch (Exception e) {
            JsfUtil.setFlashMessage("error", "Error interno, o ya existe una unidad de medida con el mismo nombre");

        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("unidades.xhtml");
    }

    public void changeBool() {
        setBoolmea(true);
    }

    /**
     * @return the measurementlist
     */
    public List<MeasurementunitsEntity> getMeasurementlist() {
        return measurementlist;
    }

    /**
     * @param measurementlist the measurementlist to set
     */
    public void setMeasurementlist(List<MeasurementunitsEntity> measurementlist) {
        this.measurementlist = measurementlist;
    }

    /**
     * @return the measurement
     */
    public MeasurementunitsEntity getMeasurement() {
        return measurement;
    }

    /**
     * @param measurement the measurement to set
     */
    public void setMeasurement(MeasurementunitsEntity measurement) {
        this.measurement = measurement;
    }

    /**
     * @return the boolmea
     */
    public boolean isBoolmea() {
        return boolmea;
    }

    /**
     * @param boolmea the boolmea to set
     */
    public void setBoolmea(boolean boolmea) {
        this.boolmea = boolmea;
    }

    /**
     * @return the measurementlistselected
     */
    public List<MeasurementunitsEntity> getMeasurementlistselected() {
        return measurementlistselected;
    }

    /**
     * @param measurementlistselected the measurementlistselected to set
     */
    public void setMeasurementlistselected(List<MeasurementunitsEntity> measurementlistselected) {
        this.measurementlistselected = measurementlistselected;
    }

}
