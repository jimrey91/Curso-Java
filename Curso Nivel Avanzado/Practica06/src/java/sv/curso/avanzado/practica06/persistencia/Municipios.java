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
@Table(name = "MUNICIPIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByCodigoMunicipio", query = "SELECT m FROM Municipios m WHERE m.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Municipios.findByMunicipio", query = "SELECT m FROM Municipios m WHERE m.municipio = :municipio"),
    @NamedQuery(name = "Municipios.findByCodigoDepartamento", query = "SELECT m FROM Municipios m WHERE m.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "Municipios.findByFechaCreacion", query = "SELECT m FROM Municipios m WHERE m.fechaCreacion = :fechaCreacion")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_MUNICIPIO")
    private String codigoMunicipio;
    @Basic(optional = false)
    @Column(name = "MUNICIPIO")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Municipios() {
    }

    public Municipios(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Municipios(String codigoMunicipio, String municipio, String codigoDepartamento, Date fechaCreacion) {
        this.codigoMunicipio = codigoMunicipio;
        this.municipio = municipio;
        this.codigoDepartamento = codigoDepartamento;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
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
        hash += (codigoMunicipio != null ? codigoMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.codigoMunicipio == null && other.codigoMunicipio != null) || (this.codigoMunicipio != null && !this.codigoMunicipio.equals(other.codigoMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.Municipios[ codigoMunicipio=" + codigoMunicipio + " ]";
    }
    
}
