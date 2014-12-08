
package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Modelo;
import br.com.aula.javaweb.service.IModeloService;
import br.com.aula.javaweb.util.MensagemUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "modeloManagedBean")
@RequestScoped
public class ModeloManagedBean implements Serializable{

    @EJB
    private IModeloService modeloService;

    private Modelo modelo;
    private Modelo modeloSelecionado;

   
    public ModeloManagedBean() {
        this.modelo = new Modelo();
    }
    
    public void novo(){
        this.modelo = new Modelo();
    }
    
    public void salvar() {

        String erro = modeloService.salvar(modelo);

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Modelo salva com sucesso");
            modelo = new Modelo();
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }

    public void excluir() {

        String erro = modeloService.remover(modeloSelecionado.getIdModelo());

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Modelo excluída com sucesso");
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar(){
        modelo = modeloSelecionado;
    }
    
    public List<Modelo> todos() {
        return modeloService.listar();
    }
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(Modelo modeloSelecionado) {
        this.modeloSelecionado = modeloSelecionado;
    }
    
}
