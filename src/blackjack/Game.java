package blackjack;

import blackjack.cards.Deck;
import blackjack.cards.DeckIsEmptyException;
import blackjack.participants.Dealer;
import blackjack.participants.Player;
import blackjack.participants.TurnAction;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player>      aPlayers = new ArrayList<>();
    private Deck              aDeck    = new Deck();
    private GameUserInterface aGameUserInterface;

    public Game(GameUserInterface gameUserInterface) {
        aGameUserInterface = gameUserInterface;
        aPlayers.add(new Dealer());
        aPlayers.addAll(aGameUserInterface.getPlayers());
    }

    public void play() {
        do {
            dealInitialCards();
            boolean allPlayersStay;
            do {
                allPlayersStay = true;
                for (Player player : aPlayers) {
                    aGameUserInterface.showHand(player);
                    TurnAction turnAction = player.getTurnAction();
                    switch (turnAction) {
                        case HIT:
                            allPlayersStay = false;
                            dealCard(player);
                            break;

                        case STAY:
                            break;
                    }
                }
            } while (!allPlayersStay);

            aGameUserInterface.showWinner(getWinner());

        } while (aGameUserInterface.wantToPlayAgain());
    }

    public void dealCard(Player player) {
        try {
            player.takeCard(aDeck.drawNextCard());
        } catch (DeckIsEmptyException e) {
            aGameUserInterface.showMessage("Deck is empty. Taking a new one.");
            aDeck = new Deck();
            try {
                player.takeCard(aDeck.drawNextCard());
            } catch (DeckIsEmptyException e1) {
                System.err.println("Deck is created empty.");
            }
        }
    }

    public void dealInitialCards() {
        for (Player player : aPlayers) {
            dealCard(player);
            dealCard(player);
        }
    }

    public Player getWinner() {
        int highest = 0;
        Player topPlayer = aPlayers.get(0);
        for (Player player : aPlayers) {
            int total = player.getScore();
            if (total >= highest && total <= 21) {
                highest = total;
                topPlayer = player;
            }
        }
        return topPlayer;
    }
}