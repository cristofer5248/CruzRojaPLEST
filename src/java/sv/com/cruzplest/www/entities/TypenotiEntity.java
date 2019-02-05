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
@Table(name = "typenoti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypenotiEntity.findAll", query = "SELECT t FROM TypenotiEntity t")
    , @NamedQuery(name = "TypenotiEntity.findByCodigotypenoti", query = "SELECT t FROM TypenotiEntity t WHERE t.codigotypenoti = :codigotypenoti")
    , @NamedQuery(name = "TypenotiEntity.findByDescripcion", query = "SELECT t FROM TypenotiEntity t WHERE t.descripcion = :descripcion")})
public class TypenotiEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigotypenoti", nullable = false)
    private Integer codigotypenoti;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<NotificationsEntity> notificationsEntityList;

    public TypenotiEntity() {
    }

    public TypenotiEntity(Integer codigotypenoti) {
        this.codigotypenoti = codigotypenoti;
    }

    public TypenotiEntity(Integer codigotypenoti, String descripcion) {
        this.codigotypenoti = codigotypenoti;
        this.descripcion = descripcion;
    }

    public Integer getCodigotypenoti() {
        return codigotypenoti;
    }

    public void setCodigotypenoti(Integer codigotypenoti) {
        this.codigotypenoti = codigotypenoti;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<NotificationsEntity> getNotificationsEntityList() {
        return notificationsEntityList;
    }

    public void setNotificationsEntityList(List<NotificationsEntity> notificationsEntityList) {
        this.notificationsEntityList = notificationsEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigotypenoti != null ? codigotypenoti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypenotiEntity)) {
            return false;
        }
        TypenotiEntity other = (TypenotiEntity) object;
        if ((this.codigotypenoti == null && other.codigotypenoti != null) || (this.codigotypenoti != null && !this.codigotypenoti.equals(other.codigotypenoti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.TypenotiEntity[ codigotypenoti=" + codigotypenoti + " ]";
    }
    
}
