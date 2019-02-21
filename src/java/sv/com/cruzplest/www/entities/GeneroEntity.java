/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneroEntity.findAll", query = "SELECT g FROM GeneroEntity g")
    , @NamedQuery(name = "GeneroEntity.findByCodgenero", query = "SELECT g FROM GeneroEntity g WHERE g.codgenero = :codgenero")
    , @NamedQuery(name = "GeneroEntity.findByNombre", query = "SELECT g FROM GeneroEntity g WHERE g.nombre = :nombre")})
public class GeneroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codgenero", nullable = false)
    private Integer codgenero;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @OneToMany(mappedBy = "genero")
    private List<UsersEntity> usersEntityList;

    public GeneroEntity() {
    }

    public GeneroEntity(Integer codgenero) {
        this.codgenero = codgenero;
    }

    public GeneroEntity(Integer codgenero, String nombre) {
        this.codgenero = codgenero;
        this.nombre = nombre;
    }

    public Integer getCodgenero() {
        return codgenero;
    }

    public void setCodgenero(Integer codgenero) {
        this.codgenero = codgenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (codgenero != null ? codgenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneroEntity)) {
            return false;
        }
        GeneroEntity other = (GeneroEntity) object;
        if ((this.codgenero == null && other.codgenero != null) || (this.codgenero != null && !this.codgenero.equals(other.codgenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.GeneroEntity[ codgenero=" + codgenero + " ]";
    }
    
}
