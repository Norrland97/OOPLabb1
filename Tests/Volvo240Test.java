import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Volvo240Test {

    Volvo240 c = new Volvo240(200, Color.BLACK, "Volvo240", 4);

    @Test
    public void speedFactor() {
        assertEquals(2.5, c.speedFactor());
    }
}