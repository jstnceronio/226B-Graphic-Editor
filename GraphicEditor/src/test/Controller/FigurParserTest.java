package test.Controller;

import graphiceditor.Controller.FigurDAO;
import graphiceditor.Controller.FigurParser;
import graphiceditor.Model.Figur;
import graphiceditor.Model.Kreis;
import graphiceditor.Model.Linie;
import graphiceditor.Model.Rechteck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigurParserTest {

    private FigurDAO dao;
    private FigurParser fp;

    @BeforeEach
    public void setup() {
        dao = new FigurDAOStub();
        fp = new FigurParser(dao);
    }

    @Test
    void testParse() {
        // parse shapes
        List<Figur> figuren = fp.parse();
        // rectangle to test
        Rechteck testRechteck = (Rechteck) figuren.get(0);
        // test shape attributes
        assertEquals(40, testRechteck.getX(), "Rechteck: Ungültige X-Position");
        assertEquals(20, testRechteck.getY(), "Rechteck: Ungültige Y-Position");
        assertEquals(80, testRechteck.getBreite(), "Rechteck: Ungültige Breite");
        assertEquals(30, testRechteck.getHoehe(), "Rechteck: Ungültige Hoehe");

        // circle to test
        Kreis testKreis = (Kreis) figuren.get(1);
        assertEquals(60, testKreis.getX(), "Kreis: Ungültige X-Position");
        assertEquals(50, testKreis.getY(), "Kreis: Ungültige Y-Position");
        assertEquals(40, testKreis.getRadius(), "Kreis: Ungültiger Radius");

        // line to test
        Linie testLinie = (Linie) figuren.get(2);
        assertEquals(30, testLinie.getX(), "Linie: Ungültige X-Position");
        assertEquals(70, testLinie.getY(), "Linie: Ungültige Y-Position");
        assertEquals(70, testLinie.getEndX(), "Linie: Ungültige End-X-Position");
        assertEquals(80, testLinie.getEndY(), "Linie: Ungültige End-X-Position");
    }
}
