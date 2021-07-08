/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "PROD_VENDA")
@NamedQueries({
    @NamedQuery(name = "ProdVenda.findAll", query = "SELECT p FROM ProdVenda p"),
    @NamedQuery(name = "ProdVenda.findByCodProduto", query = "SELECT p FROM ProdVenda p WHERE p.prodVendaPK.codProduto = :codProduto"),
    @NamedQuery(name = "ProdVenda.findByCodVenda", query = "SELECT p FROM ProdVenda p WHERE p.prodVendaPK.codVenda = :codVenda"),
    @NamedQuery(name = "ProdVenda.findByQuantidade", query = "SELECT p FROM ProdVenda p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdVenda.findByValoriva", query = "SELECT p FROM ProdVenda p WHERE p.valoriva = :valoriva")})
public class ProdVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdVendaPK prodVendaPK;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORIVA")
    private Double valoriva;
    @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProdutoFinal produtoFinal;
    @JoinColumn(name = "COD_VENDA", referencedColumnName = "COD_VENDA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public ProdVenda() {
    }

    public ProdVenda(ProdVendaPK prodVendaPK) {
        this.prodVendaPK = prodVendaPK;
    }

    public ProdVenda(int codProduto, int codVenda) {
        this.prodVendaPK = new ProdVendaPK(codProduto, codVenda);
    }

    public ProdVendaPK getProdVendaPK() {
        return prodVendaPK;
    }

    public void setProdVendaPK(ProdVendaPK prodVendaPK) {
        this.prodVendaPK = prodVendaPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValoriva() {
        return valoriva;
    }

    public void setValoriva(Double valoriva) {
        this.valoriva = valoriva;
    }

    public ProdutoFinal getProdutoFinal() {
        return produtoFinal;
    }

    public void setProdutoFinal(ProdutoFinal produtoFinal) {
        this.produtoFinal = produtoFinal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodVendaPK != null ? prodVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdVenda)) {
            return false;
        }
        ProdVenda other = (ProdVenda) object;
        if ((this.prodVendaPK == null && other.prodVendaPK != null) || (this.prodVendaPK != null && !this.prodVendaPK.equals(other.prodVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdVenda[ prodVendaPK=" + prodVendaPK + " ]";
    }
    
}
