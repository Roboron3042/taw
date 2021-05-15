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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "CHAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c"),
    @NamedQuery(name = "Chat.findByIdchat", query = "SELECT c FROM Chat c WHERE c.idchat = :idchat")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCHAT")
    private Integer idchat;
    /* TODO: Parte que falla 
    @JoinTable(name = "CHAT_HAS_MENSAJE", joinColumns = {
        @JoinColumn(name = "IDCHAT", referencedColumnName = "IDCHAT")}, inverseJoinColumns = {
        @JoinColumn(name = "IDMENSAJE", referencedColumnName = "IDMENSAJE")})
    
    @ManyToMany
    private List<Mensaje> mensajeList;
    */
    public Chat() {
    }

    public Chat(Integer idchat) {
        this.idchat = idchat;
    }

    public Integer getIdchat() {
        return idchat;
    }

    public void setIdchat(Integer idchat) {
        this.idchat = idchat;
    }
    /* TODO: Parte que falla 
    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }
    */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchat != null ? idchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.idchat == null && other.idchat != null) || (this.idchat != null && !this.idchat.equals(other.idchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taw.entity.Chat[ idchat=" + idchat + " ]";
    }
    
}
