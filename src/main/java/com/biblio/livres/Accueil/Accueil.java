package com.biblio.livres.Accueil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Accueil {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World from REST API!";
    }
}
