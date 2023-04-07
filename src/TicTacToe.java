import com.sun.rowset.internal.Row;

import java.util.Scanner;
public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];



    public static void main(String[] args) {
        clearBoard();
        showBoard();
        String playAgain = SafeInput.getYNConfirm("Do you want to play again?");

        Scanner in = new Scanner(System.in);

        //Gets player names
        System.out.println("Player 1, what's your name? ");
        String p1 = in.nextLine();
        System.out.println("Player 2, what's your name? ");
        String p2 = in.nextLine();
        boolean isPlayer1 = true;

        while (true) {
            int rowMove = getMove("row");
            int colMove = getMove("col");
            if (!isValidMove(rowMove, colMove)) {
                System.out.println("Invalid move, try again.");
                continue;
            }
            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }
            board[rowMove - 1][colMove - 1] = isPlayer1;
            showBoard();
            if (isWin(isPlayer1)) {
                System.out.println(p1 + " wins!");
                if (playAgain()) {
                    clearBoard();
                    showBoard();
                    continue;
                } else {
                    break;
                }
            }
            if (isTie()) {
                System.out.println("It's a tie!");
                if (playAgain()) {
                    clearBoard();
                    showBoard();
                    continue;
                } else {
                    break;
                }
            }
            isPlayer1 = !isPlayer1;
        }
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void showBoard() {
        System.out.println("-------------");
        for (int row = 0; row < ROW; row++) {
            System.out.print("| ");
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int getMove(String coordinate) {
        Scanner console = new Scanner(System.in);
        String prompt = "Enter " + coordinate + " coordinate (1-3): ";
        return SafeInput.getRangedInt(console, prompt, 0, 2);
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row - 1][col - 1] == " ") {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isWin(String player) {
        // Check rows
        for (int row = 0; row < ROW; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int col = 0; col < COL; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        // No win found
        return false;
    }

    private static boolean isTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
}