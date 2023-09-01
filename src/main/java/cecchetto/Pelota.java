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
        x += dx;
        y += dy;

        if (x > rectangle.getMaxX() - RADIO*2) dx = -dx;
        if (y > rectangle.getMaxY() - RADIO*2) dy = -dy;

        if (x < 0) dx = -dx;
        if (y < 0) dy = -dy;

    }

    public Ellipse2D getPelota() {
        return new Ellipse2D.Double(x-RADIO, y-RADIO, RADIO*2, RADIO*2);
    }

}
