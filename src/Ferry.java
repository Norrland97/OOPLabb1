import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry extends Vehicle {

    private CarTrailer parent; //Used for delegation from class CarTrailer.java

    private boolean isDocked; // Whether the ferry is docked or not, allows for loading of cars.
    private int maxLoad;

    private List<Car> loadedCars = new ArrayList<>();
    private double loadingProximity = 10;

    public Ferry(double enginePower, Color color, String modelName, CarTrailer parent, boolean isDocked,
                 int maxLoad, List<Car> loadedCars, double loadingProximity) {
        super(enginePower, color, modelName);
        this.parent = parent;
        this.isDocked = isDocked;
        this.maxLoad = maxLoad;
        this.loadedCars = loadedCars;
        this.loadingProximity = loadingProximity;
    }

    @Override
    public void move() {
        parent.move();
    }

    @Override
    public void turnLeft() {
        parent.turnLeft();
    }

    @Override
    public void turnRight() {
        parent.turnRight();
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
