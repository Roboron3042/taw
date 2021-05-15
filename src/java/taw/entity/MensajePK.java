/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rober
 */
@Embeddable
public class MensajePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMENSAJE")
    private int idmensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDUSUARIO")
    private String idusuario;

    public MensajePK() {
    }

    public MensajePK(int idmensaje, String idusuario) {
        this.idmensaje = idmensaje;
        this.idusuario = idusuario;
    }

    public int getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmensaje;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajePK)) {
            return false;
        }
        MensajePK other = (MensajePK) object;
        if (this.idmensaje != other.idmensaje) {
            return false;
        }
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw.entity.MensajePK[ idmensaje=" + idmensaje + ", idusuario=" + idusuario + " ]";
    }
    
}
