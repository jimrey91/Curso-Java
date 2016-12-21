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
@Table(name = "OPCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findByCodigoOpcion", query = "SELECT o FROM Opciones o WHERE o.codigoOpcion = :codigoOpcion"),
    @NamedQuery(name = "Opciones.findByNombreOpcion", query = "SELECT o FROM Opciones o WHERE o.nombreOpcion = :nombreOpcion"),
    @NamedQuery(name = "Opciones.findByFechaCreacion", query = "SELECT o FROM Opciones o WHERE o.fechaCreacion = :fechaCreacion")})
public class Opciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_OPCION")
    private String codigoOpcion;
    @Basic(optional = false)
    @Column(name = "NOMBRE_OPCION")
    private String nombreOpcion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Opciones() {
    }

    public Opciones(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public Opciones(String codigoOpcion, String nombreOpcion, Date fechaCreacion) {
        this.codigoOpcion = codigoOpcion;
        this.nombreOpcion = nombreOpcion;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
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
        hash += (codigoOpcion != null ? codigoOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.codigoOpcion == null && other.codigoOpcion != null) || (this.codigoOpcion != null && !this.codigoOpcion.equals(other.codigoOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.Opciones[ codigoOpcion=" + codigoOpcion + " ]";
    }
    
}
