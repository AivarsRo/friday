package blackjack.participants;

import blackjack.cards.Card;
import blackjack.cards.HiddenCard;

import java.util.Random;

public class Dealer extends Player {
    private static final int CUSP = 16;

    private boolean isFirstCard = true;

    public Dealer() {
        super("The Dealer");
    }

    @Override
    public void takeCard(Card card) {
        if (isFirstCard) {
            super.takeCard(new HiddenCard(card.getSuite(), card.getRank()));
            isFirstCard = false;
        } else {
            super.takeCard(card);
        }
    }

    @Override
    public TurnAction getTurnAction() {
        if (aHand.getScore() == CUSP) {
            return (new Random().nextBoolean() ? TurnAction.HIT : TurnAction.STAY);
        }
        return (aHand.getScore() < CUSP ? TurnAction.HIT : TurnAction.STAY);
    }
}