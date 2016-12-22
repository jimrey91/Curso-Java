/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica01;

import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author Reyes
 */
public class Division {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        
        System.out.println("Digite el valor 1:");
        int valor1 = lector.nextInt();
        System.out.println("Digite el valor 2:");
        int valor2 = lector.nextInt();
        
        try{
        int resultado = metodo1(valor1, valor2);
        System.out.println("Resultado:"+ resultado);
        }catch(Exception e){
            System.out.println("Error al Dividir");
        }
    }
    
    public static int metodo1(int valor1, int valor2) throws Exception{
        int resultado = metodo2(valor1, valor2);
        System.out.println("Trato Error Metodo1");
        return resultado;
    }
    
    public static int metodo2(int valor1, int valor2) throws Exception{
        int resultado = valor1 / valor2;
        System.out.println("Trato Error Metodo2");
        return resultado;
    }
}
