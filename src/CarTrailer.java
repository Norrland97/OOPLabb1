import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */

public class CarTrailer extends Car {

    private Boolean flatBedDown;
    private final int maxLoad;
    private List<Car> loadedCars = new ArrayList<>();
    private double loadingProximity = 10;

    /**
     * Constructor of a CarTrailer
     *
     * @param nrDoors     The number of doors of the CarTrailer
     * @param enginePower The engine power of the CarTrailer
     * @param color       The color of the CarTrailer
     * @param modelName   The model name of the CarTrailer
     */
    public CarTrailer(int nrDoors, double enginePower, Color color, String modelName, int maxLoad) {
        super(nrDoors, enginePower, color, modelName);
        this.flatBedDown = false;
        this.maxLoad = maxLoad;
    }



    //----------Public methods-----------

    /**
     * Method which lowers the flat bed. Allows for loading of cars.
     */
    public void lowerFlatBed() {
        if (getCurrentSpeed() == 0)
            flatBedDown = true;
        else
            System.out.println("Cant lower flat bed while driving");
    }

    /**
     * Method which raises the flat bed. Prevents the options of loading of cars.
     */
    public void raiseFlatBed() {
        flatBedDown = false;
    }

    /**
     * Method which loads a Car onto the CarTrailer. The amount of cars loaded is decided by the variable maxLoad.
     * The Car needs to be in the proximity of the CarTrailer
     *
     * @param car The car which will get loaded.
     */
    public void loadCar(Car car) {

        if (flatBedDown && loadedCars.size() <= maxLoad && checkProximity(car.getCurrentPos())) {
            loadedCars.add(car);
            moveLoadedCars();
        } else if(loadedCars.size() >= maxLoad) {
            System.out.println("CarTrailer is full");
        }else if(!flatBedDown){
            System.out.println("Can only load car when flat bed is down.");
        }
    }

    /**
     * Method which unloads the Car that's been loaded most recently.
     * The Car will be unloaded in the CarTrailers proximity.
     */
    public void unloadCar() {

        Car car = loadedCars.get(loadedCars.size());

        if (flatBedDown && loadedCars.size() > 0) {
            loadedCars.remove(loadedCars.size());
            //Update position of car to the position of CarTrailer
        } else {
            System.out.println("Can only unload car when flat bed is down.");
        }
    }

    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     */
    @Override
    public void move() {

        getCurrentPos().x = (int) Math.round(getCurrentPos().x + Math.cos(getCurrentDirection()) * getCurrentSpeed());
        getCurrentPos().y = (int) Math.round(getCurrentPos().y + Math.sin(getCurrentDirection()) * getCurrentSpeed());


        //Moving all the cars on top of it

        moveLoadedCars();

    }




    //---------private methods----------

    /**
     * Moves the cars on top of the trailer along with the trailer
     */
    private void moveLoadedCars() {
        for (Car car: loadedCars){
            car.getCurrentPos().x = getCurrentPos().x;
            car.getCurrentPos().y = getCurrentPos().y;
        }
    }

    /**
     * Checks if the point is within the loading proximity or not
     * @param point
     * @return true if point is within 'Loading proximity'
     */
    private boolean checkProximity(Point point){

        return point.x <= this.getCurrentPos().x + loadingProximity && point.x >= this.getCurrentPos().x - loadingProximity &&
                point.y <= this.getCurrentPos().y + loadingProximity && point.y >= this.getCurrentPos().y - loadingProximity;
    }

}
