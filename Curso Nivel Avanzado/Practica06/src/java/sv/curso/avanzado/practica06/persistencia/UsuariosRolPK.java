/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.practica06.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Embeddable
public class UsuariosRolPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "CODIGO_ROL")
    private String codigoRol;
    @Basic(optional = false)
    @Column(name = "CODIGO_OPCION")
    private String codigoOpcion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public UsuariosRolPK() {
    }

    public UsuariosRolPK(String usuario, String codigoRol, String codigoOpcion, Date fechaCreacion) {
        this.usuario = usuario;
        this.codigoRol = codigoRol;
        this.codigoOpcion = codigoOpcion;
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (codigoRol != null ? codigoRol.hashCode() : 0);
        hash += (codigoOpcion != null ? codigoOpcion.hashCode() : 0);
        hash += (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRolPK)) {
            return false;
        }
        UsuariosRolPK other = (UsuariosRolPK) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if ((this.codigoRol == null && other.codigoRol != null) || (this.codigoRol != null && !this.codigoRol.equals(other.codigoRol))) {
            return false;
        }
        if ((this.codigoOpcion == null && other.codigoOpcion != null) || (this.codigoOpcion != null && !this.codigoOpcion.equals(other.codigoOpcion))) {
            return false;
        }
        if ((this.fechaCreacion == null && other.fechaCreacion != null) || (this.fechaCreacion != null && !this.fechaCreacion.equals(other.fechaCreacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.UsuariosRolPK[ usuario=" + usuario + ", codigoRol=" + codigoRol + ", codigoOpcion=" + codigoOpcion + ", fechaCreacion=" + fechaCreacion + " ]";
    }
    
}
