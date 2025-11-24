package ev3.jamtogether.dto;
import lombok.Data;

@Data
public class RegistroRequestDTO {
    private String username;
    private String email;
    private String password;
    private String city;
    private Integer edad;
    private String instrumento;
}