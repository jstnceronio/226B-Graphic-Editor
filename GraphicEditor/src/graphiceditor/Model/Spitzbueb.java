package graphiceditor.Model;

import java.awt.*;

public class Spitzbueb extends Figur {

    private Gruppe gr = new Gruppe(0, 0);

    public Spitzbueb(int x, int y, int radius, int hoehe, int breite) {
        super(x, y);

        Kreis k = new Kreis(x, y, radius);
        Rechteck r = new Rechteck(x + 125, y + 70, hoehe, breite);
        Rechteck r2 = new Rechteck(x + 75, y + 115, breite, hoehe);

        gr.add(k);
        gr.add(r);
        gr.add(r2);
    }

    @Override
    public void zeichne(Graphics g) {
        gr.zeichne(g);
    }
}
