/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import mantenimientos.MantenimientoEstudiantes;
import persistencia.Estudiantes;

/**
 *
 * @author Daniel
 */
@WebService(serviceName = "WsEstudiantes")
public class WsEstudiantes {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarEstudiantes")
    public String consultarEstudiantes() {
        MantenimientoEstudiantes man = new MantenimientoEstudiantes();
        
        List<Estudiantes>listaEstudiantes = man.consultarTodosEstudiantes();
        Iterator it = listaEstudiantes.iterator();
        String xml="<?xml version=\"1.0\"?>";
        xml += "<Estudiantes>";
        while (it.hasNext()) {
            Estudiantes e = (Estudiantes) it.next();
            xml += "<Estudiante>";
            xml += "<Carnet>" + e.getCarnet() +"</Carnet>";
            xml += "<Apellidos>" + e.getApellidos() + "</Apellidos>";
            xml += "<Nombres>" + e.getNombres() +"</Nombres>";
            xml += "</Estudiante>";
            
        }
        xml += "</Estudiantes>";
        return xml;

    }

}
