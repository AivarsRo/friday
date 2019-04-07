package blackjack.ui;

import blackjack.participants.Player;
import blackjack.participants.TurnAction;

import java.util.Collection;
import java.util.function.Supplier;

public interface GameUserInterface extends Supplier<TurnAction> {

    void welcome();

    Collection<Player> getPlayers();

    void showHand(Player player);

    void showWinner(Player player);

    boolean wantToPlayAgain();

    void showMessage(String message);
}