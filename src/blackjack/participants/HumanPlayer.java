package blackjack.participants;

import java.util.function.Supplier;

public class HumanPlayer extends Player {

    private final Supplier<TurnAction> aTurnActionSupplier;

    public HumanPlayer(final String name, Supplier<TurnAction> turnActionSupplier) {
        super(name);
        aTurnActionSupplier = turnActionSupplier;
    }

    @Override
    public TurnAction getTurnAction() {
        return aTurnActionSupplier.get();
    }
}