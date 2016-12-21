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
public class BeanContribuyentes {
    private String noNit;
    private  String nombreContribuyente;
    private String razonSocial;
    private  String representanteLegal;
    private  String rentaAnual;
    private  Date fechaRegistro;
    private  String estado;

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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getRentaAnual() {
        return rentaAnual;
    }

    public void setRentaAnual(String rentaAnual) {
        this.rentaAnual = rentaAnual;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    /**
     * Creates a new instance of BeanContribuyentes
     */
    public BeanContribuyentes() {
    }
    
    public void limpiarContribuyentes(){
        this.noNit="";
        this.nombreContribuyente="";
        this.razonSocial="";
        this.representanteLegal="";
        this.rentaAnual="";
        this.fechaRegistro=null;    
    }
    
    public  void guardarContribuyente(){
        FacesMessage msg = new FacesMessage("Guardando Datos...");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
