/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.entities.ConsolidatorpoEntity;
import sv.com.cruzplest.www.model.PEDmodel;
import sv.com.cruzplest.www.utils.JsfUtil;
import sv.com.cruzplest.www.utils.TotalesOb;

/**
 *
 * @author Christopher
 */
@ManagedBean
@ViewScoped
public class PEDbean {

    private ConsolidatorpoEntity consolidator = new ConsolidatorpoEntity();
    private List<ConsolidatorpoEntity> consolidatorList;
    private List<ConsolidatorpoEntity> consolidatorListfiltered;
    private ArrayList<TotalesOb> totales;
    PEDmodel model = new PEDmodel();
    private int yearselected;
    private int trimestreselected;
    private int metafisica;
    private int indicador;
    private int unidad;
    private int area;
    private int poacod;
    private int yearsize;
    private int countVa = 0;
    private int countStop = 0;
    ConsolidatorpoEntity consoOb;
    private String comentario1;
    private int old_codigopo;
    private boolean boolped;
    private boolean boolthereisPOA;

    /**
     * Creates a new instance of PEDbean
     */
    public PEDbean() {
        consolidator = new ConsolidatorpoEntity();
        listTotal();
        listAll();
        if (yearselected == 0) {
        } else if (trimestreselected == 0) {

        } else {

        }
    }

    public void updateadmin() throws IOException {
        try {
            if (boolped) {
                model.updatePED(consolidator);
                JsfUtil.setFlashMessage("update", "Actualizado sin problemas!");
            } else {
                model.saveped(consolidator);
                JsfUtil.setFlashMessage("add", "Ingresado correctamente!");
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("PED.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().getExternalContext().redirect("PED.xhtml");
        }

    }

    public String versta() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Statistics st = context.getApplication().evaluateExpressionGet(context, "#{codpo}", Statistics.class);
            st.setParam1(this.consolidator.getCodigoPO().getCodigopo());
        } catch (Exception e) {
        }
        return "estadisticas?faces-redirect=true&cod=" + consolidator.getCodigoPO().getCodigopo() + "";
//        return "estadisticas?faces-redirect=true";
//        return "estadisticas?faces-redirect=true&includeViewParams=" + consolidator.getCodigoPO().getCodigopo() + "";
    }

    public void boolped() {
        try {
            setBoolped(true);
            System.out.print("1-codigoooo viejo " + getOld_codigopo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sumarrowspan(int consocod) {
        try {
            ConsolidatorpoEntity consolidator1 = new ConsolidatorpoEntity();
            consolidator1 = model.findbyIdPED(buscarRowspan(consocod));
            int contador = consolidator1.getRowspan2();
            contador = contador + 1;
            consolidator1.setRowspan2(contador);
            model.updatePED(consolidator1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int buscarRowspan(int cod1) {
        try {
            List list1 = model.findRowspanHigher(cod1);
            return Integer.parseInt(list1.get(0).toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean restarrowspan(int consocod) {
        try {
            ConsolidatorpoEntity consolidator1 = new ConsolidatorpoEntity();
            consolidator1 = model.findbyIdPED(buscarRowspan(consocod));
            int contador = consolidator1.getRowspan2();
            contador = contador - 1;
            consolidator1.setRowspan2(contador);
            model.updatePED(consolidator1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void changepo() {
        try {
            System.out.print("HELLO MY KITTY");
        } catch (Exception e) {
        }
    }

    public boolean findyear(int year1, int poa, int ped) {
        try {
            if (model.findyear(year1, poa, ped)) {

                return true;
            } else {
                JsfUtil.setFlashMessage("error", "Ya existe una actividad con ese mismo año");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ifthereisPO() {
        try {
            if (model.findifpo(consolidator.getCodigoPO().getCodigopo())) {
                setBoolthereisPOA(true);
                return true;
            } else {
                setBoolthereisPOA(false);
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    }

    public boolean verificMotherpoa(Integer poaold, Integer poanew) {
        if (poaold.equals(poanew)) {
            return true;
        }
        JsfUtil.setFlashMessage("error", "No puedes cambiar la actividad clave, este es el POA principal dentro del PED.");
        return false;
    }

    public void updateOrnew() throws IOException {
        int codigoold = 0;
        int codigonew = 0;

        try {

            if (boolped == true) {
                codigonew = consolidator.getCodigoPO().getCodigopo();
                ConsolidatorpoEntity datosold = new ConsolidatorpoEntity();
                datosold = model.findbyIdPED(consolidator.getCodigocon());
                codigoold = datosold.getCodigoPO().getCodigopo();
//                setOld_codigopo(datosold.getCodigoPO().getCodigopo());
                System.out.print("codigoooo viejo(2) " + getOld_codigopo());
                if (findyear(consolidator.getYear(), consolidator.getCodigoPO().getCodigopo(), consolidator.getCodigocon()) && verificMotherpoa(datosold.getCodigoPO().getCodigopo(), consolidator.getCodigoPO().getCodigopo())) {
                    if (model.updatePED(consolidator)) {
                        if (codigonew != codigoold) {
                            sumarrowspan(codigonew);
                            restarrowspan(codigoold);
                        }
                        JsfUtil.setFlashMessage("update", "PED actualizado correctamente");

                    }
                }

            } else {
//aqui verificamos si NO HAY la activiad clave registrada para empezar una
//                if (ifthereisPO(consolidator.getCodigoPO().getCodigopo())) {
//                    consolidator.setRowspan(1);
//                    consolidator.setRowspan2(1);
//                }
                if (findyear(consolidator.getYear(), consolidator.getCodigoPO().getCodigopo(), 0)) {
                    if (model.checkPoainped(consolidator.getCodigoPO().getCodigopo())) {
                        consolidator.setRowspan(1);
                        consolidator.setRowspan2(1);
                        model.saveped(consolidator);
                        JsfUtil.setFlashMessage("exito", "Insertado correctamente");
                        JsfUtil.setFlashMessage("important", "Nuevo registro madre en el PED");
                    } else {
                        model.saveped(consolidator);
                        sumarrowspan(consolidator.getCodigoPO().getCodigopo());
                    }
                }

            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("PED.xhtml");
        } catch (Exception e) {
            JsfUtil.setErrorMessage("error", "Error al actualizar PED");
            FacesContext.getCurrentInstance().getExternalContext().redirect("PED.xhtml");
            e.printStackTrace();

        }

    }

    public String deleteped() {
        try {
            if (model.delete1(consolidator.getCodigocon())) {
                JsfUtil.setFlashMessage("error", "Eliminado correctamente");
                restarrowspan(consolidator.getCodigoPO().getCodigopo());
            }

        } catch (Exception e) {
        }
        return "PED";
    }

    public void reboot1() {
        System.err.print("Evento ajax iniciado...");
        setCountVa(0);
        setCountStop(0);
        listTotal();

    }

    public void count1() {
        countVa = countVa + 1;
        if (countVa == countStop) {
            countVa = countVa - 1;
        }
    }

    public String ejecutado1() {

        String va1;
        va1 = String.valueOf(totales.get(countVa).getEjecutado());

        return va1;
    }

    public String planificado1() {

        String va1;
        va1 = String.valueOf(totales.get(countVa).getPlanificado());

        return va1;
    }

    public String totalCon1() {

        String va1;
        va1 = String.valueOf(String.format("%.2f", totales.get(countVa).getTotal()));
        count1();
        return va1;
    }

    public String clearbeanPED() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().getSessionMap().remove("#{PEDbean}");
            return "PED?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "PED?faces-redirect=true";
        }
    }

    public void listTotal() {
        setCountVa(0);
        try {
            totales = new ArrayList<TotalesOb>();
            List<Object[]> totales1 = model.listotal();
            this.countStop = totales1.size();
            for (Object[] ob : totales1) {
                TotalesOb tot = new TotalesOb(Integer.parseInt(ob[0].toString()), Integer.parseInt(ob[1].toString()), Integer.parseInt(ob[2].toString()), Double.parseDouble(ob[3].toString()));
                totales.add(tot);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Hee! Hee!");
        }
    }

    public void listMeasurementU() {
        try {
            consolidatorList = model.findMeasurementU(getPoacod());
        } catch (Exception e) {
        }
    }

    public List<ConsolidatorpoEntity> listAll() {

        try {
            return model.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object[]> listtotal() {
        try {
            return model.listotal();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    /**
     * @return the consolidator
     */
    public ConsolidatorpoEntity getConsolidator() {
        return consolidator;
    }

    /**
     * @param consolidator the consolidator to set
     */
    public void setConsolidator(ConsolidatorpoEntity consolidator) {
        this.consolidator = consolidator;
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
     * @return the consolidatorList
     */
    public List<ConsolidatorpoEntity> getConsolidatorList() {
        return consolidatorList;
    }

    /**
     * @param consolidatorList the consolidatorList to set
     */
    public void setConsolidatorList(List<ConsolidatorpoEntity> consolidatorList) {
        this.consolidatorList = consolidatorList;
    }

    /**
     * @return the consolidatorListfiltered
     */
    public List<ConsolidatorpoEntity> getConsolidatorListfiltered() {
        return consolidatorListfiltered;
    }

    /**
     * @param consolidatorListfiltered the consolidatorListfiltered to set
     */
    public void setConsolidatorListfiltered(List<ConsolidatorpoEntity> consolidatorListfiltered) {
        this.consolidatorListfiltered = consolidatorListfiltered;
    }

    /**
     * @return the unidad
     */
    public int getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the trimestreselected
     */
    public int getTrimestreselected() {
        return trimestreselected;
    }

    /**
     * @param trimestreselected the trimestreselected to set
     */
    public void setTrimestreselected(int trimestreselected) {
        this.trimestreselected = trimestreselected;
    }

    /**
     * @return the metafisica
     */
    public int getMetafisica() {
        return metafisica;
    }

    /**
     * @param metafisica the metafisica to set
     */
    public void setMetafisica(int metafisica) {
        this.metafisica = metafisica;
    }

    /**
     * @return the indicador
     */
    public int getIndicador() {
        return indicador;
    }

    /**
     * @param indicador the indicador to set
     */
    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * @return the yearsize
     */
    public int getYearsize() {
        return yearsize;
    }

    /**
     * @param yearsize the yearsize to set
     */
    public void setYearsize(int yearsize) {
        this.yearsize = yearsize;
    }

    /**
     * @return the totales
     */
    public ArrayList<TotalesOb> getTotales() {
        return totales;
    }

    /**
     * @param totales the totales to set
     */
    public void setTotales(ArrayList<TotalesOb> totales) {
        this.totales = totales;
    }

    /**
     * @return the countVa
     */
    public int getCountVa() {
        return countVa;
    }

    /**
     * @param countVa the countVa to set
     */
    public void setCountVa(int countVa) {
        this.countVa = countVa;
    }

    /**
     * @return the countStop
     */
    public int getCountStop() {
        return countStop;
    }

    /**
     * @param countStop the countStop to set
     */
    public void setCountStop(int countStop) {
        this.countStop = countStop;
    }

    /**
     * @return the forRS
     */
    public ConsolidatorpoEntity getConsoOb() {
        return consoOb;
    }

    public void setConsoOb(ConsolidatorpoEntity consoOb) {
        this.consoOb = consoOb;
    }

    /**
     * @return the comentario1
     */
    public String getComentario1() {
        return comentario1;
    }

    /**
     * @param comentario1 the comentario1 to set
     */
    public void setComentario1(String comentario1) {
        this.comentario1 = comentario1;
    }

    /**
     * @return the old_codigopo
     */
    public int getOld_codigopo() {
        return old_codigopo;
    }

    /**
     * @param old_codigopo the old_codigopo to set
     */
    public void setOld_codigopo(int old_codigopo) {
        this.old_codigopo = old_codigopo;
    }

    /**
     * @return the boolpo
     */
    public boolean isBoolped() {
        return boolped;
    }

    /**
     *
     */
    public void setBoolped(boolean boolped) {
        this.boolped = boolped;
    }

    /**
     * @return the boolthereisPOA
     */
    public boolean isBoolthereisPOA() {
        return boolthereisPOA;
    }

    /**
     * @param boolthereisPOA the boolthereisPOA to set
     */
    public void setBoolthereisPOA(boolean boolthereisPOA) {
        this.boolthereisPOA = boolthereisPOA;
    }

}
