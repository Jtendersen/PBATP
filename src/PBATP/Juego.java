package PBATP;

import java.util.Scanner;

public class Juego {

    private static final int KEY = 7;
    private static final int OFFSET = 3;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int misionesCompletadas = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Iniciar Misión");
            System.out.println("2) Guardar estado");
            System.out.println("3) Cargar estado");
            System.out.println("4) Salir");
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
                case "2" -> {
                    int raw = misionesCompletadas;
                    int codigo = (raw + OFFSET) * KEY;
                    System.out.println("\n=== GUARDAR ESTADO ===");
                    System.out.println("Tu código de progreso es: " + codigo);
                    System.out.println("Guardá este número para continuar tu partida más tarde.");
                }
                case "3" -> {
                    System.out.println("\n=== CARGAR ESTADO ===");
                    System.out.print("Ingresá tu código de progreso: ");
                    String linea = entrada.nextLine().trim();

                    // validamos que venga un numero x regex
                    if (linea.matches("\\d+")) {
                        int codigo = Integer.parseInt(linea);
                        // Solo aceptamos si es multiplo de la key
                        if (codigo % KEY == 0) {
                            // Invertimos la formula
                            int raw = codigo / KEY - OFFSET;
                            if (raw >= 0 && raw <= 3) {
                                misionesCompletadas = raw;
                                System.out.println("Estado cargado correctamente. Misiones completadas: "
                                        + misionesCompletadas);
                            } else {
                                System.out.println("El codigo ingresado está fuera del rango permitido...");
                            }
                        } else {
                            System.out.println("Código inválido... intentá nuevamente");
                        }
                    } else {
                        System.out.println("Código inválido. Ingresá solo números!.");
                    }
                }
                case "4" ->
                    salir = true;
                default ->
                    System.out.println("Opción invalida... :(");
            }
        }
        System.out.println("Nos vemos en la proxima aventura... ");
        entrada.close();
    }
}
