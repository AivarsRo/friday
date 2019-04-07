package abstractfactory.factory.win;

import abstractfactory.factory.Label;

class WinLabel implements Label {

    @Override
    public void show() {
        System.out.println("WinLabel");
    }
}