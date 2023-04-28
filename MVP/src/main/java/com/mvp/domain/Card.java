package com.mvp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCards")
    private Integer id;

    @Column(name = "idDeck")
    private Integer idDeck;
    @Column(name = "Term")
    private String term;
    @Column(name = "Definition")
    private String definition;

}
