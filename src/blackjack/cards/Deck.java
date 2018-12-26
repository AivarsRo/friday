package blackjack.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deck {
    private LinkedList<Card> aCards = new LinkedList<>();

    public Deck() {
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(suite, rank));
            }
        }

        Collections.shuffle(aCards);
    }

    public Card drawNextCard() throws DeckIsEmptyException {
        try {
            return aCards.remove();
        } catch (NoSuchElementException e) {
            throw new DeckIsEmptyException();
        }
    }
}