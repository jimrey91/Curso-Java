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
public class BeanPersona {
    
        private String nombres;
        private String apellidos;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
        
    /**
     * Creates a new instance of BeanPersona
     */
    public BeanPersona() {
    }
    
    public  void  guardarPersona(){
        FacesMessage msg = new FacesMessage("Guardando Datos...");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
