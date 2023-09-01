package cecchetto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong extends JFrame{

    final int FPS = 1000/60; //en microsegundos
    public Pong() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        Tablero tablero = new Tablero();
        this.add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.setLocationRelativeTo(null);

        Timer timer = new Timer(FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.repaint();
            }
        });
        timer.start();


    }

}
