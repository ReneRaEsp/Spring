
package com.ramesptop.agenda.web;

import org.springframework.stereotype.Controller;
import java.util.List;
import com.ramesptop.agenda.Contacto;
import com.ramesptop.agenda.service.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {
    @Autowired
    private IContactoServ serv;
    
    @GetMapping("/")
    private String Inicio(Model model){
        List<Contacto> contactos = serv.listarContactos();
        var mensajeVacio = "La lista esta vacia, precione agregar contacto, para agregar su primer contacto";
        var agregar = "Agregar Contacto";
        model.addAttribute("agregar", agregar);
        model.addAttribute("mensajeVacio", mensajeVacio);
        model.addAttribute("contactos", contactos);
        return "index";
    }
    
    @GetMapping("/agregar")
    private String Agregar(Contacto contacto, Model model){
        var titulo = "Datos Contacto";    
        model.addAttribute("titulo", titulo);
        return "modificar";
    }
    
    @GetMapping("/editar/{idContacto}")
    public String editar(Contacto contacto, Model model){
        contacto = serv.buscarContactoPorId(contacto);
        model.addAttribute("contacto", contacto);
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Contacto contacto, Errors errores){
            if(errores.hasErrors()){
                return "modificar";
            }
            serv.guardarContacto(contacto);
            
            return "redirect:/";
    }
    
    @GetMapping("/eliminar/{idContacto}")
    public String eliminar(Contacto contacto){
            serv.eliminarContacto(contacto);
            return "redirect:/";
    }
}
