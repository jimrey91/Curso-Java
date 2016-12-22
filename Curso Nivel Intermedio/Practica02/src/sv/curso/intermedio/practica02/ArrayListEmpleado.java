/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Reyes
 */
public class ArrayListEmpleado {
    public static void main(String[] args) {
        //Declaramos el objeto empleado del tipo ArrayList
        ArrayList<Empleado> empleado= new ArrayList<>();
        String cadena = JOptionPane.showInputDialog("Digite Nit y Nombre separados por con (,): ");
        
        StringTokenizer tokens = new StringTokenizer(cadena, ",");
        int posicion = 1;
        String noNit = "";
        String nombre ="";
        while(tokens.hasMoreTokens()){
            if(posicion==1) {
                noNit = tokens.nextToken().trim();
            }
            if(posicion==2) {
                nombre= tokens.nextToken().trim();
            }
            posicion++;
        }
        empleado.add(new Empleado(noNit, nombre));
        imprimirArrayList(empleado);        
        
        
    }
    public static void imprimirArrayList(ArrayList<Empleado> empleado){
        for (Empleado emp : empleado) {
            JOptionPane.showMessageDialog(null, "No nit: " + emp.getNoNit());
            JOptionPane.showMessageDialog(null, "Nombre: " + emp.getNombreContribuyente());
            System.out.println("No nit:" + emp.getNoNit());
            System.out.println("Nombre:" + emp.getNombreContribuyente());
        }
    }
}

class Empleado{
    private String noNit;
    private String nombreContribuyente;
    
    public Empleado(String noNit, String nombreContribuyente){
        this.noNit = noNit;
        this.nombreContribuyente = nombreContribuyente;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }
    
}