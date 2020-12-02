package graphiceditor;


import java.util.ArrayList;
import java.util.List;

public class Grafikeditor {

    private static final Display display = new Display();
    private static List<Figur> figuren = new ArrayList<>();
    private static Zeichnung zeichnung;

    public static void main(String [] args) {

        // Aufgabe 3 & 4

        Linie l = new Linie(10, 20, 50, 100);
        Rechteck r = new Rechteck(100, 100, 50, 50);
        Dreieck d = new Dreieck(300, 60, 100, 200);

        figuren.add(l);
        figuren.add(r);
        figuren.add(d);

        zeichnung = new Zeichnung(figuren);
        display.setZeichnung(zeichnung);

        l.move(100, 50);
        r.move(100, 50);

        zeichnung.hinzufuegen(l);
        zeichnung.hinzufuegen(r);
        zeichnung.hinzufuegen(d);
    }
}
