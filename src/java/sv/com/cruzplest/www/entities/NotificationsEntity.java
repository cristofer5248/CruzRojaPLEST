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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRDESC04
 */
@Entity
@Table(name = "notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationsEntity.findAll", query = "SELECT n FROM NotificationsEntity n")
    , @NamedQuery(name = "NotificationsEntity.findByCodigonoti", query = "SELECT n FROM NotificationsEntity n WHERE n.codigonoti = :codigonoti")
    , @NamedQuery(name = "NotificationsEntity.findByDescripcion", query = "SELECT n FROM NotificationsEntity n WHERE n.descripcion = :descripcion")})
public class NotificationsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigonoti", nullable = false)
    private Integer codigonoti;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;
    @JoinColumn(name = "tipo", referencedColumnName = "codigotypenoti", nullable = false)
    @ManyToOne(optional = false)
    private TypenotiEntity tipo;
    @JoinColumn(name = "usuario", referencedColumnName = "codigouser", nullable = false)
    @ManyToOne(optional = false)
    private UsersEntity usuario;

    public NotificationsEntity() {
    }

    public NotificationsEntity(Integer codigonoti) {
        this.codigonoti = codigonoti;
    }

    public NotificationsEntity(Integer codigonoti, String descripcion) {
        this.codigonoti = codigonoti;
        this.descripcion = descripcion;
    }

    public Integer getCodigonoti() {
        return codigonoti;
    }

    public void setCodigonoti(Integer codigonoti) {
        this.codigonoti = codigonoti;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TypenotiEntity getTipo() {
        return tipo;
    }

    public void setTipo(TypenotiEntity tipo) {
        this.tipo = tipo;
    }

    public UsersEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsersEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigonoti != null ? codigonoti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationsEntity)) {
            return false;
        }
        NotificationsEntity other = (NotificationsEntity) object;
        if ((this.codigonoti == null && other.codigonoti != null) || (this.codigonoti != null && !this.codigonoti.equals(other.codigonoti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.NotificationsEntity[ codigonoti=" + codigonoti + " ]";
    }
    
}
