
package sv.curso.intermedio.practica01;

import java.io.File;

/**
 *
 * @author Daniel
 */
public class Archivo {
    public static void main(String[] args) {
        File archivo = new File("D:\\java");
        
        boolean respuesta = archivo.mkdir();
        
        System.out.println(respuesta);
    }
    
}
