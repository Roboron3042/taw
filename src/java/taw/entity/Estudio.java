/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "ESTUDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findByIdestudio", query = "SELECT e FROM Estudio e WHERE e.idestudio = :idestudio"),
    @NamedQuery(name = "Estudio.findByYear", query = "SELECT e FROM Estudio e WHERE e.year = :year"),
    @NamedQuery(name = "Estudio.findByEvento", query = "SELECT e FROM Estudio e WHERE e.evento = :evento"),
    @NamedQuery(name = "Estudio.findByUsuarios", query = "SELECT e FROM Estudio e WHERE e.usuarios = :usuarios"),
    @NamedQuery(name = "Estudio.findByTitulo", query = "SELECT e FROM Estudio e WHERE e.titulo = :titulo")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTUDIO")
    private Integer idestudio;
    @Column(name = "year")
    private Integer year;
    @Size(max = 50)
    @Column(name = "EVENTO")
    private String evento;
    @Size(max = 50)
    @Column(name = "USUARIOS")
    private String usuarios;
    @Size(max = 50)
    @Column(name = "TITULO")
    private String titulo;

    public Estudio() {
    }

    public Estudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public Integer getIdestudio() {
        return idestudio;
    }

    public void setIdestudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudio != null ? idestudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idestudio == null && other.idestudio != null) || (this.idestudio != null && !this.idestudio.equals(other.idestudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw.entity.Estudio[ idestudio=" + idestudio + " ]";
    }
    
}
