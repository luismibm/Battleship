import java.util.Scanner;
import java.util.Random;

public class Main {

    // Menu Functions

    public static int gameMode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("- - BATTLESHIP - - ");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.println("4 - Custom");
        System.out.print("Select an option: ");
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

    public static void addBoats(char[][] board, int numLanchas, int numBuques, int numAcorazados, int numPortaaviones) {

        for (int i = 0; i < numLanchas; i++) {
            addLancha(board);
        }

        for (int i = 0; i < numBuques; i++) {
            addBuque(board);
        }

        for (int i = 0; i < numAcorazados; i++) {
            addAcorazado(board);
        }

        for (int i = 0; i < numPortaaviones; i++) {
            addPortaaviones(board);
        }

    }

    public static void addLancha(char[][] board) {

        Random random = new Random();
        int row = random.nextInt(10);
        int col = random.nextInt(10);
        board[row][col] = 'L';

    }

    public static void addBuque(char[][] board) {

        Random random = new Random();
        int row = random.nextInt(10);
        int col = random.nextInt(10);
        board[row][col] = 'B';
        board[row][col+1] = 'B';
        board[row][col+2] = 'B';

    }

    public static void addAcorazado(char[][] board) {

        Random random = new Random();
        int row = random.nextInt(10);
        int col = random.nextInt(10);
        board[row][col] = 'A';
        board[row][col+1] = 'A';
        board[row][col+2] = 'A';
        board[row][col+3] = 'A';

    }

    public static void addPortaaviones(char[][] board) {

        Random random = new Random();
        int row = random.nextInt(10);
        int col = random.nextInt(10);
        board[row][col] = 'P';
        board[row+1][col] = 'P';
        board[row+2][col] = 'P';
        board[row+3][col] = 'P';
        board[row+4][col] = 'P';

    }

    // Fire Functions

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        char[][] shownBoard = createBoard(10,10);
        char[][] hiddenBoard = createBoard(10,10);

        switch (gameMode()) {

            case 1:
                addBoats(hiddenBoard, 5, 3, 1, 1);
                break;

            case 2:
                addBoats(hiddenBoard, 3, 1, 1, 1);
                break;

            case 3:
                addBoats(hiddenBoard, 1, 1, 0, 0);
                break;

        }

        // Test
        showBoard(hiddenBoard);

    }
}