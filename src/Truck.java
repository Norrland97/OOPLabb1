import java.awt.*;

/**
 * Represents a bigger Car which can load things
 */

public class Truck extends Car {

    /**
     * The constructor of the Truck
     * @param enginePower The engine power of the Truck
     * @param color The color of the Truck
     * @param modelName The model name of the Truck
     * @param nrDoors The number of doors of the Truck
     */

    public Truck(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName, nrDoors);
    }

}
