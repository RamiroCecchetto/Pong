package cecchetto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Pong extends JFrame{

    final int FPS = 1000/60; //en microsegundos
    private boolean w, s, up, down;
    public Pong() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        Tablero tablero = new Tablero();
        this.add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.setLocationRelativeTo(null);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                actualizarTeclas(e, true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                actualizarTeclas(e, false);
            }
        });

        Timer timer = new Timer(FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.repaint();
                tablero.setTeclas(w, s, up, down);
            }
        });
        timer.start();
    }

    private void actualizarTeclas(KeyEvent e, boolean estado) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                w = estado;
                break;
            case KeyEvent.VK_S:
                s = estado;
                break;
            case KeyEvent.VK_UP:
                up = estado;
                break;
            case KeyEvent.VK_DOWN:
                down = estado;
                break;
        }
    }

}














