
package com.ramesptop.agenda;

import org.springframework.stereotype.Controller;
import com.ramesptop.agenda.Contacto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    @GetMapping("/")
    private String Inicio(Model model){
        Contacto contacto = new Contacto();
        contacto.setNombre("Abrahan");
        contacto.setTelefono("987633356");
        model.addAttribute("contacto", contacto);
        return "index";
    }
}
