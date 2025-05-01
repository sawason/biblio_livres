package com.biblio.livres.controller;

import com.biblio.livres.dto.PreterLivreRequest;
import com.biblio.livres.model.Livre;
import com.biblio.livres.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreRepository livreRepository;

    // Afficher tous les livres
    @GetMapping
    public Iterable<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Afficher un livre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        Livre livre = livreRepository.findById(id).orElse(null);
        if (livre == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livre);
    }
    //supprimer livres
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> supprimerLivre(@PathVariable Long id) {
        return livreRepository.findById(id).map(livre -> {
            livreRepository.delete(livre);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    // preter livre
//    @PostMapping("/preter")
//    public ResponseEntity<String> preterLivre(@RequestBody PreterLivreRequest request) {
//        Optional<Livre> livreOpt = livreRepository.findById(request.getLivreId());
//
//        if (livreOpt.isPresent()) {
//            Livre livre = livreOpt.get();
//
//            return ResponseEntity.ok("Livre prêté à l'utilisateur ID : " + request.getUserId());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//
//    }

    @PostMapping("/preter")
    public ResponseEntity<String> preterLivre(@RequestBody PreterLivreRequest request) {
        // Trouver le livre par son ID
        Optional<Livre> livreOpt = livreRepository.findById(request.getLivreId());

        if (livreOpt.isPresent()) {
            Livre livre = livreOpt.get();

            // Vérifier si le livre est disponible
            if (livre.isDisponible()) {
                livre.setDisponible(false); // Le livre devient indisponible
                livreRepository.save(livre); // Enregistrer l'état mis à jour du livre
                return ResponseEntity.ok("Livre prêté à l'utilisateur ID : " + request.getUserId());
            } else {
                return ResponseEntity.badRequest().body("Le livre n'est pas disponible"); // Si le livre n'est pas disponible
            }
        } else {
            return ResponseEntity.notFound().build(); // Si le livre n'existe pas
        }
    }

    // (Optionnel) Si vous voulez créer une méthode pour retourner un livre, vous pouvez créer un endpoint comme ceci
    @PostMapping("/retourner")
    public ResponseEntity<String> retournerLivre(@RequestBody PreterLivreRequest request) {
        Optional<Livre> livreOpt = livreRepository.findById(request.getLivreId());
        if (livreOpt.isPresent()) {
            Livre livre = livreOpt.get();

            // Vérifier si le livre est déjà disponible
            if (!livre.isDisponible()) {
                livre.setDisponible(true); // Le livre devient disponible à nouveau
                livreRepository.save(livre); // Enregistrer l'état mis à jour du livre
                return ResponseEntity.ok("Livre retourné par l'utilisateur ID : " + request.getUserId());
            } else {
                return ResponseEntity.badRequest().body("Le livre est déjà disponible"); // Si le livre est déjà retourné
            }
        } else {
            return ResponseEntity.notFound().build(); // Si le livre n'existe pas
        }
    }
}

