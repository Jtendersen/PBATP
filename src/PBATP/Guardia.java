package PBATP;

public class Guardia extends Personaje implements Enemigo {

    public Guardia(String nombre, Posicion posInicial) {
        super(nombre, 100, posInicial);
    }

//    @Override
//    public void mover(int desplazamientoX, int desplazamientoY) {
//        this.posicion.mover(desplazamientoX, desplazamientoY);
//        System.out.println(nombre + " patrulla hacia (" + posicion.getX() + ", " + posicion.getY() + ")");
//    }
    @Override
    public void patrullar() {
        // El movimiento lo manejamos desde el mapa
//        int dx = generador.nextInt(3) - 1;
//        int dy = generador.nextInt(3) - 1;
//        mover(dx, dy);
    }

    @Override
    public boolean detectar(Snake snake) {
        return this.posicion.distanciaAOtra(snake.getPosicion()) <= 1;
//        int deltaX = Math.abs(this.posicion.getX() - jugador.getPosicion().getX());
//        int deltaY = Math.abs(this.posicion.getY() - jugador.getPosicion().getY());
//
//        boolean estaCerca = (deltaX + deltaY) == 1;
//
//        if (estaCerca) {
//            System.out.println(nombre + " detectó al jugador. ¡Alerta máxima!");
//        }
//
//        return estaCerca;
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " no puede atacar directamente.");
        return 0; // No hay combate cuerpo a cuerpo en misiones 1 y 2 :(
    }
}
