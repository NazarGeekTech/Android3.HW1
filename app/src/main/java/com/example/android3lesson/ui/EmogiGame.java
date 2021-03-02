package com.example.android3lesson.ui;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;

import java.util.List;


public class EmogiGame {

    private final Game<Integer> game;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public EmogiGame() {
        List<Integer> content = List.of(R.drawable.bravoo, R.drawable.emoticon,R.drawable.pales);
        game = new Game<>(content);
    }

    public void choose(Card<Integer> card) {
        game.choose(card);
    }
    public List<Card<Integer>> getCards() {
      return game.getCards();
    }
}
