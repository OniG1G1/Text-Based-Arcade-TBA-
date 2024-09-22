package TBArcade_copy.gameCollection.TicTacToe;

public class Board {

    private char[][] template;

    public Board() {
        template = new char[5][11];
        createBoard();
    }

    public void createBoard() {
        for (int i = 0; i < template.length; i++) {
            for (int j = 0; j < template[0].length; j++) {
                if (i % 2 == 1) {
                    if (j % 4 == 3) {
                        template[i][j] = '+';
                        continue;
                    } else {
                        template[i][j] = '-';
                        continue;
                    }
                } else {
                    if (j % 4 == 3) {
                        template[i][j] = '|';
                        continue;
                    }
                    template[i][j] = ' ';
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < template.length; i++) {
            for (int j = 0; j < template[0].length; j++) {
                System.out.print(template[i][j]);
            }
            System.out.println();
        }
    }

    public void markPosition(int[] position, char mark) {
        template[position[0] * 2][position[1] * 4 + 1] = mark;
    }

    public boolean checkBoard(char mark) {
        //Check rows
        for (int row = 0; row <= 4; row += 2) {
            if (template[row][1] == mark && template[row][5] == mark && template[row][9] == mark) {
                return true;
            }
        }

        // Check columns
        for (int col = 1; col <= 9; col += 4) {
            if (template[0][col] == mark && template[2][col] == mark && template[4][col] == mark) {
                return true;
            }
        }

        // Check diagonals
        if ((template[0][1] == mark && template[2][5] == mark && template[4][9] == mark) || 
            (template[0][9] == mark && template[2][5] == mark && template[4][1] == mark)) {
            return true;
        }

        return false;  // No winner found
    }
    }


/*
 *  1 | 2 | 3
 * ---+---+---
 *  4 | 5 | 6
 * ---+---+---
 *  7 | 8 | 9
 * 
 * 
 */