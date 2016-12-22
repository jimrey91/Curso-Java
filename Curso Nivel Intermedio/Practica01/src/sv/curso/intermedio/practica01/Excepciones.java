
package sv.curso.intermedio.practica01;

import java.util.Scanner;


public class Excepciones {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingree su edad");
        int edad = sc.nextInt();
        final int EDAD_MENOR = 100;
        
        try {         
            if (edad < EDAD_MENOR) {
                System.out.println("Bienvenido");
            }else{
                throw new EdadExcepcion("edad no permitida");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
