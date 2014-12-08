package br.com.aula.javaweb.serviceimpl;

import br.com.aula.javaweb.service.IModeloService;
import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.entity.Modelo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ModeloService implements IModeloService {

   @PersistenceContext
    private EntityManager em;
    
    @Override
    public String salvar(Modelo modelo) {
        try {
           
            if (modelo.getIdModelo() != null) {
                em.merge(modelo);
            } else {
                em.persist(modelo);
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String remover(Short idModelo) {
        try {
            Modelo modelo = obter(idModelo);
            em.remove(modelo);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public List<Modelo> listar() {
        TypedQuery<Modelo> modeloQuery
                = em.createQuery("select m from Modelo m "
                        + "JOIN FETCH m.marca", Modelo.class);
        return modeloQuery.getResultList();
    }

    @Override
    public List<Modelo> listarPorMarca(Marca marca) {
        TypedQuery<Modelo> modeloQuery
                = em.createQuery("select m from Modelo m where m.marca.idMarca = :idMarca", Modelo.class);
        modeloQuery.setParameter("idMarca", marca.getIdMarca());
        return modeloQuery.getResultList();
    }

    @Override
    public Modelo obter(Short id) {
        Modelo modelo = em.find(Modelo.class, id);
        return modelo;
    }
}
