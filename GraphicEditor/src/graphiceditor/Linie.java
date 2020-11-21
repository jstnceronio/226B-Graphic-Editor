package grafikeditor;

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

    public void move(int deltaX, int deltaY, int deltaEndX, int deltaEndY) {
        super.move(deltaX, deltaY);
        endX = deltaEndX;
        endY = deltaEndY;
    }
}
