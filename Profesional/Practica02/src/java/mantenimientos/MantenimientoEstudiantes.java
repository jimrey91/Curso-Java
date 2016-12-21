/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;
import java.util.*;
import javax.persistence.*;
import persistencia.Estudiantes;
/**
 *
 * @author Daniel
 */
public class MantenimientoEstudiantes {
    public static void main(String[] args) {
        MantenimientoEstudiantes man = new MantenimientoEstudiantes();
        
//        Estudiantes e = new Estudiantes();
//        java.util.Date hoy = new java.util.Date();
//        e.setCarnet("AA100413");
//        e.setApellidos("Ayala");
//        e.setNombres("Jose");
//        e.setDireccion("San Salvador");
//        e.setTelefono("123456");
//        e.setCodigoPais("02");
//        e.setCodigoDepartamento("06");
//        e.setCodigoMunicipio("0614");
//        e.setCodigoCarrera("04");
//        e.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarEstudiante(e));
        
//        Estudiantes e = man.consultarEstudiante("AA100413");
//        System.out.println("Carnet: " + e.getCarnet());
//        System.out.println("Apellidos: " + e.getApellidos());
//        System.out.println("Nombres: " + e.getNombres());
        
//        System.out.println("Respuesta: " + man.eliminarEstudiante("AA100413"));
        
//        List<Estudiantes> listaEstudiantes = man.consultarTodosEstudiantes();
//        Iterator it = listaEstudiantes.iterator();
//        while (it.hasNext()) {
//            Estudiantes e = (Estudiantes) it.next();
//            System.out.println("Carnet: " + e.getCarnet());
//            System.out.println("Apellidos: " + e.getApellidos());
//            System.out.println("Nombres: " + e.getNombres());
//        }
    }
    
    public int guardarEstudiante(Estudiantes estudiantes){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(estudiantes);
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
    
    public Estudiantes consultarEstudiante(String noCarnet){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Estudiantes estudiante = null;
        em.getTransaction().begin();
        try {
            estudiante = em.find(Estudiantes.class, noCarnet);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return estudiante;
    }
    
    public int eliminarEstudiante(String noCarnet){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Estudiantes estudiante = null;
        em.getTransaction().begin();
        int flag = 0;
        try {
            estudiante = em.find(Estudiantes.class, noCarnet);
            em.remove(estudiante);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag=0;
        } finally {
            em.close();
        }
        return flag;
    }
    
    public List consultarTodosEstudiantes(){
        List<Estudiantes> listaEstudiantes = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Estudiantes e");
            em.getTransaction().commit();
            listaEstudiantes = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listaEstudiantes;
    }
}
