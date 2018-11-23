import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a transporter
 * This has methods to handle loading and unloading the transprter
 */
public class Transporter<A extends Vehicle> {

    private int maxLoad;
    private List<A> loadedCars;
    private double loadingProximity = 10;
    private boolean canLoad;
    private Point currentPos;
    protected enum UnloadPriority {
        FIRSTIN, LASTIN
    }

    /**
     * constructor of Transporter
     *
     * @param maxLoad   the max load, int value
     * @param canLoad   boolean, represents if loading is possible or not
     * @param currentPosition   the current position ot the transporter
     */
    public Transporter(int maxLoad, boolean canLoad, Point currentPosition) {
        this.maxLoad = maxLoad;
        this.loadedCars = new ArrayList<>(maxLoad);
        this.canLoad = canLoad;
        this.currentPos = currentPosition;
    }

    //----------Setters and Getters------

    /**
     * gets the list oc current loaded cars
     *
     * @return a list os veicles
     */
    public List<A> getLoadedCars() {
        return loadedCars;
    }

    /**
     * getter for loadabillity
     * @return boolean true, if the loading is possible
     */
    protected boolean isCanLoad() {
        return canLoad;
    }

    /**
     * setter for loadability
     * @param canLoad boolean true if loading should be possible
     */
    protected void setCanLoad(boolean canLoad) {
        this.canLoad = canLoad;
    }


    //----------Public methods---------

    /**
     * Method which loads a Veichle onto the transporter. The amount of Veichles loaded is decided by the variable maxLoad.
     * The Car needs to be in the proximity of the CarTrailer
     *
     * @param car The car which will get loaded.
     */
    protected void loadCar(A car) {

        if (canLoad && loadedCars.size() <= maxLoad && checkProximity(car.getCurrentPos())) {
            loadedCars.add(car);
            moveLoadedCars();
        } else if (loadedCars.size() >= maxLoad) {
            System.out.println("CarTrailer is full");
        } else if (!canLoad) {
            System.out.println("Can only load car when flat bed is down.");
        }
    }

    /**
     * Method which unloads the veichle that's been loaded most recently.
     * The Veichle will be unloaded in the transporters proximity.
     */
    protected void unloadCar(Point point, UnloadPriority priority) {
        int index = 0;
        if (priority == priority.FIRSTIN){
            index = loadedCars.size() - 1;
        }


        if (loadedCars.size() > 0) {
            A car = loadedCars.get(index);

            if (canLoad) {
                loadedCars.remove(loadedCars.size() - 1);
                //Update position of car to not the position of CarTrailer
                moveUnloadedCar(car, point);
            } else {
                System.out.println("Can only unload car when flat bed is down.");
            }

        } else
            System.out.println("no more cars to unload");


    }

    /**
     * Moves the trailer along with the given point
     * (updates the position)
     */
    protected void move(Point point) {

        currentPos.x = point.x;
        currentPos.y = point.y;


        //Moving all the cars on top of it

        moveLoadedCars();

    }

    //-------Private Methods--------

    /**
     * moves a recently unloaded car away from the transporter.
     *
     * @param car the recently unloaded car
     */
    private void moveUnloadedCar(A car, Point point) {
        car.getCurrentPos().x = point.x;
        car.getCurrentPos().y = point.y;
    }

    /**
     * Moves the cars on top of the trailer along with the trailer
     */
    private void moveLoadedCars() {
        for (A car : loadedCars) {
            car.getCurrentPos().x = currentPos.x;
            car.getCurrentPos().y = currentPos.y;
        }
    }

    /**
     * Checks if the point is within the loading proximity or not
     *
     * @param point the point that is being checked.
     * @return true if point is within 'Loading proximity'
     */
    private boolean checkProximity(Point point) {

        return point.x <= currentPos.x + loadingProximity && point.x >= currentPos.x - loadingProximity &&
                point.y <= currentPos.y + loadingProximity && point.y >= currentPos.y - loadingProximity;
    }
}
