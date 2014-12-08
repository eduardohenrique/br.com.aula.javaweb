

package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.ICombustivelService;
import br.com.aula.javaweb.entity.Combustivel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class CombustivelService implements ICombustivelService{
  
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Combustivel> listar(){
        TypedQuery<Combustivel> combustivelQuery = 
               em.createQuery("select c from Combustivel c",
                        Combustivel.class);
       return combustivelQuery.getResultList();
    }
    
 
}
