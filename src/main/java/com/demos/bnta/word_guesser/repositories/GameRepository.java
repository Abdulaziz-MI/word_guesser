package com.demos.bnta.word_guesser.repositories;

import com.demos.bnta.word_guesser.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {


    List<Game> findByCompleteTrue(); // this is a derived query built from the function definition, this will cut off the first part "findBy" to find by a criteria "CompleteTrue" this also works for "word" and "length" it will slice it up by words this example will check the "complete" boolean in the SQL database and filter the complete(true) in a List

    List<Game> findByWord(String word);
}
