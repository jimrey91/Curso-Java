
package sv.curso.intermedio.practica02;

import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class Diccionario {
    public static void main(String[] args) {
        HashMap diccionario = new HashMap();
        diccionario.put("SV", "El Salvador");
        diccionario.put("GT", "Guatemala");
        diccionario.put("MX", "Mexico");
        diccionario.put("ES", "España");
        
        String contenido = diccionario.get("MX").toString();
        
        System.out.println(contenido);
    }
    
}
