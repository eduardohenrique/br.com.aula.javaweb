package br.com.aula.javaweb.converter;

import br.com.aula.javaweb.entity.Combustivel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "combustivelConverter",forClass = Combustivel.class)
public class CombustivelConverter implements  Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        try{
            if(value == null || value.isEmpty())
                return null;
            
            Short id = Short.valueOf(value);
            
            Combustivel combustivel = new  Combustivel();
            combustivel.setIdCombustivel(id);
            
            return combustivel;
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null 
                || !(value instanceof Combustivel)){
            return null;
        }
        
        return ((Combustivel)value).getIdCombustivel().toString();
    }
    
}
