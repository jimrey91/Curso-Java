package sv.curso.avanzado.persistencia;
// Generated 09-30-2013 10:46:34 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TiposUsuario generated by hbm2java
 */
public class TiposUsuario  implements java.io.Serializable {


     private String codigoTipo;
     private String tipoUsuario;
     private Date fechaCreacion;

    public TiposUsuario() {
    }

    public TiposUsuario(String codigoTipo, String tipoUsuario, Date fechaCreacion) {
       this.codigoTipo = codigoTipo;
       this.tipoUsuario = tipoUsuario;
       this.fechaCreacion = fechaCreacion;
    }
   
    public String getCodigoTipo() {
        return this.codigoTipo;
    }
    
    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




}

