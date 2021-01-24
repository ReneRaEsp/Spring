
package com.ramesptop.persona;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ramesptop.persona.Persona;

@Controller
public class ControladorInicio {
    @GetMapping("/")
    public String Inicio(Model model){
        Persona persona = new Persona();
        persona.setNombre("Coronel");
        persona.setApellido("Desu");
        persona.setCorreo("bastion@protonmail.com");
        persona.setTelefono("992334767");
        model.addAttribute("persona", persona);
        return "index";
    }
}
