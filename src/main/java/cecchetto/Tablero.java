package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Tablero extends JPanel{

    private final int ALTO = 700, ANCHO = 400;
    private Pelota pelota;

    public  Tablero() {
        this.setBackground(Color.BLACK);
        pelota = new Pelota(ALTO/2, ANCHO/2);

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

    public void dubijar(Graphics2D g) {
        g.draw(pelota.getPelota());
    }

    public void actualizar() {
        pelota.mover(new Rectangle(ALTO, ANCHO));
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ALTO, ANCHO);
    }

}
