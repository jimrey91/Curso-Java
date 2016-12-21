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
@Table(name = "TIPOS_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposUsuario.findAll", query = "SELECT t FROM TiposUsuario t"),
    @NamedQuery(name = "TiposUsuario.findByCodigoTipo", query = "SELECT t FROM TiposUsuario t WHERE t.codigoTipo = :codigoTipo"),
    @NamedQuery(name = "TiposUsuario.findByTipoUsuario", query = "SELECT t FROM TiposUsuario t WHERE t.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "TiposUsuario.findByFechaCreacion", query = "SELECT t FROM TiposUsuario t WHERE t.fechaCreacion = :fechaCreacion")})
public class TiposUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_TIPO")
    private String codigoTipo;
    @Basic(optional = false)
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public TiposUsuario() {
    }

    public TiposUsuario(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public TiposUsuario(String codigoTipo, String tipoUsuario, Date fechaCreacion) {
        this.codigoTipo = codigoTipo;
        this.tipoUsuario = tipoUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        hash += (codigoTipo != null ? codigoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposUsuario)) {
            return false;
        }
        TiposUsuario other = (TiposUsuario) object;
        if ((this.codigoTipo == null && other.codigoTipo != null) || (this.codigoTipo != null && !this.codigoTipo.equals(other.codigoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.TiposUsuario[ codigoTipo=" + codigoTipo + " ]";
    }
    
}
