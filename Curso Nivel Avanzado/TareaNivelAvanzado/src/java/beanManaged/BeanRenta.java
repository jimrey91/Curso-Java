/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManaged;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
public class BeanRenta {
    private  String noNit;
    private  String nombre;
    private  double salarioAnual;
    private  double aguinaldo;
    private  double ingresosServicios;

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public double getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(double aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public double getIngresosServicios() {
        return ingresosServicios;
    }

    public void setIngresosServicios(double ingresosServicios) {
        this.ingresosServicios = ingresosServicios;
    }
    
        
    /**
     * Creates a new instance of BeanRenta
     */
    public BeanRenta() {
    }
    public  void limpiar(){
        this.noNit = "";
        this.nombre="";
        this.salarioAnual=0.00;
        this.aguinaldo=0.00;
        this.ingresosServicios=0.00;
        
    }
    
    public  void guardarRenta(){
        String mensaje = "";
       
        double afp = (this.salarioAnual) * (6.25/100);
        double rimp = (this.salarioAnual) - afp;
        
        NumberFormat formato = new DecimalFormat("$##,###.##");
        
//        //Tramo I
        if(rimp <= 4064.00){              
               mensaje =  "Exento de impuesto";
          //Tramo II
        }else if(rimp <= 9142.86){
            double rimpt = 0.10 * (rimp - 2514.29) + 212.12;
            mensaje = "La renta imponible es de: " + formato.format(rimpt);
          //Tramo III
        }else if(rimp <= 22857.14){
            double rimpt = 0.20 * (rimp - 9142.87) + 720.00;
            mensaje = "La renta imponible es de: " + formato.format(rimpt);
          //Tramo IV
        }else if(rimp >= 22857.15){
           double rimpt = 0.30 *(rimp - 22857.15) + 3482.86;
         mensaje = "La renta imponible es de:" + formato.format(rimpt);
        }
        FacesMessage msg = new FacesMessage(mensaje);
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
