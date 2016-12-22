/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.mantenimientorenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Daniel
 */
public class MantenimientoRenta {
    
    Connection conect = null;
    public MantenimientoRenta(){
        driver();
        conectarBD();
    }
    
    public static void  driver(){
        try{
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver cargado exitosamente...");
        }catch(Exception e){
            System.out.println(" Driver no pudo ser cargado");
        }
      }
    
    public final Connection conectarBD(){
        String url = "jdbc:postgresql://localhost:5432/Renta";
        String usuario = "postgres";
        String password = "Hola2013";
        conect = null;
        
        try{
            conect =DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion satisfactoria a la BD");
        }catch(Exception e){
            System.out.println("Conexion no se pudo establecer");
        }
        return conect;
        
    }
    public static void main(String[] args) {
        MantenimientoRenta man = new MantenimientoRenta();
        RentaImponible renta = new RentaImponible();
    }
    
    public int guardarRenta(RentaImponible renta){
        int flag=0;

        PreparedStatement ps =null;
        conect = conectarBD();
        
        try {
            String sSql="";
            sSql = sSql + "INSERT INTO \"public\".\"Renta\" ";
            sSql = sSql + "(\"no_nit\", \"nombre_empleado\", \"salario_anual\", \"aguinaldo\", \"ingresos_servicios\")";
            sSql = sSql + "VALUES";
            sSql = sSql + "?, ?, ?, ?, ?";
            
            ps = conect.prepareStatement(sSql);
            ps.setString(1, renta.getNoNit());
            ps.setString(2, renta.getNombreEmpleado());
            ps.setDouble(3, renta.getSalarioAnual());
            ps.setDouble(4, renta.getAguinaldo());
            ps.setDouble(5, renta.getIngresosServicios());
            flag = ps.executeUpdate();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
            try {
                if(ps!=null)ps.close();
                if(conect!=null)conect.close();
                
            } catch (Exception e) {
            }
        }
        return flag;
    }
}
