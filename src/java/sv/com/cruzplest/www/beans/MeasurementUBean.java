/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.com.cruzplest.www.entities.MeasurementunitsEntity;
import sv.com.cruzplest.www.model.MeasurementUModel;

/**
 *
 * @author cristofer5248
 */
@ManagedBean
@RequestScoped
public class MeasurementUBean {

    public MeasurementunitsEntity measurement;
    private List<MeasurementunitsEntity> measurementlist;
    MeasurementUModel model = new MeasurementUModel();

    /**
     * Creates a new instance of MeasurementUBean
     */
    public MeasurementUBean() {
    }

    public List<MeasurementunitsEntity> listAllSelect() {
        try {
            return model.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

}
