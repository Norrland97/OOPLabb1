import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FerryTest {

    Ferry f = new Ferry(200, Color.BLACK, "Ferry", 400);

    @Test
    public void move() {



        f.startEngine();
        f.gas(1);
    }

    @Test
    public void turnLeft() {
    }

    @Test
    public void turnRight() {
    }

    @Test
    public void loadCar() {
    }

    @Test
    public void unloadCar() {
    }
}