package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Cor;
import br.com.aula.javaweb.service.ICorService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "corManagedBean")
@RequestScoped
public class CorManagedBean implements Serializable {

    @EJB
    private ICorService corService;


    public CorManagedBean() {
       
    }
    
    public List<Cor> todos() {
        return corService.listar();
    }


}
