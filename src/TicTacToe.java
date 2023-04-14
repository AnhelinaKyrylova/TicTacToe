import java.util.Scanner;
public class TicTacToe {

    private GamePiece[][] board;
    private GamePiece currentPlayer;

    public TicTacToe() {
        board = new GamePiece[3][3];
        currentPlayer = GamePiece.X;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = GamePiece.EMPTY;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void play() {
        boolean gameWon = false;
        System.out.println("Let's play Tic Tac Toe!");
        System.out.println("Player 1 (X) goes first.");
        while (!gameWon) {
            System.out.println("Current board:");
            printBoard();
            System.out.println(currentPlayer + ", enter your move (row[1-3], column[1-3]):");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            if (board[row][col] != GamePiece.EMPTY) {
                System.out.println("That spot is already taken. Try again.");
                continue;
            }
            board[row][col] = currentPlayer;
            gameWon = CheckForWin.isWin(board, currentPlayer);
            if (gameWon) {
                System.out.println("Current board:");
                printBoard();
                System.out.println(currentPlayer + " wins! Game over.");
                return;
            }
            if (isBoardFull()) {
                System.out.println("Current board:");
                printBoard();
                System.out.println("It's a tie! Game over.");
                return;
            }
            currentPlayer = (currentPlayer == GamePiece.X) ? GamePiece.O : GamePiece.X;
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == GamePiece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}




