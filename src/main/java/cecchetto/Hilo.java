package cecchetto;

public class Hilo extends Thread{

     Tablero tablero;
     public Hilo(Tablero tablero) {
         this.tablero = tablero;
     }

     @Override
     public void run() {
         while (true) {
             tablero.repaint();
         }
     }

}
