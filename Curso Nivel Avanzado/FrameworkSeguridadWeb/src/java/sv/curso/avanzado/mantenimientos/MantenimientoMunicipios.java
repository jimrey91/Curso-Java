/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.mantenimientos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.curso.avanzado.persistencia.Municipios;
import sv.curso.avanzado.persistencia.HibernateUtil;

/**
 *
 * @author Daniel
 */
public class MantenimientoMunicipios {
    public static void main(String[] args) {
        MantenimientoMunicipios man = new MantenimientoMunicipios();
        Municipios mun = man.consultarMunicipio("0614");
//      System.out.println(man.guardarMunicipio("0619", "Ciudad Delgado", "06"));
        
        System.out.println("Codigo Municipio    :" + mun.getCodigoMunicipio());
        System.out.println("Nombre Municipio    :" + mun.getMunicipio());
        System.out.println("Codigo Departamento :" + mun.getCodigoDepartamento());
    }
    
    public int guardarMunicipio(Municipios municipios){
          
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag =0;
        
        Municipios mun = new Municipios();
        
        session.beginTransaction();        
        try {    
            session.save(mun);
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
    
    public Municipios consultarMunicipio(String codigoMunicipio){
        Municipios mun = new Municipios();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        try {
            mun = (Municipios) session.get(Municipios.class, codigoMunicipio);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return mun;
    }
    
    public int eliminarMunicipio(String codigoMunicipio){
        Municipios mun = new Municipios();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        session.beginTransaction();
        try {
            mun = (Municipios) session.get(Municipios.class, codigoMunicipio);
            session.delete(mun);
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
    
    public List consultarTodosMunicipios(){
        List <Municipios> listaMunicipios = null;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        try {
            Query q = session.createQuery("FROM Municipios");
            listaMunicipios = (List<Municipios>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMunicipios;
    }
    
}
