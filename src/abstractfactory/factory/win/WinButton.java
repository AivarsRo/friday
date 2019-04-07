package abstractfactory.factory.win;

import abstractfactory.factory.Button;

class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}