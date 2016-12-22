/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class VectorOrdenamiento {
    public static void main(String... hola){
        String[] nombres = new String[3];
        int[] edades = new int[3];
        
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese nombre: ");
            nombres[i] = sc.next();
            System.out.println("Ingrese edad: ");
            edades[i] = sc.nextInt();
        }
        
        int aux;
        String aux2;
        
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2 - i; j++) {
              //Ordenar numeros enteros
               if(edades[j] > edades[j + 1]){
                  aux = edades[j];
                  edades[j] = edades[j + 1];
                  edades[j + 1] = aux;
               }
               //Ordenar caracteres
                if (nombres[j].compareTo(nombres[j + 1]) > 0 ) {
                    aux2 = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = aux2;
                }
            }
        }
        System.out.println("---------------------");
        
        for(Integer lista : edades){
            System.out.println(lista);
        }
        
        System.out.println("---------------------");
        
        for(String lista2 : nombres){
            System.out.println(lista2);
        }
    }
}
