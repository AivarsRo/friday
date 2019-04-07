package blackjack.cards;

public enum Suite {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    private final String aDisplayName;

    Suite(String displayName) {
        aDisplayName = displayName;
    }

    @Override
    public String toString() {
        return aDisplayName;
    }
}
