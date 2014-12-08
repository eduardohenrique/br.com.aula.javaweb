package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.IFuncionarioService;
import br.com.aula.javaweb.entity.Funcionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Stateless
public class FuncionarioService implements IFuncionarioService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String salvar(Funcionario funcionario){
        try{
            funcionario.getUsuario().setPessoa(funcionario);
            if(funcionario.getIdPessoa() != null){
                em.merge(funcionario);
            }else{
                em.persist(funcionario);
            }
           
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }
    

    @Override
    public String remover(Integer idPessoa){
        try{
            Funcionario funcionario = obter(idPessoa);
            em.remove(funcionario);
        }catch(Exception ex){
            return ex.getMessage();
        }
        
        return null;
    }
    
    @Override
    public List<Funcionario> listarPorNome(String nome){
        nome = nome == null ? "": nome;
        TypedQuery<Funcionario> automovelQuery = 
                em.createQuery("select a from Funcionario a "
                        + "left join fetch a.usuario as u "
                        + "where a.nome like :nome "
                        + "order by a.nome", Funcionario.class);
        automovelQuery.setParameter("nome", "%"+nome+"%");

       return automovelQuery.getResultList();
    } 
    
    @Override
    public Funcionario obter(Integer idPessoa){
          Funcionario marca = em.find(Funcionario.class, idPessoa);
          return marca;
    }
}
