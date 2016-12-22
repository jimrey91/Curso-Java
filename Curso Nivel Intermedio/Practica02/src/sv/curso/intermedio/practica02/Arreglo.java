/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class Arreglo {
    
    static int miArreglo[];
    
    public static void main(String[] args) {
        System.out.println("Ingrese tamaño de vector");
       
        Scanner lector = new Scanner(System.in);
        int tamano = lector.nextInt();
        miArreglo = new int [tamano];
        
        
        for (int i = 0; i < miArreglo.length; i++) {
            System.out.println("Digitar numero entero para la posicion "+ i + " : ");
            miArreglo[i] = lector.nextInt();
        }
        System.out.println("----------------------");
        for (int dato : miArreglo){
            System.out.println("Valor:" + dato);
        }
/* for tradicional       
        for (int i = 0; i <= 4; i++) {
            System.out.println("Valor:" + miArreglo[i]);          
        }*/
    }
}
