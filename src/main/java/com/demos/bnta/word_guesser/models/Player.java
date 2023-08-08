package com.demos.bnta.word_guesser.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "players")
public class Player {

    @Id // equivalent to primary key in SQL
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is a serial datatype in SQL
    private int id;

    @Column // SQL column (automatically done for ID)
    private String name;

    @OneToMany(mappedBy = "player") // One player -> many games
    @JsonIgnoreProperties({"player"})// to stop infinite data recursion, otherwise the data would keep going infinitely referencing itself. "player" has to be identical to the property named in the Game class
    private List<Game> games;


    public  Player(String name){
        this.name = name;
        this.games = new ArrayList<>();

    }

    public Player(){} //POJO class
//    creates an empty Obj and uses the getters and setters to serialise it into a JSON obj And uses it to Deserialises JSON objs into Java objs.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
