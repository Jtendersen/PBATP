package PBATP;

import java.util.Random;

public class MetalGear extends Personaje implements Enemigo {

    private Random rand = new Random();

    public MetalGear(String nombre, Posicion posInicial) {
        super("Unidad Metal Gear REX", 100, posInicial);
    }

//    @Override
//    public void mover(int dx, int dy) {
//        System.out.println("REX permanece en su posición sin desplazarse.");
//    }
    @Override
    public void patrullar() {
        // no patrulla en la mision final
//        System.out.println("Metal Gear no realiza patrullas, estático.");
    }

    @Override
    public boolean detectar(Snake objetivo) {
        // no se utiliza en mision final
        return false;
    }

    @Override
    public int atacar() {
        return 15 + rand.nextInt(26); // daño entre 15 y 40
//        System.out.println("Metal Gear dispara y causa " + danio + " puntos de daño.");

    }
}
