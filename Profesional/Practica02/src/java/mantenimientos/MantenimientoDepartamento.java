/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

/**
 *
 * @author Daniel
 */
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import persistencia.Departamentos;

public class MantenimientoDepartamento {
    public static void main(String[] args) {
        //Prueba de codigo de mantenimiento
        
//        MantenimientoDepartamento man = new MantenimientoDepartamento();
//        
//        Departamentos d = new Departamentos();
//        java.util.Date hoy = new java.util.Date();
//        d.setCodigoDepartamento("02");
//        d.setDepartamento("Santa Ana");
//        d.setFechaCreacion(hoy);
//        System.out.println("Respuesta: " + man.guardarDepartamento(d));
        
//        Departamentos dep = man.consultarDepartamentos("01");
//        System.out.println("" + dep.getCodigoDepartamento());
//        System.out.println("" + dep.getDepartamento());
//        List<Departamentos>listadepartamentos = man.consultarTodosDepartamentos();
//        for (Iterator<Departamentos> it = listadepartamentos.iterator(); it.hasNext();) {
//            Departamentos d = it.next();
//            System.out.println("Codigo Departamento: " + d.getCodigoDepartamento());
//            System.out.println("Nombre Departamento: " + d.getDepartamento());
//        }
    }
    
    public  int guardarDepartamento(Departamentos departamento){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(departamento);
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
    
    public Departamentos consultarDepartamentos(String codigoDepartamento){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Departamentos departamentos = null;
        em.getTransaction().begin();
        try {
            departamentos = em.find(Departamentos.class, codigoDepartamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return departamentos;
    }
    
    public List consultarTodosDepartamentos(){
        List<Departamentos> listaDepartamentos = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT d FROM Departamentos d");
            em.getTransaction().commit();
            listaDepartamentos = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listaDepartamentos;
    }
}
