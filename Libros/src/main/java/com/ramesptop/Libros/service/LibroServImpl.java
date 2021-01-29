package com.ramesptop.Libros.service;

import com.ramesptop.Libros.Libro;
import com.ramesptop.Libros.dao.ILibroDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServImpl implements ILibroServ{
    @Autowired
    private ILibroDao dao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return (List<Libro>) dao.findAll();
    }

    @Override
    @Transactional
    public void guardarLibro(Libro libro) {
        dao.save(libro);
    }

    @Override
    @Transactional
    public void eliminarLibro(Libro libro) {
        dao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro buscarLibroPorId(Libro libro) {
        return dao.findById(libro.getIdLibro()).orElse(null);
    }
    
}
