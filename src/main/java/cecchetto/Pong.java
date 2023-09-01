package cecchetto;

import javax.swing.*;

public class Pong extends JFrame{

    public Pong() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        Tablero tablero = new Tablero();
        this.add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    tablero.repaint();
            }
        });

        thread.start();

    }

}
