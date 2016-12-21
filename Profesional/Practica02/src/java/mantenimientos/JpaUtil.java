/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

/**
 *
 * @author Daniel
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("Practica02PU");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
