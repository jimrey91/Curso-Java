/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import java.util.Date;
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
public class BeanCalendario {
    private  Date fechaCalendario;

    public Date getFechaCalendario() {
        return fechaCalendario;
    }

    public void setFechaCalendario(Date fechaCalendario) {
        this.fechaCalendario = fechaCalendario;
    }

    /**
     * Creates a new instance of BeanCalendario
     */
    public BeanCalendario() {
    }
    
    public  void limpiarDatos(){
        this.fechaCalendario=null;
    }
    
    public  void guardarDatos(){
        String mensaje="";
        
        if (this.fechaCalendario==null) {
            mensaje = "La fecha de registro es requerida...";
        }else{
            mensaje="Guardando datos";
        }
        FacesMessage msg = new FacesMessage(mensaje);
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
