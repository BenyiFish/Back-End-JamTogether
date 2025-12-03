package ev3.jamtogether.controller;

import ev3.jamtogether.dto.Artista;
import ev3.jamtogether.dto.Banda;
import ev3.jamtogether.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class PublicController {

    private final DataService dataService;

    // --- GET: OBTENER DATOS (Lectura) ---

    @GetMapping("/bandas")
    public ResponseEntity<List<Banda>> getBandas() {
        return ResponseEntity.ok(dataService.obtenerTodasLasBandas());
    }

    @GetMapping("/artistas")
    public ResponseEntity<List<Artista>> getArtistas() {
        return ResponseEntity.ok(dataService.obtenerTodosLosArtistas());
    }

    // --- POST: GUARDAR DATOS (Escritura) ---

    @PostMapping("/bandas")
    public ResponseEntity<Banda> crearBanda(@RequestBody Banda banda) {
        // Recibe el JSON del formulario de React y lo guarda
        return ResponseEntity.ok(dataService.guardarBanda(banda));
    }

    @PostMapping("/artistas")
    public ResponseEntity<Artista> crearArtista(@RequestBody Artista artista) {
        // Recibe el JSON del formulario de React y lo guarda
        return ResponseEntity.ok(dataService.guardarArtista(artista));
    }
}