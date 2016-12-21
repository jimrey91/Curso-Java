/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed_beans;

import facades.DepartamentosFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import persistencia.Departamentos;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanDepartamentos {
    @EJB
    private DepartamentosFacadeLocal departamentosFacade;
    
    private String codigoDepartamento;
    private String nombreDepartamento;

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public void limpiarDatos(){
        this.codigoDepartamento="";
        this.nombreDepartamento="";
        
        FacesMessage msg = new FacesMessage("Limpiando datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void consultarDatos(){
        String advertencia="";
        
        Departamentos depto = new Departamentos();
        depto = departamentosFacade.find(codigoDepartamento);
        
        if (depto!=null) {
            this.codigoDepartamento = depto.getCodigoDepartamento();
            this.nombreDepartamento = depto.getDepartamento();
            advertencia = "Consultando datos";
        }else{
            advertencia = "Datos no encontrados";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void guardarDatos(){
        String advertencia="";
        
        Departamentos depto = new Departamentos();
        depto = departamentosFacade.find(codigoDepartamento);
        
        if (depto == null) {
            Departamentos d = new Departamentos();
            d.setCodigoDepartamento(codigoDepartamento);
            d.setDepartamento(nombreDepartamento);
            java.util.Date hoy = new java.util.Date();
            d.setFechaCreacion(hoy);
            
            departamentosFacade.create(d);
            advertencia = "Guardando datos";
        } else {
            advertencia = "Departamento ya esta registrado...";
        }      
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    /**
     * Creates a new instance of BeanDepartamentos
     */
    public BeanDepartamentos() {
    }
    
}
