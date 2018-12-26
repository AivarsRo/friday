package blackjack.participants;

import blackjack.cards.Card;

import java.util.Collection;

public abstract class Player {

    protected String aName;
    protected Hand   aHand;

    public Player(String name) {
        aName = name;
    }

    public void takeCard(Card card) {
        aHand.addCard(card);
    }

    public abstract TurnAction getTurnAction();

    public int getScore() {
        return aHand.getScore();
    }

    public String getName() {
        return aName;
    }

    public Collection<Card> getCards() {
        return aHand.getCards();
    }
}
