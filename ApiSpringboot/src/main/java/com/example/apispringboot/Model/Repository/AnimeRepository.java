package com.example.apispringboot.Model.Repository;

import com.example.apispringboot.Model.Entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime,String> {
    //List<Anime> findByAnimeName(String AnimeName);
    //long countBySeasons(int Seasson);
    //List<Anime> findBySeasonsIsLessThan(int seasson);


}
