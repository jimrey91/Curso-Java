
package sv.curso.intermedio.practica02;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class LinkedxArrayList {
    
    public static void main(String[] args) {
        
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        // ArrayList add
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        System.out.println("ArrayList add: " + duracion);
        
        //LinkedList add
        inicio = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("LinkedList add: " + duracion);
        
        //ArrayList get
        inicio = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("ArrayList get: " + duracion);
        
        //LinkedList get
        inicio = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);                     
        }
        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("LinkedList get: " + duracion);
        
        //ArrayList remove
        inicio = System.currentTimeMillis();
        
        for (int i = 9999; i >= 0; i--) {
            arrayList.remove(i);
        }
        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("ArrayList remove: " + duracion);
        
        //LinkedList remove
        inicio = System.currentTimeMillis();
        for (int i = 9999; i >= 0; i--) {
            arrayList.remove(i);
        }
        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("LinkedList remove: " + duracion);
        
    }
    
}
