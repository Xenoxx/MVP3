package com.mvp.exceptions;



public class DeckNotFoundException extends RuntimeException {
    public DeckNotFoundException(Integer id) {
        super("Deck not found with id: " + id);
    }

}
