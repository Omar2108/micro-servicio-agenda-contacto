
package com.omar.agenda.domian;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Representa el modelo que va comunicarse con la base de datos
 *
 * @author Omar Rodriguez Chamorro < omar.rodriguez2108@hotmail.com >
 * @version 1.0.0 24/08/2022
 */
@Data
@Entity
@Table(name = "contactos")
@NoArgsConstructor
@AllArgsConstructor
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


}
