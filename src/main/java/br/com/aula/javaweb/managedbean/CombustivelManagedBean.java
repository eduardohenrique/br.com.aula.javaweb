package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Combustivel;
import br.com.aula.javaweb.service.ICombustivelService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "combustivelManagedBean")
@RequestScoped
public class CombustivelManagedBean implements Serializable {

    @EJB
    private ICombustivelService combustivelService;


    public CombustivelManagedBean() {
       
    }
    
    public List<Combustivel> todos() {
        return combustivelService.listar();
    }


}
