import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTrailerTest {

    CarTrailer ct = new CarTrailer(2, 200, Color.BLACK, "Cartrailer", 5);
    Car c = new Saab95(2, 200, Color.BLACK, "Saab95", true);

    @Test
    public void loadCar() {
        Car c1 = new Saab95(2, 200, Color.BLACK, "Saab95", true);
        Car c2 = new Saab95(2, 200, Color.BLACK, "Saab95", true);
        Car c3 = new Saab95(2, 200, Color.BLACK, "Saab95", true);
        Car c4 = new Saab95(2, 200, Color.BLACK, "Saab95", true);
        Car c5 = new Saab95(2, 200, Color.BLACK, "Saab95", true);

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

        ct.lowerFlatBed();
        ct.loadCar(c);
        ct.loadCar(c1);
        ct.loadCar(c2);
        ct.loadCar(c3);
        ct.loadCar(c4);
        ct.loadCar(c5);
        ct.raiseFlatBed();

        ct.loadCar(c5);

    }

    @Test
    public void unloadCar() {

        ct.lowerFlatBed();
        ct.loadCar(c);
        ct.raiseFlatBed();
        ct.startEngine();
        ct.gas(1);
        ct.move();
        ct.stopEngine();
        ct.lowerFlatBed();
        ct.unloadCar();
        ct.raiseFlatBed();
        ct.startEngine();
        ct.gas(1);
        ct.move();
        ct.move();
        assertNotSame(ct.getCurrentPos(), c.getCurrentPos());
        ct.stopEngine();

        ct.raiseFlatBed();
        ct.unloadCar();
        ct.lowerFlatBed();
        ct.unloadCar();


    }

    @Test
    public void flatBed() {
        ct.lowerFlatBed();
        ct.startEngine(); // prints "the flat bed is down, the truck cannot start"
        ct.raiseFlatBed();
        ct.startEngine();
        ct.lowerFlatBed();
        ct.stopEngine();

    }


}