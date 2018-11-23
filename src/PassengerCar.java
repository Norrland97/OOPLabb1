import java.awt.*;

/**
 * Represents a smaller Car that transports people
 */

public class PassengerCar extends Car {

    /**
     * The constructor of PassengerCar
     * @param enginePower The engine power of the PassengerCar
     * @param color The color of the PassengerCar
     * @param modelName The model name of the PassengerCar
     * @param nrDoors The number of doors of the Passengercar
     */

    public PassengerCar(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName, nrDoors);
    }

}
