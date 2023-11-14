package cecchetto;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Jugador extends ObjetoGrafico {

    private int x, y;
    private int alto, ancho;
    private int distanciaAlVorde = 110;
    Lado lado;
    public Jugador(Lado lado, Rectangle rectangle) {
        this.lado = lado;
        this.dx = 10;
        this.dy = 10;

        x = (lado.equals(Lado.izquierda)? distanciaAlVorde : rectangle.getSize().width - distanciaAlVorde);
        y = rectangle.getSize().height/2;

        alto = 35;
        ancho = 120;
    }

    @Override
    public void mover(Rectangle rectangle) {}

    @Override
    public void mover(Rectangle rectangle, boolean arriba, boolean abajo) {
        if (arriba && y-alto>0)
            y -= 10;
        if (abajo && y+alto*2<rectangle.height)
            y += 10;
    }

    public Shape getGrafico() {
        return new Rectangle2D.Double(x - alto/2, y - ancho/2, alto, ancho);
    }

}
