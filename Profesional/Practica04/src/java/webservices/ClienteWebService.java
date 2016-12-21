/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

/**
 *
 * @author Daniel
 */

import java.io.*;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ClienteWebService {
    public static void main(String[] args) {
        cliente_webservice.WsEstudiantes_Service  service = new cliente_webservice.WsEstudiantes_Service();
        cliente_webservice.WsEstudiantes port = service.getWsEstudiantesPort();
        String xmlString = port.consultarEstudiantes();
        
        try {
            SAXReader saxReader = new SAXReader();
           Reader in = new StringReader (xmlString); 
          Document document = saxReader.read(in);
          System.out.println(xmlString);
            
            String xPatch = "//Estudiantes/Estudiante";
            List<Node> nodes = document.selectNodes(xPatch);
            for (Node node : nodes){
                String carnet = node.valueOf("Carnet");
                String apellidos = node.valueOf("Apellidos");
                String nombres = node.valueOf("Nombres");
                
                System.out.println("Carnet : " + carnet);
                System.out.println("Apellidos : " + apellidos);
                System.out.println("Nombres : " + nombres);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
