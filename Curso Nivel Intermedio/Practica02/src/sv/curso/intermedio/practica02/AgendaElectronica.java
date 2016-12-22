/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.practica02;

import java.io.*;
import java.util.*;


/**
 *
 * @author Reyes
 */
public class AgendaElectronica {
    public static void main(String[] args)  {
        ArrayList<Persona> persona = new ArrayList<>();
        
        Scanner s = new Scanner(System.in);
        String opcion= null; 
        String continuar = "S";
        String telefono = null, nombre = null, direccion ="";
        
        while(continuar.equalsIgnoreCase("S")){
        try {
            File fichero = new File("D:/AgendaElectronica.txt");
            FileWriter fw = new FileWriter(fichero, true);
            
            System.out.println("Operacion a realizar: A=Agregar, C=Consultar, M=Modificar, E=Eliminar");
            opcion = s.nextLine();
            if(opcion.equalsIgnoreCase("A")){
            System.out.println("Ingrese: telefono, nombre, direccion");
            String datos = s.nextLine();
            
            StringTokenizer st = new StringTokenizer(datos, ",");
            int posicion = 1;
            
            while (st.hasMoreTokens()) {
                if(posicion==1){
                telefono = st.nextToken().trim();
                }
                if(posicion==2){
                nombre = st.nextToken().trim();
                }
                if(posicion==3){
                direccion = st.nextToken().trim();
                }
                posicion++;
            }
            
        persona.add(new Persona(telefono, nombre, direccion));
        Iterator<Persona> itrPer = persona.iterator();
        while (itrPer.hasNext()) {
            Persona personas = (Persona)itrPer.next();
            fw.write("Telefono: \n " +personas.getTelefono());
            fw.write(" Nombre: \n" +personas.getNombre());
            fw.write(" Direccion: \n"+personas.getDireccion());
            fw.close();
        }
            }else if(opcion.equalsIgnoreCase("C")){
                System.out.println("Digite telefono");
                telefono = s.nextLine();
                Iterator<Persona> itrPer = persona.iterator();
                while (itrPer.hasNext()) {
                    Persona personas = itrPer.next();
                    if(personas.getTelefono().equals(telefono))
                        System.out.println(persona.size());
                }//21454532 
            }else if(opcion.equalsIgnoreCase("M")){
                
            }else if(opcion.equalsIgnoreCase("E")){
                System.out.println("Digite telefono");
                telefono = s.nextLine();
                Iterator<Persona> itrPer = persona.iterator();
                while (itrPer.hasNext()) {
                    Persona personas = itrPer.next();
                    if(personas.getTelefono().equals(telefono))
                        persona.clear();
                }
            }else{
                System.out.println("Opcion invalida");
            }
            System.out.println("Presione S para continuar o N para salir:");
            continuar = s.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
    } 

    
}


class Persona{
    private String telefono;
    private String nombre;
    private String direccion;
    
    public Persona(String telefono, String nombre, String direccion){
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}