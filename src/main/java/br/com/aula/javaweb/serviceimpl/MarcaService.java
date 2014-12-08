package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.IMarcaService;
import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.util.MarcaGrafico;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateful
public class MarcaService implements IMarcaService {
    
    @PersistenceContext
    private EntityManager em;
  
    
    @Override
    public String salvar(Marca marca){
        try{
            if(marca.getIdMarca() != null){
                em.merge(marca);
            }else{
                em.persist(marca);
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }
    
    @Override
    public String remover(Short idMarca){
        try{
            Marca marca = obter(idMarca);
            em.remove(marca);
        }catch(Exception ex){
            return ex.getMessage();
        }
        
        return null;
    }
    
    @Override
    public List<Marca> listar(){
        TypedQuery<Marca> marcaQuery = 
                em.createQuery("select m from Marca m", Marca.class);
       return  marcaQuery.getResultList();
    }
    
     public List<MarcaGrafico> listarGrafico(){
        TypedQuery<MarcaGrafico> marcaQuery = 
                em.createQuery("select new br.com.aula.javaweb.util.MarcaGrafico(m.descricao,SIZE(m.modelos)) "
                        + "from Marca m", MarcaGrafico.class);
       return  marcaQuery.getResultList();
    }
    
    @Override
    public Marca obter(Short id){
          Marca marca =  em.find(Marca.class, id);
          return marca;
    }
   
}