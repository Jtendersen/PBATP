package PBATP;

import java.util.Random;

public class Mapa {

    private Celda[][] celdas;
    private Snake snake;
    private Guardia[] guardias;
    private int cantGuardias;
    private Item item;
    private Celda puerta;
    private Random rand = new Random();

    public Mapa(int filas, int columnas, int cantGuardias) {
        this.celdas = new Celda[filas][columnas];
        this.cantGuardias = cantGuardias;
        this.guardias = new Guardia[cantGuardias];

        // Inicializar las ce3ldas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j);
            }
        }
    }

    public void ubicarPuerta(int fila, int columna) {
        puerta = celdas[fila][columna];
        puerta.setEsPuerta(true);
    }

    public void ubicarSnake(Snake s, int fila, int columna) {
        snake = s;
        s.setPosicion(new Posicion(fila, columna));
        celdas[fila][columna].setSnake(s);
    }

    public void colocarItemRandom(String nombreItem) {
        Posicion p;
        do {
            int x = rand.nextInt(celdas.length);
            int y = rand.nextInt(celdas[0].length);
            p = new Posicion(x, y);
        } while (p.distanciaAOtra(snake.getPosicion()) < 2 || p.equals(puerta.getPosicion())||celdas[p.getX()][p.getY()].tieneEnemigo());
        item = new Item(nombreItem, p);
        celdas[p.getX()][p.getY()].setItem(item);
    }

    public void colocarGuardiasRandom() {
        for (int i = 0; i < cantGuardias; i++) {
            Posicion p;
            do {
                int x = rand.nextInt(celdas.length);
                int y = rand.nextInt(celdas[0].length);
                p = new Posicion(x, y);
            } while (p.distanciaAOtra(snake.getPosicion()) <= 2
                    || p.equals(puerta.getPosicion())
                    || (item != null && p.equals(item.getPosicion()))
                    || celdas[p.getX()][p.getY()].tieneEnemigo());
            Guardia g = new Guardia("G" + (i + 1), p);
            guardias[i] = g;
            celdas[p.getX()][p.getY()].setEnemigo(g);
        }
    }

    public void imprimirMapa() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[0].length; j++) {
                System.out.print(" " + celdas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean moverSnake(Posicion nuevaPos) {
         int fila = nuevaPos.getX(), columna = nuevaPos.getY();
        if (fila < 0 || fila >= celdas.length || columna < 0 || columna >= celdas[0].length) return false;
        Celda destino = celdas[fila][columna];
        if (destino.isEsPuerta() && !snake.tieneItem()) return false;
        // limpiamos la celda vieja
        Posicion anterior = snake.getPosicion();
        celdas[anterior.getX()][anterior.getY()].setSnake(null);
        // movemos a super Snake a la celda nueva
        snake.setPosicion(nuevaPos);
        destino.setSnake(snake);
        // si habemus item, lo agarramos
        if (destino.tieneItem()) {
            snake.recogerItem();
            // y lo sacamos del mapa
            destino.setItem(null);
        }
        return true;
    }

    public boolean moverGuardiasYDetectar() {
        for (Guardia g : guardias) {
            Posicion actual = g.getPosicion();
            // intento de moverse en eje
            int direccion = rand.nextInt(4); // 0=arriba, 1=abajo, 2=izq, 3=derecha
            
            int nuevaFila = actual.getX()+ (direccion == 0 ? -1 : direccion == 1 ? 1 : 0);
            int nuevaColumna = actual.getY() + (direccion == 2 ? -1 : direccion == 3 ? 1 : 0);
            
            // verificamos limites
            if (nuevaFila<0||nuevaFila>=celdas.length|| nuevaColumna<0||nuevaColumna>=celdas[0].length){
                continue; //no se deberia mover... 
            }
            
            Celda origen = celdas[actual.getX()][actual.getY()];
            Celda destino = celdas[nuevaFila][nuevaColumna];
            
            // no pisar la puerta ni a otro guardia
            if (destino.tieneEnemigo()||destino.isEsPuerta()){
                continue;
            }
            
            // si se topa con Snake ---> pica Snake!!!
            if (destino.tieneSnake()) {
                return true;
            }
            // movemos... o sea, limpiamos el origen y seteamos al guardia en destino
            origen.setEnemigo(null);
            destino.setEnemigo(g);
            g.setPosicion(new Posicion (nuevaFila, nuevaColumna));
        }
        // finally checkeamos cercania....
        for (Guardia g : guardias) {
            if (g.getPosicion().distanciaAOtra(snake.getPosicion()) <= 1) {
                return true;
            }
        }
        return false;
    }

    public Posicion getPosicionSnake() {
        return snake.getPosicion();
    }

    public Posicion getPosicionPuerta() {
        return puerta.getPosicion();
    }
    
    public Guardia[] getGuardias(){
        return guardias;
    }

}
