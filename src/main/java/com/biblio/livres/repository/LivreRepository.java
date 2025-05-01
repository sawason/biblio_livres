package com.biblio.livres.repository;

import com.biblio.livres.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    List<Livre> findByDisponibleTrue();
    //SELECT * FROM livre WHERE disponible = true.


}
