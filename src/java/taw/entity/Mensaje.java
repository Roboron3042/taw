/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "MENSAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdmensaje", query = "SELECT m FROM Mensaje m WHERE m.mensajePK.idmensaje = :idmensaje"),
    @NamedQuery(name = "Mensaje.findByFecha", query = "SELECT m FROM Mensaje m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Mensaje.findByContenido", query = "SELECT m FROM Mensaje m WHERE m.contenido = :contenido"),
    @NamedQuery(name = "Mensaje.findByIdusuario", query = "SELECT m FROM Mensaje m WHERE m.mensajePK.idusuario = :idusuario")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensajePK mensajePK;
    @Column(name = "FECHA")
    private Integer fecha;
    @Size(max = 255)
    @Column(name = "CONTENIDO")
    private String contenido;
    @ManyToMany(mappedBy = "mensajeList")
    private List<Chat> chatList;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Mensaje() {
    }

    public Mensaje(MensajePK mensajePK) {
        this.mensajePK = mensajePK;
    }

    public Mensaje(int idmensaje, int idusuario) {
        this.mensajePK = new MensajePK(idmensaje, idusuario);
    }

    public MensajePK getMensajePK() {
        return mensajePK;
    }

    public void setMensajePK(MensajePK mensajePK) {
        this.mensajePK = mensajePK;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @XmlTransient
    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajePK != null ? mensajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.mensajePK == null && other.mensajePK != null) || (this.mensajePK != null && !this.mensajePK.equals(other.mensajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw16.entity.Mensaje[ mensajePK=" + mensajePK + " ]";
    }
    
}
