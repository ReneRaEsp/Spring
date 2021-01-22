package com.ramesptop.CompartirDespedida;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.despedida}")
    private String despedida;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var mensaje = "Adios con Thymeleaf desde el controlador";
        model.addAttribute("despedida", despedida);
        model.addAttribute("mensaje", mensaje);
        return "index";
    }
}
