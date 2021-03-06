
package com.ramesptop.agenda;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Data
@Entity
@Table(name = "contacto" )
public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String telefono;
}
