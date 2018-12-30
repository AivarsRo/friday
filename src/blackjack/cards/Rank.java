package blackjack.cards;

public enum Rank {

    ACE(11, "Ace"),
    KING(10, "King"),
    QUEEN(10, "Queen"),
    JACK(10, "Jack"),
    TEN(10, "10"),
    NINE(9, "9"),
    EIGHT(8, "8"),
    SEVEN(7, "7"),
    SIX(6, "6"),
    FIVE(5, "5"),
    FOUR(4, "4"),
    THREE(3, "3"),
    TWO(2, "2");

    private final int    value;
    private final String aDisplayText;

    Rank(final int value, String displayText) {
        this.value = value;
        aDisplayText = displayText;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return aDisplayText;
    }
}