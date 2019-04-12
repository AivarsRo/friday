package adapter;

import adapter.adapter.BirdAdapter;
import adapter.classes.PlasticToyDuck;
import adapter.classes.Sparrow;
import adapter.classes.ToyDuck;

public class Main {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a sparrowToy so that it
        // behaves like toy duck
        ToyDuck sparrowToy = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        sparrowToy.squeak();
    }
}
