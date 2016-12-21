/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel Reyes
 */
public class EjecutarReporte {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "universidad", "admin");
            //String url = "C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Curso Nivel Profesional\\Practica05\\src\\java\\reportes";
            java.net.URL url = EjecutarReporte.class.getResource("ReporteDepartamento");
            String ruta = url.getPath();
            ruta = ruta.replaceAll("%20", " ");
            JasperReport reportes = JasperCompileManager.compileReport(ruta);
            JasperPrint print = JasperFillManager.fillReport(reportes, null, conn);
            JasperViewer.viewReport(print);
        } catch (JRException e) {
            e.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
