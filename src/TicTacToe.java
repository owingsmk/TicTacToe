import com.sun.rowset.internal.Row;

import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    private static String player = "X";

    // Declare class-level variables
    private static final int ROW = 3; private static final int COL = 3;

    private static String[][] board = new String[ROW][COL];

    private static String player = "X";

    // Define helper methods
    private static void clearBoard() { /* implementation */ }

    private static void display() { /* implementation */ }

    private static boolean isValidMove(int row, int col) { /* implementation */ }

    private static boolean isWin(String player) { /* implementation */ }

    // Define main method
    //public static void main(String[] args) {
        // Clear the board and set player to X
        //clearBoard();
        //player = "X";
        // Loop until the game is over
        //while (true) {
            // Display the board and prompt for player input
           // display();
            //int rowMove =  int colMove = int row = rowMove - 1;
            //int col = colMove - 1;
            // Check if the move is valid
            //if (!isValidMove(row, col)) {
                //System.out.println("Invalid move. Try again.");
               // continue; }
            // Move is valid, update the board
            //board[row][col] = player;
            // Check for a win or tie if
            //(isWin(player)) { System.out.println(player + " wins!"); if (SafeInput.getYNConfirm(Scanner, "Play again?")) // Player has won, display message and prompt to play again
            //{ clearBoard(); player = "X";
                //continue;
            //} else {
            //    break; } }
            //else if (/* check for tie */) { // Game is a tie, display message and prompt to play again
            // System.out.println("It's a tie!"); if (SafeInput.getYNConfirm(Scanner, "Play again?")) { clearBoard(); player = "X"; continue; } else { break; } } // Move is valid and game is not over
            //if (player.equals("X")) { player = "O"; } else { player = "X"; } } }

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
            togglePlayer();
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
        String prompt = "Enter " + coordinate + " coordinate (1-3): ";
        return SafeInput.getRangedInt(console, prompt, 1, 3);
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
        for (int row =0; row < ROW; row++);
            for (int col = 0; col < COL;);
    }
