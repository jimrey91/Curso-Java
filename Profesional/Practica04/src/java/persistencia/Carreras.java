/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
@Table(name = "CARRERAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c"),
    @NamedQuery(name = "Carreras.findByCodigoCarrera", query = "SELECT c FROM Carreras c WHERE c.codigoCarrera = :codigoCarrera"),
    @NamedQuery(name = "Carreras.findByCarrera", query = "SELECT c FROM Carreras c WHERE c.carrera = :carrera"),
    @NamedQuery(name = "Carreras.findByFechaCreacion", query = "SELECT c FROM Carreras c WHERE c.fechaCreacion = :fechaCreacion")})
public class Carreras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_CARRERA")
    private String codigoCarrera;
    @Basic(optional = false)
    @Column(name = "CARRERA")
    private String carrera;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Carreras() {
    }

    public Carreras(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Carreras(String codigoCarrera, String carrera, Date fechaCreacion) {
        this.codigoCarrera = codigoCarrera;
        this.carrera = carrera;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
        hash += (codigoCarrera != null ? codigoCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.codigoCarrera == null && other.codigoCarrera != null) || (this.codigoCarrera != null && !this.codigoCarrera.equals(other.codigoCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Carreras[ codigoCarrera=" + codigoCarrera + " ]";
    }
    
}
