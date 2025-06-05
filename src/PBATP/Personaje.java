
package PBATP;

    public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected Posicion posicion;

    public Personaje(String nombre, int vida, Posicion posicion) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
            vida = 0;
        }
    }

    public abstract void mover(int dx, int dy);
}
