package sv.curso.avanzado.persistencia;
// Generated 09-30-2013 10:46:34 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Opciones generated by hbm2java
 */
public class Opciones  implements java.io.Serializable {


     private String codigoOpcion;
     private String nombreOpcion;
     private Date fechaCreacion;

    public Opciones() {
    }

    public Opciones(String codigoOpcion, String nombreOpcion, Date fechaCreacion) {
       this.codigoOpcion = codigoOpcion;
       this.nombreOpcion = nombreOpcion;
       this.fechaCreacion = fechaCreacion;
    }
   
    public String getCodigoOpcion() {
        return this.codigoOpcion;
    }
    
    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }
    public String getNombreOpcion() {
        return this.nombreOpcion;
    }
    
    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




}


