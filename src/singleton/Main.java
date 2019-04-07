package singleton;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static class MyThread extends Thread {
        private int idx;

        public MyThread(int i) {
            idx = i;
        }

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance();
            System.out.println(idx + " : " + singleton.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        singleTest();
        System.out.println("end");
    }

    public static void singleTest() {
        // new Singleton();         // NOTE: Not possible - constructor is private
        System.out.println(Singleton.getInstance()
                                    .toString());

        System.out.println(Singleton.getInstance()
                                    .toString());
    }

    public static void multithreadedTest() {
        System.out.println("Creating threads");
        final List<Thread> threads = IntStream.range(0, 10)
                                              .mapToObj(MyThread::new)
                                              .collect(Collectors.toList());

        System.out.println("Launching threads");
        for (Thread thread : threads) {
            thread.start();
        }

        System.out.println("Waiting threads");
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
