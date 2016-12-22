/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Reyes
 */
public class LeerArchivo {
    public static void main(String[] args) {
        /*try{
            FileReader archivo = new FileReader("D:/CursoJava.txt");
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();
            while(linea!=null){
                System.out.println(linea);
                linea = lector.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("Error al abrir archivo");
        }catch(IOException e){
            System.out.println("Error al leer datos");
        }*/
        
        try {
            FileInputStream in = new FileInputStream("D:/CursoJava.txt");
            Scanner sc = new Scanner(in, "UTF-8");
            String texto = sc.nextLine();
            System.out.println(texto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
