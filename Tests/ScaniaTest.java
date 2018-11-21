import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania s = new Scania(2, 200, Color.BLACK, "Scania", 0);

    @Test
    public void getFlatBedAngle() {



    }

    @Test
    public void raiseBedAngle() {

        double a = s.getFlatBedAngle();

        s.raiseBedAngle();

        double b = s.getFlatBedAngle();

        assertTrue(a < b);

    }

    @Test
    public void lowerBedAngle() {

        s.raiseBedAngle();
        s.raiseBedAngle();
        s.raiseBedAngle();

        double a = s.getFlatBedAngle();

        s.lowerBedAngle();

        double b = s.getFlatBedAngle();

        assertTrue(a > b);

        s.lowerBedAngle();
        s.lowerBedAngle();
        s.lowerBedAngle();

        assertEquals(0.0,s.getFlatBedAngle());

    }

    @Test
    public void move() {

    }


    @Test
    public void startEngine(){

        s.raiseBedAngle();

        s.startEngine();

        assertEquals(0.0, s.getCurrentSpeed());

    }

}