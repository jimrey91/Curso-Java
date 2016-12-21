/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanMascara {
    
    private String fechaNacimiento;
    private  String telefonoDomicilio;
    private  String noNit;

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    /**
     * Creates a new instance of BeanMascara
     */
    public BeanMascara() {
        
    }
    
    public  void limpiarDatos(){
        this.fechaNacimiento="";
        this.telefonoDomicilio="";
        this.noNit="";
    }
    
    public void guardarDatos(){
        FacesMessage msg = new FacesMessage("Guardando Datos...");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
