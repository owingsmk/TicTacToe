import java.util.Scanner
public class TicTacToe {
    public static void main(String[] args) {
        private static final int ROW = 3;

        private static final int COL = 3;

        private static final char[][] BOARD = new char[ROW][COL];

        private static char currentPlayer;

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int moveNumber;

            int userRow, userCol;

            boolean gameOver;

            boolean validMove;

            do {

                clearBoard();

                currentPlayer = 'X';

                moveNumber = 0;

                gameOver = false;

                do {

                    display();

                    do {
                        userRow = InputLib.getRangedInt(scanner, "Please enter the row for your move", 1, 3) - 1;

                        userCol = InputLib.getRangedInt(scanner, "Please enter the column for your move", 1, 3) - 1;

                        validMove = isValidMove(userRow, userCol);

                        if(!validMove) {
                            System.out.println("That was not a valid move, try again.");
                        }
                    } while(!validMove);

                    BOARD[userRow][userCol] = currentPlayer;
                    moveNumber++;
                    if(moveNumber >= 5) {
                        if(isWin(currentPlayer)) {
                            gameOver = true;
                            System.out.println(currentPlayer + " is the winning player!");
                        }
                    }
                    if(moveNumber >= 7 && !gameOver) {
                        if(isTie()) {
                            gameOver = true;
                            System.out.println("The game is a tie!");
                        }
                    }
                    if(currentPlayer == 'X'){
                        currentPlayer = 'O';
                    }
                    else {
                        currentPlayer = 'X';
                    }
                }while(!gameOver);
            }while(InputLib.getYNComfirm(scanner, "Play again?"));
        }

        private static void clearBoard() {
            for(int i = 0; i < BOARD.length; i++) {
                for(int j = 0; j < BOARD[i].length; j++) {
                    BOARD[i][j] = ' ';

                }
            }
        }

        private static void display() {
            for(int i = 0; i < BOARD.length; i++) {
                for(int j = 0; j < BOARD[i].length; j++) {
                    System.out.print(BOARD[i][j]);
                    System.out.print(' ');
                }
                System.out.print("\n");
            }
        }

        private static boolean isValidMove(int row, int col) {

            boolean validMove = false;
            if(BOARD[row][col] == ' ') {
                validMove = true;
            }
            return validMove;
        }

        private static boolean isWin(char player) {
            return isColWin(player) || isRowWin(player) || isDiagnalWin(player);
        }

        private static boolean isColWin(char player) {

            boolean hasWon = false;
            for(int i = 0; i < BOARD.length && !hasWon; i++) {
                if((BOARD[0][i] == player) && (BOARD[1][i] == player) && (BOARD[2][i] == player)) {
                    hasWon = true;
                }
            }
            return hasWon;
        }

        private static boolean isRowWin(char player) {

            boolean hasWon = false;
            for(int i = 0; i < BOARD.length && !hasWon; i++) {
                if((BOARD[i][0] == player) && (BOARD[i][1] == player) && (BOARD[i][2] == player)) {
                    hasWon = true;
                }
            }
            return hasWon;
        }
        private static boolean isDiagnalWin(char player) {
            boolean hasWon = false;
            if((BOARD[0][0] == player) && (BOARD[1][1] == player) && (BOARD[2][2] == player)) {
                hasWon = true;
            }
            if((BOARD[0][2] == player) && (BOARD[1][1] == player) && (BOARD[2][0] == player)) {
                hasWon = true;
            }
            return hasWon;
        }
        private static boolean isTie() {
            boolean isTie = false;

/**

 * check for each possible win vector for both an x and an o

 * sc when find a vector that doesn't have both x and o

 */

            for(char[] row : BOARD) {

                if(row[0] == 'X' || row[1] == 'X' || row[2] == 'X') {
                    if(row[0] == 'O' || row[1] == 'O' || row[2] == 'O') {
                        isTie = true;
                    }
                }
            }

            for(int i = 0; i < BOARD.length && !isTie; i++) {

                if((BOARD[0][i] == 'X')|| (BOARD[1][i] == 'X') || (BOARD[2][i] == 'X')) {
                    if((BOARD[0][i] == 'O')|| (BOARD[1][i] == 'O') || (BOARD[2][i] == 'O')) {
                        isTie = true;
                    }
                }
            }

            if(!isTie) {

                if(BOARD[0][0] == 'X' || BOARD[1][1] == 'X' || BOARD[2][2] == 'X') {
                    if(BOARD[0][0] == 'O' || BOARD[1][1] == 'O' || BOARD[2][2] == 'O') {
                        isTie = true;
                    }
                }
            }

            if(!isTie) {

                if(BOARD[0][2] == 'X' || BOARD[1][1] == 'X' || BOARD[2][0] == 'X') {
                    if(BOARD[0][2] == 'O' || BOARD[1][1] == 'O' || BOARD[2][0] == 'O') {
                        isTie = true;
                    }
                }
            }
            return isTie;
        }
    }
}