package com.example.apispringboot.Controller;

import com.example.apispringboot.Model.Entities.Anime;
import com.example.apispringboot.Model.Services.ServeiAnime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnimeController {
    private final ServeiAnime serveiAnime;

    @GetMapping("/animes")
    public List<Anime> llistarAnimes(){
        return serveiAnime.llistarAnimes();
    }

    @GetMapping("/animes/{id}")
    public  Anime consultarAnimePerId(@PathVariable String id){
        return  serveiAnime.consultarAnime(id);
    }

    @PostMapping("/animes")
    public  Anime afegirAnime(@RequestBody Anime anime){
        return  serveiAnime.afegirAnime(anime);
    }

    @GetMapping("/animes/name/{animename}")
    public List<Anime> consultarAnimePerName(@PathVariable String animename){
        return serveiAnime.llistarAnimeName(animename);
    }
    @GetMapping("/animes/seassonLT/{seasson}")
    public List<Anime> consultarAnimePerSeasonMenorA(@PathVariable int seasson){
        return serveiAnime.llistarPerSeasonsMenorA(seasson);
    }
    @GetMapping("/animes/season/{seasson}")
    public List<Anime> consultarAnimePerSeason(@PathVariable int seasson){
        return serveiAnime.llistarAnimePerSeason(seasson);
    }
    @DeleteMapping("/animes/delete/{id}")
    public List<Anime> consultarAnimePerSeason(@PathVariable String id){
        return serveiAnime.eliminarAnime(id);
    }

}
