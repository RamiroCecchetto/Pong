package cecchetto;

import javax.swing.*;
import java.awt.*;

public class Tablero extends JPanel{

    private final int ALTO = 700, ANCHO = 400;
    public  Tablero() {
        this.setBackground(Color.BLACK);
        this.setSize(ALTO, ANCHO);
    }

    public Dimension getSize() {
        return new Dimension(ALTO, ANCHO);
    }

}
