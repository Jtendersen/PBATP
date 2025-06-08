package PBATP;

public interface Enemigo {

    void patrullar(); // logica para patrullar

    boolean detectar(Snake snake); // si enemigo detecta a Snake, devuelve true

    int atacar(); // daño realizado
}
