import java.awt.*;

/**
 * Represents a Scania
 * it has a flat bed that it can lower and raise between 0 and 70 degrees.
 */
public class Scania extends Truck {

    private double flatBedAngle;

    public Scania(double enginePower, Color color, String modelName, int nrDoors, double flatBedAngle) {
        super(enginePower, color, modelName, nrDoors);
        this.flatBedAngle = flatBedAngle;
    }

    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    /**
     * Raises the bed angle by 1 degree at a time
     */
    public void raiseBedAngle() {
        if (getCurrentSpeed() == 0) {
            flatBedAngle++;
        } else {
            System.out.println("Cannot raise flat bed while driving!");
        }

        if (flatBedAngle > 70) {
            flatBedAngle = 70;
        }
    }

    /**
     * Lowers the bed angle 1 degree at a time
     */
    public void lowerBedAngle() {

        flatBedAngle--;

        if (flatBedAngle < 0) {
            flatBedAngle = 0;
        }
    }

    /**
     * "Starts up the engine"
     * Actually: gives the car an small ammount of speed
     * Cannot start if the flat bed angle is greater than 0
     */
    @Override
    public void startEngine() {
        if (flatBedAngle == 0){
            super.startEngine();
        }else {
            System.out.println("The flat bed is up, the truck cannot start");
        }

    }


}
