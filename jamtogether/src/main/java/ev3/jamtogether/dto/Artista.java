package ev3.jamtogether.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String instrumento;
    private String ciudad;
    
    @Column(length = 1000)
    private String descripcion;
    
    private String ocupacion; 
    
    @Column(length = 1000)
    private String image;
}