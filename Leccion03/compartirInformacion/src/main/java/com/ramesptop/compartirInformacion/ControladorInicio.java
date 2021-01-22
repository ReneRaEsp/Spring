
package com.ramesptop.compartirInformacion;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludos}")
    private String saludos;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var mensaje = "Adios mundo con Thymeleaf";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludos", saludos);
        return "index";
    }
}
