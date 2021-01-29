package com.ramesptop.Libros.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ramesptop.Libros.Libro;
import com.ramesptop.Libros.service.ILibroServ;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {
    @Autowired
    private ILibroServ serv;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var titulo = "Listado de libros";
        List<Libro> libros = serv.listarLibros();
        model.addAttribute("titulo", titulo);
        model.addAttribute("libros", libros);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String Agregar(Libro libro, Model model){
        var titulo = "Datos Libro";
        model.addAttribute("titulo", titulo);
        return "modificar";
    }
    /* La validacion y el manejo de errores deben estar juntos*/
    @PostMapping("/guardar")
    public String Guardar(@Valid Libro libro, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        } else {
            serv.guardarLibro(libro);
            return ("redirect:/");
        }
    }
    
    @GetMapping("/editar/{idLibro}")
    public String editar(Libro libro, Model model){
        libro = serv.buscarLibroPorId(libro);
        model.addAttribute("libro", libro);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idLibro}")
    public String eliminar (Libro libro){
        serv.eliminarLibro(libro);
        return "redirect:/";
    }
}
