package abstractfactory.factory.osx;

import abstractfactory.factory.Button;

class OSXButton implements Button {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}