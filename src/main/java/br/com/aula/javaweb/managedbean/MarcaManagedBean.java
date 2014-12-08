package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Marca;
import br.com.aula.javaweb.service.IMarcaService;
import br.com.aula.javaweb.util.MarcaGrafico;
import br.com.aula.javaweb.util.MensagemUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

@Named(value = "marcaManagedBean")
@RequestScoped
public class MarcaManagedBean implements Serializable {

    @EJB
    private IMarcaService marcaService;

    private Marca marca;
    private Marca marcaSelecionada;

    public MarcaManagedBean() {
        marca = new Marca();
    }
    
    public void novo(){
        this.marca = new Marca();
    }
    
    public void salvar() {
        String erro = marcaService.salvar(marca);

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Marca salva com sucesso");
            marca = new Marca();
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }

    public void excluir() {

        String erro = marcaService.remover(marcaSelecionada.getIdMarca());

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Marca excluÃ­da com sucesso");
        } else {
            MensagemUtil.addMensagemError(erro);
        }
    }
    
    public PieChartModel gerarGrafico(){
        PieChartModel pieModel = new PieChartModel();
         
        List<MarcaGrafico> models = marcaService.listarGrafico();
        
        for (MarcaGrafico model : models) {
             pieModel.set(model.getNome(), model.getQuantidadeModelos());
        }
        pieModel.setShowDataLabels(true);
        pieModel.setTitle("Marcas");
        pieModel.setLegendPosition("w");
        
        return pieModel;
    }
    
    public void editar(){
        marca = marcaSelecionada;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> todos() {
        return marcaService.listar();
    }

    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }
    
}
