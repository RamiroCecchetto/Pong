package cecchetto;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pelota extends ObjetoGrafico{

    private final int RADIO = 10;

    public Pelota(int x, int y) {
        this.x  =x;
        this.y  =y;

        this.dx = 10;
        this.dy = 10;
    }

    public void mover(Rectangle rectangle) {
        if (x < 0 || x + RADIO * 2 > rectangle.getWidth() - RADIO * 2) {
            dx = -dx;
        }
        if (y < 0 || y + RADIO * 2 > rectangle.getHeight() - RADIO * 2) {
            dy = -dy;
        }

        x += dx;
        y += dy;
    }

    public void sacarMedio(Rectangle rectangle) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        x = (int) (rectangle.getWidth()/2);
        y = (int) (rectangle.getHeight()/2);

        rebotar();
    }

    public void rebotar() {
        dx = -dx;
        Sonido.iniciar("pong");
    }

    @Override
    public void mover(Rectangle rectangle, boolean arriba, boolean abajo) {}


    public Shape getGrafico() {
        return new Ellipse2D.Double(x-RADIO, y-RADIO, RADIO*2, RADIO*2);
    }

}
