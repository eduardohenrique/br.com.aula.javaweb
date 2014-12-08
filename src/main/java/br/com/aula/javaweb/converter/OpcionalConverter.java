package br.com.aula.javaweb.converter;

import br.com.aula.javaweb.entity.Opcional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "opcionalConverter",forClass = Opcional.class)
public class OpcionalConverter implements  Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        try{
            if(value == null || value.isEmpty())
                return null;
            
            Short id = Short.valueOf(value);
            
            Opcional opcional = new  Opcional();
            opcional.setIdOpcional(id);
            
            return opcional;
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null 
                || !(value instanceof Opcional)){
            return null;
        }
        
        return ((Opcional)value).getIdOpcional().toString();
    }
    
}
