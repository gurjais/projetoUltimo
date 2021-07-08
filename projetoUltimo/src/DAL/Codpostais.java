/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "CODPOSTAIS")
@NamedQueries({
    @NamedQuery(name = "Codpostais.findAll", query = "SELECT c FROM Codpostais c"),
    @NamedQuery(name = "Codpostais.findByCodpostal", query = "SELECT c FROM Codpostais c WHERE c.codpostal = :codpostal"),
    @NamedQuery(name = "Codpostais.findByDescpostal", query = "SELECT c FROM Codpostais c WHERE c.descpostal = :descpostal")})
public class Codpostais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPOSTAL")
    private String codpostal;
    @Column(name = "DESCPOSTAL")
    private String descpostal;
    @OneToMany(mappedBy = "codpostal")
    private Collection<Armazem> armazemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpostal")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "codpostal")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(mappedBy = "codpostal")
    private Collection<Gestao> gestaoCollection;

    public Codpostais() {
    }

    public Codpostais(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getDescpostal() {
        return descpostal;
    }

    public void setDescpostal(String descpostal) {
        this.descpostal = descpostal;
    }

    public Collection<Armazem> getArmazemCollection() {
        return armazemCollection;
    }

    public void setArmazemCollection(Collection<Armazem> armazemCollection) {
        this.armazemCollection = armazemCollection;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Collection<Gestao> getGestaoCollection() {
        return gestaoCollection;
    }

    public void setGestaoCollection(Collection<Gestao> gestaoCollection) {
        this.gestaoCollection = gestaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpostal != null ? codpostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codpostais)) {
            return false;
        }
        Codpostais other = (Codpostais) object;
        if ((this.codpostal == null && other.codpostal != null) || (this.codpostal != null && !this.codpostal.equals(other.codpostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Codpostais[ codpostal=" + codpostal + " ]";
    }
    
}
