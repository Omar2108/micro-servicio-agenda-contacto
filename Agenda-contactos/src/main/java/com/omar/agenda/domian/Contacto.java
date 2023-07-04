
package com.omar.agenda.domian;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * Representa el modelo que va comunicarse con la base de datos
 *
 * @author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 * @version 1.0.0 24/08/2022
 */
@Data
@Entity
@Table(name = "contactos")
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreCompleto;

    private String telefono;

    private String email;
    
    private String direccion;
    
    private String tipoRelacion;
    
    private String relacion;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
    
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    
    public String getTipoRelacion() {
        return tipoRelacion;
    }
    
    public String getRelacion() {
        return relacion;
    }


}
