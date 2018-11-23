import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vehicle which travels on water and can move Trucks and PassengerCars
 */

public class Ferry extends Vehicle {

    //private boolean isDocked; // Whether the ferry is docked or not, allows for loading of cars.
    private Transporter<Car> parent;

    /**
     * The constructor of Ferry
     * @param enginePower The engine power of the Ferry
     * @param color The color of the Ferry
     * @param modelName The model name of the Ferry
     * @param isDocked Whether the ferry is docked or not. Allows for loading of Cars
     * @param maxLoad The maximum number of Cars which the Ferry can load
     */
    public Ferry(double enginePower, Color color, String modelName, boolean isDocked,
                 int maxLoad) {
        super(enginePower, color, modelName);
        this.parent = new Transporter<>(maxLoad, isDocked, getCurrentPos());
        //this.isDocked = isDocked;
    }

    public void loadCar(Car car) {
        parent.loadCar(car);
    }

    public void unloadCar() {

        Car car = loadedCars.get(0);

        if (parent.isCanLoad() && loadedCars.size() > 0) {
            loadedCars.remove(0);
            car.getCurrentPos().x = parent.getCurrentPos().x - 5;
            car.getCurrentPos().y = parent.getCurrentPos().y - 5;
        } else {
            System.out.println("Can only unload car when ferry is docked.");
        }
    }

}
