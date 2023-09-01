package cecchetto;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class ObjetoGrafico {

    protected int x, y;
    protected double dx, dy;

    public abstract void mover(Rectangle rectangle);

}
