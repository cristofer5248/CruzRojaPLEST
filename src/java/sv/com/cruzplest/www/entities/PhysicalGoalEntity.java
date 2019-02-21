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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RRDESC04
 */
@Entity
@Table(name = "physical_goal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhysicalGoalEntity.findAll", query = "SELECT p FROM PhysicalGoalEntity p")
    , @NamedQuery(name = "PhysicalGoalEntity.findByCodigo", query = "SELECT p FROM PhysicalGoalEntity p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "PhysicalGoalEntity.findByMeta", query = "SELECT p FROM PhysicalGoalEntity p WHERE p.meta = :meta")})
public class PhysicalGoalEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "meta", nullable = false, length = 80)
    private String meta;
    @JoinColumn(name = "codigo", referencedColumnName = "codigoPO", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ConsolidatorpoEntity consolidatorpoEntity;

    public PhysicalGoalEntity() {
    }

    public PhysicalGoalEntity(Integer codigo) {
        this.codigo = codigo;
    }

    public PhysicalGoalEntity(Integer codigo, String meta) {
        this.codigo = codigo;
        this.meta = meta;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public ConsolidatorpoEntity getConsolidatorpoEntity() {
        return consolidatorpoEntity;
    }

    public void setConsolidatorpoEntity(ConsolidatorpoEntity consolidatorpoEntity) {
        this.consolidatorpoEntity = consolidatorpoEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhysicalGoalEntity)) {
            return false;
        }
        PhysicalGoalEntity other = (PhysicalGoalEntity) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.PhysicalGoalEntity[ codigo=" + codigo + " ]";
    }
    
}
