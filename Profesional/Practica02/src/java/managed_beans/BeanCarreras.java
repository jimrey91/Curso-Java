/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimientos.MantenimientoCarreras;
import persistencia.Carreras;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanCarreras {
    private String codigoCarrera;
    private String nombreCarrera;

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
    public void limpiarDatos(){
        this.codigoCarrera="";
        this.nombreCarrera="";
        FacesMessage msg = new FacesMessage("Limpiando datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void consultarDatos(){
        MantenimientoCarreras man = new MantenimientoCarreras();
        Carreras c = man.consultarCarrera(codigoCarrera);
        
        String advertencia="";
        if (c!=null) {
            this.codigoCarrera=c.getCodigoCarrera();
            this.nombreCarrera=c.getCarrera();
            advertencia="Consultando datos...";
        }else{
            advertencia="Datos no encontrados...";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void guardarDatos(){
        MantenimientoCarreras man = new MantenimientoCarreras();
                
        String advertencia="";
        if (this.codigoCarrera==null ||this.codigoCarrera.equals("")) {
            advertencia += "El codigo de carrera es obligatorio...<br>";
        }
        
        if (this.nombreCarrera==null || this.nombreCarrera.equals("")) {
            advertencia += "El nombre de carrera es obligatorio...<br>";
        }
        
        if (advertencia.equals("")) {
            Carreras carreras = new Carreras();
            carreras.setCodigoCarrera(codigoCarrera);
            carreras.setCarrera(nombreCarrera);
            java.util.Date hoy = new java.util.Date();
            carreras.setFechaCreacion(hoy);
            
            Carreras valCarrera = man.consultarCarrera(codigoCarrera);
            if (valCarrera!=null) {
                advertencia = "Carrera ya esta registrada...";
            }else{
                if (man.guardarCarrera(carreras)==1) {
                    advertencia = "Datos almacenados satisfactoriamente...";
                }else{
                    advertencia = "Error al tratar de almacenar datos...";
                }
            }
        }
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    /**
     * Creates a new instance of BeanCarreras
     */
    public BeanCarreras() {
    }
}
