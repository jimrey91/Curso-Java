/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.curso.intermedio.practico06.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "contribuyentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribuyentes.findAll", query = "SELECT c FROM Contribuyentes c"),
    @NamedQuery(name = "Contribuyentes.findByNoNit", query = "SELECT c FROM Contribuyentes c WHERE c.noNit = :noNit"),
    @NamedQuery(name = "Contribuyentes.findByNombreContribuyente", query = "SELECT c FROM Contribuyentes c WHERE c.nombreContribuyente = :nombreContribuyente"),
    @NamedQuery(name = "Contribuyentes.findByRazonSocial", query = "SELECT c FROM Contribuyentes c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Contribuyentes.findByRepresentanteLegal", query = "SELECT c FROM Contribuyentes c WHERE c.representanteLegal = :representanteLegal"),
    @NamedQuery(name = "Contribuyentes.findByRentaAnual", query = "SELECT c FROM Contribuyentes c WHERE c.rentaAnual = :rentaAnual"),
    @NamedQuery(name = "Contribuyentes.findByIdContribuyente", query = "SELECT c FROM Contribuyentes c WHERE c.idContribuyente = :idContribuyente")})
public class Contribuyentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "no_nit")
    private String noNit;
    @Column(name = "nombre_contribuyente")
    private String nombreContribuyente;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "representante_legal")
    private String representanteLegal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "renta_anual")
    private BigDecimal rentaAnual;
    @Basic(optional = false)
    @Column(name = "id_contribuyente")
    private int idContribuyente;

    public Contribuyentes() {
    }

    public Contribuyentes(String noNit) {
        this.noNit = noNit;
    }

    public Contribuyentes(String noNit, int idContribuyente) {
        this.noNit = noNit;
        this.idContribuyente = idContribuyente;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public BigDecimal getRentaAnual() {
        return rentaAnual;
    }

    public void setRentaAnual(BigDecimal rentaAnual) {
        this.rentaAnual = rentaAnual;
    }

    public int getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(int idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noNit != null ? noNit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contribuyentes)) {
            return false;
        }
        Contribuyentes other = (Contribuyentes) object;
        if ((this.noNit == null && other.noNit != null) || (this.noNit != null && !this.noNit.equals(other.noNit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.intermedio.practico06.persistencia.Contribuyentes[ noNit=" + noNit + " ]";
    }
    
}
