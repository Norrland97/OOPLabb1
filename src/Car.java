import java.awt.*;

/**
 * Represents a land vehicle
 */

public class Car extends Vehicle {

    private int nrDoors;

    /**
     * The construtor of Car
     * @param enginePower The engine power of the Car
     * @param color The color of the Car
     * @param modelName The model name of the Car
     * @param nrDoors The number of doors of the Car
     */
    public Car(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * @return Returns the number of doors on the Car
     */
    public int getNrDoors() {
        return nrDoors;
    }

}
