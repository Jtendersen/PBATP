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
                    Snake snake = new Snake("Snake", new Posicion(0, 0));
                    if (misionesCompletadas == 0) {
                        MisionIntermedia m1 = new MisionIntermedia(snake, 1);
                        if (m1.iniciar()) {
                            misionesCompletadas++;
                        }
                    } else if (misionesCompletadas == 1) {
                        MisionIntermedia m2 = new MisionIntermedia(snake, 2);
                        if (m2.iniciar()) {
                            misionesCompletadas++;
                        }
                    } else if (misionesCompletadas == 2) {
                        MisionFinal mf = new MisionFinal(snake);
                        if (mf.iniciar()) {
                            misionesCompletadas++;
                        }
                    } else {
                        System.out.println("Ya completaste todas las misiones! Congratz!");
                    }
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
