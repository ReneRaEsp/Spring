package com.domain.cliente.service;

import com.domain.cliente.Cliente;
import com.domain.cliente.dao.IClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private IClienteDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
       return (List<Cliente>) dao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        dao.save(cliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente encontrarCliente(Cliente cliente) {
         return dao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    @Override
    @Transactional
    public void eliminar(Cliente cliente) {
        dao.delete(cliente);
    }
}
