package abstractfactory.factory.osx;

import abstractfactory.factory.Label;

class OSXLabel implements Label {

    @Override
    public void show() {
        System.out.println("OSXLabel");
    }
}