package abstractfactory.factory.osx;

import abstractfactory.factory.Button;
import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.Label;

public class OSXFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new OSXButton();
    }

    @Override
    public Label createLabel() {
        return new OSXLabel();
    }
}