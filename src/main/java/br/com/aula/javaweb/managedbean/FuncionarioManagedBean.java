package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Funcionario;
import br.com.aula.javaweb.service.IFuncionarioService;
import br.com.aula.javaweb.util.MensagemUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "funcionarioManagedBean")
@ViewScoped
public class FuncionarioManagedBean implements Serializable {

    @EJB
    private IFuncionarioService funcionarioService;


    private Funcionario funcionario;
    private Funcionario funcionarioSelecionado;
    private List<Funcionario> funcionarios;
    private String nomeConsulta;

    public FuncionarioManagedBean() {
        funcionario = new Funcionario();
    }
    
    @PostConstruct
    public void init(){
        String id= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	if(id != null){
            funcionario = funcionarioService.obter(Integer.parseInt(id));
	} 
    }

    public void salvar() {
        String erro = funcionarioService.salvar(funcionario);

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Funcionário salvo com sucesso");
        } else {
            MensagemUtil.addMensagemError(erro);
        }

    }
    
    public void excluir() {
        String erro = funcionarioService.remover(funcionarioSelecionado.getIdPessoa());

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Funcionário excluído com sucesso");
            this.funcionarios.remove(funcionarioSelecionado);
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar() throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("formulario.jsf?id="+funcionarioSelecionado.getIdPessoa());
    }
 
    public void consultarFuncionario(){
        this.funcionarios = funcionarioService.listarPorNome(nomeConsulta);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getNomeConsulta() {
        return nomeConsulta;
    }

    public void setNomeConsulta(String nomeConsulta) {
        this.nomeConsulta = nomeConsulta;
    }
    
  
   
    
}
