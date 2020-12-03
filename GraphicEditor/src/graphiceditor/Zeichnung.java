package graphiceditor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {

    private List<Figur> figuren;

    /**
     * Zeichnungs Konstruktor
     * @param figuren
     */
    public Zeichnung(List<Figur> figuren) {
        this.figuren = figuren;
    }

    /**
     * Delegiert Zeichnen an Figur selber
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    /**
     * Fügt eine weitere Figur hinzu und löst die Auffrischung des Fensterinhaltes aus.
     * @param figur Referenz auf das weitere Figur-Objekt.
     */
    public void hinzufuegen(Figur figur) {
        figuren.add(figur);
        repaint();
    }

    /**
     * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
     */
    public void allesLoeschen() {
        figuren.clear();
        repaint();
    }
}
