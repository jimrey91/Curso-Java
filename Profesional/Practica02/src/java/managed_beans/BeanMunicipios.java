/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mantenimientos.MantenimientoDepartamento;
import mantenimientos.MantenimientoMunicipio;
import persistencia.Departamentos;
import persistencia.Municipios;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanMunicipios {
    
    private String codigoDepartamento;
    private String codigoMunicipio;
    private String nombreMunicipio;
    private Map<String,String> departamentos = new HashMap<String, String>();

    public Map<String, String> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Map<String, String> departamentos) {
        this.departamentos = departamentos;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
    
    public void limpiarDatos(){
        this.codigoMunicipio = "";
        this.codigoDepartamento = "";
        this.nombreMunicipio = "";
        FacesMessage msg = new FacesMessage("Limpiando datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    public void consultarDatos(){
        MantenimientoMunicipio m = new MantenimientoMunicipio();
        Municipios d = m.consultarMunicipio(codigoDepartamento + codigoMunicipio);
        
        String advertencia = "";
        if (d!=null) {
            this.codigoDepartamento = d.getCodigoDepartamento();
            this.nombreMunicipio = d.getMunicipio();
            advertencia = "Consultando datos...";
        }else{
            advertencia = "Datos no encontrados";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public  void guardarDatos(){
        MantenimientoMunicipio m = new MantenimientoMunicipio();
        
        String advertencia = "";
        if (this.codigoDepartamento==null || this.codigoDepartamento.equals("")) {
            advertencia += "El codigo de departamento es obligatorio...<br>";
        }
        
        if (this.codigoMunicipio==null || this.codigoMunicipio.equals("")) {
            advertencia += "El codigo de municipio es obligatorio...<br>";
        }
        
        if (this.nombreMunicipio==null || this.nombreMunicipio.equals("")) {
            advertencia += "El nombre de municipio es obligatorio...<br>";
        }
        
        if (advertencia.equals("")) {
            Municipios mun = new Municipios();
            mun.setCodigoMunicipio(codigoDepartamento + codigoMunicipio);
            mun.setCodigoDepartamento(codigoDepartamento);
            mun.setMunicipio(nombreMunicipio);
            java.util.Date hoy = new java.util.Date();
            mun.setFechaCreacion(hoy);
            
            Municipios valMun = m.consultarMunicipio(codigoDepartamento + codigoMunicipio);
            if (valMun!=null) {
                advertencia ="Municipio ya esta registrado...";
            }else{
                if (m.guardarMunicipio(mun)==1) {
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
     * Creates a new instance of BeanMunicipios
     */
    public BeanMunicipios() {
        MantenimientoDepartamento man = new MantenimientoDepartamento();
        List<Departamentos>listaDepartamentos = man.consultarTodosDepartamentos();
        Iterator it = listaDepartamentos.iterator();
        while (it.hasNext()) {
            Departamentos d = (Departamentos) it.next();
            departamentos.put(d.getDepartamento(), d.getCodigoDepartamento());
        }
    }
}
