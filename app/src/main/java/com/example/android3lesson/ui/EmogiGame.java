package com.example.android3lesson.ui;


import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;

import java.util.List;


public class EmogiGame {

    private final Game<String> game;

    public EmogiGame() {
        List<String> content = List.of(  "\uD83D\uDE0B","\uD83D\uDE0D","\uD83C\uDF81 ") ;
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }
    public List<Card<String>> getCards() {
      return game.getCard();
    }
}
