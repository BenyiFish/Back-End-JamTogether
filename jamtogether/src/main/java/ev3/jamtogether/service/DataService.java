package ev3.jamtogether.service;

import ev3.jamtogether.dto.Artista;
import ev3.jamtogether.dto.Banda;
import ev3.jamtogether.repository.ArtistaRepository;
import ev3.jamtogether.repository.BandaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final BandaRepository bandaRepository;
    private final ArtistaRepository artistaRepository;

    public List<Banda> obtenerTodasLasBandas() {
        return bandaRepository.findAll();
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return artistaRepository.findAll();
    }
    
  
    public Banda guardarBanda(Banda banda) {
        return bandaRepository.save(banda);
    }

    public Artista guardarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }
}