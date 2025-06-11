package PBATP;

public class Posicion {

    private int x; //FILA
    private int y; // COLUMNA

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter para fila
    public int getX() {
        return x;
    }

    // Getter para columna
    public int getY() {
        return y;
    }

    // Setter para fila
    public void setX(int x) {
        this.x = x;
    }

    // Setter para columna
    public void setY(int y) {
        this.y = y;
    }

//    public void mover(int dx, int dy) {
//        this.x += dx;
//        this.y += dy;
//    }
    // retornar la distancia por el metodo Manhattan... Considera solo mov en linea recta
    // https://medium.com/@datasciencejourney100_83560/difference-between-l1-manhattan-and-l2-euclidean-distance-c70b5da25fe0
    // determina distancia entre esta celda y otra
    public int distanciaAOtra(Posicion otra) {
        return Math.abs(this.x - otra.x) + Math.abs(this.y - otra.y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Posicion p = (Posicion) obj;
        return this.x == p.x && this.y == p.y;
    }

}
