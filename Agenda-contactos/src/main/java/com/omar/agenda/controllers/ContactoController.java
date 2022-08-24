
package com.omar.agenda.controllers;

import com.omar.agenda.domian.Contacto;
import com.omar.agenda.service.ContactoService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 * @version 1.0.0 24/08/2022
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
@RequestMapping(path = "/agenda")
public class ContactoController {
    
    @Autowired//para inyectar ContactoService
    private ContactoService contactoService;

    
    /**
     * Metodo para listar todo los contactos
     *
     * @return
     */
    @GetMapping(path = "/all")
    public List<Contacto> listarContactos() {

        var contactos = contactoService.list();
        return contactos;
    }

    /**
     * Metodo para agregar un contacto
     *
     * @param nombreCompleto
     * @param telefono
     * @param email
     * @param direccion
     * @return
     */
    
    @PostMapping(path = "/add")
    public @ResponseBody String agregarContacto(@RequestParam String nombreCompleto,@RequestParam String telefono, @RequestParam String email, @RequestParam String direccion) {
        
        Contacto cont = new Contacto();
        
        cont.setNombreCompleto(nombreCompleto);
        cont.setTelefono(telefono);
        cont.setEmail(email);
        cont.setDireccion(direccion);
        contactoService.save(cont);
        return "Saved";
    }
    
    
    /**
     * Metodo para consultar la informacion completa de un contacto
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/find/{id}")
    public Optional<Contacto> consultarContacto(@PathVariable("id") Long id) {
        var contacto = contactoService.findContact(id);
        return contacto;
    }

    /**
     * Metodo para actualizar la informacion completa del contacto
     *
     * @param contacto
     * @param id
     * @return
     */
    @PutMapping(path = "/contacto/{id}")
    public ResponseEntity<Contacto> actualizarContacto(Contacto contacto, @PathVariable("id") Long id) {
        log.info("contacto a modificar: {}", contacto);
        contactoService.update(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar el nombre del contacto
     *
     * @param contacto
     * @param id
     * @return
     */
    @PatchMapping(path = "/contacto/nombre/{id}")
    public ResponseEntity<Contacto> editarnombre(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Modificar el nombre del contacto: {}", contacto);
        contactoService.updateNombre(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar el numero de telefono del contacto
     *
     * @param contacto
     * @param id
     * @return
     */
    @PatchMapping(path = "/contacto/telefono/{id}")
    public ResponseEntity<Contacto> editarTelefono(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Modificar el telefono del contacto: {}", contacto);
        contactoService.updateTelefono(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar el correo electronico del contacto
     *
     * @param contacto
     * @param id
     * @return
     */
    @PatchMapping(path = "/contacto/email/{id}")
    public ResponseEntity<Contacto> editarEmail(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Modificar el email del contacto: {}", contacto);
        contactoService.updateEmail(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Metodo para actualizar la direccion del contacto
     *
     * @param contacto
     * @param id
     * @return
     */
    @PatchMapping(path = "/contacto/direccion/{id}")
    public ResponseEntity<Contacto> editarDireccion(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Modificar la direccion del contacto: {}", contacto);
        contactoService.updateDireccion(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }


    /**
     * Metodo para borrado fisico un contacto
     *
     * @param contacto
     * @return
     */
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String eliminarContacto(Contacto contacto) {
        log.info("contacto a eliminar: {}", contacto);
        contactoService.delete(contacto);
        return "deleted contact";
    }
    
}
