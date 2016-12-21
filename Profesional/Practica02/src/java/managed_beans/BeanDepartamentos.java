/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimientos.MantenimientoDepartamento;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import persistencia.Departamentos;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanDepartamentos {
    
    private FileUpload archivo;

    public FileUpload getArchivo() {
        return archivo;
    }

    public void setArchivo(FileUpload archivo) {
        this.archivo = archivo;
    }

    
    private CartesianChartModel cartesiano;

    public CartesianChartModel getCartesiano() {
        return cartesiano;
    }

    public void setCartesiano(CartesianChartModel cartesiano) {
        this.cartesiano = cartesiano;
    }

    
    
    
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
        this.codigoDepartamento = "";
        this.nombreDepartamento = "";
        FacesMessage msg = new FacesMessage("Limpiando datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void consultarDatos(){
        MantenimientoDepartamento man = new MantenimientoDepartamento();
        Departamentos d = man.consultarDepartamentos(codigoDepartamento);
        
        String advertencia = "";
        if (d != null) {
            this.codigoDepartamento = d.getCodigoDepartamento();
            this.nombreDepartamento = d.getDepartamento();
            advertencia = "Consultando datos";
            
        }else{
            advertencia = "Datos no encontrados";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void guardarDatos(){
        MantenimientoDepartamento m = new MantenimientoDepartamento();
        
        String advertencia="";
        if (this.codigoDepartamento==null || this.codigoDepartamento.equals("")) {
            advertencia += "El codigo de departamento es obligatorio...<br>";
        }
        
        if (this.nombreDepartamento==null || this.nombreDepartamento.equals("")) {
            advertencia += "El nombre de departamento es obligatorio...<br>";
        }
        
        if (advertencia.equals("")) {
            Departamentos d = new Departamentos();
            d.setCodigoDepartamento(codigoDepartamento);
            d.setDepartamento(nombreDepartamento);
            java.util.Date hoy = new java.util.Date();
            d.setFechaCreacion(hoy);
            
            Departamentos valDepto = m.consultarDepartamentos(codigoDepartamento);
            if (valDepto!=null) {
                advertencia = "Departamento ya esta registrado...";
            }else{
                if (m.guardarDepartamento(d)==1) {
                    advertencia = "Datos almacenados satisfactoriamente...";
                }else{
                    advertencia = "Error al tratar de almacenar datos..";
                }
            }
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     * Creates a new instance of BeanDepartamentos
     */
    public BeanDepartamentos() {
        
        cartesiano = new CartesianChartModel();
        
        ChartSeries ventas = new ChartSeries();
        ventas.setLabel("Ventas");
        ventas.set("2004", 1000);
        ventas.set("2005", 1170);
        ventas.set("2006", 660);
        ventas.set("2007", 1030);
        
        ChartSeries costos = new ChartSeries();
        costos.setLabel("Costos");
        costos.set("2004", 400);
        costos.set("2005", 460);
        costos.set("2006", 1120);
        costos.set("2007", 540);
        
        cartesiano.addSeries(ventas);
        cartesiano.addSeries(costos);
    }
    
}
