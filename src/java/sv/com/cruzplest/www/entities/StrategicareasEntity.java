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
@Table(name = "strategicareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StrategicareasEntity.findAll", query = "SELECT s FROM StrategicareasEntity s")
    , @NamedQuery(name = "StrategicareasEntity.findByCodigostr", query = "SELECT s FROM StrategicareasEntity s WHERE s.codigostr = :codigostr")
    , @NamedQuery(name = "StrategicareasEntity.findByNombre", query = "SELECT s FROM StrategicareasEntity s WHERE s.nombre = :nombre")})
public class StrategicareasEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigostr", nullable = false)
    private Integer codigostr;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaest")
    private List<PoTableEntity> poTableEntityList;

    public StrategicareasEntity() {
    }

    public StrategicareasEntity(Integer codigostr) {
        this.codigostr = codigostr;
    }

    public StrategicareasEntity(Integer codigostr, String nombre) {
        this.codigostr = codigostr;
        this.nombre = nombre;
    }

    public Integer getCodigostr() {
        return codigostr;
    }

    public void setCodigostr(Integer codigostr) {
        this.codigostr = codigostr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (codigostr != null ? codigostr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrategicareasEntity)) {
            return false;
        }
        StrategicareasEntity other = (StrategicareasEntity) object;
        if ((this.codigostr == null && other.codigostr != null) || (this.codigostr != null && !this.codigostr.equals(other.codigostr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.StrategicareasEntity[ codigostr=" + codigostr + " ]";
    }
    
}
