package com.ramesptop.Libros.service;

import java.util.List;
import com.ramesptop.Libros.Libro;

public interface ILibroServ {
    public List<Libro> listarLibros();
    
    public void guardarLibro(Libro libro);
    
    public void eliminarLibro(Libro libro);
    
    public Libro buscarLibroPorId(Libro libro);
}
