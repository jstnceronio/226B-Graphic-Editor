package graphiceditor.Model;

import java.awt.*;

public class Dreieck extends Figur {

    private int hoehe;
    private int laenge;
    // set of x values
    private int[] xset;
    // set of y values
    private int[] yset;

    public Dreieck(int x, int y, int hoehe, int laenge) {
        super(x, y);
        this.hoehe = hoehe;
        this.laenge = laenge;

        xset = new int[] {x, x + hoehe, x + laenge};
        yset = new int[] {y, y + hoehe, y};
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawPolygon(xset, yset, 3);
    }
}
