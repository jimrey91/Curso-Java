/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;


import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class ArregloString {
    public static void main(String[] args) {
        //Declaramos el arreglo
        String[] nombres = new String[3];
        //Leemos la cadena de caracteres
        String cadena = JOptionPane.showInputDialog("Digite 3 nombres separados por coma (,)");
        //Leemos los nombres
        StringTokenizer tokens= new StringTokenizer(cadena, ",");
        int posicion = 0;
        while(tokens.hasMoreTokens()){
            nombres[posicion]=tokens.nextToken().trim();
            posicion++;
        }
        imprimirArreglo(nombres);
    }
    //Imprimimos el arreglo
    public static void imprimirArreglo(String[]nombres){
        for (String nombre : nombres) {
            System.out.println("Nombre:" + nombre);
        }
    }
}
