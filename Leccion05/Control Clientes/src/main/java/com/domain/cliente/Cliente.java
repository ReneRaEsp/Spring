
package com.domain.cliente;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@Table(name =  "cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    private String correo;
    
    @NotEmpty
    private String telefono;
}
