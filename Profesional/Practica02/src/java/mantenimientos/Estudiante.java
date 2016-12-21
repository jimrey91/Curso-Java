/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientos;

/**
 *
 * @author Daniel
 */
public class Estudiante {
    private String noCarnet;
    private String apellidos;
    private String nombres;
    private String codigoCarrera;

    public Estudiante(String noCarnet, String apellidos, String nombres, String codigoCarrera) {
        this.noCarnet = noCarnet;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.codigoCarrera = codigoCarrera;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    
    
}
