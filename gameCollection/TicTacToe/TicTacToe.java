package TBArcade_copy.gameCollection.TicTacToe;

import TBArcade_copy.Game;

public class TicTacToe extends Game {

    protected String title = "Tic Tac Toe";
    private Board gameBoard;
    private boolean isPlayer1;
    private char mark;
    private String playerTitle;
    private String[] rows = { "Left", "Center", "Right" };
    private String[] columns = { "Top", "Middle", "Bottom" };

    public TicTacToe() {
        super.title = "Tic Tac Toe";
    }

    private void startContext() {
        System.out.println("P1 is starting. They are using the mark 'X' and P2 has the mark 'O'.");
        System.out.println("To plot your mark on the board, input [Top/Middle/Bottom] [Left/Center/Right].");
        System.out.println();
    }

    private void playerTurn(boolean isPlayer1) {

        mark = 'O';
        playerTitle = "P2";
        if (isPlayer1) {
            mark = 'X';
            playerTitle = "P1";
        }

        System.out.println(playerTitle + "'s turn:");
        markPosition(mark);
        gameBoard.printBoard();
    }

    private void markPosition(char mark) {
        String[] playerPosition;
        int[] boardCoor = new int[2];

        System.out.println("Where do you want to mark the board?");

        String inputPosition = super.gameInput.nextLine();

        playerPosition = validatePosition(inputPosition);
        boardCoor = positionToCoordinates(playerPosition);
        gameBoard.markPosition(boardCoor, mark);
    }

    private String[] validatePosition(String position) {

        String[] positionXY = position.split(" ");

        System.out.println();
        if (positionXY.length == 2 && java.util.Arrays.stream(columns).anyMatch(positionXY[0]::equals)
                && java.util.Arrays.stream(rows).anyMatch(positionXY[1]::equals)) {
            System.out.println("PLayer has picked the " + positionXY[0] + " " + positionXY[1] + " spot.");
            System.out.println();
            return positionXY;
        } else {
            System.out.println(
                    "Invalid position. Position must be of the format [Top/Middle/Bottom] [Left/Center/Right]. Try again:");
            return validatePosition(super.gameInput.nextLine());
        }
    }

    private int[] positionToCoordinates(String[] position) {
        int[] coor = new int[2];

        for (int i = 0; i < rows.length; i++) {
            if (columns[i].equals(position[0])) {
                coor[0] = i;
            }
            if (rows[i].equals(position[1])) {
                coor[1] = i;
            }
        }

        return coor;
    }

    public void run() {
        boolean winner;
        boolean restart;

        winner = false;
        restart = true;
        isPlayer1 = true;
        startContext();

        while (restart) {
            gameBoard = new Board();

            while (!winner) {
                playerTurn(isPlayer1);
                winner = gameBoard.checkBoard(mark);
                isPlayer1 = !isPlayer1;
                System.out.println();
            }
        }
        System.out.println("We have a winner!");

    }

}
