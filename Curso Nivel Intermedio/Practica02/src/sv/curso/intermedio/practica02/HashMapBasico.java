/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class HashMapBasico {
    public static void main(String[] args) {
        
        Map<String,String> mapa = new HashMap();
        HashMap<Integer, String> empleados = new HashMap<>();
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Digite el primer nombre:");
        String nombre1 = lector.next().toUpperCase();
        System.out.println("Digite el segundo nombre:");
        String nombre2 = lector.next().toUpperCase();
        System.out.println("Digite el tercer nombre:");
        String nombre3 = lector.next().toUpperCase();
        
        empleados.put(1, nombre1);
        empleados.put(2, nombre2);
        empleados.put(3, nombre3);
        
        imprimirHashtable(empleados);
        
    }
    public static void imprimirHashtable(HashMap<Integer, String> empleados ){
        for (String emp: empleados.values()) {
            System.out.println("Nombre empleado: " + emp);            
        }
        
    } 
}
