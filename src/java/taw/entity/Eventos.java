/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "EVENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findByIdeventos", query = "SELECT e FROM Eventos e WHERE e.ideventos = :ideventos"),
    @NamedQuery(name = "Eventos.findByTitulo", query = "SELECT e FROM Eventos e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Eventos.findByDescripcion", query = "SELECT e FROM Eventos e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Eventos.findByFechalim", query = "SELECT e FROM Eventos e WHERE e.fechalim = :fechalim"),
    @NamedQuery(name = "Eventos.findByCoste", query = "SELECT e FROM Eventos e WHERE e.coste = :coste"),
    @NamedQuery(name = "Eventos.findByAforo", query = "SELECT e FROM Eventos e WHERE e.aforo = :aforo"),
    @NamedQuery(name = "Eventos.findByNmaxentradas", query = "SELECT e FROM Eventos e WHERE e.nmaxentradas = :nmaxentradas"),
    @NamedQuery(name = "Eventos.findByAsientos", query = "SELECT e FROM Eventos e WHERE e.asientos = :asientos")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEVENTOS")
    private Integer ideventos;
    @Size(max = 45)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA")
    private Integer fecha;
    @Column(name = "FECHALIM")
    private Integer fechalim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTE")
    private Double coste;
    @Column(name = "AFORO")
    private Integer aforo;
    @Column(name = "NMAXENTRADAS")
    private Integer nmaxentradas;
    @Size(max = 45)
    @Column(name = "ASIENTOS")
    private String asientos;
    @JoinTable(name = "EVENTOS_HAS_USUARIO", joinColumns = {
        @JoinColumn(name = "IDEVENTOS", referencedColumnName = "IDEVENTOS")}, inverseJoinColumns = {
        @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @ManyToMany(mappedBy = "eventosList")
    private List<Etiqueta> etiquetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventos")
    private List<Asientos> asientosList;

    public Eventos() {
    }

    public Eventos(Integer ideventos) {
        this.ideventos = ideventos;
    }

    public Integer getIdeventos() {
        return ideventos;
    }

    public void setIdeventos(Integer ideventos) {
        this.ideventos = ideventos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public Integer getFechalim() {
        return fechalim;
    }

    public void setFechalim(Integer fechalim) {
        this.fechalim = fechalim;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getNmaxentradas() {
        return nmaxentradas;
    }

    public void setNmaxentradas(Integer nmaxentradas) {
        this.nmaxentradas = nmaxentradas;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Etiqueta> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<Etiqueta> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    @XmlTransient
    public List<Asientos> getAsientosList() {
        return asientosList;
    }

    public void setAsientosList(List<Asientos> asientosList) {
        this.asientosList = asientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideventos != null ? ideventos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.ideventos == null && other.ideventos != null) || (this.ideventos != null && !this.ideventos.equals(other.ideventos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw16.entity.Eventos[ ideventos=" + ideventos + " ]";
    }
    
}
