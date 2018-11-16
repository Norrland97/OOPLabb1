import java.awt.*;

/**
 * Represents a Volvo 240.
 * I has some trim to make it go faster.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240
     * @param nrDoors The number of doors for the car - int
     * @param enginePower - The engine power of the car - double
     * @param color - The color of the car - Color
     * @param modelName - The model name of the car - String
     */

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     * Method which returns speedfactor of car
     * @return enginePower * 0.01 * trimFactor
     */

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
