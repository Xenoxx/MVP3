package com.mvp.repositories;

import com.mvp.domain.Deck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeckRepo extends CrudRepository<Deck, Integer> {



    @Query(value = "SELECT * FROM Deck WHERE idDeck = :idDeck", nativeQuery = true)
    Optional<Deck> findById(@Param("idDeck") Integer idDeck);

//    Optional<Deck> findById(Integer id);

    @Query(value = "select * from Deck", nativeQuery = true)
    List<Deck> findAll();

}
