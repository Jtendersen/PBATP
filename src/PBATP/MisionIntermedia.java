package PBATP;

import java.util.Scanner;

public class MisionIntermedia extends Mision {

    private Mapa mapa;
    private Scanner entrada = new Scanner(System.in);

    public MisionIntermedia(Snake snake) {
        super(snake);
    }

    @Override
    public boolean iniciar() {
        // Creamos el mapa 7x7 con 3 guardias.... luego lo vamos a pedir por consola
        mapa = new Mapa(7, 7, 3);
        // mandamos la puerta en coordenadas fija... luego le metemos rnd
        mapa.ubicarPuerta(0, 3);
        // metemos a snake en posicion fija tmb....
        mapa.ubicarSnake(snake, 6, 3);
        // mandamos la tarjeta... esta si esta implementado rnd
        mapa.colocarItemRandom("Tarjeta");
        // metemos los guardias... tmb esta rnd
        mapa.colocarGuardiasRandom();

        // bucle principal
        while (true) {
            mapa.imprimirMapa();

            System.out.print("Es tu turno. Move a Snake (W/A/S/D): ");
            String opcion = entrada.nextLine().trim().toUpperCase();
            Posicion actual = snake.getPosicion();
            Posicion siguiente = new Posicion(actual.getX(), actual.getY());

            switch (opcion) {
                case "W" -> siguiente.setX(actual.getX() - 1);
                case "S" -> siguiente.setX(actual.getX() + 1);
                case "A" -> siguiente.setY(actual.getY() - 1);
                case "D" -> siguiente.setY(actual.getY() + 1);
                default -> {
                    System.out.println("Commando invalido!");
                    continue;
                }
            }

            if (!mapa.moverSnake(siguiente)) {
                System.out.println("No te podés mover ahi!!!");
                continue;
            }

            // si snake llega a la puerta con la tarjeta...
            if (siguiente.equals(mapa.getPosicionPuerta()) && snake.tieneItem()) {
                System.out.println("Congratulaciones!!! Llegaste a la puerta y completaste la primera misión!");
                return true;
            }

            // movemos los guardias y chequeamos de nuevo
            boolean detectado = mapa.moverGuardiasYDetectar();
            if (detectado) {
                mapa.imprimirMapa();
                System.out.println("Un guardia te atrapo al patrullar... otra vez será!");
                return false;
            }
        }
    }

}
