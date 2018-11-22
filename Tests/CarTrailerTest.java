import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTrailerTest {

    CarTrailer ct = new CarTrailer(2, 200, Color.BLACK, "Cartrailer", 5);
    Car c = new Saab95(2, 200, Color.BLACK, "Saab95", true);

    @Test
    public void loadCar() {
        ct.startEngine();
        ct.gas(0.4);
        ct.turnLeft();
        ct.move();
        ct.stopEngine();
        ct.lowerFlatBed();
        ct.loadCar(c);
        assertEquals(c.getCurrentPos(), ct.getCurrentPos());

        ct = new CarTrailer(2, 200, Color.BLACK, "Cartrailer", 5);
        c = new Saab95(2, 200, Color.BLACK, "Saab95", true);

        ct.startEngine();
        ct.gas(1);
        ct.turnLeft();
        ct.move();
        ct.stopEngine();
        ct.lowerFlatBed();
        ct.loadCar(c);
        assertTrue(c.getCurrentPos() != ct.getCurrentPos());



        ct = new CarTrailer(2, 200, Color.BLACK, "Cartrailer", 5);
        ct.loadCar(ct);//Ska inte fungera... should print "cannot load itself"

    }

    @Test
    public void unloadCar() {

    }

    @Test
    public void flatBed() {

    }


}