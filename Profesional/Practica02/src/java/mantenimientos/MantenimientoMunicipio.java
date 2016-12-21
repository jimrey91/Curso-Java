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
import persistencia.Municipios;

public class MantenimientoMunicipio {
    public static void main(String[] args) {
        MantenimientoMunicipio man = new MantenimientoMunicipio();
        
//        Municipios m = new Municipios();
//        java.util.Date hoy = new java.util.Date();
//        m.setCodigoMunicipio("0101");
//        m.setMunicicpio("Ahuachapan");
//        m.setCodigoDepartamento("01");
//        m.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarMunicipio(m));
        
        List<Municipios>listaMunicipios = man.consultarMunicipioPorDepartamento("01");
        for (Municipios d : listaMunicipios) {
            System.out.print("Codigo Departamento: " + d.getCodigoMunicipio());
            System.out.print(" Nombre Departamento: " + d.getCodigoDepartamento());
            System.out.println(" Municipio: " + d.getMunicipio());
        }
    }
    public  int guardarMunicipio(Municipios municipio){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(municipio);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        }finally{
            em.close();
        }
        return flag;
    }
        
    public Municipios consultarMunicipio(String codigoMunicipio){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Municipios municipio = null;
        em.getTransaction().begin();
        try {
            municipio = em.find(Municipios.class, codigoMunicipio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return municipio;
    }
    
    public List consultarMunicipioPorDepartamento(String codigoDepartamento){
        List<Municipios> listaMunicipios = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT m FROM Municipios m WHERE m.codigoDepartamento=?1");
            query.setParameter(1, codigoDepartamento);
            listaMunicipios = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listaMunicipios;
    }
    
    public List consultarTodosMunicipios(){
        List<Municipios> listaMunicipios = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT m FROM Municipios m");
            em.getTransaction().commit();
            listaMunicipios = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listaMunicipios;
    }
}
