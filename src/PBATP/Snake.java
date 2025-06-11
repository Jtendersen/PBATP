package PBATP;

import java.util.Random;

public class Snake extends Personaje {

    private boolean itemRecolectado = false;
    private Random rand = new Random();

    public Snake(String nombre, Posicion posInicial) {
        super(nombre, 100, posInicial);
    }

    public void recogerItem() {
        itemRecolectado = true;
        System.out.println(nombre + " agarró el item con gran destreza!!");
    }

    public boolean tieneItem() {
        return itemRecolectado;
    }

    // dispara ---> daño entre 10 y 30
    public int atacar() {
        return 10 + rand.nextInt(21);
    }

    // esquva ---> daño recibido reducido entre 50% y 100%
    public int esquivar(int danio) {
        int reduccion = 50 + rand.nextInt(51);
        return danio * (100 - reduccion) / 100;
    }

//    @Override
//    public void mover(int avanceX, int avanceY) {
//        this.posicion.mover(avanceX, avanceY);
//        System.out.println(nombre + " se desplazó a [" + posicion.getX() + ", " + posicion.getY() + "]");
//    }
//    public void atacar(Enemigo enemigo) {
//        int danio = 20; // daño fijo que Snake causa (podés ajustar)
//        System.out.println(nombre + " ataca y causa " + danio + " puntos de daño.");
//        if (enemigo instanceof Personaje) {
//            ((Personaje) enemigo).recibirDanio(danio);
//            System.out.println(((Personaje) enemigo).getNombre() + " ahora tiene " + ((Personaje) enemigo).getVida() + " puntos de vida.");
//        }
//    }
}
