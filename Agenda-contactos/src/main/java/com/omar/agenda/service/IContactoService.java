
package com.omar.agenda.service;

import com.omar.agenda.domian.Contacto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 * @version 1.0.0 24/08/2022
 */
public interface IContactoService {
    
     public List<Contacto> list();
    
    public Contacto save(Contacto contacto);
    
    public Contacto update(Long id, Contacto contacto);
    
    public void delete(Contacto contacto);
    
    public Optional<Contacto> findContact(Long id);
    
}
