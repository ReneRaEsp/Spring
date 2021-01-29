package com.domain.cliente.service;

import java.util.List;
import com.domain.cliente.Cliente;

public interface ClienteService {
    public List<Cliente> listarClientes();
    
    public void guardar(Cliente cliente);
    
    public Cliente encontrarCliente(Cliente cliente);
    
    public void eliminar(Cliente cliente);
}
