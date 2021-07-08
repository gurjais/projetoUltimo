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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "VENDA")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByCodVenda", query = "SELECT v FROM Venda v WHERE v.codVenda = :codVenda"),
    @NamedQuery(name = "Venda.findByData1", query = "SELECT v FROM Venda v WHERE v.data1 = :data1"),
    @NamedQuery(name = "Venda.findByPrecototal", query = "SELECT v FROM Venda v WHERE v.precototal = :precototal"),
    @NamedQuery(name = "Venda.findByEstadoencomenda", query = "SELECT v FROM Venda v WHERE v.estadoencomenda = :estadoencomenda"),
    @NamedQuery(name = "Venda.findByEstadopagamento", query = "SELECT v FROM Venda v WHERE v.estadopagamento = :estadopagamento")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_VENDA")
    private Integer codVenda;
    @Column(name = "DATA1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1;
    @Column(name = "PRECOTOTAL")
    private Integer precototal;
    @Column(name = "ESTADOENCOMENDA")
    private String estadoencomenda;
    @Column(name = "ESTADOPAGAMENTO")
    private String estadopagamento;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne
    private Cliente codCliente;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Gestao idFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private Collection<ProdVenda> prodVendaCollection;

    public Venda() {
    }

    public Venda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Integer getPrecototal() {
        return precototal;
    }

    public void setPrecototal(Integer precototal) {
        this.precototal = precototal;
    }

    public String getEstadoencomenda() {
        return estadoencomenda;
    }

    public void setEstadoencomenda(String estadoencomenda) {
        this.estadoencomenda = estadoencomenda;
    }

    public String getEstadopagamento() {
        return estadopagamento;
    }

    public void setEstadopagamento(String estadopagamento) {
        this.estadopagamento = estadopagamento;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Gestao getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Gestao idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Collection<ProdVenda> getProdVendaCollection() {
        return prodVendaCollection;
    }

    public void setProdVendaCollection(Collection<ProdVenda> prodVendaCollection) {
        this.prodVendaCollection = prodVendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenda != null ? codVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.codVenda == null && other.codVenda != null) || (this.codVenda != null && !this.codVenda.equals(other.codVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Venda[ codVenda=" + codVenda + " ]";
    }
    
}
