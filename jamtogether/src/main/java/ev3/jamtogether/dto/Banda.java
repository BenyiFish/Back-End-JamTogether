package ev3.jamtogether.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bandas")
public class Banda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;
    private String estilo;
    
    @Column(length = 1000) 
    private String descripcion;
    
    private Integer integrantes;
    private String buscan;     
    private String concierto;  
    
    @Column(length = 1000)
    private String image;      
}