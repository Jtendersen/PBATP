
package PBATP;
import java.util.Random;
public class MetalGear extends Personaje implements Enemigo {

    private final Random azar = new Random();

    public MetalGear(Posicion puntoInicial) {
        super("Unidad Metal Gear REX", 100, puntoInicial);
    }

    @Override
    public void mover(int dx, int dy) {
        System.out.println("REX permanece en su posición sin desplazarse.");
    }

    @Override
    public void patrullar() {
        System.out.println("Metal Gear no realiza patrullas, estático.");
    }

    @Override
    public boolean detectar(Snake objetivo) {
        // Por ahora, REX no detecta enemigos (puedes modificarlo más adelante si querés).
        return false;
    }

    @Override
    public int atacar() {
        int danio = 50 + azar.nextInt(21); // daño entre 50 y 70
        System.out.println("Metal Gear dispara y causa " + danio + " puntos de daño.");
        return danio;
    }
}
