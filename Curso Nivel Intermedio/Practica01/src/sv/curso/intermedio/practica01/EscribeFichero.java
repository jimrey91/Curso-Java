
package sv.curso.intermedio.practica01;
import java.io.*;
/**
 *
 * @author Reyes
 */
public class EscribeFichero {
    public static void main(String[] args)
    {
         
        PrintWriter pw = null;
        try(FileWriter fichero = new FileWriter("D:/Prueba.txt", true))
        {

            pw = new PrintWriter(fichero);
 
//            for (int i = 0; i < 10; i++)
                pw.println("Prueba Try Resources ");
 
        } catch (Exception e) {
            //Excepcion
        }/* finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }*/
    }
}
