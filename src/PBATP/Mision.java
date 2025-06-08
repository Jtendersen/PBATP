
package PBATP;

public abstract class Mision {
    protected Snake snake;
    public Mision(Snake snake){
        this.snake = snake;
    }
    public abstract boolean iniciar();
}
