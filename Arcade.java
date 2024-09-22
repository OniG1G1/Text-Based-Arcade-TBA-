package TBArcade_copy;

import java.io.File;
import java.util.Scanner;

public class Arcade {
    //Fields for File Navigation.
    private static String gamesDirectory;
    private static File gameFolder;
    private static File[] gameList;

    public static Scanner sc;

    public Arcade() {
        //Uses file locations to retrieve games.
        gamesDirectory = "gameCollection";
        gameFolder = new File(gamesDirectory);
        gameList = gameFolder.listFiles();

        sc = new Scanner(System.in);
    }

    private static void listGames() {
        if ((gameList != null) || (gameList.length == 0)) {
            for (int i = 0; i < gameList.length; i++) {
                System.out.println((i + 1) + ". " + gameList[i].getName());
            }
        } else {
            System.out.println("No games were found.");
        }
    }

    private static String selectGame() {
        boolean validGameChoice;
        int gameSelect;
        String selectedGame = null; //Set to NULL as 'selectedGame' won't necessarily be assigned according to code. 

        validGameChoice = false;

        while (!validGameChoice) {
            gameSelect = sc.nextInt();

            if (gameSelect > 0 && gameSelect <= gameList.length) {
                selectedGame = gameList[gameSelect - 1].getName();
                System.out.println("You selected: " + selectedGame);
                validGameChoice = true;
            } else {
                System.out.println("Invalid selection. Try again:");
            }
        }
        System.out.println();
        return selectedGame;
    }

    private static void loadAndRunGame(String gameFolderName) {
        try {
            // Retrieves the game selected and its class and creates a new instance to run it.
            // (Assuming each folder has a main game class with the same name as the folder).
            String className = "TBArcade_copy.gameCollection." + gameFolderName + "." + gameFolderName;
            Class<?> gameClass = Class.forName(className);
            Game game = (Game) gameClass.getDeclaredConstructor().newInstance();

            game.start();
        } catch (Exception e) {
            System.out.println("Failed to load the game: " + e.getMessage());
            e.printStackTrace();
            
        }
    }
    
    public void run() {
        String game;

        System.out.println("Welcome to Gigi's TBArcade (Text-Based Arcade).");
        System.out.println("....and this was a lil' edit I made in Github.");
        System.out.println("Please pick a game to play out of the list below:");

        listGames();
        game = selectGame();
        loadAndRunGame(game);
        System.out.println();
        System.out.println("-------------------------------");

        sc.close();
    }

    public static void main(String[] args) {
        Arcade arc = new Arcade();
        arc.run();

        System.out.println("End");
    }
}
