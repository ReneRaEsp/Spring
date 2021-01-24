package com.domain.ControlClientes;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.domain.ControlClientes.Cliente;



@Controller
public class ControlInicio {
    
        
    public String Inicio(Model model){
        var cliente = new Cliente();
        cliente.setNombre("Rene");
        cliente.setApellido("Ramirez");
        cliente.setCorreo("rene@protonmail.com");
        cliente.setTelefono("941339689");
        var titulo = "Lista de Clientes";
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", titulo);
        return "index";
    }
}
