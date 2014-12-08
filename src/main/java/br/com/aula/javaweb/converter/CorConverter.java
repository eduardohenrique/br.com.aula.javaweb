package br.com.aula.javaweb.converter;

import br.com.aula.javaweb.entity.Cor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "corConverter",forClass = Cor.class)
public class CorConverter implements  Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        try{
            if(value == null || value.isEmpty())
                return null;
            
            Short id = Short.valueOf(value);
            
            Cor cor = new  Cor();
            cor.setIdCor(id);
            
            return cor;
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null 
                || !(value instanceof Cor)){
            return null;
        }
        
        return ((Cor)value).getIdCor().toString();
    }
    
}
