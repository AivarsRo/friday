package blackjack.participants;

import blackjack.cards.Card;
import blackjack.cards.Rank;

import java.util.HashSet;
import java.util.Set;

public class Hand {
    private final Set<Card> aCards = new HashSet<>();

    public void addCard(Card card) {
        aCards.add(card);
    }

    public int getScore() {

        int score = aCards.stream()
                          .mapToInt(Card::getValue)
                          .sum();

        if (score > 21) {
            long countAces = aCards.stream()
                                   .map(Card::getRank)
                                   .filter(rank -> rank == Rank.ACE)
                                   .count();

            while (score > 21 && countAces > 0) {
                score -= 10;
                countAces--;
            }
        }

        return score;
    }

    public Set<Card> getCards() {
        return aCards;
    }
}