package com.ramesptop.agenda.service;

import com.ramesptop.agenda.Contacto;
import java.util.List;


public interface IContactoServ {
            public List<Contacto> listarContactos();
        
            public void guardarContacto(Contacto contacto);
        
            public Contacto buscarContactoPorId(Contacto contacto);
        
            public void eliminarContacto(Contacto contacto);
}
