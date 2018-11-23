import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania s = new Scania(200, Color.BLACK, "Scania", 2);

    @Test
    public void getFlatBedAngle() {



    }

    @Test
    public void raiseBedAngle() {

        double a = s.getFlatBedAngle();

        s.raiseBedAngle();

        s.startEngine();
        s.gas(1);
        s.raiseBedAngle();

        System.out.println(s.getCurrentSpeed());

        double b = s.getFlatBedAngle();

        assertTrue(a < b);

    }

    @Test
    public void lowerBedAngle() {


        for(int i = 0; i < 72; i++)
            s.raiseBedAngle();

        double a = s.getFlatBedAngle();

        s.lowerBedAngle();

        double b = s.getFlatBedAngle();

        assertTrue(a > b);

        for(int i = 0; i < 75; i++)
            s.lowerBedAngle();

        assertEquals(0.0,s.getFlatBedAngle());

    }

    @Test
    public void startEngine(){

        s.startEngine();

        s.raiseBedAngle();

        s.startEngine();

        assertEquals(0.1, s.getCurrentSpeed());

    }

}