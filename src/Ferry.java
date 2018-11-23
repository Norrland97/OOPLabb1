import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vehicle which travels on water and can move Trucks and PassengerCars
 */

public class Ferry extends Vehicle {

    private boolean isDocked; // Whether the ferry is docked or not, allows for loading of cars.
    private int maxLoad;
    private List<Car> loadedCars;
    private double loadingProximity = 10;

    /**
     * The constructor of Ferry
     * @param enginePower The engine power of the Ferry
     * @param color The color of the Ferry
     * @param modelName The model name of the Ferry
     * @param isDocked Whether the ferry is docked or not. Allows for loading of Cars
     * @param maxLoad The maximum number of Cars which the Ferry can load
     * @param loadedCars A list of the Cars which has been loaded
     * @param loadingProximity The distance from which the Car needs to be to be loaded onto the Ferry
     */
    public Ferry(double enginePower, Color color, String modelName, boolean isDocked,
                 int maxLoad, List<Car> loadedCars, double loadingProximity) {
        super(enginePower, color, modelName);
        this.isDocked = isDocked;
        this.maxLoad = maxLoad;
        this.loadedCars = loadedCars;
        this.loadingProximity = loadingProximity;
    }

    public void loadCar(Car car) {

        if (isDocked && parent.checkProximity(car.getCurrentPos())) {
            loadedCars.add(car);
            parent.moveLoadedCars();
        } else if(loadedCars.size() >= maxLoad) {
            System.out.println("Ferry is full");
        }else if(!isDocked){
            System.out.println("Can only load car when ferry is docked.");
        }
    }

    public void unloadCar() {

        Car car = loadedCars.get(0);

        if (isDocked && loadedCars.size() > 0) {
            loadedCars.remove(0);
            car.getCurrentPos().x = parent.getCurrentPos().x - 5;
            car.getCurrentPos().y = parent.getCurrentPos().y - 5;
        } else {
            System.out.println("Can only unload car when ferry is docked.");
        }
    }

}
