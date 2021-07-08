/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoultimo;

import DAL.Cliente;
import DAL.Codpostais;

/**
 *
 * @author ASUS
 */
public class ProjetoUltimo {

    private static final String Persistence_UNIT_NAME = "projetoFinal2PU";
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProjetoUltimo novo= new ProjetoUltimo();
        novo.inserirCliente();
    }
    
     public void inserirCliente(){
        factory = Persistence.createEntityManagerFactory(Persistence_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Cliente novoCliente = new Cliente();
        
        Codpostais novo = new Codpostais();
        novo.setCodpostal("2222-222");
        em.getTransaction().begin();
        em.persist(novo);
      
        novoCliente.setCodCliente(3);
        novoCliente.setEmail("1234");
        novoCliente.setRua("rua nova");
        novoCliente.setTelefone(123456);
        novoCliente.setPorta(5);
        novoCliente.setCodpostal(novo);
        
        
      
        
        em.persist(novoCliente);
        em.getTransaction().commit();
    }
}
