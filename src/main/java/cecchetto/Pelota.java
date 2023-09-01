package cecchetto;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pelota {

    private final int RADIO = 10;
    private int x, y;
    private double DX = 1, DY = 1;

    public Pelota(int x, int y) {
        this.x  =x;
        this.y  =y;
    }

    public void mover(Rectangle rectangle) {
        x += DX;
        y += DY;

        if (x > rectangle.getMaxX()) DX = -DX;
        if (y > rectangle.getMaxY()) DY = -DY;

        if (x < 0) DX = -DX;
        if (y < 0) DY = -DY;

    }

    public Ellipse2D getPelota() {
        return new Ellipse2D.Double(x-RADIO, y-RADIO, RADIO*2, RADIO*2);
    }

}
