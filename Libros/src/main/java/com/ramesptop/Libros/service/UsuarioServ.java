package com.ramesptop.Libros.service;

import org.springframework.stereotype.Service;
import com.ramesptop.Libros.dao.*;
import com.ramesptop.Libros.Rol;
import com.ramesptop.Libros.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioServ implements UserDetailsService{
    @Autowired
    private UsuarioDao dao;
    
    @Override
    @Transactional(readOnly =  true)
    public UserDetails loadUserByUsername(String username){
        Usuario usuario = dao.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
