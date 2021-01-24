
package com.domain.agenda;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.domain.agenda.Cita;

@Controller
public class ControladorInicio {
    
    @GetMapping("/")
    public String Inicio(Model model){
        var titulo = "Agenda";
        var cita = new Cita();
        cita.setTitulo("Vacaciones");
        cita.setHora("12:00pm");
        cita.setFecha("20/04/2021");
        var cita2 = new Cita();
        cita2.setTitulo("Vacaciones 2");
        cita2.setHora("1:00pm");
        cita2.setFecha("22/04/2021");
        var citas = new ArrayList<>();
        
        citas.add(cita);
        citas.add(cita2);
        
        model.addAttribute("titulo", titulo);
        model.addAttribute("citas", citas);
        
        return "index";
    }
}
