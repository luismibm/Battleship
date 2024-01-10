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

    public static void main(String[] args){

        System.out.println("Bienvenido a Battleship!");
        char[][] tableroUser = new char[10][10];
        System.out.println("Tablero vacío: ");
        tableroVacio(tableroUser);
        tableroMostrar(tableroUser);

    }
}