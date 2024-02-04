import java.util.Scanner;
import java.util.Random;

public class Main {

    // Menu Functions

    public static int gameMode() {

        System.out.println("- - BATTLESHIP - - ");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.print("Select an option: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }


    // Board Functions

    public static char[][] createBoard(int row, int col) {

        char[][] board = new char[row][col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
        return board;

    }

    public static void showBoard(char[][] board) {

        // Fila superior (números)
        System.out.print(" \t");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        // Fila lateral (letras)
        char letra = 'A';
        for (int i = 0; i < board.length; i++) {
            System.out.print(letra + "\t");
            letra++;
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

    }


    // Boat Functions

    public static boolean boatsLeft(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                char cellContent = gameBoard[i][j];
                if (cellContent == 'L' || cellContent == 'B' || cellContent == 'A' || cellContent == 'P') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addBoats(char[][] board, int numLanchas) {

        for (int i = 0; i < numLanchas; i++) {
            addLancha(board);
        }

    }

    public static void addLancha(char[][] board) {
        int fila = (int) (Math.random() * 10);
        int columna = (int) (Math.random() * 10);
        if (board[fila][columna] == '-') {
            board[fila][columna] = 'L';
        } else {
            addLancha(board);
        }
    }


    // Fire Functions

    public static void openFire(char[][] sBoard, char[][] hBoard, int row, int col) {

        if (hBoard[row][col] == '-') {
            sBoard[row][col] = '*';
        } else {
            sBoard[row][col] = 'X';
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        char[][] shownBoard = createBoard(10,10);
        char[][] hiddenBoard = createBoard(10,10);

        switch (gameMode()) {

            case 1:
                addBoats(hiddenBoard, 5);
                break;

            case 2:
                addBoats(hiddenBoard, 3);
                break;

            case 3:
                addBoats(hiddenBoard, 1);
                break;

        }

        // Test

        int fireOpportunities = 50;
        do {
            showBoard(shownBoard);
            openFire(shownBoard, hiddenBoard, sc.nextInt(), sc.nextInt());
            fireOpportunities--;
            System.out.println("Fire opportunities left: " + fireOpportunities);
        } while (boatsLeft(hiddenBoard) && fireOpportunities > 0);


    }
}