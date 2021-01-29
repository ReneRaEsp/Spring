
package com.dominio.peliculas.dao;

import org.springframework.data.repository.CrudRepository;
import com.dominio.peliculas.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long>{
    
}
