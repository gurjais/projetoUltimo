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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Revisao.findByIdFuncionario", query = "SELECT r FROM Revisao r WHERE r.revisaoPK.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Revisao.findByIdMaquina", query = "SELECT r FROM Revisao r WHERE r.revisaoPK.idMaquina = :idMaquina"),
    @NamedQuery(name = "Revisao.findByData1", query = "SELECT r FROM Revisao r WHERE r.data1 = :data1"),
    @NamedQuery(name = "Revisao.findByAvaliacaofinal", query = "SELECT r FROM Revisao r WHERE r.avaliacaofinal = :avaliacaofinal")})
public class Revisao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RevisaoPK revisaoPK;
    @Basic(optional = false)
    @Column(name = "DATA1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data1;
    @Basic(optional = false)
    @Column(name = "AVALIACAOFINAL")
    private String avaliacaofinal;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gestao gestao;
    @JoinColumn(name = "ID_MAQUINA", referencedColumnName = "ID_MAQUINA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Maquina maquina;

    public Revisao() {
    }

    public Revisao(RevisaoPK revisaoPK) {
        this.revisaoPK = revisaoPK;
    }

    public Revisao(RevisaoPK revisaoPK, Date data1, String avaliacaofinal) {
        this.revisaoPK = revisaoPK;
        this.data1 = data1;
        this.avaliacaofinal = avaliacaofinal;
    }

    public Revisao(int idFuncionario, int idMaquina) {
        this.revisaoPK = new RevisaoPK(idFuncionario, idMaquina);
    }

    public RevisaoPK getRevisaoPK() {
        return revisaoPK;
    }

    public void setRevisaoPK(RevisaoPK revisaoPK) {
        this.revisaoPK = revisaoPK;
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

    public Gestao getGestao() {
        return gestao;
    }

    public void setGestao(Gestao gestao) {
        this.gestao = gestao;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revisaoPK != null ? revisaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revisao)) {
            return false;
        }
        Revisao other = (Revisao) object;
        if ((this.revisaoPK == null && other.revisaoPK != null) || (this.revisaoPK != null && !this.revisaoPK.equals(other.revisaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Revisao[ revisaoPK=" + revisaoPK + " ]";
    }
    
}
