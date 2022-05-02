package com.example.apispringboot.Model.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Anime {
    @Id
    //@GeneratedValue
    private String animeid;
    private String animeName;
    private int seasons;
}
