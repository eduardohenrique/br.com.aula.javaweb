package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.ICorService;
import br.com.aula.javaweb.entity.Cor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class CorService implements ICorService{
  
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Cor> listar(){
        TypedQuery<Cor> corQuery = 
                em.createQuery("select c from Cor c", Cor.class);
       return corQuery.getResultList();
    }
    
 
}
