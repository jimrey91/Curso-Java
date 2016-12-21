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
import persistencia.Carreras;

public class MantenimientoCarreras {
    public static void main(String[] args) {
        MantenimientoCarreras man = new MantenimientoCarreras();
        
//        Carreras c = new Carreras();
//        java.util.Date hoy = new java.util.Date();
//        c.setCodigoCarrera("01");
//        c.setCarrera("Ingenieria en Computacion");
//        c.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarCarrera(c));
        
        List<Carreras> listaCarreras = man.consultarTodasCarreras();
        for (Carreras c : listaCarreras) {
            
            System.out.print("Codigo Carrera: " + c.getCodigoCarrera());
            System.out.println(" Nombre Carrera: " + c.getCarrera());
        }
    }
    
    public int guardarCarrera(Carreras carreras){
        int flag = 0;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(carreras);
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
    
     public  Carreras consultarCarrera(String codigoCarrera){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Carreras carreras = null;
        em.getTransaction().begin();
        try {
            carreras = em.find(Carreras.class, codigoCarrera);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return carreras;
    }
     
     public List consultarTodasCarreras(){
        List<Carreras> listaCarreras = null;
        EntityManager em  = JpaUtil.getEntityManagerFactory().createEntityManager();
        
         em.getTransaction().begin();
         try {
            Query query = em.createQuery("SELECT c FROM Carreras c");
            em.getTransaction().commit();
            listaCarreras = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
         return listaCarreras;
    }
    
}
