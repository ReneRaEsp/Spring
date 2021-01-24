package com.dominio.Peliculas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dominio.Peliculas.Peliculas;

@Controller
public class ControladorInicio {
    @GetMapping("/")
    public String Inicio(Model model){
        Peliculas pelicula = new Peliculas();
        pelicula.setTitulo("El señor de los anillos");
        pelicula.setYear("2005");
        pelicula.setGenero("Accion");
        var titulo = "Listado de Peliculas";
        model.addAttribute("titulo", titulo);
        model.addAttribute("pelicula", pelicula);
        return "index";
    }
}
