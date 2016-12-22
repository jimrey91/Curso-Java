/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practico06.mantenimiento;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import sv.curso.intermedio.practico06.persistencia.Contribuyentes;

/**
 *
 * @author Daniel
 */
public class MantenimientoContribuyentesJpa {
    public static void main(String[] args) {
// Implementar la logica de guardar, consultar, modificar y eliminar
        
     MantenimientoContribuyentesJpa mantenimiento = new MantenimientoContribuyentesJpa();
//     System.out.println("Respuesta: " + mantenimiento.eliminarContribuyente("061406126201"));
     
 /*    Modificar contribuyente 
     Contribuyentes contribuyente = new Contribuyentes();
     System.out.println("Respuesta: " + mantenimiento.consultarContribuyente("06143010901151"));     
     System.out.println("No Nit              :" + contribuyente.getNoNit());
     System.out.println("Nombre Contribuyente:" + contribuyente.getNombreContribuyente());
     System.out.println("Razon Social        :" + contribuyente.getRazonSocial());
     System.out.println("Representante Legal :" + contribuyente.getRepresentanteLegal());
     System.out.println("Renta Anual         :" + contribuyente.getRentaAnual());
 */    
     /* Guardar un contribuyente*/
     Contribuyentes contribuyente = new Contribuyentes();
     contribuyente.setNoNit("0614301070134");
     contribuyente.setNombreContribuyente("Open Source Solutions");
     contribuyente.setRazonSocial("Servicio de Capacitacion");
     contribuyente.setRepresentanteLegal("Daniel Reyes");
     contribuyente.setRentaAnual(new BigDecimal(1000.00));
     System.out.println("Respuesta: " + mantenimiento.guardarContribuyente(contribuyente));
     
     
 }
    public int guardarContribuyente(Contribuyentes contribuyente){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(contribuyente);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        }
        return flag;
    }
    public Contribuyentes consultarContribuyente(String noNit){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Contribuyentes contribuyente=null;
        em.getTransaction().begin();
        try {
            contribuyente = em.find(Contribuyentes.class, noNit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return contribuyente;
    }
    public int modificarContribuyente(String noNit, double rentaAnual){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Contribuyentes contribuyente=null;
        int flag = 0;
        try {
            em.getTransaction().begin();
            contribuyente = em.find(Contribuyentes.class, noNit);
            contribuyente.setRentaAnual(new BigDecimal(rentaAnual));
            em.merge(contribuyente);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        }
        return flag;
    }
    public int eliminarContribuyente(String noNit){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Contribuyentes contribuyente=null;
        int flag = 0;      
        try {
            em.getTransaction().begin();
            contribuyente = em.find(Contribuyentes.class, noNit);
            em.remove(contribuyente);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        }
        return flag;
    }
}
