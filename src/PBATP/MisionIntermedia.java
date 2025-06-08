package PBATP;

import java.util.Scanner;

public class MisionIntermedia extends Mision {

    private Mapa mapa;
    private Scanner entrada = new Scanner(System.in);
    private int numeroMision;

    public MisionIntermedia(Snake snake, int numeroMision) {
        super(snake);
        this.numeroMision = numeroMision;
    }

    @Override
    public boolean iniciar() {
        // parametros segun el numero de mision:
        int filas = (numeroMision == 1) ? 7 : 9;
        int columnas = filas; // siempre va a ser cuadrado
        int cantidadGuardias = (numeroMision == 1) ? 3 : 4;
        // el random para ubicar no va ya que puede quedar facil o casi sin sentido.
        // optamos por fijar la puerta en la primera fila y al medio del mapa:
        int columnaPuerta = (numeroMision == 1) ? 3 : 4;
        // y snake que arranque inferior izq para la mision 1 e inferior derecha para la mision 2.
        int filaInicio = (numeroMision == 1) ? 6 : 8;
        int columnaInicio = (numeroMision == 1) ? 0 : 8;
        String nombreItem = (numeroMision == 1) ? "Tarjeta" : "C4" ;
        // Creamos el mapa...
        mapa = new Mapa(filas, columnas, cantidadGuardias);
        // mandamos la puerta segun los criterios de mas arriba...
        mapa.ubicarPuerta(0, columnaPuerta);
        // metemos a snake en posicion segun los criterios....
        mapa.ubicarSnake(snake, filaInicio, columnaInicio);
        // mandamos la tarjeta o C4
        mapa.colocarItemRandom(nombreItem);
        // metemos los guardias... rnd
        mapa.colocarGuardiasRandom();

        // bucle principal
        while (true) {
            mapa.imprimirMapa();

            System.out.print("Es tu turno. Move a Snake (W/A/S/D): ");
            String opcion = entrada.nextLine().trim().toUpperCase();
            Posicion actual = snake.getPosicion();
            Posicion siguiente = new Posicion(actual.getX(), actual.getY());

            switch (opcion) {
                case "W" ->
                    siguiente.setX(actual.getX() - 1);
                case "S" ->
                    siguiente.setX(actual.getX() + 1);
                case "A" ->
                    siguiente.setY(actual.getY() - 1);
                case "D" ->
                    siguiente.setY(actual.getY() + 1);
                default -> {
                    System.out.println("Commando invalido!");
                    continue;
                }
            }

            if (!mapa.moverSnake(siguiente)) {
                System.out.println("No te podés mover ahi!!!");
                continue;
            }

            // si snake llega a la puerta con el item que sea...
            if (siguiente.equals(mapa.getPosicionPuerta()) && snake.tieneItem()) {
                // para la mision 2 debemos verificar distancia tambien.. 
                if (numeroMision ==2){
                    boolean guardiaCerca = false;
                    // refactor con while para que corte al encontrar el primer guardia y evitar el break...
                    for (Guardia g: mapa.getGuardias()){
                        if (g.getPosicion().distanciaAOtra(mapa.getPosicionPuerta())<=3){
                            guardiaCerca = true;
                            break;
                        }
                    }
                    if (guardiaCerca){
                        System.out.println("Hay moros en la costa... Tenés que alejarte de los guardias! ");
                        continue;
                    }
                }
                System.out.println("Congratulaciones!!! Llegaste a la puerta y completaste la misión "+numeroMision+"!!");
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
