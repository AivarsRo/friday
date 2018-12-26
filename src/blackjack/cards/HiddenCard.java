package blackjack.cards;

public class HiddenCard extends Card {
    public HiddenCard(Suite suite, Rank rank) {
        super(suite, rank);
    }

    @Override
    public String toString() {
        return "HiddenCard";
    }
}
