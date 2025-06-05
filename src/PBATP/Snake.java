
package PBATP;

public class Snake extends Personaje {

    public Snake(String apodo, Posicion lugarInicio) {
        super(apodo, 100, lugarInicio);
    }

    @Override
    public void mover(int avanceX, int avanceY) {
        this.posicion.mover(avanceX, avanceY);
        System.out.println(nombre + " se desplazó a [" + posicion.getX() + ", " + posicion.getY() + "]");
    }
    
    public void atacar(Enemigo enemigo) {
        int danio = 20; // daño fijo que Snake causa (podés ajustar)
        System.out.println(nombre + " ataca y causa " + danio + " puntos de daño.");
        if (enemigo instanceof Personaje) {
            ((Personaje) enemigo).recibirDanio(danio);
            System.out.println(((Personaje) enemigo).getNombre() + " ahora tiene " + ((Personaje) enemigo).getVida() + " puntos de vida.");
        }
    }
}





