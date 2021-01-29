package com.domain.cliente.dao;

import org.springframework.data.repository.CrudRepository;
import com.domain.cliente.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
    
}
