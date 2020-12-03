package graphiceditor;


import java.util.ArrayList;
import java.util.List;

public class Grafikeditor {

    private static final Display display = new Display();
    private static List<Figur> figuren = new ArrayList<>();
    private static Zeichnung zeichnung;
    private static Gruppe gruppe = new Gruppe(0, 0);

    public static void main(String [] args) {

        Kreis k = new Kreis(300, 50, 300);
        Linie l2 = new Linie(10, 20, 50, 100);

        gruppe.add(k);
        gruppe.add(l2);
        Rechteck r = new Rechteck(100, 100, 50, 50);

        // figuren.add(k);
        figuren.add(r);
        // figuren.add(k);
        figuren.add(gruppe);

        // figuren.add(d);

        zeichnung = new Zeichnung(figuren);
        display.setZeichnung(zeichnung);
        zeichnung.hinzufuegen(gruppe);
        // zeichnung.hinzufuegen(d);
    }
}
