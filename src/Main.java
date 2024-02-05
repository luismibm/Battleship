import java.util.Scanner;

public class Main {

    // Game Functions

    public static int gameMode() {

        System.out.println("- - BATTLESHIP - - ");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.print("Select an option: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public static boolean checkWin(char[][] board, int cellsToWin) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char cellContent = board[i][j];
                if (cellContent == 'X') {
                    count++;
                }
            }
        }
        return count == cellsToWin;
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
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        if (board[row][col] == '-') {
            board[row][col] = 'L';
        } else {
            addLancha(board);
        }
    }

    public static void addBuque(char[][] board) {
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        if (board[row][col] == '-') {
            board[row][col] = 'B';
            if (col < 8) {
                board[row][col + 1] = 'B';
                board[row][col + 2] = 'B';
            } else {
                board[row][col - 1] = 'B';
                board[row][col - 2] = 'B';
            }
        } else {
            addBuque(board);
        }
    }

    public static void addAcorazado(char[][] board) {
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        if (board[row][col] == '-') {
            board[row][col] = 'A';
            if (col < 7) {
                board[row][col + 1] = 'A';
                board[row][col + 2] = 'A';
                board[row][col + 3] = 'A';
            } else {
                board[row][col - 1] = 'A';
                board[row][col - 2] = 'A';
                board[row][col - 3] = 'A';
            }
        } else {
            addAcorazado(board);
        }
    }

    public static void addPortaaviones(char[][] board) {
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        if (board[row][col] == '-') {
            board[row][col] = 'P';
            if (row < 6) {
                board[row + 1][col] = 'P';
                board[row + 2][col] = 'P';
                board[row + 3][col] = 'P';
                board[row + 4][col] = 'P';
            } else {
                board[row - 1][col] = 'P';
                board[row - 2][col] = 'P';
                board[row - 3][col] = 'P';
                board[row - 4][col] = 'P';
            }
        } else {
            addPortaaviones(board);
        }
    }


    // Fire Functions

    public static void openFire(char[][] sBoard, char[][] hBoard, int row, int col) {

        if (row >= 0 && row < 10 && col >= 0 && col < 10) {
            if (hBoard[row][col] == '-') {
                sBoard[row][col] = '*';
            } else {
                sBoard[row][col] = 'X';
            }
        } else {
            System.out.println("Invalid cell");
        }

        // Primer if comprueba que la celda está dentro del tablero
        // Segundo if comprueba si la celda está vacía o tiene un barco

    }


    // Main

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        char[][] shownBoard = createBoard(10,10);
        char[][] hiddenBoard = createBoard(10,10);

        int cellsToWin = 0;

        switch (gameMode()) {

            case 1:
                addBoats(hiddenBoard, 5, 3, 1, 1);
                cellsToWin = 23;
                break;

            case 2:
                addBoats(hiddenBoard, 3, 1, 1, 1);
                cellsToWin = 15;
                break;

            case 3:
                addBoats(hiddenBoard, 1, 1, 0, 0);
                cellsToWin = 4;
                break;

        }

        showBoard(hiddenBoard);
        int fireOpportunities = 50;
        boolean gameWon = false;
        do {
            showBoard(shownBoard);
            openFire(shownBoard, hiddenBoard, sc.nextInt(), sc.nextInt());
            fireOpportunities--;

            if (checkWin(shownBoard, cellsToWin) && fireOpportunities > 0) {
                System.out.println("You win!");
                gameWon = true;
            } else if (fireOpportunities == 0){
                System.out.println("You lose!");
            }

            if (!gameWon) {
                System.out.println("Fire opportunities left: " + fireOpportunities);
            }

        } while (!gameWon && fireOpportunities > 0);

    }

    //

}