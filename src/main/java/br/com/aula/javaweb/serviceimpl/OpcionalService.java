

package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.IOpcionalService;
import br.com.aula.javaweb.entity.Opcional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class OpcionalService implements IOpcionalService{
  
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Opcional> listar(){
        TypedQuery<Opcional> opcionalQuery = 
                em.createQuery("select o from Opcional o", Opcional.class);
       return opcionalQuery.getResultList();
    }
    
 
}
