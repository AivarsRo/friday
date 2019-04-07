package abstractfactory;

import abstractfactory.factory.AbstractFactory;
import abstractfactory.factory.Button;
import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.Label;

import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(final String[] arguments) {
        String randomAppearance = Arrays.asList("osx", "win")
                                        .get(new Random().nextInt(2));

        GUIFactory factory = AbstractFactory.build(randomAppearance);

        Button button = factory.createButton();
        button.paint();
        Label label = factory.createLabel();
        label.show();
    }
}