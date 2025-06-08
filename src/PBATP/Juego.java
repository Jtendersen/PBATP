package PBATP;

import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int misionesCompletadas = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Iniciar Misión");
            System.out.println("2) Salir");
            System.out.print("Elegite una opción... ");
            String selectedOption = entrada.nextLine();

            switch (selectedOption) {
                case "1" -> {
                    Snake snake = new Snake("Snake", new Posicion (0,0));
                    MisionIntermedia mision1 = new MisionIntermedia(snake);
                    boolean ok = mision1.iniciar();
                    if (ok) System.out.println("Avanza a la siguiente mision... ");
                }
                case "2" ->
                    salir = true;
                default ->
                    System.out.println("Opción invalida... :(");

            }
            

        }
        System.out.println("Nos vemos en la proxima aventura... ");
        entrada.close();
    }
}
