/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.com.cruzplest.www.entities.IndicatorpoEntity;
import sv.com.cruzplest.www.model.IndicatorModel;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@RequestScoped
public class IndicatorBean {

    IndicatorModel model = new IndicatorModel();
    private IndicatorpoEntity indicator;

    public void saveind() {
        try {
            model.save(indicator);
        } catch (Exception e) {
        }
    }

    /**
     * Creates a new instance of IndicatorBean
     */
    public IndicatorBean() {
        indicator = new IndicatorpoEntity();
    }

    public List<IndicatorpoEntity> listAll() {
        try {
            List<IndicatorpoEntity> indi = model.listAll();
            return indi;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public IndicatorpoEntity getIndicator() {
        return indicator;
    }

    public void setIndicator(IndicatorpoEntity indicator) {
        this.indicator = indicator;
    }

}
