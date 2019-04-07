package abstractfactory.factory.win;

import abstractfactory.factory.Button;
import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.Label;

public class WinFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Label createLabel() {
        return new WinLabel();
    }
}