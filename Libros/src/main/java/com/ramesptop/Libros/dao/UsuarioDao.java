package com.ramesptop.Libros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ramesptop.Libros.*;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
