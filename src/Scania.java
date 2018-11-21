import java.awt.*;

public class Scania extends Car {

    private double flatBedAngle;

    /**
     * The constructor of Scania
     *
     * @param nrDoors      The ammount of doors for the new car
     * @param enginePower  The power of the enging in Horsepower
     * @param color        The color of the Car
     * @param modelName    The modelname of the car
     * @param flatBedAngle The current angle of the flatbed
     */
    public Scania(int nrDoors, double enginePower, Color color, String modelName, double flatBedAngle) {
        super(nrDoors, enginePower, color, modelName);
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
