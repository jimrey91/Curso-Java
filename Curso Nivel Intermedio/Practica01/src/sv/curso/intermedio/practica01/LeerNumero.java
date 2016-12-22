/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica01;

import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class LeerNumero {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Digite un numero");
        try{
        int numero = lector.nextInt();
        System.out.println("El numero es:"+ numero);
        }catch(Exception e){
            System.out.println("Error al leer el mensaje");
        }
    }
}
