import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTrailerTest {

    CarTrailer ct = new CarTrailer(200,  Color.BLACK, "Cartrailer", 5, 5);
    PassengerCar c = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

    @Test
    public void Transporter() {
        Transporter<Car> t = new Transporter(2, false, new Position(0,0));
        t.loadCar(c);
        t.setCanLoad(true);
        t.loadCar(c);
        assertNotSame(t.getLoadedCars(), 0);
        t.setCanLoad(false);
        t.unloadCar(new Position(0,0), Transporter.UnloadPriority.FIRSTIN);
    }

    @Test
    public void loadCar() {
        PassengerCar c1 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c2 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c3 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c4 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c5 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

        ct.startEngine();
        ct.gas(0.4);
        ct.turnLeft();
        ct.move();
        ct.stopEngine();
        ct.lowerFlatBed();
        ct.loadCar(c);
        assertEquals(c.getCurrentPos(), ct.getCurrentPos());

        ct = new CarTrailer(200,  Color.BLACK, "Cartrailer", 5, 5);
        c = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

        ct.startEngine();
        ct.gas(1);
        ct.turnLeft();
        ct.move();
        ct.stopEngine();
        ct.lowerFlatBed();
        ct.loadCar(c);
        assertTrue(c.getCurrentPos() != ct.getCurrentPos());



        ct = new CarTrailer(200,  Color.BLACK, "Cartrailer", 5, 5);
        //ct.loadCar(ct);//Ska inte fungera...

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