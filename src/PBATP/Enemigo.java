
package PBATP;

  public interface Enemigo {
    void patrullar();
    boolean detectar(Snake snake);
    int atacar();
}
  
