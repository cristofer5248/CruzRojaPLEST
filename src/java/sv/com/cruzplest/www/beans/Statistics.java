/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.PieChartModel;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.model.PEDmodel;

/**
 *
 * @author Crls
 */
@ManagedBean
@ViewScoped
public class Statistics {

    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
    private CartesianChartModel combinedModel;
    private CartesianChartModel fillToZero;
    private LineChartModel areaModel;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private DonutChartModel donutModel1;
    private DonutChartModel donutModel2;
    private MeterGaugeChartModel meterGaugeModel1;
    private MeterGaugeChartModel meterGaugeModel2;
    private BubbleChartModel bubbleModel1;
    private BubbleChartModel bubbleModel2;
    private OhlcChartModel ohlcModel;
    private OhlcChartModel ohlcModel2;
    private PieChartModel livePieModel;
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
    private ConsolidatorpoEntity conso;
    private PEDmodel model1;
    List<ConsolidatorpoEntity> list1;
    private int param1 = 2;
    private int limite;

    public Statistics() {        
        createLineModels();
        createAnimatedModels();
    }

    public void changeParameter() {

        createLineModels();

        createAnimatedModels();
    }

    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Line Chart");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(limite);

    }

    private void createLineModels() {
    
    model1  = new PEDmodel();
    list1  = model1.findbypo(param1);
    List list = model1.maxejecutado(param1);
    List list2 = model1.maxplanificado(param1);
    limite  = (Integer) list.get(0);
    int limite2 = (Integer) list2.get(0);
    if (limite< limite2

    
        ) {
            limite = limite2;
    }
    lineModel1  = initLinearModel();

    lineModel1.setTitle (

    "Linear Chart");
    lineModel1.setLegendPosition (
    "e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);

    yAxis.setMin (

    0);
    yAxis.setMax (

    10);

    setLineModel2(initCategoryModel

    ());
    getLineModel2()

    .setTitle("Plan estrategico de desarrollo");
    getLineModel2()

    .setLegendPosition("e");
    getLineModel2()

    .setShowPointLabels(true);
    getLineModel2()
    .getAxes().put(AxisType.X, new CategoryAxis("Año"));
        yAxis  = getLineModel2().getAxis(AxisType.Y);

    yAxis.setLabel (

    "Planificado y Ejecutado");
    yAxis.setMin (

    0);
    yAxis.setMax (limite);

}

private LineChartModel initCategoryModel() {

        LineChartModel model = new LineChartModel();

        ChartSeries planificado = new ChartSeries();
        planificado.setLabel("Planificado");
        list1.forEach((o) -> {
            planificado.set(String.valueOf(o.getYear()), o.getPlanificado());

        });

        ChartSeries ejecutado = new ChartSeries();
        ejecutado.setLabel("Ejecutado");
        list1.forEach((o) -> {
            ejecutado.set(String.valueOf(o.getYear()), o.getEjecutado());

        });

        model.addSeries(planificado);
        model.addSeries(ejecutado);

        return model;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();

        series1.setLabel("Planificado");
        list1.forEach((o) -> {
            series1.set(o.getYear(), o.getPlanificado());

        });

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Ejecutado");
        list1.forEach((o) -> {
            series2.set(o.getYear(), o.getEjecutado());

        });

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    /**
     * @return the animatedModel1
     */
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    /**
     * @param animatedModel1 the animatedModel1 to set
     */
    public void setAnimatedModel1(LineChartModel animatedModel1) {
        this.animatedModel1 = animatedModel1;
    }

    /**
     * @return the animatedModel2
     */
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    /**
     * @param animatedModel2 the animatedModel2 to set
     */
    public void setAnimatedModel2(BarChartModel animatedModel2) {
        this.animatedModel2 = animatedModel2;
    }

    /**
     * @return the lineModel2
     */
    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    /**
     * @param lineModel2 the lineModel2 to set
     */
    public void setLineModel2(LineChartModel lineModel2) {
        this.lineModel2 = lineModel2;
    }

    /**
     * @return the param1
     */
    public int getParam1() {
        return param1;
    }

    /**
     * @param param1 the param1 to set
     */
    public void setParam1(int param1) {
        this.param1 = param1;
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

}
