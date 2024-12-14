import java.util.Scanner;

public class TicTacToe {

    private static final int rows = 3;

    private static final int cols = 3;

    private static String board[][] = new String[rows][cols];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean again = true;

        do {
            clearBoard();

            String currentPlayer = "X";
            int moves = 0;
            boolean winner = false;

            do {
                display();

                System.out.println("Player " + currentPlayer + ", you're up." );

                int row = SafeInput.getRangedInt(scan, "Enter row", 1, 3) - 1;
                int col = SafeInput.getRangedInt(scan, "Enter your column", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moves++;

                    if(moves >= 5) {
                        winner = isWin(currentPlayer);
                    } if(winner) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else if(moves == rows * cols) {
                        display();
                        System.out.println("It's a tie!");
                    } else {
                        currentPlayer = togglePlayer(currentPlayer);
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } while(!winner && moves < rows * cols);

            again = SafeInput.getYNConfirm(scan, "Would you like to play again?");
        } while(again);

        System.out.println("Thanks for playing!");
    }

    private static void clearBoard() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println(" 1 2 3");
        for(int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for(int j = 0; j < cols; j++) {
                System.out.print(board[i][j]);
                if(j < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < rows - 1) {
                System.out.println("  -----");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagWin(player);
    }

    private static boolean isColWin(String player) {
        for(int i = 0; i < cols; i++) {
            if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for(int i = 0; i < rows; i++) {
            if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagWin(String player) {
        return(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static String togglePlayer(String currentPlayer) {
        return currentPlayer.equals("X") ? "O" : "X";
    }
}
