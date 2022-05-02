package com.example.apispringboot.Model.Services;


import com.example.apispringboot.Model.Entities.Anime;
import com.example.apispringboot.Model.Repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiAnime {

    private final AnimeRepository animeRepository;

    public List<Anime>llistarAnimes(){
        return animeRepository.findAll();
    }
    public List<Anime> llistarAnimeName(String name){
        return animeRepository.findByAnimeName(name);
    }
    public List<Anime> llistarPerSeasonsMenorA(Integer Season){
        return animeRepository.findBySeasonsIsLessThan(Season);
    }
    public List<Anime> llistarAnimePerSeason(Integer Season){
        return animeRepository.findBySeasons(Season);
    }

    public Anime consultarAnime(String Id){
        return  animeRepository.findById(Id).orElse(null);
    }

    public Anime afegirAnime(Anime anime){
        return animeRepository.save(anime);
    }

    /*public Anime modificarAnime(Anime anime){
        Anime anime1 = null;
        if(animeRepository.existsById(anime.getAnimeid())){
            anime1=animeRepository.save(anime);

        }
        return anime1;
    }*/

    public List<Anime> eliminarAnime(String id){
        Anime anime=animeRepository.findById(id).orElse(null);
        if (anime!=null){
            animeRepository.deleteById(id);

        }
        return animeRepository.findAll();
    }






}
