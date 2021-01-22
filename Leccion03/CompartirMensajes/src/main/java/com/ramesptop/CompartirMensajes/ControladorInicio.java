
package com.ramesptop.CompartirMensajes;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {
    
    @Value("${index.mensaje}")
    private String properties;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var mensaje = "Mensaje compartido desde el controlador";
        model.addAttribute("mensajes", mensaje);
        model.addAttribute("properties", properties);
                
        return "index";
    }
}
