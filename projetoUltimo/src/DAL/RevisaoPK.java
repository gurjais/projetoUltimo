/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thalisson
 */
@Embeddable
public class RevisaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    private int idFuncionario;
    @Basic(optional = false)
    @Column(name = "ID_MAQUINA")
    private int idMaquina;

    public RevisaoPK() {
    }

    public RevisaoPK(int idFuncionario, int idMaquina) {
        this.idFuncionario = idFuncionario;
        this.idMaquina = idMaquina;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFuncionario;
        hash += (int) idMaquina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RevisaoPK)) {
            return false;
        }
        RevisaoPK other = (RevisaoPK) object;
        if (this.idFuncionario != other.idFuncionario) {
            return false;
        }
        if (this.idMaquina != other.idMaquina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.RevisaoPK[ idFuncionario=" + idFuncionario + ", idMaquina=" + idMaquina + " ]";
    }
    
}
