package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Automovel;
import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.entity.Modelo;
import br.com.aula.javaweb.service.IAutomovelService;
import br.com.aula.javaweb.service.IModeloService;
import br.com.aula.javaweb.util.MensagemUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "automovelManagedBean")
@ViewScoped
public class AutomovelManagedBean implements Serializable {

    @EJB
    private IAutomovelService automovelService;

    @EJB
    private IModeloService modeloService;

    private Automovel automovel;
    private Automovel automovelSelecionado;
    private Marca marca;
    private List<Modelo> modelos;
    private List<Automovel> automoveis;
    private String marcaConsulta;

    public AutomovelManagedBean() {
        automovel = new Automovel();
    }
    
    @PostConstruct
    public void init(){
        String id= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	if(id != null){
            automovel = automovelService.obter(Integer.parseInt(id));
            marca = automovel.getModelo().getMarca();
            modelos = modeloService.listarPorMarca(marca); 
	} 
    }

    public void salvar() {
        String erro = automovelService.salvar(automovel);

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Automóvel salva com sucesso");
        } else {
            MensagemUtil.addMensagemError(erro);
        }

    }
    
    public void excluir() {
        String erro = automovelService.remover(automovelSelecionado.getIdAutomovel());

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Automóvel excluído com sucesso");
            this.automoveis.remove(automovelSelecionado);
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar() throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("formulario.jsf?id="+automovelSelecionado.getIdAutomovel());
    }
 
    public void consultarAutomovel(){
        this.automoveis = automovelService.listarPorMarca(marcaConsulta);
    }
    
    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public void listarPorMarca() {
        if (marca != null) {
            modelos = modeloService.listarPorMarca(marca);
        }
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public String getMarcaConsulta() {
        return marcaConsulta;
    }

    public void setMarcaConsulta(String marcaConsulta) {
        this.marcaConsulta = marcaConsulta;
    }

    public Automovel getAutomovelSelecionado() {
        return automovelSelecionado;
    }

    public void setAutomovelSelecionado(Automovel automovelSelecionado) {
        this.automovelSelecionado = automovelSelecionado;
    }
   
    
}
