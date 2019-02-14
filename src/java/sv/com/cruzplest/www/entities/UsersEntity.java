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
 * @author Christopher
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersEntity.findAll", query = "SELECT u FROM UsersEntity u")
    , @NamedQuery(name = "UsersEntity.findByCodigouser", query = "SELECT u FROM UsersEntity u WHERE u.codigouser = :codigouser")
    , @NamedQuery(name = "UsersEntity.findByNombre", query = "SELECT u FROM UsersEntity u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsersEntity.findByTypeU", query = "SELECT u FROM UsersEntity u WHERE u.tipou.codigousertype = 1 AND  u.codigouser = :codigouser")
    , @NamedQuery(name = "UsersEntity.findByAuten", query = "SELECT u FROM UsersEntity u WHERE u.codigouser = :codigouser AND  u.pass = :pass")
    , @NamedQuery(name = "UsersEntity.findByApellidos", query = "SELECT u FROM UsersEntity u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "UsersEntity.findByPass", query = "SELECT u FROM UsersEntity u WHERE u.pass = :pass")})
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigouser", nullable = false, length = 6)
    private String codigouser;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellidos", length = 50)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "pass", nullable = false, length = 20)
    private String pass;
    @Basic(optional = false)
    @Column(name = "correo", nullable = false, length = 20)
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PrivilegesuserEntity> privilegesuserEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encargado")
    private List<PoTableEntity> poTableEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<NotificationsEntity> notificationsEntityList;
    @JoinColumn(name = "tipou", referencedColumnName = "codigousertype", nullable = false)
    @ManyToOne(optional = false)
    private UsertypeEntity tipou;

    public UsersEntity() {
    }

    public UsersEntity(String codigouser) {
        this.codigouser = codigouser;
    }

    public UsersEntity(String codigouser, String nombre, String pass) {
        this.codigouser = codigouser;
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getCodigouser() {
        return codigouser;
    }

    public void setCodigouser(String codigouser) {
        this.codigouser = codigouser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public List<PrivilegesuserEntity> getPrivilegesuserEntityList() {
        return privilegesuserEntityList;
    }

    public void setPrivilegesuserEntityList(List<PrivilegesuserEntity> privilegesuserEntityList) {
        this.privilegesuserEntityList = privilegesuserEntityList;
    }

    @XmlTransient
    public List<PoTableEntity> getPoTableEntityList() {
        return poTableEntityList;
    }

    public void setPoTableEntityList(List<PoTableEntity> poTableEntityList) {
        this.poTableEntityList = poTableEntityList;
    }

    @XmlTransient
    public List<NotificationsEntity> getNotificationsEntityList() {
        return notificationsEntityList;
    }

    public void setNotificationsEntityList(List<NotificationsEntity> notificationsEntityList) {
        this.notificationsEntityList = notificationsEntityList;
    }

    public UsertypeEntity getTipou() {
        return tipou;
    }

    public void setTipou(UsertypeEntity tipou) {
        this.tipou = tipou;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigouser != null ? codigouser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersEntity)) {
            return false;
        }
        UsersEntity other = (UsersEntity) object;
        if ((this.codigouser == null && other.codigouser != null) || (this.codigouser != null && !this.codigouser.equals(other.codigouser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.UsersEntity[ codigouser=" + codigouser + " ]";
    }

}
