package blackjack.ui;

import blackjack.cards.Card;
import blackjack.participants.HumanPlayer;
import blackjack.participants.Player;
import blackjack.participants.TurnAction;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ConsoleUserInterface implements GameUserInterface {
    private final Scanner aScanner = new Scanner(System.in);

    @Override
    public void welcome() {
        System.out.println("\n\n\nWelcome to a new Game game!\n\n");
    }

    @Override
    public Collection<Player> getPlayers() {
        System.out.print("Enter player name: ");
        String name = aScanner.next();
        return Collections.singletonList(new HumanPlayer(name, this));
    }

    @Override
    public void showHand(Player player) {
        Collection<Card> cards = player.getCards();
        System.out.println(player.getName() + " has " + cards + ".");
    }

    @Override
    public void showWinner(Player player) {
        System.out.println(player.getName() + " is the winner with score : " + player.getScore());
    }

    @Override
    public boolean wantToPlayAgain() {
        System.out.print("\nDo you want to play again? 'y'/'n': ");
        String input = aScanner.nextLine();
        if (input.equals("y") || input.equals("n")) {
            return (input.equals("y"));
        }
        return wantToPlayAgain();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public TurnAction get() {
        do {
            System.out.print("Do you want to 'hit' or 'stay'? ");
            switch (aScanner.next()
                            .toUpperCase()) {
                case "HIT":
                case "H":
                    return TurnAction.HIT;

                case "STAY":
                case "S":
                    return TurnAction.STAY;

                default:
                    System.err.println("Incorrect input!");
                    break;
            }
        } while (true);
    }
}