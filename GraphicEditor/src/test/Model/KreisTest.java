package test.Model;

import graphiceditor.Model.Kreis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KreisTest {
    private GraphicsStub graphicsStub;
    private Kreis kreis;

    @BeforeEach
    void setUp() throws Exception {
        graphicsStub = new GraphicsStub();
        kreis = new Kreis(55, 65, 15);
    }

    @Test
    void testDraw() {
        kreis.zeichne(graphicsStub);
        assertEquals(1, graphicsStub.ovalCounter, "drawOval() wurde nicht ausgefuehrt!");
        assertEquals(55, graphicsStub.x, "Parameter X von drawOval() nicht korrekt!");
        assertEquals(65, graphicsStub.y, "Parameter Y von drawOval() nicht korrekt!");
        assertEquals(15, graphicsStub.width, "Parameter width von drawOval() nicht korrekt!");
        assertEquals(15, graphicsStub.height, "Parameter height von drawOval() nicht korrekt!");
    }
}
