package ev3.jamtogether.service;

import ev3.jamtogether.dto.RegistroRequestDTO;
import ev3.jamtogether.dto.Usuario;
import ev3.jamtogether.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    // Obtener todos los usuarios ( Admin.jsx)
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    // Eliminar usuario ( Admin.jsx)
    public void eliminarUsuario(String username) {
        Usuario usuario = repository.findByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        
        if ("admin".equals(usuario.getRol())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No se puede eliminar a un administrador");
        }
        repository.delete(usuario);
    }

    public Usuario registrarUsuario(RegistroRequestDTO dto) {
        if (repository.existsByUsername(dto.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre de usuario ya está registrado");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(dto.getUsername());
        nuevoUsuario.setEmail(dto.getEmail());
        nuevoUsuario.setPassword(dto.getPassword());
        nuevoUsuario.setCity(dto.getCity());
        nuevoUsuario.setEdad(dto.getEdad());
        nuevoUsuario.setInstrumento(dto.getInstrumento());
        nuevoUsuario.setRol("user");

        return repository.save(nuevoUsuario);
    }

    public Usuario loginUsuario(String username, String password) {
        Usuario usuario = repository.findByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no existe"));

        if (!usuario.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña incorrecta");
        }
        return usuario;
    }
}