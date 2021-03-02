package com.example.android3lesson.data;

import java.util.Objects;

public class Card<CardContent> {
    private boolean isFaceUp;
    private boolean isMatched;
    private CardContent Content;
    private int id;

    public Card(boolean isFaceUp, boolean isMatched, CardContent content, int id) {
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.Content = content;
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public CardContent getContent() {
        return Content;
    }

    public void setContent(CardContent content) {
        this.Content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return id == card.id && isFaceUp == card.isFaceUp &&
                isMatched == card.isMatched &&
                Objects.equals(Content, card.Content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFaceUp, isMatched, Content, id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "isFaceUp=" + isFaceUp +
                ", isMatched=" + isMatched +
                ", Content=" + Content +
                ", id=" + id +
                '}';
    }
}
