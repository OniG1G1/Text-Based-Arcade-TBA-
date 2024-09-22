package TBArcade_copy;
import java.util.Scanner;


public abstract class Game implements Runnable {
    // Common attributes and methods for all games can go here
    protected boolean isRunning = false;
    protected String title;
    protected Scanner gameInput;


    // Method to initialize and start the game
    public void start() {
        isRunning = true;
        gameInput = new Scanner(System.in);
        System.out.println(title + " is running...");
        System.out.println();
        run();
        // Additional setup logic can go here
    }

    // Method to stop and clean up the game
    public void stop() {
        isRunning = false;
        System.out.println("Game has been stopped.");
        // Additional cleanup logic can go here
    }

    @Override
    public
    abstract void run(); // Each specific game will provide its own implementation

}
