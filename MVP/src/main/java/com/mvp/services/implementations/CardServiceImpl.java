package com.mvp.services.implementations;

import com.mvp.domain.Card;
import com.mvp.repositories.CardRepo;
import com.mvp.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;

    @Override
    public Card getCardById(Integer id) {
        return cardRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    @Override
    public List<Card> getAllCardsByDeckId(Integer id) {
        return cardRepo.findCardByIdDeck(id);
    }
}
