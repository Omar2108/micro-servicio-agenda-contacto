
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
     * @param nombre
     * 
     */
    
    @Transactional
    public void updateNombre(Long id, String nombre) {
       contactoRepository.updateNombre(id, nombre);
    }
    
    /**
     * Metodo para modificar el telefono de un contacto por el id un contacto
     * @param id
     * @param telefono
     * 
     */
    
    @Transactional
    public void updateTelefono(Long id, String telefono) {
       contactoRepository.updateTelefono(id, telefono);
    }
    
    
    /**
     * Metodo para modificar el email de un contacto por el id un contacto
     * @param id
     * @param email
     * 
     */
    
    @Transactional
    public void updateEmail(Long id, String email) {
       contactoRepository.updateEmail(id, email);
    }
    
    
    /**
     * Metodo para modificar la fecha de nacimiento de un contacto por el id un contacto
     * @param id
     * @param direccion
     * 
     */
    
    @Transactional
    public void updateDireccion(Long id, String direccion) {
       contactoRepository.updateDireccion(id, direccion);
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
