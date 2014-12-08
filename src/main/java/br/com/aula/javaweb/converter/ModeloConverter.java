package br.com.aula.javaweb.converter;

import br.com.aula.javaweb.entity.Modelo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "modeloConverter",forClass = Modelo.class)
public class ModeloConverter implements  Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        try{
            if(value == null || value.isEmpty())
                return null;
            
            Short id = Short.valueOf(value);
            
            Modelo modelo = new  Modelo();
            modelo.setIdModelo(id);
            
            return modelo;
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null 
                || !(value instanceof Modelo)){
            return null;
        }
        
        return ((Modelo)value).getIdModelo().toString();
    }
    
}
