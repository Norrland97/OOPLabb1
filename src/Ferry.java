import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry implements Movable {

    private CarTrailer parent =  new CarTrailer(); //Used for delegation from class CarTrailer.java

    private boolean isDocked; // Whether the ferry is docked or not, allows for loading of cars.
    private double enginePower; // Engine power of the ferry
    private double currentSpeed; // The current speed of the ferry
    private double currentDirection; // The current position of
    private Point currentPos;
    private Color color; // Color of the car
    private String modelName; // The car model name
    private boolean engineOn;
    private int maxLoad;

    private List<Car> loadedCars = new ArrayList<>();

    private double loadingProximity = 10;

    public Ferry(double enginePower, Color color, String modelName, int maxLoad) {
        this.isDocked = true;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.currentDirection = 0;
        this.currentPos = new Point(0,0);
        this.color = color;
        this.modelName = modelName;
        this.engineOn = false;
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
            System.out.println("Can only load car when flat bed is down.");
        }
    }

    public void unloadCar() {

        Car car = loadedCars.get(loadedCars.size());

        if (isDocked && loadedCars.size() > 0) {
            loadedCars.remove(loadedCars.size());
            //Update position of car to the position of CarTrailer
        } else {
            System.out.println("Can only unload car when flat bed is down.");
        }
    }
}
