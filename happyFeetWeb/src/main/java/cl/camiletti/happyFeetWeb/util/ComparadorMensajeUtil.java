package cl.camiletti.happyFeetWeb.util;


import java.util.Comparator;

import org.springframework.stereotype.Component;

import cl.camiletti.happyFeetWeb.model.Mensaje;


@Component
public class ComparadorMensajeUtil implements Comparator<Mensaje>{
    @Override    
    public int compare(Mensaje mensaje1, Mensaje mensaje2) {
        return mensaje1.getId() - mensaje2.getId();
        
    }
}
