/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.practica06.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "ESTADOS_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosUsuario.findAll", query = "SELECT e FROM EstadosUsuario e"),
    @NamedQuery(name = "EstadosUsuario.findByCodigoEstado", query = "SELECT e FROM EstadosUsuario e WHERE e.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "EstadosUsuario.findByEstadoUsuario", query = "SELECT e FROM EstadosUsuario e WHERE e.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "EstadosUsuario.findByFechaCreacion", query = "SELECT e FROM EstadosUsuario e WHERE e.fechaCreacion = :fechaCreacion")})
public class EstadosUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ESTADO")
    private String codigoEstado;
    @Basic(optional = false)
    @Column(name = "ESTADO_USUARIO")
    private String estadoUsuario;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public EstadosUsuario() {
    }

    public EstadosUsuario(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public EstadosUsuario(String codigoEstado, String estadoUsuario, Date fechaCreacion) {
        this.codigoEstado = codigoEstado;
        this.estadoUsuario = estadoUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
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
        hash += (codigoEstado != null ? codigoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosUsuario)) {
            return false;
        }
        EstadosUsuario other = (EstadosUsuario) object;
        if ((this.codigoEstado == null && other.codigoEstado != null) || (this.codigoEstado != null && !this.codigoEstado.equals(other.codigoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.EstadosUsuario[ codigoEstado=" + codigoEstado + " ]";
    }
    
}
