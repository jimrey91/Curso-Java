package sv.curso.intermedio.practica02;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class VectorParalelo {
    public static void main(String[] args) {
        String nombres[] = new String[3];
        int edades[] = new int[3];
        
        for (int i = 0; i < 3; i++) {
            Scanner lector = new Scanner(System.in);
            System.out.println("Ingrese nombre: ");
            nombres[i] = lector.next();
            System.out.println("Ingrese edad: ");
            edades[i] = lector.nextInt();
        }
        System.out.println("--------------------");
//        for (int i = 0; i < 3; i++) {
//            if (edades[i] == 23) {
//                System.out.println(nombres[i] + " " + edades[i]);
//            }
//            System.out.println(nombres[i] + " " + edades[i]);
//        }
        
        //Encontrar mayor elemento
        int mayor = edades[0];
        int posicion = 0;
        
        for (int i = 0; i < 3; i++) {
            if (edades[i] > mayor) {
                mayor = edades[i];
                posicion = i;
            }
        }
        System.out.println("El mayor es : " + mayor);
        System.out.println("Su nombre es : " + nombres[posicion]);
    }
}
