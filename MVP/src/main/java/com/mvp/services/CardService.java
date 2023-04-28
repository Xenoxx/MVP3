package com.mvp.services;

import com.mvp.domain.Card;

import java.util.List;

public interface CardService {

    Card getCardById(Integer id);
    List<Card> getAllCards();
    List<Card> getAllCardsByDeckId(Integer id);


}
