package graphiceditor.Model;

import graphiceditor.Model.Figur;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gruppe extends Figur {

    private List<Figur> figuren = new ArrayList<Figur>();

    public Gruppe(int x, int y) {
        super(x, y);
    }

    public void add(Figur f) {
        figuren.add(f);
    }

    public void delete(Figur f) {
        figuren.remove(f);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        for(Figur f: figuren) {
            f.move(deltaX, deltaY);
        }
    }

    @Override
    public void zeichne(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

}
