/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

/**
 *
 * @author Daniel
 */

import java.util.*;
import javax.persistence.*;
import persistencia.Paises;

public class MantenimientoPaises {
    public static void main(String[] args) {
        MantenimientoPaises man = new MantenimientoPaises();
        
        Paises p = new Paises();
        java.util.Date hoy = new java.util.Date();
        p.setCodigoPais("01");
        p.setPais("Guatemala");
        p.setFechaCreacion(hoy);
        System.out.println("Respuesta: " + man.guardarPais(p));
        
//        List<Paises> listaPaises = man.consultarTodosPaises();
//        for (Paises p : listaPaises) {
//            
//            System.out.print("Codigo Pais: " + p.getCodigoPais());
//            System.out.println(" Nombre Pais: " + p.getPais());
//        }
    }
    
    public int guardarPais(Paises paises){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(paises);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }
    
    public  Paises consultarPais(String codigoPais){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Paises paises = null;
        em.getTransaction().begin();
        try {
            paises = em.find(Paises.class, codigoPais);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return paises;
    }
    
    public List consultarTodosPaises(){
        List<Paises> listaPaises = null;
        EntityManager em  = JpaUtil.getEntityManagerFactory().createEntityManager();
        
         em.getTransaction().begin();
         try {
            Query query = em.createQuery("SELECT p FROM Paises p");
            em.getTransaction().commit();
            listaPaises = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
         return listaPaises;
    }
}
