import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    Car c = new Car(4, 200, Color.BLACK, "Volvo240");
    @Test
    public void getCurrentPos() {
        assertEquals(new Point(0,0), c.getCurrentPos());
    }

    @Test
    public void setCurrentPos() {

        c.setCurrentPos(new Point(1,1));
        assertEquals(new Point(1,1), c.getCurrentPos());



    }

    @Test
    public void getCurrentDirection() {

        assertEquals(0.0, c.getCurrentDirection());

    }

    @Test
    public void setCurrentDirection() {
        c.setCurrentDirection(30);
        assertEquals(30.0, c.getCurrentDirection());

    }

    @Test
    public void getNrDoors() {

        assertEquals(4, c.getNrDoors());
    }

    @Test
    public void getEnginePower() {

        assertEquals(200.0, c.getEnginePower());
    }

    @Test
    public void getCurrentSpeed() {

        assertEquals(0.0, c.getCurrentSpeed());
    }

    @Test
    public void getColor() {


        assertEquals(Color.BLACK, c.getColor());

    }

    @Test
    public void setColor() {
        c.setColor(Color.BLUE);
        assertEquals(Color.BLUE, c.getColor());
    }

    @Test
    public void startEngine() {

        c.startEngine();

        assertEquals(0.1, c.getCurrentSpeed());
    }

    @Test
    public void stopEngine() {
        c.stopEngine();

        assertEquals(0.0, c.getCurrentSpeed());
    }

    @Test
    public void speedFactor() {
        assertEquals(20.0, c.speedFactor());
    }

    @Test
    public void incrementSpeed() {
        c.incrementSpeed(10);
        assertEquals(200.0, c.getCurrentSpeed(), 0.01);
    }

    @Test
    public void decrementSpeed() {

        c.decrementSpeed(10);
        assertEquals(-200.0, c.getCurrentSpeed(), 0.01);

    }

    @Test
    public void move() {
        c.startEngine();
        c.incrementSpeed(10);
        c.move();

        assertEquals(new Point(200,0),c.getCurrentPos());
        c.stopEngine();
    }

    @Test
    public void turnLeft() {
        c.turnLeft();
        assertEquals(1.0, c.getCurrentDirection());
    }

    @Test
    public void turnRight() {
        c.turnRight();
        assertEquals(-1.0, c.getCurrentDirection());
    }
}