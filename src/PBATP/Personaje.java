package PBATP;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected Posicion posicion;
    protected boolean vivo;

    public Personaje(String nombre, int vidaInicial, Posicion posicionInicial) {
        this.nombre = nombre;
        this.vida = vidaInicial;
        this.posicion = posicionInicial;
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

    public boolean estaVivo() {
        return vivo;
    }

    public void setVida(int v) {
        this.vida = v;
        if (this.vida <= 0) {
            this.vida = 0;
            this.vivo = false;
        }
    }

    public void setPosicion(Posicion p) {
        this.posicion = p;
    }
}
