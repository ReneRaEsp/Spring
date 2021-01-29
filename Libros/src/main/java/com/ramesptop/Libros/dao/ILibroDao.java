package com.ramesptop.Libros.dao;

import org.springframework.data.repository.CrudRepository;
import com.ramesptop.Libros.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long>{
    
}
