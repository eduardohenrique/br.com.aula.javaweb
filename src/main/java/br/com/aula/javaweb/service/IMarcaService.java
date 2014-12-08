
package br.com.aula.javaweb.service;

import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.util.MarcaGrafico;
import java.util.List;

public interface IMarcaService {

    List<Marca> listar();

    String remover(Short idMarca);

    String salvar(Marca marca);
    
    Marca obter(Short id);
    
    List<MarcaGrafico> listarGrafico();
    
}
