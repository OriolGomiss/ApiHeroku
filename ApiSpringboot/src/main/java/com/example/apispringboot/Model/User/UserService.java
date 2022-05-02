package com.example.apispringboot.Model.User;

import com.example.apispringboot.Model.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final UserRepository repositoriUsuari;
    private final PasswordEncoder xifrat;


    public UserService(UserRepository repositoriUsuari, PasswordEncoder xifrat) {
        this.repositoriUsuari = repositoriUsuari;
        this.xifrat = xifrat;
    }

    public User consultarPerUsername(String username) {
        return repositoriUsuari.findByUsername(username).orElse(null);
    }

    public User crearNouUsuari(User nouUsuari) {
        //falta controlar que els 2 passwords del client coincideixen
        //passar un UsuariCreacioDTO
        nouUsuari.setPassword(xifrat.encode(nouUsuari.getPassword()));
        repositoriUsuari.save(nouUsuari);
        return nouUsuari;
    }

    public List<User> llistarUsuaris() {
        return repositoriUsuari.findAll();
    }
}

