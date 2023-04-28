package com.mvp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Deck")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDeck")
    private Integer id;

    @Column(name = "DeckName")
    private String deckName;
//    @OneToMany
//    private List<Card> cardList;

}
