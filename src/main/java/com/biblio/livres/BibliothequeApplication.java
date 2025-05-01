package com.biblio.livres;


import com.biblio.livres.model.Livre;
import com.biblio.livres.repository.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(LivreRepository livreRepository) {
        return args -> {
            // Ajoute des livres à la base de données
            livreRepository.save(new Livre("Introduction à Java", "Introduction à Java", "John Doe", true));
            livreRepository.save(new Livre("Python pour débutants", "Python pour débutants", "Jane Smith", false));
            livreRepository.save(new Livre("Structures de données en C", "Structures de données en C", "Bill Gates", true));
            livreRepository.save(new Livre("Algorithmes avancés", "Algorithmes avancés", "Ada Lovelace", false));
            livreRepository.save(new Livre("Les bases de données SQL", "Les bases de données SQL", "Alan Turing", true));
            livreRepository.save(new Livre("Développement Web avec HTML5", "Développement Web avec HTML5", "Chris Johnson", true));
            livreRepository.save(new Livre("CSS et design réactif", "CSS et design réactif", "Sarah Connor", false));
            livreRepository.save(new Livre("JavaScript et Node.js", "JavaScript et Node.js", "Martin Fowler", true));
            livreRepository.save(new Livre("Introduction à C++", "Introduction à C++", "Bjarne Stroustrup", true));};
    }
}
