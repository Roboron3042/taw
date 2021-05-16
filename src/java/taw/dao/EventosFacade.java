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
import taw.entity.Eventos;

/**
 *
 * @author rober
 */
@Stateless
public class EventosFacade extends AbstractFacade<Eventos>{
    
    @PersistenceContext(unitName = "TAW16PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public EventosFacade() {
        super(Eventos.class);
    }

    public Eventos findById(String id) {
        Query q = this.getEntityManager().createNamedQuery("Eventos.findByIdeventos");
        q.setParameter("id", id);
        Eventos evento = null;
        
        if(!q.getResultList().isEmpty()){
            evento = (Eventos) q.getResultList().get(0);
        }
        
        return evento;
    }
}
