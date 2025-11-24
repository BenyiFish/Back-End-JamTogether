package ev3.jamtogether.controller;

import ev3.jamtogether.dto.LoginRequestDTO;
import ev3.jamtogether.dto.RegistroRequestDTO;
import ev3.jamtogether.dto.Usuario;
import ev3.jamtogether.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody RegistroRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.loginUsuario(dto.getUsername(), dto.getPassword()));
    }

    // Endpoint extra para Admin.jsx
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