package ev3.jamtogether.config;

import ev3.jamtogether.dto.Artista;
import ev3.jamtogether.dto.Banda;
import ev3.jamtogether.repository.ArtistaRepository;
import ev3.jamtogether.repository.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private BandaRepository bandaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bandaRepository.count() == 0) {
            cargarBandas();
        }
        
        if (artistaRepository.count() == 0) {
            cargarArtistas();
        }
    }

    private void cargarBandas() {
        Banda b1 = crearBanda("Solar Flare", "Santiago", "Indie Rock", 
            "Banda con riffs frescos y letras introspectivas que exploran temas de juventud, cambio y autodescubrimiento.", 
            4, "Bajista", "Bar Loreto - 2 Nov", "/images/imgSolarFlare.jpg");

        Banda b2 = crearBanda("Neón Vibes", "Valparaíso", "Synthpop", 
            "Sonidos electrónicos y melodías pegajosas con una estética retro-futurista.", 
            5, "Tecladista", "Club Amanda - 10 Nov", "/images/imgSynthPop.jpg");

        Banda b3 = crearBanda("Cobre Jazz", "Antofagasta", "Jazz Fusion", 
            "Improvisación libre, armonías complejas y una mezcla de jazz clásico con influencias latinas.", 
            6, "Percusionista", "Teatro Municipal - 15 Nov", "/images/imgJazzFusion.jpg");

        Banda b4 = crearBanda("Trueno Pesado", "Coquimbo", "Heavy Metal", 
            "Riffs potentes, batería explosiva y voces desgarradoras definen su identidad.", 
            4, "Vocalista", "Rockódromo - 22 Nov", "/images/imgHeavyMetal.jpg");

        Banda b5 = crearBanda("Funkorama", "Calama", "Funk", 
            "Groove contagioso, bajos marcados y una energía imparable en el escenario.", 
            5, "No", "Sala Scd Bellavista - 25 Nov", "/images/imgFunk.jpg");

        Banda b6 = crearBanda("Mar Adentro", "La Serena", "Rock Alternativo", 
            "Melodías profundas y guitarras envolventes que retratan la nostalgia del norte costero.", 
            4, "Guitarrista líder", "Pub El Muelle - 29 Nov", "/images/imgRockAlternativo.jpg");

        Banda b7 = crearBanda("Estrella del Sur", "Puerto Montt", "Pop Rock", 
            "Canciones pegajosas, ritmos bailables y letras que conectan con el día a día.", 
            5, "Corista", "Casa del Arte Diego Rivera - 30 Nov", "/images/imgPopRock.jpg");

        Banda b8 = crearBanda("Lluvia de Sol", "Temuco", "Folk", 
            "Armonías acústicas con influencia mapuche y sonidos de la naturaleza.", 
            3, "Percusionista", "Centro Cultural de Temuco - 5 Dic", "/images/imgFolk.jpg");

        Banda b9 = crearBanda("Río Rojo", "Concepción", "Punk Rock", 
            "Energía cruda, letras contestatarias y una actitud rebelde.", 
            4, "No", "Bar La Puerta Roja - 8 Dic", "/images/imgPunkRock.jpg");

        Banda b10 = crearBanda("Andes Beat", "Santiago", "Electrónica", 
            "Mezcla de ritmos modernos y beats urbanos inspirados en la cordillera.", 
            2, "No", "Club Subterráneo - 9 Dic", "/images/imgElectronica.jpg");

        Banda b11 = crearBanda("Aurora Austral", "Puerto Varas", "Jazz", 
            "Improvisación elegante y melodías suaves que evocan los paisajes del sur.", 
            5, "Saxofonista", "Café Concert Austral - 12 Dic", "/images/imgJazz.jpg");

        Banda b12 = crearBanda("Fogoneros", "Osorno", "Rock Folk", 
            "Historias de la vida chilena contadas a través de guitarras acústicas.", 
            4, "Percusionista", "Festival del Sur - 14 Dic", "/images/imgRockFolk.webp");

        Banda b13 = crearBanda("Viento Norte", "Iquique", "Reggae", 
            "Ritmos relajados, mensajes positivos y una vibra playera.", 
            6, "Tecladista", "Playa Cavancha - 18 Dic", "/images/imgReggae.jpg");

        Banda b14 = crearBanda("Cascada Eléctrica", "Santiago", "Metal Progresivo", 
            "Complejidad técnica, cambios de ritmo y riffs agresivos.", 
            5, "No", "Sala Metrónomo - 20 Dic", "/images/imgMetalProgresivo.jpg");

        Banda b15 = crearBanda("Latido Urbano", "Valparaíso", "Hip Hop", 
            "Rap con mensaje social, líricas conscientes y beats urbanos.", 
            3, "Productor", "Centro Cultural Valpo - 22 Dic", "/images/imgHipHop.jpg");

        bandaRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15));
        System.out.println("--- Todas las bandas cargadas ---");
    }

    private void cargarArtistas() {
        Artista a1 = crearArtista("Camila Rivera", "Voz", "Santiago", 
            "Cantante versátil con experiencia en pop/rock e indie.", "/images/CamilaRiveraIMG.jpg");

        Artista a2 = crearArtista("Diego Fuentes", "Guitarra líder", "Valparaíso", 
            "Guitarrista con enfoque en riffs melódicos y solos.", "/images/DiegoFuentesIMG.jpg");

        Artista a3 = crearArtista("Ana Beltrán", "Bajo", "Antofagasta", 
            "Bajista con groove funk/rock, buen timing y experiencia en estudio.", "/images/AnaBeltranIMG.webp");

        Artista a4 = crearArtista("Felipe Contreras", "Batería", "Coquimbo", 
            "Baterista sólido, click track, doble bombo intermedio.", "/images/FelipeContrerasIMG.jpg");

        Artista a5 = crearArtista("Valentina Soto", "Teclados", "Calama", 
            "Sintetizadores, pianos y pads; arreglos para synthpop.", "/images/ValentinaSotoIMG.jpg");

        Artista a6 = crearArtista("Javier Ortiz", "Guitarra rítmica", "La Serena", 
            "Rítmico con buen groove, coros básicos.", "/images/JavierOrtizIMG.avif");

        Artista a7 = crearArtista("Constanza Mella", "Saxo alto", "Puerto Montt", 
            "Saxofonista con formación jazz, improvisación modal.", "/images/ConstanzaMellaIMG.jpg");

        Artista a8 = crearArtista("Tomás Aguilera", "Percusión", "Temuco", 
            "Cajón, congas y accesorios; refuerza grooves acústicos.", "/images/TomasAguileraIMG.jpg");

        Artista a9 = crearArtista("Isabel Núñez", "Voz", "Concepción", 
            "Registro mezzo con proyección; repertorio pop-rock.", "/images/IsabelNuñezIMG.avif");

        Artista a10 = crearArtista("Rodrigo Paredes", "Bajo", "Santiago", 
            "Bajo eléctrico 4/5 cuerdas, slap básico.", "/images/RodrigoParedesIMG.webp");

        Artista a11 = crearArtista("María José Vera", "Violín", "Valparaíso", 
            "Arreglos de cuerdas para pop/folk; lectura a primera vista.", "/images/MariaJoseVeraIMG.jpeg");

        Artista a12 = crearArtista("Lucas Fernández", "Guitarra líder", "Iquique", 
            "Lead con overdrive clásico, influencia blues/rock.", "/images/LucasFernandezIMG.jpg");

        artistaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12));
        System.out.println("--- Todos los artistas cargados ---");
    }

   
    private Banda crearBanda(String nombre, String ciudad, String estilo, String desc, int integrantes, String buscan, String concierto, String img) {
        Banda b = new Banda();
        b.setNombre(nombre);
        b.setCiudad(ciudad);
        b.setEstilo(estilo);
        b.setDescripcion(desc);
        b.setIntegrantes(integrantes);
        b.setBuscan(buscan);
        b.setConcierto(concierto);
        b.setImage(img);
        return b;
    }

    private Artista crearArtista(String nombre, String instrumento, String ciudad, String desc, String img) {
        Artista a = new Artista();
        a.setNombre(nombre);
        a.setInstrumento(instrumento);
        a.setCiudad(ciudad);
        a.setDescripcion(desc);
        a.setImage(img); 
        return a;
    }
}