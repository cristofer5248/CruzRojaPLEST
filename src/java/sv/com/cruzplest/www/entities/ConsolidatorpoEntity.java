/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "consolidatorpo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidatorpoEntity.findAll", query = "SELECT c FROM ConsolidatorpoEntity c order by c.codigoPO.codigopo, c.rowspan desc")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByCodigocon", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.codigocon = :codigocon")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByTrimestre", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.trimestre = :trimestre")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByYear", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.year = :year")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByMeasurementU", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.codigoPO.unidad.codigomea = :cod")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByPlanificado", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.planificado = :planificado")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByEjecutado", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.ejecutado = :ejecutado")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByComentario", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.comentario = :comentario")})
public class ConsolidatorpoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigocon", nullable = false)
    private Integer codigocon;
    @Basic(optional = false)
    @Column(name = "trimestre", nullable = false)
    private int trimestre;
    @Basic(optional = false)
    @Column(name = "year", nullable = false)
    private int year;
    @Basic(optional = false)
    @Column(name = "planificado", nullable = false)
    private int planificado;
    @Column(name = "ejecutado")
    private Integer ejecutado;
    @Column(name = "comentario", length = 150)
    private String comentario;
    
    private int rowspan;
    private int rowspan2;
    
    @JoinColumn(name = "codigoPO", referencedColumnName = "codigopo", nullable = false)
    @ManyToOne(optional = false)
    private PoTableEntity codigoPO;
    @JoinColumn(name = "physicalgoal", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private PhysicalGoalEntity physicalgoal;

    public ConsolidatorpoEntity() {
    }

    public ConsolidatorpoEntity(Integer codigocon) {
        this.codigocon = codigocon;
    }

    public ConsolidatorpoEntity(Integer codigocon, int trimestre, int year, int planificado) {
        this.codigocon = codigocon;
        this.trimestre = trimestre;
        this.year = year;
        this.planificado = planificado;
    }

    public Integer getCodigocon() {
        return codigocon;
    }

    public void setCodigocon(Integer codigocon) {
        this.codigocon = codigocon;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPlanificado() {
        return planificado;
    }

    public void setPlanificado(int planificado) {
        this.planificado = planificado;
    }

    public Integer getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(Integer ejecutado) {
        this.ejecutado = ejecutado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public PoTableEntity getCodigoPO() {
        return codigoPO;
    }

    public void setCodigoPO(PoTableEntity codigoPO) {
        this.codigoPO = codigoPO;
    }

    public PhysicalGoalEntity getPhysicalgoal() {
        return physicalgoal;
    }

    public void setPhysicalgoal(PhysicalGoalEntity physicalgoal) {
        this.physicalgoal = physicalgoal;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocon != null ? codigocon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsolidatorpoEntity)) {
            return false;
        }
        ConsolidatorpoEntity other = (ConsolidatorpoEntity) object;
        if ((this.codigocon == null && other.codigocon != null) || (this.codigocon != null && !this.codigocon.equals(other.codigocon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.ConsolidatorpoEntity[ codigocon=" + codigocon + " ]";
    }

    /**
     * @return the rowspan
     */
    public int getRowspan() {
        return rowspan;
    }

    /**
     * @param rowspan the rowspan to set
     */
    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    /**
     * @return the rowspan2
     */
    public int getRowspan2() {
        return rowspan2;
    }

    /**
     * @param rowspan2 the rowspan2 to set
     */
    public void setRowspan2(int rowspan2) {
        this.rowspan2 = rowspan2;
    }

}
