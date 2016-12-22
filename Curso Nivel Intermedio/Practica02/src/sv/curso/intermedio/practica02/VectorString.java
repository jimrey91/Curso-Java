/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Reyes
 */
public class VectorString {
    public static void main(String[] args) {
        Vector <String> nombres = new Vector<>();
        
        String cadena = JOptionPane.showInputDialog("Digite 3 nombres separados por coma (,)");
        
        StringTokenizer tokens= new StringTokenizer(cadena, ",");
        int posicion = 0;
        while(tokens.hasMoreTokens()){
            nombres.add(tokens.nextToken().trim());
            posicion++;
        }
        imprimirVector(nombres);
    }
    
    public static void imprimirVector(Vector <String> nombres){
        
        Collections.sort(nombres);
        Iterator it = nombres.iterator();
        
        while(it.hasNext()){
            System.out.println("Nombre: " + (String)it.next());
        }
    }
}
