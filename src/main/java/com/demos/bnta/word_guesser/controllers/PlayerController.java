package com.demos.bnta.word_guesser.controllers;

import com.demos.bnta.word_guesser.models.Player;
import com.demos.bnta.word_guesser.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // turns it into Beans looks for methods turning into endpoints
@RequestMapping(value = "/players")
public class PlayerController {
//  FAT model and skinny controller, heavy logic and lifting should not be in the controller
    @Autowired
    PlayerService playerService;

@GetMapping // GET ALL /players
public ResponseEntity<List<Player>> getAllPlayers(){
List<Player> players = playerService.getAllPlayers();
    return  new ResponseEntity<>(players, HttpStatus.OK);
}


@GetMapping (value = "/{id}")// GET BY ID players/id {} makes it optional
public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable int id){ //path variable must be identical to getMapping
        Optional<Player> player = playerService.getPlayerById(id);
        if (player.isPresent() ){
        return new ResponseEntity<>(player, HttpStatus.OK);}
        else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
}

@PostMapping// POST (add) NEW PLAYER
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player){
       Player savedPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}
