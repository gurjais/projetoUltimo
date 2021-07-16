/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "MAQUINA")
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.findByIdMaquina", query = "SELECT m FROM Maquina m WHERE m.idMaquina = :idMaquina"),
    @NamedQuery(name = "Maquina.findByDescricao", query = "SELECT m FROM Maquina m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Maquina.findByTipoMaquina", query = "SELECT m FROM Maquina m WHERE m.tipoMaquina = :tipoMaquina"),
    @NamedQuery(name = "Maquina.findByProximarevisao", query = "SELECT m FROM Maquina m WHERE m.proximarevisao = :proximarevisao")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MAQUINA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMaquina;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TIPO_MAQUINA")
    private String tipoMaquina;
    @Column(name = "PROXIMAREVISAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proximarevisao;
    @OneToMany(mappedBy = "idMaquina")
    private Collection<Revisao> revisaoCollection;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public Date getProximarevisao() {
        return proximarevisao;
    }

    public void setProximarevisao(Date proximarevisao) {
        this.proximarevisao = proximarevisao;
    }

    public Collection<Revisao> getRevisaoCollection() {
        return revisaoCollection;
    }

    public void setRevisaoCollection(Collection<Revisao> revisaoCollection) {
        this.revisaoCollection = revisaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Maquina[ idMaquina=" + idMaquina + " ]";
    }
    
}
