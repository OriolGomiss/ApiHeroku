package com.example.apispringboot.Controller;

import com.example.apispringboot.Model.Entities.Anime;
import com.example.apispringboot.Model.Services.ServeiAnime;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnimeController {
    private final ServeiAnime serveiAnime;

    @GetMapping("/animes")
    public ResponseEntity<?> llistarAnimes(){
        List<Anime> animeList=serveiAnime.llistarAnimes();
        if(animeList.isEmpty()==true){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeList);
        }

    }

    @GetMapping("/animes/{id}")
    public  ResponseEntity<?> consultarAnimePerId(@PathVariable String id){
        Anime animeid=serveiAnime.consultarAnime(id);
        if(animeid==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeid);
        }

    }

    @PostMapping("/animes")
    public  ResponseEntity<?> afegirAnime(@RequestBody Anime anime){
        Anime animeid=serveiAnime.afegirAnime(anime);
        if(animeid==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeid);
        }
    }

    @GetMapping("/animes/name/{animename}")
    public ResponseEntity<?> consultarAnimePerName(@PathVariable String animename){
        List<Anime> animeList=serveiAnime.llistarAnimeName(animename);
        if(animeList.isEmpty()==true){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeList);
        }
    }
    @GetMapping("/animes/seassonLT/{seasson}")
    public ResponseEntity<?> consultarAnimePerSeasonMenorA(@PathVariable int seasson){
        List<Anime> animeList=serveiAnime.llistarPerSeasonsMenorA(seasson);
        if(animeList.isEmpty()==true){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeList);
        }
    }
    @GetMapping("/animes/season/{seasson}")
    public ResponseEntity<?> consultarAnimePerSeason(@PathVariable int seasson){
        List<Anime> animeList=serveiAnime.llistarAnimePerSeason(seasson);
        if(animeList.isEmpty()==true){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeList);
        }
    }
    @DeleteMapping("/animes/delete/{id}")
    public ResponseEntity<?> consultarAnimePerSeason(@PathVariable String id){
        List<Anime> animeid=serveiAnime.eliminarAnime(id);
        if(animeid.isEmpty()==true){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(animeid);
        }
    }

}
