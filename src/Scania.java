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

    public void raiseBedAngle() {
        if (getCurrentSpeed() == 0) {
            flatBedAngle++;
        } else {
            System.out.println("Cannot lower flat bed while driving!");
        }

        if (flatBedAngle > 70) {
            flatBedAngle = 70;
        }
    }

    public void lowerBedAngle() {

        flatBedAngle--;

        if (flatBedAngle < 0) {
            flatBedAngle = 0;
        }
    }

    /**
     * Moves the Scania forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     * Cannot move if the flat bed angle is greater than 0
     */
    @Override
    public void move() {
        if (flatBedAngle == 0) {

            getCurrentPos().x = (int) Math.round(getCurrentPos().x + Math.cos(getCurrentDirection()) * getCurrentSpeed());
            getCurrentPos().y = (int) Math.round(getCurrentPos().y + Math.sin(getCurrentDirection()) * getCurrentSpeed());
        } else {
            System.out.println("The flat bed is up, the truck cannot move");
        }

    }


}
