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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "intentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntentosEntity.findAll", query = "SELECT i FROM IntentosEntity i")
    , @NamedQuery(name = "IntentosEntity.findByCodintentos", query = "SELECT i FROM IntentosEntity i WHERE i.codintentos = :codintentos")
    , @NamedQuery(name = "IntentosEntity.findByNombre", query = "SELECT i FROM IntentosEntity i WHERE i.nombre = :nombre")})
public class IntentosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codintentos", nullable = false)
    private Integer codintentos;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @JoinColumn(name = "userintentos", referencedColumnName = "codigouser", nullable = false)
    @ManyToOne(optional = false)
    private UsersEntity userintentos;
    @JoinColumn(name = "categoria", referencedColumnName = "codintentos", nullable = false)
    @ManyToOne(optional = false)
    private CategoriaintentosEntity categoria;

    public IntentosEntity() {
    }

    public IntentosEntity(Integer codintentos) {
        this.codintentos = codintentos;
    }

    public IntentosEntity(Integer codintentos, String nombre) {
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

    public UsersEntity getUserintentos() {
        return userintentos;
    }

    public void setUserintentos(UsersEntity userintentos) {
        this.userintentos = userintentos;
    }

    public CategoriaintentosEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaintentosEntity categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof IntentosEntity)) {
            return false;
        }
        IntentosEntity other = (IntentosEntity) object;
        if ((this.codintentos == null && other.codintentos != null) || (this.codintentos != null && !this.codintentos.equals(other.codintentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.IntentosEntity[ codintentos=" + codintentos + " ]";
    }
    
}
