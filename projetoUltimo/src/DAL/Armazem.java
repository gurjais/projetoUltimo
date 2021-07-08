/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "ARMAZEM")
@NamedQueries({
    @NamedQuery(name = "Armazem.findAll", query = "SELECT a FROM Armazem a"),
    @NamedQuery(name = "Armazem.findByIdArmazem", query = "SELECT a FROM Armazem a WHERE a.idArmazem = :idArmazem"),
    @NamedQuery(name = "Armazem.findByCapacidade", query = "SELECT a FROM Armazem a WHERE a.capacidade = :capacidade"),
    @NamedQuery(name = "Armazem.findByLotacao", query = "SELECT a FROM Armazem a WHERE a.lotacao = :lotacao"),
    @NamedQuery(name = "Armazem.findByRua", query = "SELECT a FROM Armazem a WHERE a.rua = :rua"),
    @NamedQuery(name = "Armazem.findByPorta", query = "SELECT a FROM Armazem a WHERE a.porta = :porta")})
public class Armazem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ARMAZEM")
    private Integer idArmazem;
    @Column(name = "CAPACIDADE")
    private Integer capacidade;
    @Column(name = "LOTACAO")
    private Integer lotacao;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "PORTA")
    private Integer porta;
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL")
    @ManyToOne
    private Codpostais codpostal;
    @OneToMany(mappedBy = "idArmazem")
    private Collection<ProdutoInicial> produtoInicialCollection;
    @OneToMany(mappedBy = "idArmazem")
    private Collection<ProdutoFinal> produtoFinalCollection;

    public Armazem() {
    }

    public Armazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public Codpostais getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Codpostais codpostal) {
        this.codpostal = codpostal;
    }

    public Collection<ProdutoInicial> getProdutoInicialCollection() {
        return produtoInicialCollection;
    }

    public void setProdutoInicialCollection(Collection<ProdutoInicial> produtoInicialCollection) {
        this.produtoInicialCollection = produtoInicialCollection;
    }

    public Collection<ProdutoFinal> getProdutoFinalCollection() {
        return produtoFinalCollection;
    }

    public void setProdutoFinalCollection(Collection<ProdutoFinal> produtoFinalCollection) {
        this.produtoFinalCollection = produtoFinalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArmazem != null ? idArmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armazem)) {
            return false;
        }
        Armazem other = (Armazem) object;
        if ((this.idArmazem == null && other.idArmazem != null) || (this.idArmazem != null && !this.idArmazem.equals(other.idArmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Armazem[ idArmazem=" + idArmazem + " ]";
    }
    
}
