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
@Table(name = "TIPOS_DOCUMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDocumentos.findAll", query = "SELECT t FROM TiposDocumentos t"),
    @NamedQuery(name = "TiposDocumentos.findByCodigoDocumento", query = "SELECT t FROM TiposDocumentos t WHERE t.codigoDocumento = :codigoDocumento"),
    @NamedQuery(name = "TiposDocumentos.findByEstadoUsuario", query = "SELECT t FROM TiposDocumentos t WHERE t.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "TiposDocumentos.findByFechaCreacion", query = "SELECT t FROM TiposDocumentos t WHERE t.fechaCreacion = :fechaCreacion")})
public class TiposDocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_DOCUMENTO")
    private String codigoDocumento;
    @Basic(optional = false)
    @Column(name = "ESTADO_USUARIO")
    private String estadoUsuario;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public TiposDocumentos() {
    }

    public TiposDocumentos(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public TiposDocumentos(String codigoDocumento, String estadoUsuario, Date fechaCreacion) {
        this.codigoDocumento = codigoDocumento;
        this.estadoUsuario = estadoUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
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
        hash += (codigoDocumento != null ? codigoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDocumentos)) {
            return false;
        }
        TiposDocumentos other = (TiposDocumentos) object;
        if ((this.codigoDocumento == null && other.codigoDocumento != null) || (this.codigoDocumento != null && !this.codigoDocumento.equals(other.codigoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.TiposDocumentos[ codigoDocumento=" + codigoDocumento + " ]";
    }
    
}
