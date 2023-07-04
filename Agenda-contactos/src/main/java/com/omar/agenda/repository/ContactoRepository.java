
package com.omar.agenda.repository;

import com.omar.agenda.domian.Contacto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *Interfaz que contiene los metodos minimos para iteractuar con la base de datos
 * @author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 * @version 1.0.0 24/08/2022
 */
public interface ContactoRepository extends CrudRepository<Contacto, Long>{
    
    @Modifying
    @Query("update Contacto contact set contact.nombreCompleto = :nombreCompleto where contact.id = :id")
    public void updateNombre(@Param(value="id") Long id, @Param(value="nombreCompleto") String nombreCompleto);
    
    
    @Modifying
    @Query("update Contacto contact set contact.telefono = :telefono where contact.id = :id")
    public void updateTelefono(@Param(value="id") Long id, @Param(value="telefono") String telefono);
    
    @Modifying
    @Query("update Contacto contact set contact.email = :email where contact.id = :id")
    public void updateEmail(@Param(value="id") Long id, @Param(value="email") String email);
    
    @Modifying
    @Query("update Contacto contact set contact.direccion = :direccion where contact.id = :id")
    public void updateDireccion(@Param(value="id") Long id, @Param(value="direccion") String direccion);
    
    @Modifying
    @Query("update Contacto contact set contact.tipoRelacion = :tipoRelacion where contact.id = :id")
    public void updateTipoRelacion(@Param(value="id") Long id, @Param(value="tipoRelacion") String tipoRelacion);
    
    @Modifying
    @Query("update Contacto contact set contact.relacion = :relacion where contact.id = :id")
    public void updateRelacion(@Param(value="id") Long id, @Param(value="relacion") String relacion);
    
}
