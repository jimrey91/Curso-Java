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
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByTipoDocumento", query = "SELECT u FROM Usuarios u WHERE u.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Usuarios.findByNombreDocumento", query = "SELECT u FROM Usuarios u WHERE u.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "Usuarios.findByNoNit", query = "SELECT u FROM Usuarios u WHERE u.noNit = :noNit"),
    @NamedQuery(name = "Usuarios.findByCodigoPais", query = "SELECT u FROM Usuarios u WHERE u.codigoPais = :codigoPais"),
    @NamedQuery(name = "Usuarios.findByCodigoDepartamento", query = "SELECT u FROM Usuarios u WHERE u.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "Usuarios.findByCodigoMunicipio", query = "SELECT u FROM Usuarios u WHERE u.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Usuarios.findByDireccionParticular", query = "SELECT u FROM Usuarios u WHERE u.direccionParticular = :direccionParticular"),
    @NamedQuery(name = "Usuarios.findByTelefonoParticular", query = "SELECT u FROM Usuarios u WHERE u.telefonoParticular = :telefonoParticular"),
    @NamedQuery(name = "Usuarios.findByDireccionTrabajoUsuario", query = "SELECT u FROM Usuarios u WHERE u.direccionTrabajoUsuario = :direccionTrabajoUsuario"),
    @NamedQuery(name = "Usuarios.findByTelefonoTrabajoUsuario", query = "SELECT u FROM Usuarios u WHERE u.telefonoTrabajoUsuario = :telefonoTrabajoUsuario"),
    @NamedQuery(name = "Usuarios.findByFaxUsuario", query = "SELECT u FROM Usuarios u WHERE u.faxUsuario = :faxUsuario"),
    @NamedQuery(name = "Usuarios.findByCorreoElectronico", query = "SELECT u FROM Usuarios u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuarios.findByEstadoUsuario", query = "SELECT u FROM Usuarios u WHERE u.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Usuarios.findByFechaCreacion", query = "SELECT u FROM Usuarios u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuarios.findByTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    @Basic(optional = false)
    @Column(name = "NO_NIT")
    private String noNit;
    @Basic(optional = false)
    @Column(name = "CODIGO_PAIS")
    private String codigoPais;
    @Basic(optional = false)
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Basic(optional = false)
    @Column(name = "CODIGO_MUNICIPIO")
    private String codigoMunicipio;
    @Column(name = "DIRECCION_PARTICULAR")
    private String direccionParticular;
    @Column(name = "TELEFONO_PARTICULAR")
    private String telefonoParticular;
    @Column(name = "DIRECCION_TRABAJO_USUARIO")
    private String direccionTrabajoUsuario;
    @Column(name = "TELEFONO_TRABAJO_USUARIO")
    private String telefonoTrabajoUsuario;
    @Column(name = "FAX_USUARIO")
    private String faxUsuario;
    @Basic(optional = false)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "ESTADO_USUARIO")
    private String estadoUsuario;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;

    public Usuarios() {
    }

    public Usuarios(String usuario) {
        this.usuario = usuario;
    }

    public Usuarios(String usuario, String primerApellido, String segundoApellido, String nombres, String tipoDocumento, String nombreDocumento, String noNit, String codigoPais, String codigoDepartamento, String codigoMunicipio, String correoElectronico, String estadoUsuario, Date fechaCreacion) {
        this.usuario = usuario;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombres = nombres;
        this.tipoDocumento = tipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.noNit = noNit;
        this.codigoPais = codigoPais;
        this.codigoDepartamento = codigoDepartamento;
        this.codigoMunicipio = codigoMunicipio;
        this.correoElectronico = correoElectronico;
        this.estadoUsuario = estadoUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
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

    public String getDireccionParticular() {
        return direccionParticular;
    }

    public void setDireccionParticular(String direccionParticular) {
        this.direccionParticular = direccionParticular;
    }

    public String getTelefonoParticular() {
        return telefonoParticular;
    }

    public void setTelefonoParticular(String telefonoParticular) {
        this.telefonoParticular = telefonoParticular;
    }

    public String getDireccionTrabajoUsuario() {
        return direccionTrabajoUsuario;
    }

    public void setDireccionTrabajoUsuario(String direccionTrabajoUsuario) {
        this.direccionTrabajoUsuario = direccionTrabajoUsuario;
    }

    public String getTelefonoTrabajoUsuario() {
        return telefonoTrabajoUsuario;
    }

    public void setTelefonoTrabajoUsuario(String telefonoTrabajoUsuario) {
        this.telefonoTrabajoUsuario = telefonoTrabajoUsuario;
    }

    public String getFaxUsuario() {
        return faxUsuario;
    }

    public void setFaxUsuario(String faxUsuario) {
        this.faxUsuario = faxUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.Usuarios[ usuario=" + usuario + " ]";
    }
    
}
