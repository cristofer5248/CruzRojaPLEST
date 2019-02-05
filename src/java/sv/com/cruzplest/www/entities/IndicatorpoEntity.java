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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "indicatorpo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicatorpoEntity.findAll", query = "SELECT i FROM IndicatorpoEntity i")
    , @NamedQuery(name = "IndicatorpoEntity.findByCodigoind", query = "SELECT i FROM IndicatorpoEntity i WHERE i.codigoind = :codigoind")
    , @NamedQuery(name = "IndicatorpoEntity.findByDetalle", query = "SELECT i FROM IndicatorpoEntity i WHERE i.detalle = :detalle")
    , @NamedQuery(name = "IndicatorpoEntity.findByTipou", query = "SELECT i FROM IndicatorpoEntity i WHERE i.tipou = :tipou")})
public class IndicatorpoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoind", nullable = false)
    private Integer codigoind;
    @Basic(optional = false)
    @Column(name = "detalle", nullable = false, length = 150)
    private String detalle;
    @Basic(optional = false)
    @Column(name = "tipou", nullable = false)
    private int tipou;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicatores")
    private List<PoTableEntity> poTableEntityList;

    public IndicatorpoEntity() {
    }

    public IndicatorpoEntity(Integer codigoind) {
        this.codigoind = codigoind;
    }

    public IndicatorpoEntity(Integer codigoind, String detalle, int tipou) {
        this.codigoind = codigoind;
        this.detalle = detalle;
        this.tipou = tipou;
    }

    public Integer getCodigoind() {
        return codigoind;
    }

    public void setCodigoind(Integer codigoind) {
        this.codigoind = codigoind;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getTipou() {
        return tipou;
    }

    public void setTipou(int tipou) {
        this.tipou = tipou;
    }

    @XmlTransient
    public List<PoTableEntity> getPoTableEntityList() {
        return poTableEntityList;
    }

    public void setPoTableEntityList(List<PoTableEntity> poTableEntityList) {
        this.poTableEntityList = poTableEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoind != null ? codigoind.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicatorpoEntity)) {
            return false;
        }
        IndicatorpoEntity other = (IndicatorpoEntity) object;
        if ((this.codigoind == null && other.codigoind != null) || (this.codigoind != null && !this.codigoind.equals(other.codigoind))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.IndicatorpoEntity[ codigoind=" + codigoind + " ]";
    }
    
}
