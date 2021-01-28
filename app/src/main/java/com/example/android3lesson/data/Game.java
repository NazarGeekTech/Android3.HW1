package com.example.android3lesson.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i * 1));
            cards.add(new Card<>(false, false, contents.get(i), i * 2 + 1));
        }
        Collections.shuffle(cards);

    }
    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            findPairs(card);
        }
    }

    private void findPairs(Card<CardContent> card) {
        for (Card<CardContent> searchCard : cards) {
            if (searchCard.isFaceUp() &&
                    searchCard.getId() != card.getId()
                    && searchCard.equals(card)) {
                card.setMatched(true);
                searchCard.setMatched(true);
                cards.remove(searchCard);
                cards.remove(card);
//                Log.d("tag", "Match");
              return;
            }
        }
    }

    public List<Card<CardContent>> getCard() {
        return cards;
    }


}
