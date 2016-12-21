/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.mantenimientos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.curso.avanzado.persistencia.HibernateUtil;
import sv.curso.avanzado.persistencia.Usuarios;
/**
 *
 * @author Daniel
 */
public class MantenimientoUsuarios {
    public static void main(String[] args) {
        String usuario ="daniel.reyes";
        String primerApellido = "Reyes";
        String segundoApellido = "Melendez";
        String nombres = "Jaime Daniel";
        String tipoDocumento = "1";
        String numeroDocumento = "021000090";
        String noNit = "06143010701105";
        String codigoPais = "SV";
        String codigoDepartamento = "06";
        String codigoMunicipio = "0614";
        String direccionParticular = "San Salvador";
        String telefonoParticular = "25631832";
        String direccionTrabajoUsuario = "San Salvador";
        String telefonoTrabajoUsuario = "25631832";
        String faxUsuario ="NA";
        String correoElectronico = "danielreyes00@gmail.com";
        String estadoUsuario = "A";
        String tipoUsuario = "I";
 
        
        MantenimientoUsuarios mantenimiento = new MantenimientoUsuarios();
        
        System.out.println(mantenimiento.guardarUsuario(usuario, primerApellido, segundoApellido, nombres, tipoDocumento, 
                numeroDocumento, noNit, codigoPais, codigoDepartamento, codigoMunicipio, direccionParticular, telefonoParticular, 
                direccionTrabajoUsuario, telefonoTrabajoUsuario, faxUsuario, correoElectronico, estadoUsuario, tipoUsuario));
        
        /*
        Usuarios usu = mantenimiento.consultarUsuario("jaime.reyes");
        System.out.println("Usuario         : " + usu.getUsuario());
        System.out.println("Primer Apellido : " + usu.getPrimerApellido());
        System.out.println("Segundo Apellido: " + usu.getSegundoApellido());
        System.out.println("Nombres         : " + usu.getNombres());
        */
    }
    
    public int guardarUsuario(String usuario, 
                              String primerApellido, 
                              String segundoApellido,
                              String nombres,
                              String tipoDocumento,
                              String numeroDocumento,
                              String noNit,
                              String codigoPais,
                              String codigoDepartamento,
                              String codigoMunicipio,
                              String direccionParticular,
                              String telefonoParticular,
                              String direccionTrabajoUsuario,
                              String telefonoTrabajoUsuario,
                              String faxUsuario,
                              String correoElectronico,
                              String estadoUsuario,
                              String tipoUsuario){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag =0;
        
        Usuarios usu = new Usuarios();
        usu.setUsuario(usuario);
        usu.setPrimerApellido(primerApellido);
        usu.setSegundoApellido(segundoApellido);
        usu.setNombres(nombres);
        usu.setTipoDocumento(tipoDocumento);
        usu.setNombreDocumento(numeroDocumento);
        usu.setNoNit(noNit);
        usu.setCodigoPais(codigoPais);
        usu.setCodigoDepartamento(codigoDepartamento);
        usu.setCodigoMunicipio(codigoMunicipio);
        usu.setDireccionParticular(direccionParticular);
        usu.setTelefonoParticular(telefonoParticular);
        usu.setDireccionTrabajoUsuario(direccionTrabajoUsuario);
        usu.setTelefonoTrabajoUsuario(telefonoTrabajoUsuario);
        usu.setFaxUsuario(faxUsuario);
        usu.setCorreoElectronico(correoElectronico);
        usu.setEstadoUsuario(estadoUsuario);
        
        java.util.Date hoy = new java.util.Date();
        usu.setFechaCreacion(hoy);
        usu.setTipoUsuario(tipoUsuario);
        
        try {
            session.beginTransaction();
            session.save(usu);
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
    
    public Usuarios consultarUsuario(String usuario){
        Usuarios usu = new Usuarios();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try {
            session.beginTransaction();
            usu = (Usuarios) session.get(Usuarios.class, usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return usu;
    }
}
