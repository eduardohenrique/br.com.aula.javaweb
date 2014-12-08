package br.com.aula.javaweb.service;

import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.entity.Modelo;
import java.util.List;

public interface IModeloService {

    List<Modelo> listar();

    Modelo obter(Short id);

    String remover(Short idModelo);

    String salvar(Modelo modelo);
    
    List<Modelo> listarPorMarca(Marca marca);
    
}
