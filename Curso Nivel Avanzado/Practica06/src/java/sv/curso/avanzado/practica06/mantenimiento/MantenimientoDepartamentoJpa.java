/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.practica06.mantenimiento;

/**
 *
 * @author Daniel
 */
import java.util.*;
import javax.persistence.*;
import sv.curso.avanzado.practica06.persistencia.Departamentos;

public class MantenimientoDepartamentoJpa {
    public static void main(String[] args) {
        //Implementar la lógica de los metodos
        
        MantenimientoDepartamentoJpa man = new MantenimientoDepartamentoJpa();
        //Guardar Departamento
//        Departamentos d = new Departamentos();
//        java.util.Date hoy = new java.util.Date();
//        d.setCodigoDepartamento("10");
//        d.setDepartamento("San Vicente");
//        d.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarDepartamento(d));
        
        //Consultar Departamento
//        Departamentos d = man.consultarDepartamentos("02");
//        System.out.println("Codigo Departamento: " + d.getCodigoDepartamento());
//        System.out.println("Nombre Departamento: " + d.getDepartamento());
        
        //Modificar Departamento
//        Departamentos d = new Departamentos();
//        d.setCodigoDepartamento("10");
//        d.setDepartamento("SAN VICENTE");
//        System.out.println("Respuesta: " + man.modificarDepartamentos(d));
        
        //Eliminar Departamento
//        System.out.println("Respuesta: " + man.eliminarDepartamento("10"));
        
        //Listar Departamentos
        List<Departamentos>listadepartamentos = man.consultarTodosDepartamentos();
        for (Iterator<Departamentos> it = listadepartamentos.iterator(); it.hasNext();) {
            Departamentos d = it.next();
            System.out.println("Codigo Departamento: " + d.getCodigoDepartamento());
            System.out.println("Nombre Departamento: " + d.getDepartamento());
        }
    }
    
    public int guardarDepartamento(Departamentos departamentos){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(departamentos);
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
    
    public Departamentos consultarDepartamentos(String noNit){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Departamentos departamento= null;
        em.getTransaction().begin();
        try {
            departamento = em.find(Departamentos.class, noNit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return departamento;
    }
    
    public int modificarDepartamentos(Departamentos d){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Departamentos departamento = null;
        int flag = 0;
        em.getTransaction().begin();
        try {
            departamento=em.find(Departamentos.class, d.getCodigoDepartamento());
            departamento.setDepartamento(d.getDepartamento());
            em.merge(departamento);
            em.getTransaction().commit();
            flag= 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag=0;
        } finally {
            em.close();
        }
        return flag;
    }
    
    public int eliminarDepartamento(String codigoDepartamento){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Departamentos departamento = null;
        em.getTransaction().begin();
        int flag = 0;
        try {
            departamento = em.find(Departamentos.class, codigoDepartamento);
            em.remove(departamento);
            em.getTransaction().commit();
            flag=1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }
    
    public List consultarTodosDepartamentos(){
        List<Departamentos>listadepartamentos = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT d FROM Departamentos d");
            em.getTransaction().commit();
            listadepartamentos = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listadepartamentos;
    }
}
