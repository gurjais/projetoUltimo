/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author Thalisson
 */
@Entity
@Table(name = "FORNECEDOR")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.codFornecedor = :codFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT f FROM Fornecedor f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedor.findByRua", query = "SELECT f FROM Fornecedor f WHERE f.rua = :rua"),
    @NamedQuery(name = "Fornecedor.findByPorta", query = "SELECT f FROM Fornecedor f WHERE f.porta = :porta")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_FORNECEDOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codFornecedor;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONE")
    private Integer telefone;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "PORTA")
    private Integer porta;
    @OneToMany(mappedBy = "codFornecedor")
    private Collection<Encomenda> encomendaCollection;
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL")
    @ManyToOne
    private Codpostais codpostal;
    
    private static final String Persistence_UNIT_NAME = "projetoUltimoPU";
    private static EntityManagerFactory factory;

    public Fornecedor() {
    }

    public Fornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
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
        hash += (codFornecedor != null ? codFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codFornecedor == null && other.codFornecedor != null) || (this.codFornecedor != null && !this.codFornecedor.equals(other.codFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Fornecedor[ codFornecedor=" + codFornecedor + " ]";
    }
    
        public Fornecedor procurarFornecedor(String nome){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        Fornecedor novo = new Fornecedor();
        Query q = em.createNamedQuery("Fornecedor.findByNome");
        q.setParameter("nome",nome);
        
            Object obj = null;
        try{
             obj = q.getSingleResult();
        }catch(Exception ex){
            
        }
       return ((Fornecedor)obj);       
    }
        
        public List<Fornecedor> listarFornecedores(){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createNamedQuery("Fornecedor.findAll");
        List<Fornecedor> fornecedores = new ArrayList();
        
        for (Object d : q.getResultList()) {
            if ((((Fornecedor) d).getCodFornecedor() != null)) {
                 fornecedores.add(((Fornecedor) d));
            }
        }
        
        return fornecedores;
    }
    
}
