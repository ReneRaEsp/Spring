package com.domain.cliente.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.domain.cliente.Cliente;
import com.domain.cliente.service.ClienteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {
    
    @Autowired
    private ClienteService serv;
    
    @GetMapping("/")
    public String Inicio(Model model){
        var titulo = "Listado de clientes";
        
        var clientes = serv.listarClientes();
        
        model.addAttribute("clientes", clientes);
        model.addAttribute("titulo", titulo);
        
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Cliente cliente, Model model){
        var titulo = "Datos de la persona";
        model.addAttribute("titulo", titulo);
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, Errors errors){
        if(errors.hasErrors()) {
        return "modificar";
        } else {
        serv.guardar(cliente); 
        return "redirect:/";
        }
    }
    
    @GetMapping("/editar/{idCliente}")
    public String editar(Cliente cliente, Model model){
        cliente = serv.encontrarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idCliente}")
    public String eliminar(Cliente cliente){
        serv.eliminar(cliente);
        return "redirect:/";
    }
    
}
