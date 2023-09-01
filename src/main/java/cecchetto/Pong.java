package cecchetto;

import javax.swing.*;

public class Pong extends JFrame{

    Hilo hilo;
    public Pong() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        Tablero tablero = new Tablero();
        this.add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        hilo = new Hilo(tablero);
        hilo.run();


    }

}
