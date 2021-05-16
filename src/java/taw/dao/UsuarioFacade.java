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
    
    public List<Usuario> findByAge(Integer age){
            
        Query q = this.getEntityManager().createNamedQuery("Usuario.findByEdad");
        q.setParameter("edad", age);
        
        return q.getResultList();
    }
    
    public List<Usuario> findByString(String string, String value){
            
        Query q = this.getEntityManager().createNamedQuery("Usuario.findBy" + string);
        q.setParameter(string.toLowerCase(), value);
        
        return q.getResultList();
    }
    
    public List<Usuario> findByEdadOrResidenciaOrSexo (Integer edadInicio,Integer edadFin, String sexo) {
        List<Usuario> lista;
        
        
        //Caso 1:  sexo = null
        if (sexo == null) {
            lista = findByRangoEdad (edadInicio, edadFin);
            
        } 
        //Caso 2: edadInicio o edadFin = null
        else if(edadInicio == null || edadFin == null){
            lista = findBySexoU(sexo); 
        }
        //Caso 4:residencia = null
        else{
            lista = finByEdadAndSexo(edadInicio,edadFin,sexo);
        }
        
        return lista;       
    }
    
    public List<Usuario> findBySexoU (String sexo) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = 'user' and u.sexo = :sexo");
        q.setParameter("sexo", sexo);
        return q.getResultList(); 
    }
  
    
    public List<Usuario> findByRangoEdad (Integer edadInicio,Integer edadFin) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = 'user' and u.edad >= :edadInicio and u.edad <= :edadFin");
        q.setParameter("edadInicio", edadInicio);
        q.setParameter("edadFin", edadFin);
        return q.getResultList(); 
    }
    
    public List<Usuario> finByEdadAndSexo (Integer edadInicio,Integer edadFin, String sexo) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = 'user' and u.edad >= :edadInicio and u.edad <= :edadFin and u.sexo = :sexo");
        q.setParameter("edadInicio", edadInicio);
        q.setParameter("edadFin", edadFin);
        q.setParameter("sexo", sexo);
        return q.getResultList(); 
    }
    
 
    
    public List<Usuario> findByResidenciaAndSexo (String residencia, String sexo) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = 'user' and u.residencia = :residencia and u.sexo = :sexo");
        q.setParameter("sexo", sexo);
        q.setParameter("residencia", residencia);
        return q.getResultList(); 
    }
    
    public List<Usuario> findAllUser () {
        Query q;
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.rol = 'user'");
        return q.getResultList(); 
    }


    
}
