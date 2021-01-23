package test.Model;

public class GraphicsStub extends ConcreteGraphics {
    int ovalCounter;

    int x, y, width, height;

    @Override
    public void drawOval(int x, int y, int width, int height) {
        ovalCounter++;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
