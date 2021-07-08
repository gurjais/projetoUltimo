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
public class ProdVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COD_PRODUTO")
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "COD_VENDA")
    private int codVenda;

    public ProdVendaPK() {
    }

    public ProdVendaPK(int codProduto, int codVenda) {
        this.codProduto = codProduto;
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProduto;
        hash += (int) codVenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdVendaPK)) {
            return false;
        }
        ProdVendaPK other = (ProdVendaPK) object;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (this.codVenda != other.codVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.ProdVendaPK[ codProduto=" + codProduto + ", codVenda=" + codVenda + " ]";
    }
    
}
