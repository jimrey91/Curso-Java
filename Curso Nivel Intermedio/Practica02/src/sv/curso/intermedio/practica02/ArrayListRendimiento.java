/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList(INITIAL CAPACITY) 
 * Daniel
 */
public class ArrayListRendimiento {
    public static void main(String[] arg){
        
        long inicio1 = System.currentTimeMillis();
        List<Integer> lista = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            lista.add(i);
        }
        
    /*  lista.add(1);// 1 procesador 1 bloque
        lista.add(2);// 1 procesador 1 bloque
        lista.add(3);// 1 procesador 1 bloque
        lista.add(4);// 1 procesador 1 bloque
        lista.add(5);// 1 procesador 1 bloque */
        
        long fin1 = System.currentTimeMillis();
        
        System.out.println(fin1 - inicio1);
        
        long inicio2 = System.currentTimeMillis();
        List<Integer> lista2 = new ArrayList(1000000);
        
        for (int i = 0; i < 1000000; i++) {
            lista2.add(i);
        }
        // 1 procesador 5 bloques
    /*  lista2.add(1);// a cada bloque
        lista2.add(2);
        lista2.add(3);
        lista2.add(4);
        lista2.add(5);*/
        long fin2 = System.currentTimeMillis();
        
        System.out.println(fin2 - inicio2);
    }
}
