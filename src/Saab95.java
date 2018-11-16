import java.awt.*;

public class Saab95 extends Car {

    /**
     *
     */
    public boolean turboOn;

    /**
     *
     * @param nrDoors The number of doors of the car - int
     * @param enginePower The engine power of the car - double
     * @param color The color of the car - Color
     * @param modelName The model name of the car - String
     * @param turboOn Whether or not the turbo is activated or not - boolean
     */

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn) {
        super(nrDoors, enginePower, color, modelName);
        this.turboOn = turboOn;
    }

    /**
     * Activate turbo
     */

    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Deactivate turbo
     */

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Method which returns the speedFactor
     * @return EnginePower * 0.01 * turbo
     */

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }


}
