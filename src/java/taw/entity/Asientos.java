/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "ASIENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asientos.findAll", query = "SELECT a FROM Asientos a"),
    @NamedQuery(name = "Asientos.findByIdasientos", query = "SELECT a FROM Asientos a WHERE a.asientosPK.idasientos = :idasientos"),
    @NamedQuery(name = "Asientos.findByFilas", query = "SELECT a FROM Asientos a WHERE a.filas = :filas"),
    @NamedQuery(name = "Asientos.findByColumna", query = "SELECT a FROM Asientos a WHERE a.columna = :columna"),
    @NamedQuery(name = "Asientos.findByDisp", query = "SELECT a FROM Asientos a WHERE a.disp = :disp"),
    @NamedQuery(name = "Asientos.findByIdeventos", query = "SELECT a FROM Asientos a WHERE a.asientosPK.ideventos = :ideventos")})
public class Asientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsientosPK asientosPK;
    @Column(name = "FILAS")
    private Integer filas;
    @Column(name = "COLUMNA")
    private Integer columna;
    @Column(name = "DISP")
    private Integer disp;
    @JoinColumn(name = "IDEVENTOS", referencedColumnName = "IDEVENTOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Eventos eventos;

    public Asientos() {
    }

    public Asientos(AsientosPK asientosPK) {
        this.asientosPK = asientosPK;
    }

    public Asientos(int idasientos, int ideventos) {
        this.asientosPK = new AsientosPK(idasientos, ideventos);
    }

    public AsientosPK getAsientosPK() {
        return asientosPK;
    }

    public void setAsientosPK(AsientosPK asientosPK) {
        this.asientosPK = asientosPK;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public Integer getDisp() {
        return disp;
    }

    public void setDisp(Integer disp) {
        this.disp = disp;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asientosPK != null ? asientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asientos)) {
            return false;
        }
        Asientos other = (Asientos) object;
        if ((this.asientosPK == null && other.asientosPK != null) || (this.asientosPK != null && !this.asientosPK.equals(other.asientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw16.entity.Asientos[ asientosPK=" + asientosPK + " ]";
    }
    
}
