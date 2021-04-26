/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "ETIQUETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiqueta.findAll", query = "SELECT e FROM Etiqueta e"),
    @NamedQuery(name = "Etiqueta.findByIdetiqueta", query = "SELECT e FROM Etiqueta e WHERE e.idetiqueta = :idetiqueta"),
    @NamedQuery(name = "Etiqueta.findByEtiqueta", query = "SELECT e FROM Etiqueta e WHERE e.etiqueta = :etiqueta")})
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDETIQUETA")
    private Integer idetiqueta;
    @Size(max = 45)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @JoinTable(name = "ETIQUETA_HAS_EVENTOS", joinColumns = {
        @JoinColumn(name = "IDETIQUETA", referencedColumnName = "IDETIQUETA")}, inverseJoinColumns = {
        @JoinColumn(name = "IDEVENTOS", referencedColumnName = "IDEVENTOS")})
    @ManyToMany
    private List<Eventos> eventosList;

    public Etiqueta() {
    }

    public Etiqueta(Integer idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public Integer getIdetiqueta() {
        return idetiqueta;
    }

    public void setIdetiqueta(Integer idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetiqueta != null ? idetiqueta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiqueta)) {
            return false;
        }
        Etiqueta other = (Etiqueta) object;
        if ((this.idetiqueta == null && other.idetiqueta != null) || (this.idetiqueta != null && !this.idetiqueta.equals(other.idetiqueta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw16.entity.Etiqueta[ idetiqueta=" + idetiqueta + " ]";
    }
    
}
