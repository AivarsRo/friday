package blackjack.participants;

import blackjack.cards.Card;
import blackjack.cards.HiddenCard;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Dealer extends Player {
    private static final int CUSP = 16;

    public Dealer() {
        super("The Dealer");
        final Set<Card> cards = aHand.getCards();
        final Iterator<Card> iterator = cards.iterator();
        final Card next = iterator.next();
        HiddenCard hiddenCard = new HiddenCard(next.getSuite(), next.getRank());
        iterator.remove();
        cards.add(hiddenCard);
    }

    @Override
    public TurnAction getTurnAction() {
        if (aHand.getScore() == CUSP) {
            return (new Random().nextBoolean() ? TurnAction.HIT : TurnAction.STAY);
        }
        return (aHand.getScore() < CUSP ? TurnAction.HIT : TurnAction.STAY);
    }
}