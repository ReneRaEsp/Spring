
package com.dominio.peliculas.service;

import com.dominio.peliculas.Pelicula;
import com.dominio.peliculas.dao.IPeliculaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PeliculaServImpl implements IPeliculaServ{
    @Autowired
    private IPeliculaDao dao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> listarPeliculas() {
        return (List<Pelicula>) dao.findAll();
    }

    @Override
    @Transactional
    public void guardarPelicula(Pelicula p) {
        dao.save(p);
    }


    @Override
    @Transactional
    public void eliminarPelicula(Pelicula p) {
        dao.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula buscarPelicula(Pelicula p) {
        return dao.findById(p.getIdPelicula()).orElse(null);
    }
    
}
