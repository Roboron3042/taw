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

/**
 *
 * @author rober
 */
@Embeddable
public class AsientosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDASIENTOS")
    private int idasientos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEVENTOS")
    private int ideventos;

    public AsientosPK() {
    }

    public AsientosPK(int idasientos, int ideventos) {
        this.idasientos = idasientos;
        this.ideventos = ideventos;
    }

    public int getIdasientos() {
        return idasientos;
    }

    public void setIdasientos(int idasientos) {
        this.idasientos = idasientos;
    }

    public int getIdeventos() {
        return ideventos;
    }

    public void setIdeventos(int ideventos) {
        this.ideventos = ideventos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idasientos;
        hash += (int) ideventos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsientosPK)) {
            return false;
        }
        AsientosPK other = (AsientosPK) object;
        if (this.idasientos != other.idasientos) {
            return false;
        }
        if (this.ideventos != other.ideventos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw.entity.AsientosPK[ idasientos=" + idasientos + ", ideventos=" + ideventos + " ]";
    }
    
}
