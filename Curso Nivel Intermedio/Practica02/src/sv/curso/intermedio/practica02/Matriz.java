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
public class Matriz {
    public static void main(String[] args) {
        int fila;
        int columna;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de filas: ");
        fila = sc.nextInt();
        System.out.println("Ingrese numero de columnas: ");
        columna = sc.nextInt();
        int[][] numeros = new int[fila][columna];
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                System.out.println("Ingrese elemento para la posicion fila: "+ i + " Columna: " + j);
                numeros[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                System.out.print(numeros[i][j]+ "\t");
           }
            System.out.print("\n");
        }
    }
}
