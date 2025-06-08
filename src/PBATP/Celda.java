package PBATP;

public class Celda {

    private Posicion pos;
    private boolean esPuerta = false;
    private Item item = null;
    private Snake snake = null;
    private Enemigo enemigo = null;

    public Celda(int x, int y) {
        this.pos = new Posicion(x, y);
    }

    public Posicion getPosicion() {
        return pos;
    }

    public boolean isEsPuerta() {
        return esPuerta;
    }

    public void setEsPuerta(boolean b) {
        this.esPuerta = b;
    }

    public boolean tieneItem() {
        return item != null;
    }

    public void setItem(Item it) {
        item = it;
    }

    public boolean tieneSnake() {
        return snake != null;
    }

    public void setSnake(Snake sn) {
        snake = sn;
    }

    public boolean tieneEnemigo() {
        return enemigo != null;
    }

    public void setEnemigo(Enemigo en) {
        enemigo = en;
    }

    @Override
    public String toString() {
        if (snake != null) {
            return "S";
        }
        if (enemigo != null) {
            return "G";
        }
        if (item != null) {
            return item.getNombre() == "Tarjeta" ? "L" : "C4";

        }
        if (esPuerta) {
            return "P";
        }
        return ".";
    }

}
