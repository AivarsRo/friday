package factorymethod;

import factorymethod.factory.PolygonFactory;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String res = PolygonFactory.getPolygon(3 + new Random().nextInt(3))
                                   .draw();
        System.out.println(res);
    }
}
