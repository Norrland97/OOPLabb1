import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FerryTest {

    Ferry f = new Ferry(200, Color.BLACK, "Ferry", true, 5);
    PassengerCar c = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

    @Test
    public void loadCar() {
        PassengerCar c1 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c2 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c3 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c4 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);
        PassengerCar c5 = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

        f.startEngine();
        f.gas(0.4);
        f.turnLeft();
        f.move();
        f.stopEngine();
        f.dock();
        f.loadCar(c);
        assertEquals(c.getCurrentPos(), f.getCurrentPos());

        f = new Ferry(200, Color.BLACK, "Ferry", true, 5);
        c = new Saab95(200,  Color.BLACK, "Saab95", 4, true);

        f.startEngine();
        f.gas(1);
        f.turnLeft();
        f.move();
        f.stopEngine();
        f.dock();
        f.loadCar(c);
        assertTrue(c.getCurrentPos() != f.getCurrentPos());



        f = new Ferry(200, Color.BLACK, "Ferry", true, 5);
        //f.loadCar(f); //Fungerar ej

        f.dock();
        f.loadCar(c);
        f.loadCar(c1);
        f.loadCar(c2);
        f.loadCar(c3);
        f.loadCar(c4);
        f.loadCar(c5);
        f.unDock();

        f.loadCar(c5);
    }

    @Test
    public void unloadCar() {
        f.dock();
        f.loadCar(c);
        f.unDock();
        f.startEngine();
        f.gas(1);
        f.move();
        f.stopEngine();
        f.dock();
        f.unloadCar();
        f.unDock();
        f.startEngine();
        f.gas(1);
        f.move();
        f.move();
        assertNotSame(f.getCurrentPos(), c.getCurrentPos());
        f.stopEngine();

        f.unDock();
        f.unloadCar();
        f.dock();
        f.unloadCar();
    }

    @Test
    public void docking() {
        f.dock();
        f.startEngine(); // prints "the flat bed is down, the truck cannot start"
        f.unDock();
        f.startEngine();
        f.dock();
        f.stopEngine();
    }
}