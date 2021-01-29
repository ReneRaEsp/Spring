package com.dominio.peliculas.service;

import java.util.List;
import com.dominio.peliculas.Pelicula;

public interface IPeliculaServ {
    public List<Pelicula> listarPeliculas();
    
    public void guardarPelicula(Pelicula p);
    
    public void eliminarPelicula(Pelicula p);
    
    public Pelicula buscarPelicula(Pelicula p);
}
