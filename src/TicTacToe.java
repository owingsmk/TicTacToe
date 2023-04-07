import com.sun.rowset.internal.Row;

import java.util.Scanner;
public class TicTacToe {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Gets player names
        System.out.println("Player 1, what's your name? ");
        String p1 = in.nextLine();
        System.out.println("Player 2, what's your name? ");
        String p2 = in.nextLine();

        //3x3 Tic Tac Toe board
        //-empty space
        //x player 1
        //o player 2
        char[][] board = new char[3][3];

        //Fill the board with dashes
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                board[i][j] = '_';
            }
        }

        //Draw the board
        drawBoard(board);

        //Keep track of whose turn it is
        boolean isPlayer1 = true;

        //Keep track of what symbol we are using to Play
        char symbol = ' ';
        if (isPlayer1) {
            symbol = 'x';
        } else {
            symbol = 'o';
        }

        //Players turns
        if (isPlayer1){
            System.out.println(p1 + "'s turn (X):");
        } else {
            System.out.println(p2 + "'s turn (O):");
        }

        int row = 0;
        int col = 0;

        while (true) {
            //Get row and col from user
            System.out.print("Enter a row (0,1 or 2): ");
            row = in.nextInt();
            System.out.print("Enter a col (0,1 or 2): ");
            col = in.nextInt();


            if (row < 0 || col < 0 || row > 2 || col > 2) { //Check if row and col are valid
                System.out.println("You entered incorrect row and col, please try again!");
            } else if (board[row][col] != '_') {
                System.out.println("This spot is already taken!"); //board position check for used spots
            } else {
                //this checks if Row and Col are valid
                break;
            }
        }
        board[row][col] = symbol; //Setting the position on the board to the players symbol
        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}