package br.com.aula.javaweb.managedbean;

import br.com.aula.javaweb.entity.Opcional;
import br.com.aula.javaweb.service.IOpcionalService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "opcionalManagedBean")
@RequestScoped
public class OpcionalManagedBean implements Serializable {

    @EJB
    private IOpcionalService opcionalService;


    public OpcionalManagedBean() {
       
    }
    
    public List<Opcional> todos() {
        return opcionalService.listar();
    }


}
