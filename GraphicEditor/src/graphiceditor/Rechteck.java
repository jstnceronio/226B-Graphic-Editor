package graphiceditor;

import java.awt.*;

public class Rechteck extends Figur {

    private int breite;
    private int hoehe;

    public Rechteck(int x, int y, int breite, int hoehe) {
        super(x, y);
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawRect(x, y, breite, hoehe);
    }
}
