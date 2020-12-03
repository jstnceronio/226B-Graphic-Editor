package graphiceditor.Controller;


import graphiceditor.Model.Figur;
import graphiceditor.View.Display;
import graphiceditor.Model.Gruppe;
import graphiceditor.Model.Spitzbueb;
import graphiceditor.View.Zeichnung;

import java.util.ArrayList;
import java.util.List;

public class Grafikeditor {

    private static final Display display = new Display();
    private static List<Figur> figuren = new ArrayList<>();
    private static Zeichnung zeichnung;
    private static Gruppe gruppe = new Gruppe(0, 0);

    public static void main(String [] args) {

        // Figuren (Kreis + Kreuz)
        Spitzbueb s = new Spitzbueb(300, 50, 300, 50, 150);

        // Gruppe füllen
        gruppe.add(s);

        // Gruppe zu Figuren hinzufügen
        figuren.add(gruppe);
        zeichnung = new Zeichnung(figuren);

        display.setZeichnung(zeichnung);
        zeichnung.hinzufuegen(gruppe);
    }
}
