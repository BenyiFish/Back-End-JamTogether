package ev3.jamtogether.controller;

import ev3.jamtogether.dto.Artista;
import ev3.jamtogether.dto.Banda;
import ev3.jamtogether.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PublicController {

    private final DataService dataService;

    @GetMapping("/bandas")
    public ResponseEntity<List<Banda>> getBandas() {
        return ResponseEntity.ok(dataService.obtenerTodasLasBandas());
    }

    @GetMapping("/artistas")
    public ResponseEntity<List<Artista>> getArtistas() {
        return ResponseEntity.ok(dataService.obtenerTodosLosArtistas());
    }
    
    // Endpoints para cargar tu data.js a la BD (solo úsalos una vez con Postman)
    @PostMapping("/bandas")
    public ResponseEntity<Banda> crearBanda(@RequestBody Banda banda) {
        return ResponseEntity.ok(dataService.guardarBanda(banda));
    }
    
    @PostMapping("/artistas")
    public ResponseEntity<Artista> crearArtista(@RequestBody Artista artista) {
        return ResponseEntity.ok(dataService.guardarArtista(artista));
    }
}