import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class CarTest {

    Car c = new PassengerCar(200,Color.BLACK,"Volvo240", 4);

    @Test
    public void getCurrentPos() {
        assertEquals(new Point(0,0), c.getCurrentPos());
    }

    @Test
    public void getCurrentDirection() {

        assertEquals(0.0, c.getCurrentDirection());

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
        c.gas(1);
        c.startEngine();
        c.gas(1);
        assertEquals(20.0, c.getCurrentSpeed(), 1);

        for(int i = 0; i < 20; i++)
            c.gas(1);

        assertEquals(200.0, c.getCurrentSpeed());
    }

    @Test
    public void decrementSpeed() {

        c.brake(1);
        assertEquals(0, c.getCurrentSpeed(), 0.01);

    }

    @Test
    public void move() {
        c.startEngine();
        c.gas(1);
        c.move();

        assertEquals(new Point(20,0),c.getCurrentPos());
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

    @Test
    public void gas() {
        c.startEngine();
        c.gas(1);
        assertEquals( 20.1,c.getCurrentSpeed(), 0.01);

        c.startEngine();
        c.gas(2);
        assertEquals( 20.1,c.getCurrentSpeed(), 0.01);

        c.startEngine();
        c.gas(-1);
        assertEquals( 0.1,c.getCurrentSpeed(), 0.01);

    }

    @Test
    public void brake() {
        c.startEngine();
        c.gas(1);
        c.brake(1);
        assertEquals( 0.1,c.getCurrentSpeed(), 0.01);

        c.brake(1);
        assertEquals(0, c.getCurrentSpeed(), 0.01);

        c.startEngine();
        c.gas(1);
        c.brake(2);
        assertEquals( 0.1,c.getCurrentSpeed(), 0.01);

        c.startEngine();
        c.gas(1);
        c.brake(-1);
        assertEquals( 20.1,c.getCurrentSpeed(), 0.01);


    }
}