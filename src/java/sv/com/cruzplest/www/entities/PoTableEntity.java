/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RRDESC04
 */
@Entity
@Table(name = "po_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoTableEntity.findAll", query = "SELECT p FROM PoTableEntity p")
    , @NamedQuery(name = "PoTableEntity.findByCodigopo", query = "SELECT p FROM PoTableEntity p WHERE p.codigopo = :codigopo")
    , @NamedQuery(name = "PoTableEntity.findByActividad", query = "SELECT p FROM PoTableEntity p WHERE p.actividad = :actividad")
    , @NamedQuery(name = "PoTableEntity.findByMetaGlobal", query = "SELECT p FROM PoTableEntity p WHERE p.metaGlobal = :metaGlobal")})
public class PoTableEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigopo", nullable = false)
    private Integer codigopo;
    @Basic(optional = false)
    @Column(name = "actividad", nullable = false, length = 80)
    private String actividad;
    @Basic(optional = false)
    @Column(name = "meta_global", nullable = false)
    private int metaGlobal;
    @JoinColumn(name = "indicatores", referencedColumnName = "codigoind", nullable = false)
    @ManyToOne(optional = false)
    private IndicatorpoEntity indicatores;
    @JoinColumn(name = "encargado", referencedColumnName = "codigouser", nullable = false)
    @ManyToOne(optional = false)
    private UsersEntity encargado;
    @JoinColumn(name = "unidad", referencedColumnName = "codigomea", nullable = false)
    @ManyToOne(optional = false)
    private MeasurementunitsEntity unidad;
    @JoinColumn(name = "areaest", referencedColumnName = "codigostr", nullable = false)
    @ManyToOne(optional = false)
    private StrategicareasEntity areaest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPO")
    private List<ConsolidatorpoEntity> consolidatorpoEntityList;

    public PoTableEntity() {
    }

    public PoTableEntity(Integer codigopo) {
        this.codigopo = codigopo;
    }

    public PoTableEntity(Integer codigopo, String actividad, int metaGlobal) {
        this.codigopo = codigopo;
        this.actividad = actividad;
        this.metaGlobal = metaGlobal;
    }

    public Integer getCodigopo() {
        return codigopo;
    }

    public void setCodigopo(Integer codigopo) {
        this.codigopo = codigopo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public int getMetaGlobal() {
        return metaGlobal;
    }

    public void setMetaGlobal(int metaGlobal) {
        this.metaGlobal = metaGlobal;
    }

    public IndicatorpoEntity getIndicatores() {
        return indicatores;
    }

    public void setIndicatores(IndicatorpoEntity indicatores) {
        this.indicatores = indicatores;
    }

    public UsersEntity getEncargado() {
        return encargado;
    }

    public void setEncargado(UsersEntity encargado) {
        this.encargado = encargado;
    }

    public MeasurementunitsEntity getUnidad() {
        return unidad;
    }

    public void setUnidad(MeasurementunitsEntity unidad) {
        this.unidad = unidad;
    }

    public StrategicareasEntity getAreaest() {
        return areaest;
    }

    public void setAreaest(StrategicareasEntity areaest) {
        this.areaest = areaest;
    }

    @XmlTransient
    public List<ConsolidatorpoEntity> getConsolidatorpoEntityList() {
        return consolidatorpoEntityList;
    }

    public void setConsolidatorpoEntityList(List<ConsolidatorpoEntity> consolidatorpoEntityList) {
        this.consolidatorpoEntityList = consolidatorpoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopo != null ? codigopo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoTableEntity)) {
            return false;
        }
        PoTableEntity other = (PoTableEntity) object;
        if ((this.codigopo == null && other.codigopo != null) || (this.codigopo != null && !this.codigopo.equals(other.codigopo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.PoTableEntity[ codigopo=" + codigopo + " ]";
    }
    
}
