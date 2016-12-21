/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
//        e.setCarnet("OA100413");
//        e.setApellidos("Olivares");
//        e.setNombres("Salvador");
//        e.setDireccion("San Salvador");
//        e.setTelefono("22445000");
//        e.setCodigoPais("02");
//        e.setCodigoDepartamento("06");
//        e.setCodigoMunicipio("0614");
//        e.setCodigoCarrera("04");
//        e.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarEstudiante(e));
        
        List<Estudiantes>listaEstudiantes = man.consultarTodosEstudiantes();
        Iterator it = listaEstudiantes.iterator();
        String xml="<?xml version=\"1.0\"?>\n";
        xml += "<Estudiantes>\n";
        while (it.hasNext()) {
            Estudiantes e = (Estudiantes) it.next();
            xml += "<Estudiante>\n";
            xml += "<Carnet>" + e.getCarnet() +"</Carnet>\n";
            xml += "<Apellidos>" +e.getApellidos()+ "</Apellidos>\n";
            xml += "<Nombres>"+ e.getNombres() +"</Nombres>\n";
            xml += "</Estudiante>\n";
            
        }
        xml += "</Estudiantes>\n";
        System.out.println("xml" + xml);
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
