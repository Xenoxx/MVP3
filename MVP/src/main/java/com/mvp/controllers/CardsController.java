package com.mvp.controllers;


import com.mvp.domain.Card;
import com.mvp.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardsController {

    private final CardService cardService;

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

}
