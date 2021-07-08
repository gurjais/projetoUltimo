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
@Table(name = "GESTAO")
@NamedQueries({
    @NamedQuery(name = "Gestao.findAll", query = "SELECT g FROM Gestao g"),
    @NamedQuery(name = "Gestao.findByIdFuncionario", query = "SELECT g FROM Gestao g WHERE g.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Gestao.findByIdDepartamento", query = "SELECT g FROM Gestao g WHERE g.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Gestao.findByNome", query = "SELECT g FROM Gestao g WHERE g.nome = :nome"),
    @NamedQuery(name = "Gestao.findByRua", query = "SELECT g FROM Gestao g WHERE g.rua = :rua"),
    @NamedQuery(name = "Gestao.findByPorta", query = "SELECT g FROM Gestao g WHERE g.porta = :porta"),
    @NamedQuery(name = "Gestao.findByPasswordd", query = "SELECT g FROM Gestao g WHERE g.passwordd = :passwordd")})
public class Gestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    private Integer idFuncionario;
    @Column(name = "ID_DEPARTAMENTO")
    private Integer idDepartamento;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "PORTA")
    private Integer porta;
    @Column(name = "PASSWORDD")
    private String passwordd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gestao")
    private Collection<Revisao> revisaoCollection;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Venda> vendaCollection;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Encomenda> encomendaCollection;
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL")
    @ManyToOne
    private Codpostais codpostal;

    public Gestao() {
    }

    public Gestao(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    public Collection<Revisao> getRevisaoCollection() {
        return revisaoCollection;
    }

    public void setRevisaoCollection(Collection<Revisao> revisaoCollection) {
        this.revisaoCollection = revisaoCollection;
    }

    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    public Collection<Encomenda> getEncomendaCollection() {
        return encomendaCollection;
    }

    public void setEncomendaCollection(Collection<Encomenda> encomendaCollection) {
        this.encomendaCollection = encomendaCollection;
    }

    public Codpostais getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Codpostais codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestao)) {
            return false;
        }
        Gestao other = (Gestao) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Gestao[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
