package com.mvp.services.implementations;

import com.mvp.domain.Deck;
import com.mvp.repositories.DeckRepo;
import com.mvp.services.DeckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeckServiceImpl implements DeckService {

    private final DeckRepo deckRepo;

    @Override
    public Deck getDeckById(Integer id) {
        return deckRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Deck> getAllDecks() {
        System.out.println("test");
        return deckRepo.findAll();
    }
}
