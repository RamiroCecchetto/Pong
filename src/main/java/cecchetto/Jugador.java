package cecchetto;

import java.awt.*;

public class Jugador extends ObjetoGrafico{

    private int x, y;
    Posicion posicion;
    public Jugador(Posicion posicion) {
        this.posicion = posicion;

        this.dx = 10;
        this.dy = 10;

    }

    @Override
    public void mover(Rectangle rectangle) {

    }

}
