package cecchetto;

import javax.swing.*;

public class Pong extends JFrame{

    public Pong() {
        Tablero tablero = new Tablero();
        this.add(tablero);

        this.setSize(tablero.getSize());
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
