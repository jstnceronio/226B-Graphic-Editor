package grafikeditor;

public class Figur {
    int x;
    int y;

    public Figur(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int deltaX, int deltaY) {
        x = deltaX;
        y = deltaY;
    }
}
