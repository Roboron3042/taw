/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import taw.entity.Usuario;

/**
 *
 * @author rober
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "TAW16PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
        public Usuario findByEmail(String email){
            
        Query q = this.getEntityManager().createNamedQuery("Usuario.findByCorreo");
        q.setParameter("correo", email);
        Usuario usuario = null;
        
        if(!q.getResultList().isEmpty()){
            usuario = (Usuario) q.getResultList().get(0);
        }
        
        return usuario;
    }


    
}
