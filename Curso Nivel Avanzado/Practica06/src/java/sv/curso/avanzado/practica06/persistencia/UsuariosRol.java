/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.practica06.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "USUARIOS_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosRol.findAll", query = "SELECT u FROM UsuariosRol u"),
    @NamedQuery(name = "UsuariosRol.findByUsuario", query = "SELECT u FROM UsuariosRol u WHERE u.usuariosRolPK.usuario = :usuario"),
    @NamedQuery(name = "UsuariosRol.findByCodigoRol", query = "SELECT u FROM UsuariosRol u WHERE u.usuariosRolPK.codigoRol = :codigoRol"),
    @NamedQuery(name = "UsuariosRol.findByCodigoOpcion", query = "SELECT u FROM UsuariosRol u WHERE u.usuariosRolPK.codigoOpcion = :codigoOpcion"),
    @NamedQuery(name = "UsuariosRol.findByFechaCreacion", query = "SELECT u FROM UsuariosRol u WHERE u.usuariosRolPK.fechaCreacion = :fechaCreacion")})
public class UsuariosRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosRolPK usuariosRolPK;

    public UsuariosRol() {
    }

    public UsuariosRol(UsuariosRolPK usuariosRolPK) {
        this.usuariosRolPK = usuariosRolPK;
    }

    public UsuariosRol(String usuario, String codigoRol, String codigoOpcion, Date fechaCreacion) {
        this.usuariosRolPK = new UsuariosRolPK(usuario, codigoRol, codigoOpcion, fechaCreacion);
    }

    public UsuariosRolPK getUsuariosRolPK() {
        return usuariosRolPK;
    }

    public void setUsuariosRolPK(UsuariosRolPK usuariosRolPK) {
        this.usuariosRolPK = usuariosRolPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosRolPK != null ? usuariosRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRol)) {
            return false;
        }
        UsuariosRol other = (UsuariosRol) object;
        if ((this.usuariosRolPK == null && other.usuariosRolPK != null) || (this.usuariosRolPK != null && !this.usuariosRolPK.equals(other.usuariosRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.curso.avanzado.persistencia.UsuariosRol[ usuariosRolPK=" + usuariosRolPK + " ]";
    }
    
}
