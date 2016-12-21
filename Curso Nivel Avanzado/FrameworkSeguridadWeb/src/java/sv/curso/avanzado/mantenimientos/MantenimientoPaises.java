/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.mantenimientos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.curso.avanzado.persistencia.Paises;
import sv.curso.avanzado.persistencia.HibernateUtil;
/**
 *
 * @author Daniel
 */
public class MantenimientoPaises {
    
    public static void main(String[] args) {
        MantenimientoPaises man = new MantenimientoPaises();
        Paises pa = man.consultarPaises("SV");
        System.out.println("Codigo Pais: " + pa.getCodigoPais());
        System.out.println("Nombre Pais: " + pa.getPais());
//        System.out.println(man.guardarPaises("SV", "El Salvador"));
    }
     public int guardarPaises(String codigoPais,
                                    String pais
                                    ){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag =0;
        
        Paises pa = new Paises();
        pa.setCodigoPais(codigoPais);
        pa.setPais(pais);
        
        java.util.Date hoy = new java.util.Date();
        pa.setFechaCreacion(hoy);
        
        session.beginTransaction();
        try {
            session.save(pa);
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
    
    public Paises consultarPaises(String codigoPais){
        Paises pa = new Paises();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.getTransaction();
        try {
            pa = (Paises) session.get(Paises.class, codigoPais);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return pa;
    }
    
    public int eliminarTipoDocumento(String codigoPais){
        Paises pa = new Paises();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        session.beginTransaction();
        try {
            pa = (Paises) session.get(Paises.class, codigoPais);
            session.delete(pa);
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
    
    public List consultarTodosTiposDocumentos(){
        List<Paises> listaTiposDocumentos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        try {
            Query q = session.createQuery("FROM Paises");
            listaTiposDocumentos = (List<Paises>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTiposDocumentos;
    }
}
