package com.mvp.services;

import com.mvp.domain.Deck;


import java.util.List;

public interface DeckService {

    Deck getDeckById(Integer id);
    List<Deck> getAllDecks();

}
