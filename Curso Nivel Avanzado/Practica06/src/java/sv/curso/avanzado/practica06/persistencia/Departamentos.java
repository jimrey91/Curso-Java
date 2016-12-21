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
@Table(name = "DEPARTAMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByCodigoDepartamento", query = "SELECT d FROM Departamentos d WHERE d.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "Departamentos.findByDepartamento", query = "SELECT d FROM Departamentos d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "Departamentos.findByFechaCreacion", query = "SELECT d FROM Departamentos d WHERE d.fechaCreacion = :fechaCreacion")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Basic(optional = false)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Departamentos() {
    }

    public Departamentos(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public Departamentos(String codigoDepartamento, String departamento, Date fechaCreacion) {
        this.codigoDepartamento = codigoDepartamento;
        this.departamento = departamento;
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
        hash += (codigoDepartamento != null ? codigoDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.codigoDepartamento == null && other.codigoDepartamento != null) || (this.codigoDepartamento != null && !this.codigoDepartamento.equals(other.codigoDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.Departamentos[ codigoDepartamento=" + codigoDepartamento + " ]";
    }
    
}
