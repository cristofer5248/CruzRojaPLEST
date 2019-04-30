/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.com.cruzplest.www.entities.IndicatorpoEntity;
import sv.com.cruzplest.www.model.IndicatorModel;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class IndicatorBean {

    IndicatorModel model = new IndicatorModel();
    public IndicatorpoEntity indicator;
    private boolean done1;

    public IndicatorBean() {
        indicator = new IndicatorpoEntity();
    }

    public void saveind() {
        try {
            getIndicator().setTipou(0);
            if (model.save(getIndicator())) {
                setDone1(true);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Creates a new instance of IndicatorBean
     */
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

    public boolean isDone1() {
        return done1;
    }

    public void setDone1(boolean done1) {
        this.done1 = done1;
    }

}
