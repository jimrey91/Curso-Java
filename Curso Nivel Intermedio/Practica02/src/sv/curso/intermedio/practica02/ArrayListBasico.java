/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Reyes
 */
public class ArrayListBasico {
    public static void main(String[] args) {
        List <String> listaNombres = new ArrayList<>();
        listaNombres.add("Juan");
        listaNombres.add("Jose");
        listaNombres.add("Carlos");
        imprimirLista(listaNombres);
    }
    public static void imprimirLista(List<String> listaNombres){
        for (Iterator <String> listaIterator = listaNombres.iterator(); listaIterator.hasNext();) {
            System.out.println("Nombre:" + listaIterator.next());
        }
    }
}
