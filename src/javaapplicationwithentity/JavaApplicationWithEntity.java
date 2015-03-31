/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationwithentity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Zurab
 */
public class JavaApplicationWithEntity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 1-Creates an instance of book
        
    //Book book = new Book("H2G4", 12.5F,"bbbb's Guide to the Galaxy",  "1-84023-742-2", 444, false);
    Student stud = new Student("David", "Sirbiladze2", 23);
    // 2-Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationWithEntityPU");
    EntityManager em = emf.createEntityManager();
    // 3-Persists the book to the database
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    //em.persist(book);
    em.persist(stud);
    tx.commit();
    // 4-Executes the named query
    //book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    Query query = em.createNamedQuery("findStudent");
    query.setParameter("ln", "Si%");
    List<String> lst = query.getResultList();
    // 5-Closes the entity manager and the factory
    em.close();
    emf.close();
    }
    
}
