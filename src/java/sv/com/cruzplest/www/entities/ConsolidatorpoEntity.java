/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRDESC04
 */
@Entity
@Table(name = "consolidatorpo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidatorpoEntity.findAll", query = "SELECT c FROM ConsolidatorpoEntity c")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByCodigocon", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.codigocon = :codigocon")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByTrimestre", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.trimestre = :trimestre")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByYear", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.year = :year")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByPlanificado", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.planificado = :planificado")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByEjecutado", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.ejecutado = :ejecutado")
    , @NamedQuery(name = "ConsolidatorpoEntity.findByComentario", query = "SELECT c FROM ConsolidatorpoEntity c WHERE c.comentario = :comentario")})
public class ConsolidatorpoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "consolidatorpoEntity")
    private PhysicalGoalEntity physicalGoalEntity;
    @JoinColumn(name = "codigoPO", referencedColumnName = "codigopo", nullable = false)
    @ManyToOne(optional = false)
    private PoTableEntity codigoPO;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "consolidatorpoEntity")
    private ResultsEntity resultsEntity;

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

    public PhysicalGoalEntity getPhysicalGoalEntity() {
        return physicalGoalEntity;
    }

    public void setPhysicalGoalEntity(PhysicalGoalEntity physicalGoalEntity) {
        this.physicalGoalEntity = physicalGoalEntity;
    }

    public PoTableEntity getCodigoPO() {
        return codigoPO;
    }

    public void setCodigoPO(PoTableEntity codigoPO) {
        this.codigoPO = codigoPO;
    }

    public ResultsEntity getResultsEntity() {
        return resultsEntity;
    }

    public void setResultsEntity(ResultsEntity resultsEntity) {
        this.resultsEntity = resultsEntity;
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
    
}
