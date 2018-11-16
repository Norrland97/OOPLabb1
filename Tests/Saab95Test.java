import org.junit.Test;
import java.awt.Color;

import static org.junit.Assert.*;

public class Saab95Test {

    Saab95 c = new Saab95(4, 200, Color.BLACK, "Saab95", true);

    @Test
    public void setTurboOn() {
        c.setTurboOn();
        assertEquals(2.6, c.speedFactor());
    }

    @Test
    public void setTurboOff() {
        c.setTurboOff();
        assertEquals(2.0, c.speedFactor());
    }

    @Test
    public void gas() {
        c.startEngine();
        c.gas(1);
        assertEquals( 2.7,c.getCurrentSpeed());
    }

    @Test
    public void brake() {
        c.startEngine();
        c.gas(1);
        c.brake(1);
        assertEquals( 0.1,c.getCurrentSpeed(), 0.01);

        c.brake(1);
        assertEquals(0, c.getCurrentSpeed(), 0.01);


    }
}