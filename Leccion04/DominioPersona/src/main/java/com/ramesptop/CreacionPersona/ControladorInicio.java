
package com.ramesptop.CreacionPersona;

import lombok.extern.slf4j.Slf4j;
import com.ramesptop.CreacionPersona.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @GetMapping("/")
    public String Inicio(Model model){
        var mensajePersona = "Lista de Personas";
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jdbjnd@protonmai.com");
        persona.setTelefono("98837849");
        
        model.addAttribute("mensajePersona", mensajePersona);
        model.addAttribute("persona", persona);
        return "index";
    }
    
}
