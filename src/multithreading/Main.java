package multithreading;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Multithreading test");
        Button hangWindowButton = new Button("Hang window");
        hangWindowButton.setOnAction(event -> reallyLongProcessing());

        Button parallelProcessingButton = new Button("Parallel processing");
        parallelProcessingButton.setOnAction(event -> reallyLongProcessingInSeparateThread());

        String[] texts = {"Happy new year", "Peace is a lie", "Through passion i gain strength"};
        Button syncDemoButtonWrong = new Button("Writing words (wrong)");
        syncDemoButtonWrong.setOnAction(event -> {
            Thread[] threads = {new Thread(() -> displayText(texts[0])),
                                new Thread(() -> displayText(texts[1])),
                                new Thread(() -> displayText(texts[2]))};

            for (Thread thread : threads) {
                thread.start();
            }
        });

        Button syncDemoButtonRight = new Button("Writing words (right)");
        syncDemoButtonRight.setOnAction(event -> {
            Thread[] threads = {new Thread(() -> displayTextSync(texts[0])),
                                new Thread(() -> displayTextSync(texts[1])),
                                new Thread(() -> displayTextSync(texts[2]))};

            for (Thread thread : threads) {
                thread.start();
            }
        });

        VBox root = new VBox();
        root.getChildren()
            .addAll(hangWindowButton, parallelProcessingButton, syncDemoButtonWrong, syncDemoButtonRight, setupNonFxElements(texts), setupFxElements(texts));
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    private Node setupNonFxElements(String[] texts) {
        HBox hbox = new HBox();

        Button buttonWithProgress = new Button("Progress bars (not FX thread)");
        ProgressBar[] progressBars = {
                new ProgressBar(), new ProgressBar(), new ProgressBar()
        };

        buttonWithProgress.setOnAction(event -> {
            Thread[] threads = {new Thread(() -> displayTextWithProgress(texts[0], progressBars[0])),
                                new Thread(() -> displayTextWithProgress(texts[1], progressBars[1])),
                                new Thread(() -> displayTextWithProgress(texts[2], progressBars[2]))};
            for (Thread thread : threads) {
                thread.start();
            }
        });

        hbox.getChildren()
            .addAll(buttonWithProgress);
        hbox.getChildren()
            .addAll(progressBars);
        return hbox;
    }

    private Node setupFxElements(String[] texts) {
        HBox hbox = new HBox();

        Button buttonWithProgress = new Button("Progress bars Task");
        ProgressBar[] progressBars = {
                new ProgressBar(), new ProgressBar(), new ProgressBar()
        };

        buttonWithProgress.setOnAction(event -> {
            Task<?>[] tasks = {
                    newTask(texts[0], progressBars[0]),
                    newTask(texts[1], progressBars[1]),
                    newTask(texts[2], progressBars[2])
            };

            for (Task<?> task : tasks) {
                new Thread(task).start();
            }
        });

        hbox.getChildren()
            .addAll(buttonWithProgress);
        hbox.getChildren()
            .addAll(progressBars);
        return hbox;
    }

    private Task<Void> newTask(String text, ProgressBar progressBar) {
        Task<Void> t1 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                long progress = 0;
                for (char c : text.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(ThreadLocalRandom.current()
                                                  .nextInt(500, 1500));
                    progress += 1;
                    updateProgress(progress, text.length());
                }

                System.out.println();
                return null;
            }
        };

        t1.progressProperty()
          .addListener((observable, oldValue, newValue) -> {
              progressBar.setProgress((double) newValue);
          });

        return t1;
    }


    private void displayTextWithProgress(String text, ProgressBar progressBar) {
        double progress = 0;
        for (char c : text.toCharArray()) {
            progressBar.setProgress(progress / text.length());
            System.out.print(c);
            Thread.yield();
            progress += 1;
        }

        System.out.println();
    }

    private void displayText(String string) {
        for (char c : string.toCharArray()) {
            System.out.print(c);
            Thread.yield();
        }

        System.out.println();
    }


    private synchronized void displayTextSync(String string) {
        displayText(string);
    }

    private void reallyLongProcessingInSeparateThread() {
        Thread thread = new Thread(this::reallyLongProcessing);
        thread.start();
    }

    private void reallyLongProcessing() {
        try {
            System.out.println("Starting long processing");
            for (int i = 0; i < 5; ++i) {
                System.out.println("Step " + i);
                Thread.sleep(1000);
            }
            System.out.println("Long processing done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
