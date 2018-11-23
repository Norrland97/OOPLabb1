import javafx.scene.effect.Light;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a transporter
 * This has methods to handle loading and unloading the transprter
 */
public class Transporter <A extends Vehicle>{

    private int maxLoad;
    private List<A> loadedCars;
    private double loadingProximity = 10;
    private boolean canLoad;
    private Point currentPos;

    public Transporter(int maxLoad, boolean canLoad, Point currentPosition) {
        this.maxLoad = maxLoad;
        this.loadedCars = new ArrayList<>(maxLoad);
        this.canLoad = canLoad;
        this.currentPos = currentPosition;
    }

    //----------Setters and Getters------

    /**
     * gets the list oc current loaded cars
     * @return a list os veicles
     */
    public List<A> getLoadedCars() {
        return loadedCars;
    }

    //är dessa rätt ens??

    public boolean isCanLoad() {
        return canLoad;
    }

    public void setCanLoad(boolean canLoad) {
        this.canLoad = canLoad;
    }


    //----------Public methods---------

    /**
     * Method which loads a Car onto the CarTrailer. The amount of cars loaded is decided by the variable maxLoad.
     * The Car needs to be in the proximity of the CarTrailer
     *
     * @param car The car which will get loaded.
     */
    public void loadCar(Car car) {

        if (canLoad && loadedCars.size() <= maxLoad && checkProximity(car.getCurrentPos())) {
            if (!car.getClass().equals(this.getClass())) {
                loadedCars.add(car);
                moveLoadedCars();
            } else
                System.out.println("Cannot load other car trailers or itself");
        } else if (loadedCars.size() >= maxLoad) {
            System.out.println("CarTrailer is full");
        } else if (!canLoad) {
            System.out.println("Can only load car when flat bed is down.");
        }
    }

    /**
     * Method which unloads the Car that's been loaded most recently.
     * The Car will be unloaded in the CarTrailers proximity.
     */
    public void unloadCar() {
        if (loadedCars.size() > 0) {
            Car car = loadedCars.get(loadedCars.size() - 1);

            if (canLoad && loadedCars.size() > 0) {
                loadedCars.remove(loadedCars.size() - 1);
                //Update position of car to not the position of CarTrailer
                moveUnloadedCar(car);
            } else {
                System.out.println("Can only unload car when flat bed is down.");
            }

        } else
            System.out.println("no more cars to unload");


    }

    /**
     * moves a recently unloaded car away from the car traielr.
     *
     * @param car the recently unloaded car
     */
    private void moveUnloadedCar(Car car) {
        car.getCurrentPos().x = getCurrentPos().x - 5;
        car.getCurrentPos().y = getCurrentPos().y - 5;
    }

    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     */

    public void move(Point point) {

        currentPos.x = point.x;
        currentPos.y = point.y;


        //Moving all the cars on top of it

        moveLoadedCars();

    }

    /**
     * Moves the cars on top of the trailer along with the trailer
     */
    public void moveLoadedCars() {
        for (A car : loadedCars) {
            car.getCurrentPos().x = getCurrentPos().x;
            car.getCurrentPos().y = getCurrentPos().y;
        }
    }

    /**
     * Checks if the point is within the loading proximity or not
     *
     * @param point
     * @return true if point is within 'Loading proximity'
     */
    public boolean checkProximity(Point point) {

        return point.x <= this.getCurrentPos().x + loadingProximity && point.x >= this.getCurrentPos().x - loadingProximity &&
                point.y <= this.getCurrentPos().y + loadingProximity && point.y >= this.getCurrentPos().y - loadingProximity;
    }
}
