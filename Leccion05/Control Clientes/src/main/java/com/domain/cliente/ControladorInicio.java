package com.domain.cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.domain.cliente.Cliente;
import java.util.ArrayList;

@Controller
public class ControladorInicio {
    
    @GetMapping("/")
    public String Inicio(Model model){
        var titulo = "Listado de clientes";
        var cliente = new Cliente();
        cliente.setNombre("Rene");
        cliente.setApellido("Ramirez");
        cliente.setCorreo("reneraesp@protonmail.com");
        cliente.setTelefono("941339689");
        
        var cliente2 = new Cliente();
        cliente2.setNombre("Abrahan");
        cliente2.setApellido("Sulbaran");
        cliente2.setCorreo("jndbjnskl");
        cliente2.setTelefono("527687980");
        
        var clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);
        
        model.addAttribute("clientes", clientes);
        model.addAttribute("titulo", titulo);
        
        return "index";
    }
}
