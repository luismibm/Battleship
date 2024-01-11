import java.util.Scanner;

public class Main {

    public static void tableroVacio(char[][] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }

    }

    public static void tableroMostrar(char[][] tablero) {

        System.out.print(" \t");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        char letra = 'A';
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letra + "\t");
            letra++;
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void insertarLancha(char[][] tablero, int row, int col) {

        tablero[row][col] = 'L';

    }

    public static void insertarBarco(char[][] tablero, int row, int col) {

        tablero[row][col] = 'B';
        tablero[row][col+1] = 'B';
        tablero[row][col+2] = 'B';

    }

    public static void insertarAcorazado(char[][] tablero, int row, int col) {

        tablero[row][col] = 'A';
        tablero[row][col+1] = 'A';
        tablero[row][col+2] = 'A';
        tablero[row][col+3] = 'A';

    }

    public static void insertarPortaaviones(char[][] tablero, int row, int col) {

        tablero[row][col] = 'P';
        tablero[row+1][col] = 'P';
        tablero[row+2][col] = 'P';
        tablero[row+3][col] = 'P';
        tablero[row+4][col] = 'P';

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Battleship!");
        char[][] tableroUser = new char[10][10];
        System.out.println("Tablero vacío: ");
        tableroVacio(tableroUser);
        tableroMostrar(tableroUser);

        // Test
        insertarLancha(tableroUser,1,1);
        insertarBarco(tableroUser, 3, 3);
        insertarAcorazado(tableroUser, 5, 3);
        insertarPortaaviones(tableroUser, 5, 0);
        tableroMostrar(tableroUser);


    }
}