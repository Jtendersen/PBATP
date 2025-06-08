//package PBATP;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Posicion puntoInicio = new Posicion(3, 3);
//        Snake jugadorSnake = new Snake("Jugador Snake", puntoInicio);
//
//        Guardia enemigoGuardia = new Guardia("Guardia Alfa", new Posicion(3, 4));
//        enemigoGuardia.patrullar();
//        boolean detectado = enemigoGuardia.detectar(jugadorSnake);
//
//        if (detectado) {
//            System.out.println("¡El guardia ha detectado a Snake!");
//            jugadorSnake.atacar(enemigoGuardia);
//        } else {
//            System.out.println("El guardia no detectó a Snake.");
//        }
//
//        MetalGear rex = new MetalGear(new Posicion(0, 0));
//        int dañoCausado = rex.atacar();
//
//        System.out.println("Metal Gear causó " + dañoCausado + " puntos de daño a Snake.");
//
//        jugadorSnake.recibirDanio(dañoCausado);
//        System.out.println(jugadorSnake.getNombre() + " ahora tiene " + jugadorSnake.getVida() + " puntos de vida.");
//    }
//}
