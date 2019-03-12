/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.utils;

/**
 *
 * @author RRDESC04
 */
public class TotalesOb {

    private int codigopo;
    private int planificado;
    private int ejecutado;
    private double total;

    public TotalesOb(int codigopo, int planificado, int ejecutado, double total) {
        this.codigopo = codigopo;
        this.planificado = planificado;
        this.ejecutado = ejecutado;
        this.total = total;
    }

    public int getCodigopo() {
        return codigopo;
    }

    public void setCodigopo(int codigopo) {
        this.codigopo = codigopo;
    }

    public int getPlanificado() {
        return planificado;
    }

    public void setPlanificado(int planificado) {
        this.planificado = planificado;
    }

    public int getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(int ejecutado) {
        this.ejecutado = ejecutado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
