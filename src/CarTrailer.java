import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Represents a car trailer it can hold a set number of cars,
 * It can only load cars while stationary.
 */
public class CarTrailer extends Car {

    private Boolean flatBedDown;
    private int maxLoad;
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

    public CarTrailer() {
        super(0, 0, null, null);
    }

    //----------Public methods-----------

    /**
     * Method which lowers the flat bed. Allows for loading of cars.
     */
    public void lowerFlatBed() {
        if (getCurrentSpeed() == 0)
            flatBedDown = true;
        else
            System.out.println("Can't lower flat bed while driving");
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
            if (!car.getClass().equals(this.getClass())){
            loadedCars.add(car);
            moveLoadedCars();
            } else
                System.out.println("Cannot load other car trailers or itself");
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

        if (flatBedDown && loadedCars.size() > 0) {
            loadedCars.remove(loadedCars.size());
            //Update position of car to not the position of CarTrailer
            moveUnloadedCar(car);
        } else {
            System.out.println("Can only unload car when flat bed is down.");
        }
    }


    /**
     * moves a recently unloaded car away from the car traielr.
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
    public void moveLoadedCars() {
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
    public boolean checkProximity(Point point){

        return point.x <= this.getCurrentPos().x + loadingProximity && point.x >= this.getCurrentPos().x - loadingProximity &&
                point.y <= this.getCurrentPos().y + loadingProximity && point.y >= this.getCurrentPos().y - loadingProximity;
    }

}
