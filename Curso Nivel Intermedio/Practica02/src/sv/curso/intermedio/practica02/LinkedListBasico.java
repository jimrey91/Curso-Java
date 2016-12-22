/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class LinkedListBasico {
    public static void main(String[] args) {
        List listaMatriculas = new LinkedList();
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Digite la primer matricula:");
        String nombre1 = lector.next().toUpperCase();
        System.out.println("Digite la segunda matricula:");
        String nombre2 = lector.next().toUpperCase();
        System.out.println("Digite la tercera matricula:");
        String nombre3 = lector.next().toUpperCase();
        
        listaMatriculas.add(0, nombre1);
        listaMatriculas.add(1, nombre2);
        listaMatriculas.add(2, nombre3);
        
        imprimirLinkedList(listaMatriculas);
    }
    public static void imprimirLinkedList(List listaMatriculas){
        Iterator it = listaMatriculas.iterator();
        while(it.hasNext()){
            System.out.println("Matricula: "+ it.next());
        }
    }
}
