package blackjack;

import blackjack.ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new ConsoleUserInterface());
        game.play();
    }
}