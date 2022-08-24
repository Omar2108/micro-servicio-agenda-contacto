
package com.omar.agenda.service;

import com.omar.agenda.domian.Contacto;
import com.omar.agenda.repository.ContactoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *@author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 *@version 1.0.0 24/08/2022
 */

@Service
@Component
public class ContactoService implements IContactoService{
    
    @Autowired//para inyectar contactoDao
    private ContactoRepository contactoRepository;
    
    /**
     * Metodo para consultado todo los contactos de la tabla
     * @return
     */

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> list() {
        return (List<Contacto>) contactoRepository.findAll();
    }
    
     /**
     * Metodo para guardar un nuevo contacto
     * @param contacto
     * @return
     */

    @Override
    @Transactional
    public Contacto save(Contacto contacto) {

        return contactoRepository.save(contacto);

    }
    
    /**
     * Metodo para consultar un contacto por el id un contacto
     * @param id
     * @return
     */

    @Transactional(readOnly = true)
    @Override
    public Optional<Contacto> findContact(Long id) {
        return contactoRepository.findById(id);
        

    }
    
    /**
     * Metodo para actualizar por el id un contacto
     * @param id
     * @param contacto
     * @return
     */

    @Override
    @Transactional
    public Contacto update(Long id, Contacto contacto) {
        contacto.setId(id);
        return contactoRepository.save(contacto);
        

    }
    
    /**
     * Metodo para modificar el nombre de un contacto por el id un contacto
     * @param id
     * @param contacto
     * 
     */
    
    @Transactional
    public void updateNombre(Long id, Contacto contacto) {
       contactoRepository.updateNombre(id, contacto.getNombreCompleto());
    }
    
    /**
     * Metodo para modificar el telefono de un contacto por el id un contacto
     * @param id
     * @param contacto
     * 
     */
    
    @Transactional
    public void updateTelefono(Long id, Contacto contacto) {
       contactoRepository.updateTelefono(id, contacto.getTelefono());
    }
    
    
    /**
     * Metodo para modificar el email de un contacto por el id un contacto
     * @param id
     * @param contacto
     * 
     */
    
    @Transactional
    public void updateEmail(Long id, Contacto contacto) {
       contactoRepository.updateEmail(id, contacto.getEmail());
    }
    
    
    /**
     * Metodo para modificar la fecha de nacimiento de un contacto por el id un contacto
     * @param id
     * @param contacto
     * 
     */
    
    @Transactional
    public void updateDireccion(Long id, Contacto contacto) {
       contactoRepository.updateDireccion(id, contacto.getDireccion());
    }
    
   
    
    /**
     * Metodo para eliminar por el id un contacto
     * @param contacto
     * 
     */

    @Override
    @Transactional
    public void delete(Contacto contacto) {
       contactoRepository.delete(contacto);
    }

   
    
}
