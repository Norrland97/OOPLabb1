/**
 * This represents a position using doubles as x and y coordinates.
 */
public class Position {
    private double x;
    private double y;

    /**
     * constructor of the class Position
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
