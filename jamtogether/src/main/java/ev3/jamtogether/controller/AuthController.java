package ev3.jamtogether.controller;

import ev3.jamtogether.dto.LoginRequestDTO;
import ev3.jamtogether.dto.RegistroRequestDTO;
import ev3.jamtogether.dto.Usuario;
import ev3.jamtogether.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class AuthController {

    private final UsuarioService usuarioService;

    // --- REGISTRO DE USUARIOS ---
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody RegistroRequestDTO dto) {
        // Llama al servicio para crear el usuario en la BD
        return ResponseEntity.ok(usuarioService.registrarUsuario(dto));
    }

    // --- INICIO DE SESIÓN (LOGIN) ---
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequestDTO dto) {
        // Verifica credenciales y retorna el usuario si son correctas

        return ResponseEntity.ok(usuarioService.loginUsuario(dto.getUsername(), dto.getPassword()));
    }

    // --- GESTIÓN DE USUARIOS (Para panel de Admin) ---
    
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
    
    @DeleteMapping("/usuarios/{username}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String username) {
        usuarioService.eliminarUsuario(username);
        return ResponseEntity.noContent().build();
    }
}