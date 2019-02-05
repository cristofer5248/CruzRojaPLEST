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
 * @author Christopher
 */
@Entity
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultsEntity.findAll", query = "SELECT r FROM ResultsEntity r")
    , @NamedQuery(name = "ResultsEntity.findByCodigo", query = "SELECT r FROM ResultsEntity r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "ResultsEntity.findByResultadoEsperado", query = "SELECT r FROM ResultsEntity r WHERE r.resultadoEsperado = :resultadoEsperado")})
public class ResultsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Column(name = "resultadoEsperado", length = 40)
    private String resultadoEsperado;
    @JoinColumn(name = "codigo", referencedColumnName = "codigocon", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ConsolidatorpoEntity consolidatorpoEntity;

    public ResultsEntity() {
    }

    public ResultsEntity(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
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
        if (!(object instanceof ResultsEntity)) {
            return false;
        }
        ResultsEntity other = (ResultsEntity) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cruzplest.www.entities.ResultsEntity[ codigo=" + codigo + " ]";
    }
    
}
