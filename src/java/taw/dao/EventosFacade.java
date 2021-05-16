/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.dao;

import java.util.List;
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
    
    public List<Eventos> findByFechaOrCoste (Integer year, Double costeInicio, Double costeFin) {
        List<Eventos> lista;
        
        //Caso 1: fecha = null
        if (year == null) {
            lista = findByRangoCoste (costeInicio, costeFin);
            
        } 
        //Caso 2 : coste = null
        else if (costeInicio == null || costeFin == null){
            lista = findByYear (year);
           
        }
        //Caso 3: Nada es nulo
        else{
            lista = findByYearAndCoste(year, costeInicio, costeFin);
        }
        
        return lista;
    }
    public List<Eventos> findByRangoCoste (Double costeInicio, Double costeFin) {
        Query q;
        q = em.createQuery("SELECT e FROM Eventos e WHERE e.coste >= :costeInicio and e.coste <= :costeFin");
        q.setParameter("costeInicio", costeInicio);
        q.setParameter("costeFin", costeFin);
        return q.getResultList(); 
    }
    
    public List<Eventos> findByYear (Integer year) {
        Query q;
        String strYear = String.valueOf(year);
        q = em.createQuery("SELECT e FROM Eventos e WHERE e.fecha LIKE :year");
        q.setParameter("year", "'" + strYear + "%'");
        return q.getResultList(); 
    }
    
    public List<Eventos> findByYearAndCoste (Integer year, Double costeInicio, Double costeFin) {
        List<Eventos> lista;
        Query q;
        String strYear = String.valueOf(year);
        q = em.createQuery("SELECT e FROM Eventos e WHERE e.coste >= :costeInicio and e.coste <= :costeFin and e.fecha LIKE :year");
        q.setParameter("year", strYear + "%");
        q.setParameter("costeInicio", costeInicio);
        q.setParameter("costeFin", costeFin);
        lista = q.getResultList();
        
        
        return lista; 
    }
}
