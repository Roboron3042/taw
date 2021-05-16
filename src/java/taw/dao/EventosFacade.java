/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
