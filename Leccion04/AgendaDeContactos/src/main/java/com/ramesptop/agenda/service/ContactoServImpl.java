
package com.ramesptop.agenda.service;

import com.ramesptop.agenda.Contacto;
import java.util.List;
import com.ramesptop.agenda.dao.IContactoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServImpl implements IContactoServ{
    @Autowired
    private IContactoDao dao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Contacto> listarContactos() {
            return (List<Contacto>) dao.findAll();
    }

    @Override
    @Transactional
    public void guardarContacto(Contacto contacto) {
           dao.save(contacto);
    }

    @Override
    @Transactional(readOnly = true)
    public Contacto buscarContactoPorId(Contacto contacto) {
        return dao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarContacto(Contacto contacto) {
        dao.delete(contacto);
    }
    
}
