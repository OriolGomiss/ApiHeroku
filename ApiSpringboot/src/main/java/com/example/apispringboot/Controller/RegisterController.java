package com.example.apispringboot.Controller;

import com.example.apispringboot.Model.User.User;
import com.example.apispringboot.Model.User.UserDTO;
import com.example.apispringboot.Model.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final UserService serveiUsuaris;


    @GetMapping("/me")
    public UserDTO consultaQuiEts(@AuthenticationPrincipal User usu) {
        return new UserDTO(usu.getUsername(), usu.getAvatar(), usu.getRol());
    }

    /*
    {
    "username":"Montse",
    "password":"1234",
    "avatar":"http://imatge.com"
    }
    Afegeix id automàticament
     */
    @PostMapping("/users/add")
    public ResponseEntity<?> nouUsuari(@RequestBody User nouUsuari) {
        try {
            User res = serveiUsuaris.crearNouUsuari(nouUsuari);
            UserDTO usu = new UserDTO(res.getUsername(), res.getAvatar(), res.getRol());
            return new ResponseEntity<UserDTO>(usu, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            //per si intentem afegir 2 usuaris amb el mateix username, saltarà excepció
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> llistarUsuarisDTO() {
        List<User> res = serveiUsuaris.llistarUsuaris();
        List<UserDTO> aux = new ArrayList();
        for (User usu : res) {
            aux.add(new UserDTO(usu.getUsername(), usu.getAvatar(), usu.getRol()));
        }
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(aux);
    }
}
