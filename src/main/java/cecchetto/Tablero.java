package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tablero extends JPanel{

    private final int ALTO = 700, ANCHO = 400;
    private Pelota pelota;
    private Jugador jugadorL, jugadorR;
    private Puntaje puntaje;
    ArrayList<ObjetoGrafico> objetosGraficos;
    private boolean w, s, up, down;

    public  Tablero() {
        this.setBackground(Color.BLACK);

        objetosGraficos = new ArrayList<>();
        pelota = new Pelota(ALTO / 2, ANCHO / 2);
        jugadorL = new Jugador(Lado.izquierda, new Rectangle(ALTO, ANCHO));
        jugadorR = new Jugador(Lado.derecha, new Rectangle(ALTO, ANCHO));
        puntaje = new Puntaje();

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
        verificarPuntos();

        g2.dispose();
    }

    private void verificarPuntos() {

        if (pelota.x == 0) {
            puntaje.aumentarPuntos(Lado.derecha);
            pelota.sacarMedio(new Rectangle(ALTO, ANCHO));
        }
        if (pelota.x == 670) {
            puntaje.aumentarPuntos(Lado.izquierda);
            pelota.sacarMedio(new Rectangle(ALTO, ANCHO));
        }

    }

    private void dubijar(Graphics2D g) {
        objetosGraficos.forEach(e -> g.fill(e.getGrafico()));

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(puntaje.getPuntaje(), ALTO/2, ANCHO/5);
    }

    private void actualizar() {
        pelota.mover(new Rectangle(ALTO, ANCHO));
        jugadorR.mover(new Rectangle(ALTO, ANCHO), up, down);
        jugadorL.mover(new Rectangle(ALTO, ANCHO), w, s);

        if(pelota.getGrafico().intersects(jugadorL.getGrafico().getBounds2D())
                || pelota.getGrafico().intersects(jugadorR.getGrafico().getBounds2D()))
            pelota.rebotar();

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
