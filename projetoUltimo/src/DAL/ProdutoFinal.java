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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "PRODUTO_FINAL")
@NamedQueries({
    @NamedQuery(name = "ProdutoFinal.findAll", query = "SELECT p FROM ProdutoFinal p"),
    @NamedQuery(name = "ProdutoFinal.findByCodProduto", query = "SELECT p FROM ProdutoFinal p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "ProdutoFinal.findByNomeProduto", query = "SELECT p FROM ProdutoFinal p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "ProdutoFinal.findByDesProduto", query = "SELECT p FROM ProdutoFinal p WHERE p.desProduto = :desProduto"),
    @NamedQuery(name = "ProdutoFinal.findByQuantidade", query = "SELECT p FROM ProdutoFinal p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutoFinal.findByPreco", query = "SELECT p FROM ProdutoFinal p WHERE p.preco = :preco")})
public class ProdutoFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PRODUTO")
    private Integer codProduto;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "DES_PRODUTO")
    private String desProduto;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECO")
    private Double preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoFinal")
    private Collection<ProdVenda> prodVendaCollection;
    @JoinColumn(name = "ID_ARMAZEM", referencedColumnName = "ID_ARMAZEM")
    @ManyToOne
    private Armazem idArmazem;

    public ProdutoFinal() {
    }

    public ProdutoFinal(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDesProduto() {
        return desProduto;
    }

    public void setDesProduto(String desProduto) {
        this.desProduto = desProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Collection<ProdVenda> getProdVendaCollection() {
        return prodVendaCollection;
    }

    public void setProdVendaCollection(Collection<ProdVenda> prodVendaCollection) {
        this.prodVendaCollection = prodVendaCollection;
    }

    public Armazem getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Armazem idArmazem) {
        this.idArmazem = idArmazem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoFinal)) {
            return false;
        }
        ProdutoFinal other = (ProdutoFinal) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdutoFinal[ codProduto=" + codProduto + " ]";
    }
    
}
