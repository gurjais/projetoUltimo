/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "REVISAO")
@NamedQueries({
    @NamedQuery(name = "Revisao.findAll", query = "SELECT r FROM Revisao r"),
    @NamedQuery(name = "Revisao.findByData1", query = "SELECT r FROM Revisao r WHERE r.data1 = :data1"),
    @NamedQuery(name = "Revisao.findByAvaliacaofinal", query = "SELECT r FROM Revisao r WHERE r.avaliacaofinal = :avaliacaofinal"),
    @NamedQuery(name = "Revisao.findByIdrevisao", query = "SELECT r FROM Revisao r WHERE r.idrevisao = :idrevisao")})
public class Revisao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "DATA1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1;
    @Basic(optional = false)
    @Column(name = "AVALIACAOFINAL")
    private String avaliacaofinal;
    @Id
    @Basic(optional = false)
    @Column(name = "IDREVISAO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idrevisao;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Gestao idFuncionario;
    @JoinColumn(name = "ID_MAQUINA", referencedColumnName = "ID_MAQUINA")
    @ManyToOne
    private Maquina idMaquina;

    public Revisao() {
    }

    public Revisao(Integer idrevisao) {
        this.idrevisao = idrevisao;
    }

    public Revisao(Integer idrevisao, Date data1, String avaliacaofinal) {
        this.idrevisao = idrevisao;
        this.data1 = data1;
        this.avaliacaofinal = avaliacaofinal;
    }

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public String getAvaliacaofinal() {
        return avaliacaofinal;
    }

    public void setAvaliacaofinal(String avaliacaofinal) {
        this.avaliacaofinal = avaliacaofinal;
    }

    public Integer getIdrevisao() {
        return idrevisao;
    }

    public void setIdrevisao(Integer idrevisao) {
        this.idrevisao = idrevisao;
    }

    public Gestao getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Gestao idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrevisao != null ? idrevisao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revisao)) {
            return false;
        }
        Revisao other = (Revisao) object;
        if ((this.idrevisao == null && other.idrevisao != null) || (this.idrevisao != null && !this.idrevisao.equals(other.idrevisao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Revisao[ idrevisao=" + idrevisao + " ]";
    }
    
}
