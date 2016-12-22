
package sv.curso.intermedio.practica02;


public class Hilo extends Thread{
    
    private String nombre;
    
    public Hilo(){
        
    }
    
    public Hilo(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(nombre + "-" +i);
        }
    }
}

class pruebaHilo{
    
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1");
        hilo1.start();
        
        Hilo hilo2 = new Hilo("Hilo 2");
        hilo2.start();
    }
}
