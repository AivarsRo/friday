package singleton;

public class Singleton {
    private static Singleton self = null;

    public static Singleton getInstance() {
        System.out.println("Get instance called");
        if (self != null) {
            System.out.println("Returning object created earlier");
            return self;
        }

        System.out.println("Creating new object");
        self = new Singleton();
        return self;
    }

    private Singleton() {
        System.out.println("Constructor called");
    }
}
