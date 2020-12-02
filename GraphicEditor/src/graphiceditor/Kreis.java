package graphiceditor;

import java.awt.*;

public class Kreis extends Figur {

    int radius;

    public Kreis(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawOval(x, y, radius, radius);
    }
}
