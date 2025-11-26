package ev3.jamtogether; 

import com.fasterxml.jackson.databind.ObjectMapper;
import ev3.jamtogether.controller.AuthController; 
import ev3.jamtogether.dto.RegistroRequestDTO;
import ev3.jamtogether.dto.Usuario;
import ev3.jamtogether.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos Java a JSON

    @MockBean
    private UsuarioService usuarioService; // Usuario de prueba simulado

    @Test
    public void testRegistroExitoso() throws Exception {
        // Creamos el objeto que enviaría el Frontend (DTO)
        RegistroRequestDTO registroInput = new RegistroRequestDTO();
        registroInput.setUsername("testUser");
        registroInput.setEmail("test@jam.com");
        registroInput.setPassword("12345");
        registroInput.setCity("Santiago");
        registroInput.setEdad(25);
        registroInput.setInstrumento("Guitarra");

        // Creamos el objeto que devolvería la Base de Datos simulada (Entidad)
        Usuario usuarioGuardado = new Usuario();
        usuarioGuardado.setId(1L); 
        usuarioGuardado.setUsername("testUser");
        usuarioGuardado.setEmail("test@jam.com");
        usuarioGuardado.setPassword("12345");
        usuarioGuardado.setCity("Santiago");
        usuarioGuardado.setEdad(25);
        usuarioGuardado.setInstrumento("Guitarra");
        usuarioGuardado.setRol("user");

   
        // Le decimos a Mockito: "Cuando alguien llame a registrarUsuario con cualquier DTO,
        // devuelve este 'usuarioGuardado' 
        when(usuarioService.registrarUsuario(any(RegistroRequestDTO.class))).thenReturn(usuarioGuardado);

        // Realizamos la petición POST al endpoint /api/auth/registro
        mockMvc.perform(post("/api/auth/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registroInput))) 
                
               
                .andExpect(status().isOk())
                
               
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("testUser"))
                .andExpect(jsonPath("$.email").value("test@jam.com"))
                .andExpect(jsonPath("$.rol").value("user"));
    }
}