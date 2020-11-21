package grafikeditor;

public class Grafikeditor {

    private static final Display display = new Display();

    public static void main(String [] args) {
        /*
        Rechteck r = new Rechteck(270, 270, 50, 100);
        Linie l = new Linie(250, 300, 150, 100);
        Kreis k1 = new Kreis(250, 250, 100);
        Kreis k2 = new Kreis(350, 250, 100);

        display.hinzufuegen(r);
        display.hinzufuegen(k1);
        display.hinzufuegen(k2);
        display.hinzufuegen(l);

        r.move(10, 10);
        l.move(15, 15, 50, 15);
        */

        Linie l2 = new Linie(10, 20, 30, 40);
        l2.move(10, 10);
        Figur f2 = new Linie(10, 20, 30, 40);
        f2.move(10, 10);

        display.hinzufuegen(l2);
        display.hinzufuegen(f2);

    }
}
