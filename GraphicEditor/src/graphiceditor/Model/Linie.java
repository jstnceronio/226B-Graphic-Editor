package graphiceditor.Model;

import graphiceditor.Model.Figur;

import java.awt.*;

public class Linie extends Figur {

    private int endX;
    private int endY;

    public Linie(int x, int y, int endX, int endY) {
        super(x, y);
        this.endX = endX;
        this.endY = endY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
        endX += deltaX;
        endY += deltaY;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawLine(x, y, endX, endY);
    }
}
