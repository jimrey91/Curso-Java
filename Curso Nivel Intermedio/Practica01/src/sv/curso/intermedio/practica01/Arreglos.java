/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica01;

/**
 *
 * @author Reyes
 */
public class Arreglos {
    static String nombres[];
    public static void main(String[] args) {
        nombres = new String[4];
        nombres[0] = "Josue";
        nombres[1] = "Luis";
        nombres[2] = "Perez";
        nombres[3] = "Gomez";
        try{
        System.out.println("Nombre: "+ nombres[0]);
        System.out.println("Nombre: "+ nombres[1]);
        System.out.println("Nombre: "+ nombres[2]);
        System.out.println("Nombre: "+ nombres[3]);
        
        System.out.println("Nombre: "+ nombres[5]);
        }catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Arreglo fuera de rango");
        }catch(Exception e2){
            System.out.println("Error General");
        }
    }
}
