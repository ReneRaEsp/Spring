
package com.dominio.peliculas.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.dominio.peliculas.Pelicula;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.dominio.peliculas.service.IPeliculaServ;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {
    @Autowired
    private IPeliculaServ serv;
    
    @GetMapping("/")
    public String Inicio(Model model){       
        var titulo = "Listado de peliculas";
        var peliculas = serv.listarPeliculas();
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("titulo", titulo);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Pelicula pelicula, Model model){
        var titulo = "Datos Pelicula";
        model.addAttribute("titulo", titulo);
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Pelicula pelicula){
        serv.guardarPelicula(pelicula);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPelicula}")
    public String editar(Pelicula pelicula, Model model){
        pelicula = serv.buscarPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPelicula}")
    public String eliminar(Pelicula pelicula){
        serv.eliminarPelicula(pelicula);
        return "redirect:/";
    }
}
