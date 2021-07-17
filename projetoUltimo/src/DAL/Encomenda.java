/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "ENCOMENDA")
@NamedQueries({
    @NamedQuery(name = "Encomenda.findAll", query = "SELECT e FROM Encomenda e"),
    @NamedQuery(name = "Encomenda.findByCodEncomenda", query = "SELECT e FROM Encomenda e WHERE e.codEncomenda = :codEncomenda"),
    @NamedQuery(name = "Encomenda.findByDataEncomenda", query = "SELECT e FROM Encomenda e WHERE e.dataEncomenda = :dataEncomenda"),
    @NamedQuery(name = "Encomenda.findByPrecototal", query = "SELECT e FROM Encomenda e WHERE e.precototal = :precototal")})
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ENCOMENDA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codEncomenda;
    @Column(name = "DATA_ENCOMENDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEncomenda;
    @Column(name = "PRECOTOTAL")
    private Integer precototal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encomenda")
    private Collection<ProdEncomenda> prodEncomendaCollection;
    @JoinColumn(name = "COD_FORNECEDOR", referencedColumnName = "COD_FORNECEDOR")
    @ManyToOne
    private Fornecedor codFornecedor;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Gestao idFuncionario;
    
    private static final String Persistence_UNIT_NAME = "projetoUltimoPU";
    private static EntityManagerFactory factory;

    public Encomenda() {
    }

    public Encomenda(Integer codEncomenda) {
        this.codEncomenda = codEncomenda;
    }

    public Integer getCodEncomenda() {
        return codEncomenda;
    }

    public void setCodEncomenda(Integer codEncomenda) {
        this.codEncomenda = codEncomenda;
    }

    public Date getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Date dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public Integer getPrecototal() {
        return precototal;
    }

    public void setPrecototal(Integer precototal) {
        this.precototal = precototal;
    }

    public Collection<ProdEncomenda> getProdEncomendaCollection() {
        return prodEncomendaCollection;
    }

    public void setProdEncomendaCollection(Collection<ProdEncomenda> prodEncomendaCollection) {
        this.prodEncomendaCollection = prodEncomendaCollection;
    }

    public Fornecedor getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Fornecedor codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Gestao getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Gestao idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEncomenda != null ? codEncomenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.codEncomenda == null && other.codEncomenda != null) || (this.codEncomenda != null && !this.codEncomenda.equals(other.codEncomenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Encomenda[ codEncomenda=" + codEncomenda + " ]";
    }
    
    
    public void criarEncomenda(Encomenda nova){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(nova);
        em.getTransaction().commit();
    }
    
    public Encomenda ultimaInserida(){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Encomenda ultima = new Encomenda();
        ultima.setCodEncomenda(0);
        
        Query q = em.createNamedQuery("Encomenda.findAll");
        for (Object d : q.getResultList()) {
            if ((((Encomenda) d).getCodEncomenda() > ultima.getCodEncomenda())) {
                ultima = ((Encomenda) d);
            }
        }
        
        return ultima;
    }
    
    
    public void atualizar(Encomenda nova){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(nova);
        em.getTransaction().commit();
    }
    
}
