package com.ramesptop.Libros;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@Table(name = "libro")
public class Libro implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    
    @NotEmpty
    public String titulo;
    
    @NotEmpty
    public String year;
    
    @NotEmpty
    public String genero;
    
    @NotEmpty
    public String isbn;
}
