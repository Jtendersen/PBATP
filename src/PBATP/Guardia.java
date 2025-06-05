
package PBATP;

import java.util.Random;
public class Guardia extends Personaje implements Enemigo {

    private final Random generador = new Random();

    public Guardia(String identificador, Posicion ubicacionInicial) {
        super(identificador, 100, ubicacionInicial);
    }

    @Override
    public void mover(int desplazamientoX, int desplazamientoY) {
        this.posicion.mover(desplazamientoX, desplazamientoY);
        System.out.println(nombre + " patrulla hacia (" + posicion.getX() + ", " + posicion.getY() + ")");
    }

    @Override
    public void patrullar() {
        int dx = generador.nextInt(3) - 1;
        int dy = generador.nextInt(3) - 1;
        mover(dx, dy);
    }

    @Override
    public boolean detectar(Snake jugador) {
        int deltaX = Math.abs(this.posicion.getX() - jugador.getPosicion().getX());
        int deltaY = Math.abs(this.posicion.getY() - jugador.getPosicion().getY());

        boolean estaCerca = (deltaX + deltaY) == 1;

        if (estaCerca) {
            System.out.println(nombre + " detectó al jugador. ¡Alerta máxima!");
        }

        return estaCerca;
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " no puede atacar directamente.");
        return 0;
    }
}
