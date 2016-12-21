/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimientos.MantenimientoPaises;
import persistencia.Paises;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanPaises {
    private String codigoPais;
    private  String nombrePais;

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
   public void llimpiarDatos(){
       this.codigoPais = "";
       this.nombrePais = "";
       
       FacesMessage msg = new FacesMessage("Limpiando datos...");
       FacesContext.getCurrentInstance().addMessage(null, msg);
   } 
   
   public void consultarDatos(){
       MantenimientoPaises m = new MantenimientoPaises();
       Paises p = m.consultarPais(codigoPais);
       
       String advertencia="";
       if (p!=null) {
           this.codigoPais=p.getCodigoPais();
           this.nombrePais=p.getPais();
           advertencia="Consultando datos...";
       }else{
           advertencia = "Datos no encontrados";
       }
       
       FacesMessage msg = new FacesMessage(advertencia);
       FacesContext.getCurrentInstance().addMessage(null, msg);
   }
   
   public void guardarDatos(){
       MantenimientoPaises m = new MantenimientoPaises();
              
       String advertencia="";
       if (this.codigoPais==null || this.codigoPais.equals("")) {
           advertencia += "El codigo de pais es obligatorio...<br>";
       }
       if (this.nombrePais==null || this.nombrePais.equals("")) {
           advertencia += "El nombre de pais es obligatorio...<br>";
       }
       
       if (advertencia.equals("")) {
           Paises p = new Paises();
           p.setCodigoPais(codigoPais);
           p.setPais(nombrePais);
           java.util.Date hoy = new java.util.Date();
           p.setFechaCreacion(hoy);
           
           Paises valPais = m.consultarPais(codigoPais);
           if (valPais!=null) {
               advertencia = "Pais ya esta registrado...";
           }else{
               if (m.guardarPais(p)==1) {
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
     * Creates a new instance of BeanPaises
     */
    public BeanPaises() {
    }
}
