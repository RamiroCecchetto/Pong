package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Tablero extends JPanel{

    private final int ALTO = 700, ANCHO = 400;
    private Pelota pelota;
    private Jugador jugadorL, jugadorR;

    public  Tablero() {
        this.setBackground(Color.BLACK);
        pelota = new Pelota(ALTO / 2, ANCHO / 2);
        jugadorL = new Jugador(Lado.izquierda, new Rectangle(ALTO, ANCHO));
        jugadorR = new Jugador(Lado.derecha, new Rectangle(ALTO, ANCHO));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        dubijar(g2);
        actualizar();

        g2.dispose();
    }

    private void dubijar(Graphics2D g) {
        g.fill(pelota.getPelota());
        g.fill(jugadorR.getJugador());
        g.fill(jugadorL.getJugador());
    }

    private void actualizar() {
        pelota.mover(new Rectangle(ALTO, ANCHO));
        jugadorR.mover(new Rectangle(ALTO, ANCHO));
        jugadorL.mover(new Rectangle(ALTO, ANCHO));
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ALTO, ANCHO);
    }

    public void setTeclas(boolean w, boolean s, boolean up, boolean down) {
        jugadorR.setTeclas(w, s);
        jugadorL.setTeclas(up, down);
    }
}
