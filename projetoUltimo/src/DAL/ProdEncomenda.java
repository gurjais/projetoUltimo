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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "PROD_ENCOMENDA")
@NamedQueries({
    @NamedQuery(name = "ProdEncomenda.findAll", query = "SELECT p FROM ProdEncomenda p"),
    @NamedQuery(name = "ProdEncomenda.findByCodProduto", query = "SELECT p FROM ProdEncomenda p WHERE p.prodEncomendaPK.codProduto = :codProduto"),
    @NamedQuery(name = "ProdEncomenda.findByCodEncomenda", query = "SELECT p FROM ProdEncomenda p WHERE p.prodEncomendaPK.codEncomenda = :codEncomenda"),
    @NamedQuery(name = "ProdEncomenda.findByQuantidade", query = "SELECT p FROM ProdEncomenda p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdEncomenda.findByPrecoiva", query = "SELECT p FROM ProdEncomenda p WHERE p.precoiva = :precoiva")})
public class ProdEncomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdEncomendaPK prodEncomendaPK;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECOIVA")
    private Double precoiva;
    @JoinColumn(name = "COD_ENCOMENDA", referencedColumnName = "COD_ENCOMENDA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encomenda encomenda;
    @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProdutoInicial produtoInicial;
    
     private static final String Persistence_UNIT_NAME = "projetoUltimoPU";
    private static EntityManagerFactory factory;

    public ProdEncomenda() {
    }

    public ProdEncomenda(ProdEncomendaPK prodEncomendaPK) {
        this.prodEncomendaPK = prodEncomendaPK;
    }

    public ProdEncomenda(int codProduto, int codEncomenda) {
        this.prodEncomendaPK = new ProdEncomendaPK(codProduto, codEncomenda);
    }

    public ProdEncomendaPK getProdEncomendaPK() {
        return prodEncomendaPK;
    }

    public void setProdEncomendaPK(ProdEncomendaPK prodEncomendaPK) {
        this.prodEncomendaPK = prodEncomendaPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoiva() {
        return precoiva;
    }

    public void setPrecoiva(Double precoiva) {
        this.precoiva = precoiva;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public ProdutoInicial getProdutoInicial() {
        return produtoInicial;
    }

    public void setProdutoInicial(ProdutoInicial produtoInicial) {
        this.produtoInicial = produtoInicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodEncomendaPK != null ? prodEncomendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdEncomenda)) {
            return false;
        }
        ProdEncomenda other = (ProdEncomenda) object;
        if ((this.prodEncomendaPK == null && other.prodEncomendaPK != null) || (this.prodEncomendaPK != null && !this.prodEncomendaPK.equals(other.prodEncomendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdEncomenda[ prodEncomendaPK=" + prodEncomendaPK + " ]";
    }
    
    public void criarProdEncomenda(ProdEncomenda nova){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(nova);
        em.getTransaction().commit();
    }
    
}
