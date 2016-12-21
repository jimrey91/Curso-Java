/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.mantenimientos;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.curso.avanzado.persistencia.HibernateUtil;
import sv.curso.avanzado.persistencia.Departamentos;

/**
 *
 * @author Daniel
 */
public class MantenimientoDepartamentos {
    public static void main(String[] args) {
        String codigoDepartamento = "14";
        String departamento = "La Union";
        
        MantenimientoDepartamentos man = new MantenimientoDepartamentos();
//        Departamentos dep = man.consultarDepartamento("03");
//        //System.out.println(man.guardarDepartamento(codigoDepartamento, departamento));
//        System.out.println("Codigo Departamento :" + dep.getCodigoDepartamento());
//        System.out.println("Nombre Departamento :" + dep.getDepartamento());
    }
    
    public int guardarDepartamento(Departamentos departamentos){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag =0;        
        Departamentos dep = new Departamentos();
        
        try {
            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
            flag=1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag=1;
            }
        }finally {
            session.close();
        }
        return flag;
        
    }
    
    public Departamentos consultarDepartamento(String codigoDepartamento){
        Departamentos dep = new Departamentos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        try {
            dep = (Departamentos) session.get(Departamentos.class, codigoDepartamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return dep;
    }
    
    public int eliminarDepartamento(String codigoDepartamento){
        Departamentos dep = new Departamentos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        session.beginTransaction();
        try {
            dep = (Departamentos) session.get(Departamentos.class, codigoDepartamento);
            session.delete(dep);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            flag = 0;
        }finally{
            session.close();
        }
        return flag;
    }
    
    public List consultarTodosDepartamentos(){
        List <Departamentos> listaDepartamentos = null;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        try {
            Query q = session.createQuery("FROM Departamentos");
            listaDepartamentos = (List<Departamentos>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDepartamentos;
    }
}
