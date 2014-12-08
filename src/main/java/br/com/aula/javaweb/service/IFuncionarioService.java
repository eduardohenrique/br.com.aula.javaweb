package br.com.aula.javaweb.service;

import br.com.aula.javaweb.entity.Funcionario;
import java.util.List;

public interface IFuncionarioService {

    List<Funcionario> listarPorNome(String nome);

    Funcionario obter(Integer idPessoa);

    String remover(Integer idPessoa);

    String salvar(Funcionario funcionario);
    
}
