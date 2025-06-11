package PBATP;

import java.util.Scanner;

public class MisionFinal extends Mision {

    private MetalGear metalGear;
    private Scanner entrada = new Scanner(System.in);

    public MisionFinal(Snake snake) {
        super(snake);
        this.metalGear = new MetalGear("Metal Gear REX", new Posicion(0, 0));
    }

    @Override
    public boolean iniciar() {
        System.out.println("=== MISIÓN FINAL: LA GRAN BATALLA CONTRA METAL GEAR ===");
        // Restauramos la vida al arrancar
        snake.setVida(100);
        metalGear.setVida(100);

        System.out.println("DEBUG → snake.estaVivo()="
                + snake.estaVivo() + " | vidas=" + snake.getVida());
        System.out.println("DEBUG → metalGear.estaVivo()="
                + metalGear.estaVivo() + " | vidas=" + metalGear.getVida());

        while (snake.estaVivo() && metalGear.estaVivo()) {
            // mostramos la vida
            System.out.println("\nTu vida: " + snake.getVida() + " | Vida de Metal Gear: " + metalGear.getVida());
            // Turno de snake...
            System.out.println("Eelegí la acción:");
            System.out.println("1) Disparar misil");
            System.out.println("2) Esquivar");
            System.out.print("Opción: ");
            String opcion = entrada.nextLine().trim();

            boolean esquivar = false;
            if (opcion.equals("1")) {
                int danio = snake.atacar();
                System.out.println("Disparás un misil y le hacés " + danio + " de daño!");
                metalGear.setVida(metalGear.getVida() - danio);
            } else if (opcion.equals("2")) {
                esquivar = true;
                System.out.println("--> Intentás esquivar el próximo ataque de Metal Gear");
            } else {
                System.out.println("Ingresaste una opción inválida y perdés el turno! Prestá atención!");
            }

            // chequeamos si Metal palmo...
            if (!metalGear.estaVivo()) {
                System.out.println("\n Le ganaste a Metal Gear y completaste la misión final... ");
                System.out.println("Estate atento a las úlitmas novedades del grupo 14...");
                System.out.println("Proximamente la batalla final contra un enemigo mucho mas difícil...");
                System.out.println("Podrá Snake vencer a 'La inflacion'???");
                System.out.println("=== COMMING SOON!!! ===");
                return true;
            }

            // Turno de Metal Gear...
            int danioMG = metalGear.atacar();
            if (esquivar) {
                int danioRecibido = snake.esquivar(danioMG);
                System.out.println("Metal Gear te ataca realizando " + danioMG + " de daño. Lográs esquivar el ataque y reducirlo a " + danioRecibido + ".");
                snake.setVida(snake.getVida() - danioRecibido);
            } else {
                System.out.println("Metal Gear te ataca y recibis " + danioMG + " de daño.");
                snake.setVida(snake.getVida() - danioMG);
            }

            // chequeamos si palmo snake
            if (!snake.estaVivo()) {
                System.out.println("\nSnake ha caído en batalla. Fallaste la misión final.");
                return false;
            }
        }
        return false;
    }
}
