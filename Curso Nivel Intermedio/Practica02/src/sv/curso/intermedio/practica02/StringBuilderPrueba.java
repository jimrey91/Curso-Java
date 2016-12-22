
package sv.curso.intermedio.practica02;

/**
 *
 * @author Daniel
 */
public class StringBuilderPrueba {
    public static void main(String[] args) {
        
//        StringBuilder texto = new StringBuilder();
//        texto.append("Hola a todos").append("esto es una prueba");
//        
//        System.out.println(texto.toString());
        
        
        long tiempo_inicio = System.nanoTime();
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append(i);
        }
        
        long tiempo_fin = System.nanoTime();
        
        double diferencia = (tiempo_fin - tiempo_inicio);
        
        System.out.println(diferencia);
        
        //////////////////////////////////////////
        
        long tiempo_inicio2 = System.nanoTime();
        
        String texto2 = "";
        for (int i = 0; i < 1000; i++) {
            texto2 += i;
        }
        
        long tiempo_fin2 = System.nanoTime();
        
        double diferencia2 = (tiempo_fin2 - tiempo_inicio2);
        
        System.out.println(diferencia2);
    }
    
}
