package com.mvp.controllers;

import com.mvp.domain.Deck;
import com.mvp.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/deck")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeckController {

    private final DeckService deckService;

    @GetMapping("/")
    public ResponseEntity<List<Deck>> getAllDecks() {
        return ResponseEntity.ok(deckService.getAllDecks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable Integer id) {
        return ResponseEntity.ok(deckService.getDeckById(id));
    }



}
