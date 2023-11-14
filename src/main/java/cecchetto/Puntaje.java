package cecchetto;

import java.awt.*;
import java.awt.font.TextLayout;

public class Puntaje{

    private String puntaje;
    private int puntajeL = 0, puntajeR = 0;

    public Puntaje() {
        puntaje = new String("0 - 0");
    }

    public void aumentarPuntos(Lado lado) {
        if (lado.equals(Lado.izquierda))
            puntajeL++;
        else
            puntajeR++;
    }

    public String getPuntaje() {
        puntaje = puntajeL + " - "+ puntajeR;
        return puntaje;
    }

}
