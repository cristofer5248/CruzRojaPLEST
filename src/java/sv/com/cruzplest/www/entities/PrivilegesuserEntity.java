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
 * @author Christopher
 */
@Entity
@Table(name = "privilegesuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivilegesuserEntity.findAll", query = "SELECT p FROM PrivilegesuserEntity p")
    , @NamedQuery(name = "PrivilegesuserEntity.findByCodigopri", query = "SELECT p FROM PrivilegesuserEntity p WHERE p.codigopri = :codigopri")
    , @NamedQuery(name = "PrivilegesuserEntity.findByAccesoA", query = "SELECT p FROM PrivilegesuserEntity p WHERE p.accesoA = :accesoA")})
public class PrivilegesuserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigopri", nullable = false)
    private Integer codigopri;
    @Basic(optional = false)
    @Column(name = "accesoA", nullable = false)
    private int accesoA;
    @JoinColumn(name = "user", referencedColumnName = "codigouser", nullable = false)
    @ManyToOne(optional = false)
    private UsersEntity user;

    public PrivilegesuserEntity() {
    }

    public PrivilegesuserEntity(Integer codigopri) {
        this.codigopri = codigopri;
    }

    public PrivilegesuserEntity(Integer codigopri, int accesoA) {
        this.codigopri = codigopri;
        this.accesoA = accesoA;
    }

    public Integer getCodigopri() {
        return codigopri;
    }

    public void setCodigopri(Integer codigopri) {
        this.codigopri = codigopri;
    }

    public int getAccesoA() {
        return accesoA;
    }

    public void setAccesoA(int accesoA) {
        this.accesoA = accesoA;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopri != null ? codigopri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrivilegesuserEntity)) {
            return false;
        }
        PrivilegesuserEntity other = (PrivilegesuserEntity) object;
        if ((this.codigopri == null && other.codigopri != null) || (this.codigopri != null && !this.codigopri.equals(other.codigopri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.PrivilegesuserEntity[ codigopri=" + codigopri + " ]";
    }
    
}
