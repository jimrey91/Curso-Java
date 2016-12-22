
package sv.curso.intermedio.practica02;

import java.util.HashSet;
import java.util.Set;

public class Hashset {
    
    public static void main(String[] args) {
        Set<String> lista = new HashSet<>();
       //La lista es arrojada de manera aleatoria
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");
        
        for (String dato : lista) {
            System.out.println(dato);
        }
    }
    
}
