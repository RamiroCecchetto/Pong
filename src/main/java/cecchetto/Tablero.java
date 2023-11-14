package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tablero extends JPanel{

    private final int ALTO = 700, ANCHO = 400;
    private Pelota pelota;
    private Jugador jugadorL, jugadorR;
    ArrayList<ObjetoGrafico> objetosGraficos;
    private boolean w, s, up, down;

    public  Tablero() {
        this.setBackground(Color.BLACK);

        pelota = new Pelota(ALTO / 2, ANCHO / 2);
        jugadorL = new Jugador(Lado.izquierda, new Rectangle(ALTO, ANCHO));
        jugadorR = new Jugador(Lado.derecha, new Rectangle(ALTO, ANCHO));
        objetosGraficos = new ArrayList<>();

        objetosGraficos.add(pelota);
        objetosGraficos.add(jugadorL);
        objetosGraficos.add(jugadorR);
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
        objetosGraficos.forEach(e -> g.fill(e.getGrafico()) );
    }

    private void actualizar() {
        pelota.mover(new Rectangle(ALTO, ANCHO));
        jugadorR.mover(new Rectangle(ALTO, ANCHO), up, down);
        jugadorL.mover(new Rectangle(ALTO, ANCHO), w, s);

        for (ObjetoGrafico objetoGrafico : objetosGraficos) {
            if (objetoGrafico instanceof Pelota)
                if(pelota.getGrafico().intersects(jugadorL.getGrafico().getBounds2D()) || pelota.getGrafico().intersects(jugadorR.getGrafico().getBounds2D()))
                    pelota.rebotar();
        }

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ALTO, ANCHO);
    }

    public void setTeclas(boolean w, boolean s, boolean up, boolean down) {
        this.w  =w;
        this.s  =s;
        this.up  =up;
        this.down = down;
    }
}
