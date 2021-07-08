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
public class ProdEncomendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COD_PRODUTO")
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "COD_ENCOMENDA")
    private int codEncomenda;

    public ProdEncomendaPK() {
    }

    public ProdEncomendaPK(int codProduto, int codEncomenda) {
        this.codProduto = codProduto;
        this.codEncomenda = codEncomenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodEncomenda() {
        return codEncomenda;
    }

    public void setCodEncomenda(int codEncomenda) {
        this.codEncomenda = codEncomenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProduto;
        hash += (int) codEncomenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdEncomendaPK)) {
            return false;
        }
        ProdEncomendaPK other = (ProdEncomendaPK) object;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (this.codEncomenda != other.codEncomenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdEncomendaPK[ codProduto=" + codProduto + ", codEncomenda=" + codEncomenda + " ]";
    }
    
}
