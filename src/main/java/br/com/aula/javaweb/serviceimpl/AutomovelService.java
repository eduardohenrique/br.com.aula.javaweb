package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.IAutomovelService;
import br.com.aula.javaweb.entity.Automovel;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AutomovelService implements IAutomovelService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public String salvar(Automovel automovel){
        try{
            if(automovel.getIdAutomovel() != null){
                em.merge(automovel);
            }else{
                em.persist(automovel);
            }
           
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }
    
    @Override
    public String remover(Integer idAutomovel){
        try{
            Automovel automovel = obter(idAutomovel);
            em.remove(automovel);
        }catch(Exception ex){
            return ex.getMessage();
        }
        
        return null;
    }
    
    
    @Override
    public List<Automovel> listarPorMarca(String marca){
        marca = marca == null ? "": marca;
        TypedQuery<Automovel> automovelQuery = 
                em.createQuery("select distinct a from Automovel a "
                        + "join fetch a.cor "
                        + "join fetch a.combustivel "
                        + "left join fetch a.opcionais "
                        + "join fetch a.modelo as mo "
                        + "join fetch mo.marca as ma "
                        + "where ma.descricao like :marca", Automovel.class);
        automovelQuery.setParameter("marca", "%"+marca+"%");
       return automovelQuery.getResultList();
    } 
    
    @Override
    public Automovel obter(Integer id){
          Automovel automovel = em.find(Automovel.class, id);
          return automovel;
    }
    
}
