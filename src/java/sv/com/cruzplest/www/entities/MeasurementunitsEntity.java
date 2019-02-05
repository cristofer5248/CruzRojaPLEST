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
@Table(name = "measurementunits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasurementunitsEntity.findAll", query = "SELECT m FROM MeasurementunitsEntity m")
    , @NamedQuery(name = "MeasurementunitsEntity.findByCodigomea", query = "SELECT m FROM MeasurementunitsEntity m WHERE m.codigomea = :codigomea")
    , @NamedQuery(name = "MeasurementunitsEntity.findByNombre", query = "SELECT m FROM MeasurementunitsEntity m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MeasurementunitsEntity.findByEspecificaciones", query = "SELECT m FROM MeasurementunitsEntity m WHERE m.especificaciones = :especificaciones")})
public class MeasurementunitsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigomea", nullable = false)
    private Integer codigomea;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Column(name = "especificaciones", length = 100)
    private String especificaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private List<PoTableEntity> poTableEntityList;

    public MeasurementunitsEntity() {
    }

    public MeasurementunitsEntity(Integer codigomea) {
        this.codigomea = codigomea;
    }

    public MeasurementunitsEntity(Integer codigomea, String nombre) {
        this.codigomea = codigomea;
        this.nombre = nombre;
    }

    public Integer getCodigomea() {
        return codigomea;
    }

    public void setCodigomea(Integer codigomea) {
        this.codigomea = codigomea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
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
        hash += (codigomea != null ? codigomea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeasurementunitsEntity)) {
            return false;
        }
        MeasurementunitsEntity other = (MeasurementunitsEntity) object;
        if ((this.codigomea == null && other.codigomea != null) || (this.codigomea != null && !this.codigomea.equals(other.codigomea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.MeasurementunitsEntity[ codigomea=" + codigomea + " ]";
    }
    
}
