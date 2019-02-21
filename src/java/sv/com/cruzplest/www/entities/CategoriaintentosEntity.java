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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categoriaintentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaintentosEntity.findAll", query = "SELECT c FROM CategoriaintentosEntity c")
    , @NamedQuery(name = "CategoriaintentosEntity.findByCodintentos", query = "SELECT c FROM CategoriaintentosEntity c WHERE c.codintentos = :codintentos")
    , @NamedQuery(name = "CategoriaintentosEntity.findByNombre", query = "SELECT c FROM CategoriaintentosEntity c WHERE c.nombre = :nombre")})
public class CategoriaintentosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codintentos", nullable = false)
    private Integer codintentos;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<IntentosEntity> intentosEntityList;

    public CategoriaintentosEntity() {
    }

    public CategoriaintentosEntity(Integer codintentos) {
        this.codintentos = codintentos;
    }

    public CategoriaintentosEntity(Integer codintentos, String nombre) {
        this.codintentos = codintentos;
        this.nombre = nombre;
    }

    public Integer getCodintentos() {
        return codintentos;
    }

    public void setCodintentos(Integer codintentos) {
        this.codintentos = codintentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<IntentosEntity> getIntentosEntityList() {
        return intentosEntityList;
    }

    public void setIntentosEntityList(List<IntentosEntity> intentosEntityList) {
        this.intentosEntityList = intentosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codintentos != null ? codintentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaintentosEntity)) {
            return false;
        }
        CategoriaintentosEntity other = (CategoriaintentosEntity) object;
        if ((this.codintentos == null && other.codintentos != null) || (this.codintentos != null && !this.codintentos.equals(other.codintentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.CategoriaintentosEntity[ codintentos=" + codintentos + " ]";
    }
    
}
