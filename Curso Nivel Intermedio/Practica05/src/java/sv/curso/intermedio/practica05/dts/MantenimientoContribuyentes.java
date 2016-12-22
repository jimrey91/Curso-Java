package sv.curso.intermedio.practica05.dts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Daniel
 */
public class MantenimientoContribuyentes {

    public MantenimientoContribuyentes() {
        cargarDriver();
    }
    
    public void cargarDriver(){
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado satisfactoriamente...");
        } catch (Exception e) {
            System.out.println("Driver no pudo ser cargado");
        }
    }
    
    public Connection conectarBaseDatos(){
        String url = "jdbc:postgresql://192.168.10.107:5432/postgres";
        String usuario = "postgres";
        String password = "postgres123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Satisfactoria a la base de datos...");
        } catch (Exception e) {
            System.out.println("Conexion a la base de datos no se pudo establecer...");
        }
        
        return conn;              
    }
    
    public static void main(String[] args) throws SQLException {
        MantenimientoContribuyentes man = new MantenimientoContribuyentes();
//        Contribuyentes c = new Contribuyentes();
//        c.setNoNit("06143010901179");
//        c.setNombreContribuyentes("Open Source");
//        c.setRazonSocial("Servicios de Tecnologia");
//        c.setRepresentanteLegal("Jimmy Melendez");
//        c.setRentaAnual(1500);
//        System.out.println("Respuesta:" + man.guardarContribuyente(c));
        
//        Contribuyentes contribuyentes = man.consultarContribuyente("06143010901159");
//        if (contribuyentes == null) {
//            System.out.println("Datos del contribuyentes no encontrados");
//        }else{
//            System.out.println("No Nit              : " + contribuyentes.getNoNit());
//            System.out.println("Nombre Contribuyente: " + contribuyentes.getNombreContribuyentes());
//            System.out.println("Razon Social        : " + contribuyentes.getRazonSocial());
//            System.out.println("Representante Legal : " + contribuyentes.getRepresentanteLegal());
//            System.out.println("Renta Anual         : " + contribuyentes.getRentaAnual());
//        }
        
//        Contribuyentes contribuyentes = man.consultarContribuyente("06143010901159");
//        
//        if (contribuyentes!=null) {
//            contribuyentes.setNombreContribuyentes("open source");
//            contribuyentes.setRentaAnual(3000);
//            System.out.println("Nombre Contribuyente: " + contribuyentes.getNombreContribuyentes());
//            System.out.println("Renta Anual: " + contribuyentes.getRentaAnual());
//            System.out.println("Respuesta: " + man.modificarContribuyente(contribuyentes));
//        }
        List<Contribuyentes> lista = man.listarContribuyentes();
         for(Contribuyentes c1 : lista){
             System.out.println(c1);
         }  

    }
    
    public int guardarContribuyente(Contribuyentes contribuyentes){
        int flag = 0;
        PreparedStatement ps = null;
        Connection conn = conectarBaseDatos();
        
        try {
            String sSql = "";
            sSql = sSql + "INSERT INTO \"public\".\"CONTRIBUYENTES\" ";
            sSql = sSql + "(\"NO_NIT\", \"NOMBRE_CONTRIBUYENTE\", \"RAZON_SOCIAL\", ";
            sSql = sSql + "\"REPRESENTANTE_LEGAL\", \"RENTA_ANUAL\")";
            sSql = sSql + "VALUES ";
            sSql = sSql + "(?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(sSql);
            ps.setString(1, contribuyentes.getNoNit());
            ps.setString(2, contribuyentes.getNombreContribuyentes());
            ps.setString(3, contribuyentes.getRazonSocial());
            ps.setString(4, contribuyentes.getRepresentanteLegal());
            ps.setDouble(5, contribuyentes.getRentaAnual());            
            flag = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
    public Contribuyentes consultarContribuyente(String noNit){
        Statement stmt = null;
        ResultSet rs = null;
        Contribuyentes contribuyentes = null;
        Connection conn = conectarBaseDatos();
        
        try {
            String sql = "SELECT * FROM \"public\". \"CONTRIBUYENTES\" WHERE \"NO_NIT\"='"+ noNit +"'" ;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                contribuyentes = new Contribuyentes();
                contribuyentes.setNoNit(rs.getString(1));
                contribuyentes.setNombreContribuyentes(rs.getString(2));
                contribuyentes.setRazonSocial(rs.getString(3));
                contribuyentes.setRepresentanteLegal(rs.getString(4));
                contribuyentes.setRentaAnual(rs.getDouble(5));
            }
            
        } catch (Exception e) {
            e.getMessage();
        }finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return contribuyentes;
    }
    
    public int modificarContribuyente(Contribuyentes contribuyentes){
        int flag = 0;
        PreparedStatement ps = null;
        Connection conn = conectarBaseDatos();
        
        try {
            String sSql = "";
            sSql = sSql + "UPDATE \"public\".\"CONTRIBUYENTES\"";
            sSql = sSql + "SET \"NOMBRE_CONTRIBUYENTE\"=?, \"RAZON_SOCIAL\"=?, \"REPRESENTANTE_LEGAL\"=?, ";
            sSql = sSql + "\"RENTA_ANUAL\"=?";
            sSql = sSql + "WHERE \"NO_NIT\"=?";
            
            ps = conn.prepareStatement(sSql);
            ps.setString(1, contribuyentes.getNombreContribuyentes());
            ps.setString(2, contribuyentes.getRazonSocial());
            ps.setString(3, contribuyentes.getRepresentanteLegal());
            ps.setDouble(4, contribuyentes.getRentaAnual());
            ps.setString(5, contribuyentes.getNoNit());
            
            flag = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
    public List<Contribuyentes> listarContribuyentes() throws SQLException{
        
        List<Contribuyentes> lista = null;
        Connection conn = conectarBaseDatos();
        PreparedStatement ps = null;
        
        try {
            String sSql = "SELECT * FROM \"public\".\"CONTRIBUYENTES\"";
            ps = conn.prepareStatement(sSql);
            
            lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contribuyentes con = new Contribuyentes();
                con.setNoNit(rs.getString(1));
                con.setNombreContribuyentes(rs.getString(2));
                con.setRazonSocial(rs.getString(3));
                con.setRepresentanteLegal(rs.getString(4));
                con.setRentaAnual(rs.getDouble(5));
                lista.add(con);
            }           
        } catch (Exception e) {
                throw e;
        }finally {
                if(ps != null) ps.close();
                if(conn != null) conn.close();
        }
        return lista;
    }
    
}
