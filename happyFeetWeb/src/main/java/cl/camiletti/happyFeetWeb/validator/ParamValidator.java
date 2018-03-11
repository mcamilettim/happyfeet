package cl.camiletti.happyFeetWeb.validator;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ParamValidator implements Validator {
    @Autowired
    private ParametroService parametroService;
     

    @Override
    public boolean supports(Class<?> aClass) {
        return Parametro.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Parametro parametro = (Parametro) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
        if (parametroService.findOne(parametro.getId())!=null) {
            errors.rejectValue("id", "Duplicate.parametroForm.id");    
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
        if(parametro.getId()<0){
        	errors.rejectValue("id","Size.parametroForm.id");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "decripcion", "NotEmpty");
        if(parametro.getDecripcion().length()<=1){
        	errors.rejectValue("decripcion","Size.parametroForm.decripcion");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "NotEmpty");
        if(parametro.getNumero()<0){
        	errors.rejectValue("numero","Size.parametroForm.numero");
        }
        
        
    }	
}