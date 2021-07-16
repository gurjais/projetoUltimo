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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "PRODUTO_INICIAL")
@NamedQueries({
    @NamedQuery(name = "ProdutoInicial.findAll", query = "SELECT p FROM ProdutoInicial p"),
    @NamedQuery(name = "ProdutoInicial.findByCodProduto", query = "SELECT p FROM ProdutoInicial p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "ProdutoInicial.findByNomeProduto", query = "SELECT p FROM ProdutoInicial p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "ProdutoInicial.findByDescProduto", query = "SELECT p FROM ProdutoInicial p WHERE p.descProduto = :descProduto"),
    @NamedQuery(name = "ProdutoInicial.findByQuantidade", query = "SELECT p FROM ProdutoInicial p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutoInicial.findByPreco", query = "SELECT p FROM ProdutoInicial p WHERE p.preco = :preco")})
public class ProdutoInicial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PRODUTO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codProduto;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "DESC_PRODUTO")
    private String descProduto;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECO")
    private Double preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoInicial")
    private Collection<ProdEncomenda> prodEncomendaCollection;
    @JoinColumn(name = "ID_ARMAZEM", referencedColumnName = "ID_ARMAZEM")
    @ManyToOne
    private Armazem idArmazem;

    public ProdutoInicial() {
    }

    public ProdutoInicial(Integer codProduto) {
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

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
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

    public Collection<ProdEncomenda> getProdEncomendaCollection() {
        return prodEncomendaCollection;
    }

    public void setProdEncomendaCollection(Collection<ProdEncomenda> prodEncomendaCollection) {
        this.prodEncomendaCollection = prodEncomendaCollection;
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
        if (!(object instanceof ProdutoInicial)) {
            return false;
        }
        ProdutoInicial other = (ProdutoInicial) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdutoInicial[ codProduto=" + codProduto + " ]";
    }
    
}
