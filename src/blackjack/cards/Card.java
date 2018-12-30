package blackjack.cards;

import java.util.Objects;

public class Card {
    private final Suite aSuite;
    private final Rank  aRank;

    public Card(Suite suite, Rank rank) {
        aSuite = suite;
        aRank = rank;
    }

    public Suite getSuite() {
        return aSuite;
    }

    public Rank getRank() {
        return aRank;
    }

    public int getValue() {
        return aRank.getValue();
    }

    @Override
    public String toString() {
        return aRank.toString() + aSuite.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return aSuite == card.aSuite &&
                aRank == card.aRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aSuite, aRank);
    }
}
