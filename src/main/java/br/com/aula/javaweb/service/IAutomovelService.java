package br.com.aula.javaweb.service;

import br.com.aula.javaweb.entity.Automovel;
import java.util.List;


public interface IAutomovelService {

    List<Automovel> listarPorMarca(String Marca);

    Automovel obter(Integer id);

    String remover(Integer idAutomovel);

    String salvar(Automovel automovel);
    
}
