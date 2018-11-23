import org.junit.Test;
import java.awt.Color;

import static org.junit.Assert.*;

public class Saab95Test {

    Saab95 c = new Saab95(200, Color.BLACK, "Saab95", 4, true);

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


}