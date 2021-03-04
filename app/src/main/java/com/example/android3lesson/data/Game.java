package com.example.android3lesson.data;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private static final String tag = "gameClass";
    private final List<Card<CardContent>> cards = new ArrayList<>();
    private Context context;

    public Game(List<CardContent> contents, Context context) {
        this.context = context;
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i * 2));
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
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceUp() && anotherCard.getId() != card.getId()) {
                if (anotherCard.getContent().equals(card.getContent())) {
                    anotherCard.setMatched(true);
                    card.setMatched(true);
                } else {
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                }

            }
        }
        removePair();
    }

    private void removePair() {
        List<Card<CardContent>> newList = new ArrayList<>(cards);
        for (Card<CardContent> card : cards) {
            if (card.isMatched())
                newList.remove(card);
        }
        cards.clear();
        cards.addAll(newList);
        if (cards.size() == 0) {
            endGame(context);
        }
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

    public void endGame(Context context) {
        if (getCards().size() == 0) Toast.makeText(context, "GAME OVER", Toast.LENGTH_LONG).show();
    }
}

