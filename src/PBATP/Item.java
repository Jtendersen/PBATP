package PBATP;

public class Item {

    private String nombre;
    private Posicion posicion;

    public Item(String nombre, Posicion posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return nombre + " en " + posicion;
    }

}
