/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByCarnet", query = "SELECT e FROM Estudiantes e WHERE e.carnet = :carnet"),
    @NamedQuery(name = "Estudiantes.findByApellidos", query = "SELECT e FROM Estudiantes e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Estudiantes.findByNombres", query = "SELECT e FROM Estudiantes e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Estudiantes.findByDireccion", query = "SELECT e FROM Estudiantes e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Estudiantes.findByTelefono", query = "SELECT e FROM Estudiantes e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Estudiantes.findByCodigoPais", query = "SELECT e FROM Estudiantes e WHERE e.codigoPais = :codigoPais"),
    @NamedQuery(name = "Estudiantes.findByCodigoDepartamento", query = "SELECT e FROM Estudiantes e WHERE e.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "Estudiantes.findByCodigoMunicipio", query = "SELECT e FROM Estudiantes e WHERE e.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Estudiantes.findByCodigoCarrera", query = "SELECT e FROM Estudiantes e WHERE e.codigoCarrera = :codigoCarrera"),
    @NamedQuery(name = "Estudiantes.findByFechaCreacion", query = "SELECT e FROM Estudiantes e WHERE e.fechaCreacion = :fechaCreacion")})
public class Estudiantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CARNET")
    private String carnet;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "CODIGO_PAIS")
    private String codigoPais;
    @Basic(optional = false)
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Basic(optional = false)
    @Column(name = "CODIGO_MUNICIPIO")
    private String codigoMunicipio;
    @Basic(optional = false)
    @Column(name = "CODIGO_CARRERA")
    private String codigoCarrera;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Estudiantes() {
    }

    public Estudiantes(String carnet) {
        this.carnet = carnet;
    }

    public Estudiantes(String carnet, String apellidos, String nombres, String direccion, String codigoPais, String codigoDepartamento, String codigoMunicipio, String codigoCarrera, Date fechaCreacion) {
        this.carnet = carnet;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.codigoPais = codigoPais;
        this.codigoDepartamento = codigoDepartamento;
        this.codigoMunicipio = codigoMunicipio;
        this.codigoCarrera = codigoCarrera;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
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
        hash += (carnet != null ? carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Estudiantes[ carnet=" + carnet + " ]";
    }
    
}
