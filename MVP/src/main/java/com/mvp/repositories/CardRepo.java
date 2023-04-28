package com.mvp.repositories;


import com.mvp.domain.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardRepo extends CrudRepository<Card, Integer> {

    @Query(value = "SELECT * FROM Cards WHERE idCards = :idCard", nativeQuery = true)
    Optional<Card> findById(@Param("idCard") Integer idCard);

    @Query(value = "SELECT * FROM Cards", nativeQuery = true)
    List<Card> findAll();

    @Query(value = "SELECT * FROM Cards WHERE idDeck = :idDeck", nativeQuery = true)
    List<Card> findCardByIdDeck(@Param("idDeck") Integer idDeck);

}
