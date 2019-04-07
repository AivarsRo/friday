package abstractfactory.factory;


import abstractfactory.factory.osx.OSXFactory;
import abstractfactory.factory.win.WinFactory;

public class AbstractFactory {
    public static GUIFactory build(String appearance) {
        switch (appearance) {
            case "osx":
                return new OSXFactory();
            case "win":
                return new WinFactory();
            default:
                throw new IllegalArgumentException("unknown " + appearance);
        }
    }
}
