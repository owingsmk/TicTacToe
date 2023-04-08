import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    private static String player = "X";

    public static void main(String[] args) {
        clearBoard();
        display();

        while (true) {
            int rowMove = getMove("row");
            int colMove = getMove("col");

            if (!isValidMove(rowMove, colMove)) {
                System.out.println("Invalid move, try again.");
                continue;
            }
            board[rowMove - 1][colMove - 1] = player;
            display();
            if (isWin(player)) {
                System.out.println(player + " wins!");
                if (playAgain()) {
                    clearBoard();
                    display();
                    continue;
                } else {
                    break;
                }
            }
            if (isTie()) {
                System.out.println("It's a tie!");
                if (playAgain()) {
                    clearBoard();
                    display();
                    continue;
                } else {
                    break;
                }
            }
        }
    }


    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() {
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
        String prompt = "Enter " + coordinate + " coordinate (0-2): ";
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
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) ;
                {
                }
            }
            return false;
        }

    private static boolean playAgain() {
        Scanner in = new Scanner(System.in);
        return SafeInput.getYNConfirm(in, "Would you like to play again?");
    }
}

