/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.mantenimientos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.curso.avanzado.persistencia.TiposDocumentos;
import sv.curso.avanzado.persistencia.HibernateUtil;
/**
 *
 * @author Daniel
 */
public class MantenimientoTiposDocumentos {
    public static void main(String[] args) {
        MantenimientoTiposDocumentos man = new MantenimientoTiposDocumentos();
        
        TiposDocumentos td = man.consultarTipoDocumentos("D");
        System.out.println("Codigo Documento: " + td.getCodigoDocumento());
        System.out.println("Tipo Documento:   " + td.getEstadoUsuario());
//        System.out.println(man.guardarTipoDocumento("D", "Dui Ciudadano"));
    }
    
    public int guardarTipoDocumento(String codigoDocumento,
                                    String tipoDocumento
                                    ){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag =0;
        
        TiposDocumentos td = new TiposDocumentos();
        td.setCodigoDocumento(codigoDocumento);
        td.setEstadoUsuario(tipoDocumento);
        
        java.util.Date hoy = new java.util.Date();
        td.setFechaCreacion(hoy);
        
        session.beginTransaction();
        try {
            session.save(td);
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
    
    public TiposDocumentos consultarTipoDocumentos(String codigoDocumento){
        TiposDocumentos td = new TiposDocumentos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.getTransaction();
        try {
            td = (TiposDocumentos) session.get(TiposDocumentos.class, codigoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return td;
    }
    
    public int eliminarTipoDocumento(String codigoDocumento){
        TiposDocumentos td = new TiposDocumentos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        session.beginTransaction();
        try {
            td = (TiposDocumentos) session.get(TiposDocumentos.class, codigoDocumento);
            session.delete(td);
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
        List<TiposDocumentos> listaTiposDocumentos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        try {
            Query q = session.createQuery("FROM Municipios");
            listaTiposDocumentos = (List<TiposDocumentos>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTiposDocumentos;
    }
}
