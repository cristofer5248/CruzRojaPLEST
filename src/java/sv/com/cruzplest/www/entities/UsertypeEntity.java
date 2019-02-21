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
 * @author RRDESC04
 */
@Entity
@Table(name = "usertype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsertypeEntity.findAll", query = "SELECT u FROM UsertypeEntity u")
    , @NamedQuery(name = "UsertypeEntity.findByCodigousertype", query = "SELECT u FROM UsertypeEntity u WHERE u.codigousertype = :codigousertype")
    , @NamedQuery(name = "UsertypeEntity.findByTipo", query = "SELECT u FROM UsertypeEntity u WHERE u.tipo = :tipo")})
public class UsertypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigousertype", nullable = false)
    private Integer codigousertype;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 15)
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipou")
    private List<UsersEntity> usersEntityList;

    public UsertypeEntity() {
    }

    public UsertypeEntity(Integer codigousertype) {
        this.codigousertype = codigousertype;
    }

    public UsertypeEntity(Integer codigousertype, String tipo) {
        this.codigousertype = codigousertype;
        this.tipo = tipo;
    }

    public Integer getCodigousertype() {
        return codigousertype;
    }

    public void setCodigousertype(Integer codigousertype) {
        this.codigousertype = codigousertype;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<UsersEntity> getUsersEntityList() {
        return usersEntityList;
    }

    public void setUsersEntityList(List<UsersEntity> usersEntityList) {
        this.usersEntityList = usersEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigousertype != null ? codigousertype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsertypeEntity)) {
            return false;
        }
        UsertypeEntity other = (UsertypeEntity) object;
        if ((this.codigousertype == null && other.codigousertype != null) || (this.codigousertype != null && !this.codigousertype.equals(other.codigousertype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.UsertypeEntity[ codigousertype=" + codigousertype + " ]";
    }
    
}
